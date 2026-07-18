package ar.edu.utn.ba.ddsi.Climalert.Repositories;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.Subscriber;

import java.util.List;

public interface SubscriberRepository {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    List<Subscriber> getAll();
}
