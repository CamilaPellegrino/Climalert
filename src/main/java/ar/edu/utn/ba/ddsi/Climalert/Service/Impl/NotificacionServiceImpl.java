package ar.edu.utn.ba.ddsi.Climalert.Service.Impl;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.SubscriberRepository;
import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Subscriber;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class NotificacionServiceImpl implements NotificacionService {
    private final SubscriberRepository subscriberRepository;

    public NotificacionServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public void enviar(String cuerpo, String remitente) {
        List<Subscriber> subscribers = subscriberRepository.getAll();
        subscribers.forEach(suscriber -> suscriber.notificar(cuerpo));
    }
}