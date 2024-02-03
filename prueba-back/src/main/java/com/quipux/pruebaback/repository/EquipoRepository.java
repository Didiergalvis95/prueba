package com.quipux.pruebaback.repository;

import com.quipux.pruebaback.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    @Query(value = "SELECT e.nombre, titulos, count(j.nombre) as jugadores \n" +
            "FROM equipos e INNER JOIN jugadores j ON e.id = j.equipo_id \n" +
            "GROUP BY e.nombre, titulos;", nativeQuery = true)
    List<Object[]> obtenerReporte();
}
