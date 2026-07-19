package ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones;

public interface MedioNotificacion {
    boolean enviar(Notificacion notificacion, String destinatario);
}
