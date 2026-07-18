package ar.edu.utn.ba.ddsi.Climalert.Repositories.InMemory;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.WeatherRepository;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryWeatherRepository implements WeatherRepository {

    private final List<Clima> climas = new ArrayList<>();

    @Override
    public void save(Clima clima) {
        climas.add(clima);
    }

    @Override
    public Clima getClima() {
        return climas.isEmpty() ? null : climas.getLast();
    }
}