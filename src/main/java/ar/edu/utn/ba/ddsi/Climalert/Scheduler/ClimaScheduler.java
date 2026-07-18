package ar.edu.utn.ba.ddsi.Climalert.Scheduler;

import ar.edu.utn.ba.ddsi.Climalert.Service.ClimaService;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClimaScheduler {
    private final ClimaService climaService;

    public ClimaScheduler(ClimaService climaService) {
        this.climaService = climaService;
    }

    @Scheduled(fixedRate = 10000)
    public void actualizarClima() {
        Clima weatherResponse = climaService.actualizarClima();
        System.out.println("Clima actualizado: "+weatherResponse.current().temp_c() + ", "+weatherResponse.current().humidity());
    }
}