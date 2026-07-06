package ar.edu.utn.ba.ddsi.Climalert.Service;

import ar.edu.utn.ba.ddsi.Climalert.dto.NotificacionRequest;

public interface NotificacionService {
    void enviar(String mensaje, String medioString);
}
