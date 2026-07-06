package ar.edu.utn.ba.ddsi.Climalert.Service.Impl;

import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import ar.edu.utn.ba.ddsi.Climalert.dto.NotificacionRequest;
import ar.edu.utn.ba.ddsi.Climalert.dto.NotificacionResponse;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.MedioNotificacion;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Getter
public class NotificacionServiceImpl implements NotificacionService {

    private final Map<String, MedioNotificacion> medios;
    private final String remitente;
    private final List<String> destinatarios;

    public NotificacionServiceImpl(Map<String, MedioNotificacion> medios
            , @Value("${email.alertas.remitente}") String remitente
            , @Value("#{'${email.alertas.destinatarios}'.split(',')}") List<String> destinatarios) {
        this.remitente = remitente;
        this.destinatarios = destinatarios;
        this.medios = medios;
    }

    public void enviar(String mensaje, String medioString) {
        MedioNotificacion medio = medios.get(medioString);

        if (medio == null) {
            throw new IllegalArgumentException("Medio no soportado: " + medioString);
        }

        medio.enviar(this.getDestinatarios(), mensaje);
    }
}