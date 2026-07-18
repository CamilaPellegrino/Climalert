package ar.edu.utn.ba.ddsi.Climalert.Repositories.InMemory;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.SubscriberRepository;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Subscriber;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemorySubscriberRepository implements SubscriberRepository {
    private final List<Subscriber> subscribers;

    public InMemorySubscriberRepository() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber suscriber) {
        subscribers.add(suscriber);
    }


    @Override
    public void unsubscribe(Subscriber suscriber) {
        subscribers.remove(suscriber);
    }

    @Override
    public List<Subscriber> getAll() {
        return subscribers;
    }
}
