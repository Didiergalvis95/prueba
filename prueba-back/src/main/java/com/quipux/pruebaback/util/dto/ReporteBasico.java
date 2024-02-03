package com.quipux.pruebaback.util.dto;

public class ReporteBasico {
    private String nombre;
    private int titulo;
    private Long cantJugadores;

    public ReporteBasico() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTitulo() {
        return titulo;
    }

    public void setTitulo(int titulo) {
        this.titulo = titulo;
    }

    public Long getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(Long cantJugadores) {
        this.cantJugadores = cantJugadores;
    }
}
