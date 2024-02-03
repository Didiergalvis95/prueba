package com.quipux.pruebaback.service;

import com.quipux.pruebaback.entity.Equipo;
import com.quipux.pruebaback.entity.Jugador;
import com.quipux.pruebaback.repository.EquipoRepository;
import com.quipux.pruebaback.repository.JugadorRepository;
import com.quipux.pruebaback.util.dto.EquipoResponse;
import com.quipux.pruebaback.util.dto.ReporteDetallado;
import com.quipux.pruebaback.util.Mappers;
import com.quipux.pruebaback.util.dto.ReporteBasico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private Mappers mappers;
    public void crearEquipo(List<Equipo> equipos) {
        for (Equipo equipo : equipos) {
            equipoRepository.save(equipo);
        }
    }

    public void crearJugador(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            Equipo equipo = equipoRepository.findById(jugador.getEquipo().getId())
                    .orElseThrow(() -> new NoSuchElementException("No se encontró el equipo con ID: " + jugador.getEquipo().getId()
                    + ". Primero debe crear los equipos."));
            jugador.setEquipo(equipo);
            jugadorRepository.save(jugador);
        }
    }

    public List<EquipoResponse> obtenerEquipo(){
        List<Equipo> equipos = equipoRepository.findAll();

        return equipos.stream()
                .map(equipo -> new EquipoResponse(equipo.getId(), equipo.getNombre()))
                .collect(Collectors.toList());
    }

    public List<ReporteDetallado> reporteDetallado() {
        List<Equipo> equipos = equipoRepository.findAll();

        return equipos.stream()
                .map(mappers::mapEquipoToResponseConJugadores)
                .collect(Collectors.toList());
    }

    public List<ReporteBasico> reporteBasico() {
        List<Object[]> resultados = equipoRepository.obtenerReporte();

        List<ReporteBasico> reportes = resultados.stream()
                .map(mappers::mapToObject)
                .collect(Collectors.toList());

        return reportes;
    }

}
