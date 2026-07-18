package ar.edu.utn.ba.ddsi.Climalert.Repositories.InMemory;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.EmailRepository;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.Notificacion;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryEmailRepository implements EmailRepository {
    private final Map<Long, Notificacion> emails = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Notificacion save(Notificacion email) {
        if (email.getId() == null) {
            // Es un nuevo email
            Long id = idGenerator.getAndIncrement();
            email.setId(id);
            emails.put(id, email);
        } else {
            // Es una actualización
            emails.put(email.getId(), email);
        }
        return email;
    }

    @Override
    public List<Notificacion> findAll() {
        return new ArrayList<>(emails.values());
    }

    @Override
    public List<Notificacion> findByEnviado(boolean enviado) {
        return emails.values().stream()
                .filter(email -> email.isEnviado() == enviado)
                .toList();
    }

    @Override
    public Optional<Notificacion> findById(Long id) {
        return Optional.ofNullable(emails.get(id));
    }

    @Override
    public void delete(Notificacion email) {
        if (email.getId() != null) {
            emails.remove(email.getId());
        }
    }
}