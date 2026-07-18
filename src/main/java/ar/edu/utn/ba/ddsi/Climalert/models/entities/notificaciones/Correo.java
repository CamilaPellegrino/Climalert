package ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

@Component("Correo")
public class Correo implements MedioNotificacion {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.active:false}")
    private boolean active;

    public Correo(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean enviar(String destinatario, String asunto, String remitente, String contenido) {
        if(active){
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(destinatario);
            mail.setSubject(asunto);
            mail.setText(contenido);
            mail.setFrom(remitente);

            mailSender.send(mail);
        }

        System.out.println("## Mail enviado a " + destinatario);
        return true;
    }

}
