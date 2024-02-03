package com.quipux.pruebaback.util.dto;

import java.util.List;

public class ReporteDetallado {
    private String nombre;
    private List<JugadorResponse> jugadores;

    public ReporteDetallado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<JugadorResponse> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadorResponse> jugadores) {
        this.jugadores = jugadores;
    }
}
