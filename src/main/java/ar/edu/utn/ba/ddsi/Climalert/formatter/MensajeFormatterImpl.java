package ar.edu.utn.ba.ddsi.Climalert.formatter;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;
import org.springframework.stereotype.Component;

@Component
public class MensajeFormatterImpl implements MensajeFormatter{
    public String generarMensaje(Clima clima) {
        return String.format("""
                ⚠️ ALERTA METEOROLÓGICA ⚠️

                Temperatura: %.1f °C
                Sensación térmica: %.1f °C
                Humedad: %d%%
                Viento: %.1f km/h (%s)

                Se recomienda tomar las precauciones necesarias.

                ---
                ClimaAlert
                """,
                clima.current().temp_c(),
                clima.current().feelslike_c(),
                clima.current().humidity(),
                clima.current().wind_kph(),
                clima.current().wind_dir());
    }
}