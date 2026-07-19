package ar.edu.utn.ba.ddsi.Climalert.models.entities;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.Canal;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.MedioNotificacion;
import ar.edu.utn.ba.ddsi.Climalert.models.entities.notificaciones.Notificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Subscriber {
    private Canal canal; // podria tener varios canales

    public boolean notificar(Notificacion notificacion){
        Canal canal = this.elegirCanal();
        return canal != null && canal.notificar(notificacion);
    }

    public Canal elegirCanal(){
        return this.canal;
    }
}
