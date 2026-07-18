package ar.edu.utn.ba.ddsi.Climalert.Service;

import ar.edu.utn.ba.ddsi.Climalert.dto.NotificacionRequest;
import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;

public interface NotificacionService {
    void enviar(String cuerpo, String remitente);
}
