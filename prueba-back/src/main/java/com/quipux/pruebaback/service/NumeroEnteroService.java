package com.quipux.pruebaback.service;

import com.quipux.pruebaback.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NumeroEnteroService {

    public String numeroEntero(int numero) {
        String respuesta = "";

        if (!validRang(numero, Constants.MIN_NUM, Constants.MAX_NUM)) {
            return "Numero fuera de rango.";
        }

        if (numero % 2 != 0) {
            respuesta = Constants.QUIPUX;
        } else {
            if (numero >= 2 && numero <= 5) {
                respuesta = Constants.NO_QUIPUX;
            } else if (numero >= 6 && numero <= 20) {
                respuesta = Constants.QUIPUX;
            } else {
                respuesta = Constants.NO_QUIPUX;
            }
        }

        return respuesta;
    }

    public boolean validRang(int valor, int min, int max) {
        return valor >= min && valor <= max;
    }

}
