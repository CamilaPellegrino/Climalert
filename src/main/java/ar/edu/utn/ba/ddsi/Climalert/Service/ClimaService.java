package ar.edu.utn.ba.ddsi.Climalert.Service;

import ar.edu.utn.ba.ddsi.Climalert.models.entities.Clima;

public interface ClimaService {
    public Clima actualizarClima();
    public Clima getClima();
    public boolean condicionCritica(Clima weatherResponse);
}
