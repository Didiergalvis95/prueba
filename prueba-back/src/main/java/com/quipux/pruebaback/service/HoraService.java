package com.quipux.pruebaback.service;

import com.quipux.pruebaback.util.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class HoraService {

    private final Logger logger = LoggerFactory.getLogger(HoraService.class);
    private static JSONObject horas;
    private static JSONObject minutos;
    private static JSONObject decimas;
    private static JSONObject especiales;
    public String convertirTiempo(int horasNum, int minutosNum) {
        initializerJson();

        if (!validRang(horasNum, Constants.MIN_HORAS, Constants.MAX_HORAS)) {
            return "Hora fuera de rango.";
        }

        if (!validRang(minutosNum, Constants.MIN_MINUTOS, Constants.MAX_MINUTOS)) {
            return "Minutos fuera de rango.";
        }

        boolean especial = especiales.containsKey(String.valueOf(minutosNum));
        boolean sinDecimales = minutos.containsKey(String.valueOf(minutosNum));
        StringBuilder horaTxt = new StringBuilder(horas.get(String.valueOf(horasNum)).toString());

        if (especial) {
            horaTxt.append(especiales.get(String.valueOf(minutosNum)));
        } else if (sinDecimales) {
            horaTxt.append(minutos.get(String.valueOf(minutosNum)));
        } else {
            horaTxt.append(decimas.get(String.valueOf(minutosNum / 10))).append(minutos.get(String.valueOf(minutosNum % 10)));
        }

        return "La hora convertida es: " + horaTxt;
    }

    public void initializerJson() {
        try {
            ClassLoader classLoader = HoraService.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("datos.json");

            if (inputStream == null) {
                logger.error("No se pudo encontrar el archivo 'datos.json' en la carpeta resources.");
                return;
            }
            String jsonData = new String(inputStream.readAllBytes());

            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(jsonData);

            horas = (JSONObject)  data.get("horas");
            minutos = (JSONObject)  data.get("minutos");
            decimas = (JSONObject)  data.get("decimas");
            especiales = (JSONObject)  data.get("especiales");

        } catch (IOException | ParseException e) {
            logger.error("Error al inicializar JSON", e);
        }
    }

    public boolean validRang(int valor, int min, int max) {
        return valor >= min && valor < max;
    }
}
