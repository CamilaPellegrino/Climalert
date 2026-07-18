package ar.edu.utn.ba.ddsi.Climalert.config;

import ar.edu.utn.ba.ddsi.Climalert.Service.Impl.NotificacionServiceImpl;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.MedioNotificacion;
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
    public CommandLineRunner inicializarSuscriptores(NotificacionServiceImpl notificacionService, Map<String, MedioNotificacion> medios) {
        MedioNotificacion correo = medios.get("Correo");
        return args -> {
            destinatarios.forEach(direccion -> {
                Subscriber suscriber = new Subscriber(direccion, correo);
                notificacionService.suscribe(suscriber);
            });
        };
    }
}