package ar.edu.utn.ba.ddsi.Climalert.models.entities;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.MedioNotificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Subscriber {
    private final String direccion;
    private final MedioNotificacion medio;

    public void notificar(String asunto, String remitente, String contenido){
        medio.enviar(this.direccion, asunto, remitente, contenido);
    }
}
