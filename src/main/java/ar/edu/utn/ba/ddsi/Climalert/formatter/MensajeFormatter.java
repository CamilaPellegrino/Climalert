package ar.edu.utn.ba.ddsi.Climalert.formatter;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;

public interface MensajeFormatter {
    String generarMensaje(Clima clima);
}
