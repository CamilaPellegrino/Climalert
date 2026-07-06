package ar.edu.utn.ba.ddsi.Climalert.models.entities;

public class Notificador {

    public Notificacion enviar(String destinatario, String mensaje, MedioNotificacion medio) {
        Notificacion notif = new Notificacion(destinatario, mensaje);
        Boolean resultado = medio.enviar(destinatario, mensaje);
        if (resultado) {
            notif.marcarComoEnviada();
        }
        return notif;
    }
}