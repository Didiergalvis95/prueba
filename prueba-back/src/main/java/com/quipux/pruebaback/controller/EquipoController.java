package com.quipux.pruebaback.controller;

import com.quipux.pruebaback.entity.Equipo;
import com.quipux.pruebaback.entity.Jugador;
import com.quipux.pruebaback.service.EquipoService;
import com.quipux.pruebaback.util.dto.EquipoResponse;
import com.quipux.pruebaback.util.dto.ReporteDetallado;
import com.quipux.pruebaback.util.dto.ReporteBasico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoController {
    @Autowired
    private EquipoService service;

    @PostMapping("/crearequipo")
    public ResponseEntity<?> crearEquipo(@RequestBody List<Equipo> equipos){
        try {
            service.crearEquipo(equipos);
            return ResponseEntity.ok("Equipo creado con exito");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo crear el equipo: " + e.getMessage());
        }
    }

    @PostMapping("/crearjugador")
    public ResponseEntity<?> crearJugador(@RequestBody List<Jugador> jugadores){
        try {
            service.crearJugador(jugadores);
            return ResponseEntity.ok("Jugador creado con exito");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudo crear el Jugador: " + e.getMessage());
        }
    }

    @GetMapping("/obtenerequipos")
    public ResponseEntity<?> obtenerEquipo(){
        try {
            List<EquipoResponse> response = service.obtenerEquipo();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudieron obtener los equipos: " + e.getMessage());
        }
    }

    @GetMapping("/reportedetallado")
    public ResponseEntity<?> reporteDetallado(){
        try {
            List<ReporteDetallado> response = service.reporteDetallado();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudieron obtener los equipos: " + e.getMessage());
        }
    }

    @GetMapping("/reportebasico")
    public ResponseEntity<?> reporteBasico(){
        try {
            List<ReporteBasico> response = service.reporteBasico();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("No se pudieron obtener los equipos: " + e.getMessage());
        }
    }
}
