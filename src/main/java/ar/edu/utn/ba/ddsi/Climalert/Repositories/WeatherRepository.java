package ar.edu.utn.ba.ddsi.Climalert.Repositories;

import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;

public interface WeatherRepository {
    void save(WeatherResponse weatherResponse);
    WeatherResponse getClima();
}
