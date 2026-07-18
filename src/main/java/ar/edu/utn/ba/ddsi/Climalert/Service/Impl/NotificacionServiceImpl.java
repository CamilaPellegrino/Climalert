package ar.edu.utn.ba.ddsi.Climalert.Service.Impl;

import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.MedioNotificacion;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Subscriber;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Getter
public class NotificacionServiceImpl implements NotificacionService {
    private final List<Subscriber> suscribers;

    public NotificacionServiceImpl() {
        this.suscribers = new ArrayList<>();
    }

    public void enviar(String mensaje) {
        suscribers.forEach(suscriber -> suscriber.notificar(mensaje));
    }

    public void suscribe(Subscriber suscriber) {
        suscribers.add(suscriber);
    }

    public void unsuscribe(Subscriber suscriber) {
        suscribers.remove(suscriber);
    }
}