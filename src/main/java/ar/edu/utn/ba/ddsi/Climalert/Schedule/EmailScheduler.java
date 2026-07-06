package ar.edu.utn.ba.ddsi.Climalert.Schedule;

import ar.edu.utn.ba.ddsi.Climalert.Service.ClimaService;
import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private final ClimaService climaService;
    private final NotificacionService notificacionService;
    public EmailScheduler(ClimaService climaService, NotificacionService notificacionService) {
        this.climaService = climaService;
        this.notificacionService = notificacionService;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void notificar() {
        System.out.println("Evaluando si notificar");
        if(climaService.condicionCritica()){
            System.out.println("Notificando");
            String mensaje = "Hola mundo";
            notificacionService.enviar(mensaje, "Correo");
        }
    }
}
