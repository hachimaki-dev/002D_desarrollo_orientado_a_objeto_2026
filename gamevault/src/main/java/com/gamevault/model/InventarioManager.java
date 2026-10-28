package com.gamevault.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class InventarioManager {
    private List<Videojuego> inventario;

    public InventarioManager() {
        this.inventario = new ArrayList<>();
        cargarInventario();
    }

    public void cargarInventario() {
        Gson gson = new Gson();
        try (Reader reader = new InputStreamReader(
                getClass().getResourceAsStream("/inventario.json"), StandardCharsets.UTF_8)) {

            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String tipo = jsonObject.has("tipo") ? jsonObject.get("tipo").getAsString() : "";

                switch (tipo.toLowerCase()) {
                    case "físico":
                    case "fisico":
                        JuegoFisico fisico = gson.fromJson(jsonObject, JuegoFisico.class);
                        inventario.add(fisico);
                        break;
                    case "digital":
                        JuegoDigital digital = gson.fromJson(jsonObject, JuegoDigital.class);
                        inventario.add(digital);
                        break;
                    default:
                        System.out.println("Tipo desconocido: " + tipo);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Videojuego> getInventario() {
        return inventario;
    }
}