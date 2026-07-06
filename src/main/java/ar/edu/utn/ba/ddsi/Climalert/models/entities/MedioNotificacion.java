package ar.edu.utn.ba.ddsi.Climalert.models.entities;

import java.util.List;

public interface MedioNotificacion {
    public boolean enviar(String destinatario, String mensaje);
    public boolean enviar(List<String> destinatario, String mensaje);

}
