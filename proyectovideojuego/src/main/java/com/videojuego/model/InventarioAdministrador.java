package com.videojuego.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class InventarioAdministrador  {

    private ArrayList<VideoJuego> inventario_juegos = new ArrayList<>();

    public InventarioAdministrador(){
        cargarInventario();
    }

public void cargarInventario(){
    InputStream capturador = getClass().getResourceAsStream("/InventarioJuegos.json");
    InputStreamReader lector = new InputStreamReader(capturador);

    Gson gson = new Gson();
    JsonObject[] inventario = gson.fromJson(lector, JsonObject[].class);

    for (JsonObject objetoJson : inventario) {

        String tipo = objetoJson.get("tipo").getAsString();
        String titulo = objetoJson.get("titulo").getAsString();
        String plataforma = objetoJson.get("plataforma").getAsString();
        String portadaUrl = objetoJson.get("portada").getAsString();

        VideoJuego videoJuego = null;

        switch (tipo) {
            case "fisico":
                int stockTienda = objetoJson.get("stockTienda").getAsInt();
                int pesoGramos = objetoJson.get("pesoGramos").getAsInt();
                videoJuego = new JuegoFisico(titulo, plataforma, portadaUrl, stockTienda, pesoGramos);
                break;
            case "digital":
                double tamanoGB = objetoJson.get("tamanoGB").getAsDouble();
                String codigoActivacion = objetoJson.get("codigoActivacion").getAsString();
                videoJuego = new JuegoDigital(titulo, plataforma, portadaUrl, tamanoGB, codigoActivacion);
                break;
        }

        inventario_juegos.add(videoJuego);
    }
 }
}
