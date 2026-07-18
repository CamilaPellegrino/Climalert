package ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones;

public interface MedioNotificacion {
    boolean enviar(String destinatario, String asunto, String remitente, String contenido);
}
