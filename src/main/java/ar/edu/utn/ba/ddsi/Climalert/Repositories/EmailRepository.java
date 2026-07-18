package ar.edu.utn.ba.ddsi.Climalert.Repositories;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.Notificacion;

import java.util.List;
import java.util.Optional;

public interface EmailRepository {
    Notificacion save(Notificacion email);
    List<Notificacion> findAll();
    List<Notificacion> findByEnviado(boolean enviado);
    Optional<Notificacion> findById(Long id);
    void delete(Notificacion email);

}
