package ar.edu.utn.ba.ddsi.Climalert.config;

import ar.edu.utn.ba.ddsi.Climalert.Repositories.SubscriberRepository;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.MedioNotificacion;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Subscriber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class NotificacionConfig {

    @Value("#{'${email.alertas.destinatarios}'.split(',')}")
    private List<String> destinatarios;

    @Bean
    public CommandLineRunner inicializarSuscriptores(
            SubscriberRepository subscriberRepository,
            Map<String, MedioNotificacion> medios) {

        MedioNotificacion correo = medios.get("Correo");

        return args -> {
            destinatarios.forEach(direccion -> {
                Subscriber subscriber = new Subscriber(direccion, correo);
                subscriberRepository.subscribe(subscriber);
            });
        };
    }
}