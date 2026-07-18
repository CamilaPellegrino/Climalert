package ar.edu.utn.ba.ddsi.Climalert.formatter;

import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;

public interface MensajeFormatter {
    String generarMensaje(WeatherResponse clima);
}
