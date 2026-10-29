package com.gallegos.steamtemu.Model;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GameManager {
    public static List<Videojuego> cargarInventario() {
        List<Videojuego> lista = new ArrayList<>();
        try (Reader reader = new InputStreamReader(GameManager.class.getResourceAsStream("/GameData.json"))) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            Gson gson = new Gson();

            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                String tipo = obj.get("tipo").getAsString();
                String titulo = obj.get("titulo").getAsString();
                String plataforma = obj.get("plataforma").getAsString();
                String portada = obj.get("portada").getAsString();

                switch (tipo.toLowerCase()) {
                    case "fisico":
                        int stock = obj.get("stockTienda").getAsInt();
                        int peso = obj.get("pesoGramos").getAsInt();
                        lista.add(new JuegoFisico(titulo, plataforma, portada, stock, peso));
                        break;
                    case "digital":
                        double tamano = obj.get("tamanoGB").getAsDouble();
                        String codigo = obj.get("codigoActivacion").getAsString();
                        lista.add(new JuegoDigital(titulo, plataforma, portada, tamano, codigo));
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
