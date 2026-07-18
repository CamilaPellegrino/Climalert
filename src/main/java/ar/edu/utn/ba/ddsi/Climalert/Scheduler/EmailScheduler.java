package ar.edu.utn.ba.ddsi.Climalert.Scheduler;

import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private final NotificacionService notificacionService;

    public EmailScheduler(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @Scheduled(fixedRateString = "${cron.notificacion}")
    public void notificar() {
        System.out.println("Enviando notificaciones");
        notificacionService.notificar();
    }
}
