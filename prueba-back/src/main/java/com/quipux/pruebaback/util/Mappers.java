package com.quipux.pruebaback.util;

import com.quipux.pruebaback.entity.Equipo;
import com.quipux.pruebaback.entity.Jugador;
import com.quipux.pruebaback.util.dto.ReporteDetallado;
import com.quipux.pruebaback.util.dto.JugadorResponse;
import com.quipux.pruebaback.util.dto.ReporteBasico;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class Mappers {
    public ReporteDetallado mapEquipoToResponseConJugadores(Equipo equipo) {
        ReporteDetallado reporteDetallado = new ReporteDetallado();
        reporteDetallado.setNombre(equipo.getNombre());

        List<JugadorResponse> jugadoresResponse = equipo.getJugadores().stream()
                .sorted(Comparator.comparing(Jugador::getRol)) // Ordena por rol
                .map(this::mapJugadorToResponse)
                .collect(Collectors.toList());

        reporteDetallado.setJugadores(jugadoresResponse);

        return reporteDetallado;
    }

    public JugadorResponse mapJugadorToResponse(Jugador jugador) {
        JugadorResponse jugadorResponse = new JugadorResponse();
        jugadorResponse.setNombre(jugador.getNombre());
        jugadorResponse.setPosicion(jugador.getPosicion());
        jugadorResponse.setRol(jugador.getRol());

        return jugadorResponse;
    }

    public ReporteBasico mapToObject(Object[] resultado) {
        ReporteBasico reporte = new ReporteBasico();
        reporte.setNombre((String) resultado[0]);
        reporte.setTitulo((int) resultado[1]);
        reporte.setCantJugadores((Long) resultado[2]);
        return reporte;
    }
}
