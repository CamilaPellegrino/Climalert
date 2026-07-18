package ar.edu.utn.ba.ddsi.Climalert.Scheduler;

import ar.edu.utn.ba.ddsi.Climalert.Service.AlertasService;
import ar.edu.utn.ba.ddsi.Climalert.Service.ClimaService;
import ar.edu.utn.ba.ddsi.Climalert.Service.NotificacionService;
import ar.edu.utn.ba.ddsi.Climalert.formatter.MensajeFormatter;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AlertasScheduler {
    private final ClimaService climaService;
    private final AlertasService alertasService;

    @Value("${spring.application.testing:false}")
    private boolean testing;

    public AlertasScheduler(ClimaService climaService, AlertasService alertasService) {
        this.climaService = climaService;
        this.alertasService = alertasService;
    }

    @Scheduled(fixedRateString = "${cron.alertas}")// 1 minuto
    public void generarAlertas() {
        Clima clima = climaService.getClima();
        if(clima != null && (climaService.condicionCritica(clima) || testing)){
            System.out.println("Generando alertas");
            this.alertasService.generarAlertas(clima);
        }
    }
}
