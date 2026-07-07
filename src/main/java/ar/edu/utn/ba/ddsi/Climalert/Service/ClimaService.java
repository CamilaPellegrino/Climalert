package ar.edu.utn.ba.ddsi.Climalert.Service;

import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;

public interface ClimaService {
    public WeatherResponse actualizarClima();
    public WeatherResponse getClima();
    public boolean condicionCritica(WeatherResponse weatherResponse);
}
