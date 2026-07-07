package ar.edu.utn.ba.ddsi.Climalert.Schedule;

import ar.edu.utn.ba.ddsi.Climalert.Service.ClimaService;
import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import ar.edu.utn.ba.ddsi.Climalert.dto.WeatherResponse;
import ar.edu.utn.ba.ddsi.Climalert.formatter.MailFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private final ClimaService climaService;
    private final NotificacionService notificacionService;
    private final MailFormatter mailFormatter;
    public EmailScheduler(ClimaService climaService, NotificacionService notificacionService, MailFormatter mailFormatter) {
        this.climaService = climaService;
        this.notificacionService = notificacionService;
        this.mailFormatter = mailFormatter;
    }

    @Scheduled(fixedRate = 60000)
    public void notificar() {
        System.out.println("Evaluando si notificar");
        WeatherResponse weatherResponse = climaService.getClima();
        if(climaService.condicionCritica(weatherResponse)){
            System.out.println("Notificando");
            String mensaje = this.mailFormatter.generarMensaje(weatherResponse);
            notificacionService.enviar(mensaje, "Correo");
        }
    }
}
