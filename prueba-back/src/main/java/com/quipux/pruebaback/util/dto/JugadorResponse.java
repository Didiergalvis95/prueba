package com.quipux.pruebaback.util.dto;

import com.quipux.pruebaback.entity.Equipo;

public class JugadorResponse {
    private String nombre;
    private String posicion;
    private String rol;

    public JugadorResponse() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
