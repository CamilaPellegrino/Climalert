package ar.edu.utn.ba.ddsi.Climalert.Repositories.InMemory;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.WeatherRepository;
import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryWeatherRepository implements WeatherRepository {

    private final List<WeatherResponse> weatherResponses = new ArrayList<>();

    @Override
    public void save(WeatherResponse weatherResponse) {
        weatherResponses.add(weatherResponse);
    }

    @Override
    public WeatherResponse getClima() {
        if (weatherResponses.isEmpty()) {
            return null;
        }
        return weatherResponses.getLast();
    }
}