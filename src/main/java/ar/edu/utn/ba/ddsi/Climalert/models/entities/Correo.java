package ar.edu.utn.ba.ddsi.Climalert.models.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@Component("Correo")
public class Correo implements MedioNotificacion{
    private final JavaMailSender mailSender;

    @Value("${spring.application.testing:false}")
    private boolean testing;

    public Correo(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean enviar(String destinatario, String mensaje) {
        System.out.println("Destinatario: "+ destinatario);
        if(!testing){
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(destinatario);
            mail.setSubject("Notificación ClimaAlert");
            mail.setText(mensaje);
            mail.setFrom("test@example.com");

            mailSender.send(mail);
        }

        System.out.println("📧 Mail enviado a " + destinatario);
        return true;
    }
    @Override
    public boolean enviar(List<String> destinatarios, String mensaje){
        for (String destinatario : destinatarios){
            if(!enviar(destinatario, mensaje)){
                return false;
            }
        }
        return true;
    }
}
