package ar.edu.utn.ba.ddsi.Climalert.Service.Impl;

import ar.edu.utn.ba.ddsi.Climalert.Api.WeatherApi;
import ar.edu.utn.ba.ddsi.Climalert.Repositories.WeatherRepository;
import ar.edu.utn.ba.ddsi.Climalert.Service.ClimaService;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;
import org.springframework.stereotype.Service;

@Service
public class ClimaServiceImpl implements ClimaService {

    private final WeatherApi weatherApi;
    private final WeatherRepository weatherRepository;
    public ClimaServiceImpl(WeatherApi weatherApi, WeatherRepository weatherRepository) {
        this.weatherApi = weatherApi;
        this.weatherRepository = weatherRepository;

    }

    public Clima actualizarClima() {
        Clima response = weatherApi.obtenerClimaActual();
        weatherRepository.save(response);
        return response;
    }

    @Override
    public Clima getClima() {
        return weatherRepository.getClima();
    }

    @Override
    public boolean condicionCritica(Clima weatherResponse) {
        if(weatherResponse == null){
            return false;
        }
        return weatherResponse.current().humidity()>60 && weatherResponse.current().temp_c() >35;
    }
}
