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
    public boolean enviar(Notificacion notificacion, String destinatario) {
        if(active){
            try {
                SimpleMailMessage mail = new SimpleMailMessage();
                mail.setTo(destinatario);
                mail.setSubject(notificacion.getAsunto());
                mail.setText(notificacion.getContenido());
                mail.setFrom(notificacion.getRemitente());

                mailSender.send(mail);
            }
            catch(Exception e) {
                System.out.println("## Error al enviar mail a " + destinatario);
                return false;
            }
        }

        System.out.println("## Mail enviado a " + destinatario);
        return true;
    }

}
