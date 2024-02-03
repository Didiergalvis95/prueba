package com.quipux.pruebaback.controller;

import com.quipux.pruebaback.service.NumeroEnteroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numero")
public class NumeroEnteroController {
    @Autowired
    private NumeroEnteroService service;

    @GetMapping("/entero")
    public ResponseEntity<?> numeroEntero(@RequestParam int numero){
        try {
            String respuesta = service.numeroEntero(numero);
            return ResponseEntity.ok(respuesta);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en la informacion: " + e.getMessage());
        }
    }
}
