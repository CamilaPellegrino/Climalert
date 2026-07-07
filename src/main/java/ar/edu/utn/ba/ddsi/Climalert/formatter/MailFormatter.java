package ar.edu.utn.ba.ddsi.Climalert.formatter;

import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;

public interface MailFormatter {
    public String generarMensaje(WeatherResponse clima);
}
