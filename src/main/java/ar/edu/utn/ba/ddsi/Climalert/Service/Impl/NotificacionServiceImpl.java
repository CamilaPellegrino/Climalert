package ar.edu.utn.ba.ddsi.Climalert.Service.Impl;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.EmailRepository;
import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.Notificacion;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class NotificacionServiceImpl implements NotificacionService {
    private final EmailRepository emailRepository;

    public NotificacionServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void notificar() {
        emailRepository.findByEnviado(false)
                .forEach(Notificacion::enviar);
    }
}