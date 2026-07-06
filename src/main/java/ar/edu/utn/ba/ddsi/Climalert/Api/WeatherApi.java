package ar.edu.utn.ba.ddsi.Climalert.Api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;

@Component
public class WeatherApi {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey;
    public WeatherApi(@Value("${weather.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    public WeatherResponse obtenerClimaActual() {
        String url = String.format(
                "https://api.weatherapi.com/v1/current.json?key=%s&q=Buenos Aires&aqi=no", apiKey);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}