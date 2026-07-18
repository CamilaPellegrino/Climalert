package ar.edu.utn.ba.ddsi.Climalert.Service.Impl;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.EmailRepository;
import ar.edu.utn.ba.ddsi.Climalert.Repositories.SubscriberRepository;
import ar.edu.utn.ba.ddsi.Climalert.Service.AlertasService;
import ar.edu.utn.ba.ddsi.Climalert.formatter.MensajeFormatter;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.Notificacion;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Subscriber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlertasServiceImpl implements AlertasService {
    private final EmailRepository emailRepository;
    private final MensajeFormatter mensajeFormatter;
    private final SubscriberRepository subscriberRepository;


    @Value("${email.alertas.remitente}")
    private String remitente;

    public AlertasServiceImpl(EmailRepository emailRepository, MensajeFormatter mensajeFormatter, SubscriberRepository subscriberRepository) {
        this.emailRepository = emailRepository;
        this.mensajeFormatter = mensajeFormatter;
        this.subscriberRepository = subscriberRepository;
    }

    @Override
    public void generarAlertas(Clima clima) {
        subscriberRepository.getAll().forEach(subscriber -> {
            Notificacion email = generarMail(clima, subscriber);
            emailRepository.save(email);
        });
    }

    private Notificacion generarMail(Clima clima, Subscriber subscriber){
        String contenido = mensajeFormatter.generarMensaje(clima);
        String asunto = "Alerta de Clima - Condiciones Extremas";
        return new Notificacion(subscriber, remitente, asunto, contenido);
    }
}
