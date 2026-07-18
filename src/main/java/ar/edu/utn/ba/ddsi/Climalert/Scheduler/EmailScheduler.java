package ar.edu.utn.ba.ddsi.Climalert.Scheduler;

import ar.edu.utn.ba.ddsi.Climalert.Service.ClimaService;
import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;
import ar.edu.utn.ba.ddsi.Climalert.formatter.MensajeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private final ClimaService climaService;
    private final NotificacionService notificacionService;
    private final MensajeFormatter mailFormatter;

    @Value("${spring.application.testing:false}")
    private boolean testing;

    @Value("${email.alertas.remitente}")
    private String remitente;

    public EmailScheduler(ClimaService climaService, NotificacionService notificacionService, MensajeFormatter mailFormatter) {
        this.climaService = climaService;
        this.notificacionService = notificacionService;
        this.mailFormatter = mailFormatter;
    }

    public String generarMensaje(WeatherResponse weatherResponse){
        return this.mailFormatter.generarMensaje(weatherResponse);
    }

    @Scheduled(fixedRate = 60000)
    public void notificar() {
        System.out.println("Evaluando si notificar");
        WeatherResponse weatherResponse = climaService.getClima();
        if(climaService.condicionCritica(weatherResponse) || testing){
            System.out.println("Notificando");
            notificacionService.enviar(this.generarMensaje(weatherResponse), remitente);
        }
    }
}
