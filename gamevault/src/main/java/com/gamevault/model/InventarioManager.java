package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class InventarioManager {

    ArrayList<Videojuego> arraylist_videojuegos = new ArrayList<>();

    public InventarioManager() {
        loadData();
    }

    public void loadData() {
        arraylist_videojuegos.clear();

        InputStream stream = getClass().getResourceAsStream("/inventario.json");

        if (stream == null) {
            System.out.println("No se encontró inventario.json");
            return;
        }

        InputStreamReader reader = new InputStreamReader(stream);

        JsonArray videojuegos = JsonParser.parseReader(reader).getAsJsonArray();
        Gson gson = new Gson();

        for (int i = 0; i < videojuegos.size(); i++) {
            JsonObject juego = videojuegos.get(i).getAsJsonObject();

            String tipo = juego.get("tipo").getAsString();
            String titulo = juego.get("titulo").getAsString();
            String plataforma = juego.get("plataforma").getAsString();
            String portada = juego.get("portada").getAsString();

            if (tipo.equals("fisico")) {
                JuegoFisico fisico = gson.fromJson(juego, JuegoFisico.class);

                arraylist_videojuegos.add(
                        new JuegoFisico(
                                fisico.getPesoGramos(),
                                fisico.getStockTienda(),
                                plataforma,
                                portada,
                                titulo));

            } else if (tipo.equals("digital")) {
                JuegoDigital digital = gson.fromJson(juego, JuegoDigital.class);

                arraylist_videojuegos.add(
                        new JuegoDigital(
                                digital.getCodigoActivacion(),
                                digital.getTamañoGB(),
                                plataforma,
                                portada,
                                titulo));
            }
        }

        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar el archivo JSON");
        }
    }

    public ArrayList<Videojuego> obtenerInventario() {
        return arraylist_videojuegos;
    }
}