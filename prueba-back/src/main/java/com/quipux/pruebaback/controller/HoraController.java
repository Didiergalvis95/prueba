package com.quipux.pruebaback.controller;

import com.quipux.pruebaback.service.HoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hora")
public class HoraController {

    @Autowired
    private HoraService service;

    @GetMapping("/convertirtiempo")
    public ResponseEntity<?> convertirTiempo(@RequestParam int hora, @RequestParam int minuto){
        try {
        String tiempoTexto = service.convertirTiempo(hora, minuto);
            return ResponseEntity.ok(tiempoTexto);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al convertir tiempo: " + e.getMessage());
        }
    }
}
