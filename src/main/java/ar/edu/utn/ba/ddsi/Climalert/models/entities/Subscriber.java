package ar.edu.utn.ba.ddsi.Climalert.models.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Subscriber {
    private final String direccion;
    private final MedioNotificacion medio;

    public void notificar(String mensaje){
        medio.enviar(direccion, mensaje);
    }
}
