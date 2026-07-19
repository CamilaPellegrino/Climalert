package ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Canal {
    private MedioNotificacion medio;
    private String destinatario;

    public boolean notificar(Notificacion notificacion) {
        return medio.enviar(notificacion, destinatario);
    }
}