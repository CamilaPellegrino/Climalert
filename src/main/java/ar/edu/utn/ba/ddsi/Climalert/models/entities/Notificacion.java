package ar.edu.utn.ba.ddsi.Climalert.models.entities;

import lombok.Getter;

@Getter
public class Notificacion {
    private final String destinatario;
    private final String mensaje;
    private Boolean enviada;

    public Notificacion(String destinatario, String mensaje) {
        this.destinatario = destinatario;
        this.mensaje = mensaje;
        this.enviada = false;
    }

    public void marcarComoEnviada() {
        this.enviada = true;
    }
}