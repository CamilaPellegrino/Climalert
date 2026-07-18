package ar.edu.utn.ba.ddsi.Climalert.Repositories;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;

public interface WeatherRepository {
    void save(Clima weatherResponse);
    Clima getClima();
}
