package com.quipux.pruebaback.repository;

import com.quipux.pruebaback.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

}
