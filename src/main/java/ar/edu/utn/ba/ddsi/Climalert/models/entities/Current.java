package ar.edu.utn.ba.ddsi.Climalert.models.entities;

public record Current(
        String last_updated,
        double temp_c,
        double feelslike_c,
        int humidity,
        double wind_kph,
        String wind_dir,
        double pressure_mb,
        double precip_mm,
        int cloud,
        double vis_km,
        double uv
) {
}