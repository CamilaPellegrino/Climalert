package ar.edu.utn.ba.ddsi.Climalert.Service.Impl;

import ar.edu.utn.ba.ddsi.Climalert.Api.WeatherApi;
import ar.edu.utn.ba.ddsi.Climalert.Repositories.WeatherRepository;
import ar.edu.utn.ba.ddsi.Climalert.Service.ClimaService;
import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class ClimaServiceImpl implements ClimaService {

    private final WeatherApi weatherApi;
    private final WeatherRepository weatherRepository;
    public ClimaServiceImpl(WeatherApi weatherApi, WeatherRepository weatherRepository) {
        this.weatherApi = weatherApi;
        this.weatherRepository = weatherRepository;

    }

    public WeatherResponse actualizarClima() {
        WeatherResponse response = weatherApi.obtenerClimaActual();
        weatherRepository.save(response);
        return response;
    }

    @Override
    public WeatherResponse getClima() {
        return weatherRepository.getClima();
    }

    @Override
    public boolean condicionCritica(WeatherResponse weatherResponse) {
        if(weatherResponse == null){
            return false;
        }
        return weatherResponse.current().humidity()>60 && weatherResponse.current().temp_c() >35;
        //return true;
    }
}
