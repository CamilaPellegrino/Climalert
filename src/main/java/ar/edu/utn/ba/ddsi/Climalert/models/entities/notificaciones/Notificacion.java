package ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.Subscriber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Notificacion {
    private Long id;
    private Subscriber subscriber;
    private String remitente;
    private String asunto;
    private String contenido;
    private boolean enviado;
    private int intentos;

    public Notificacion(Subscriber subscriber, String remitente, String asunto, String contenido) {
        this.subscriber = subscriber;
        this.remitente = remitente;
        this.asunto = asunto;
        this.contenido = contenido;
        this.enviado = false;
        this.intentos = 0;
    }

    public boolean enviar() {
        this.intentos += 1;
        this.enviado = subscriber.notificar(this);
        return this.enviado;
    }
}