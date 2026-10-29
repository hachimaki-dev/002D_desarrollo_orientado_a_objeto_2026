package com.gamevault.model;
import com.google.gson.*;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InventarioManager {
    private ArrayList<VideoJuego> inventario = new ArrayList<>();

    public InventarioManager() {
        try {
            InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/inventario.json"));
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            Gson gson = new Gson();
            for (JsonElement elemento : jsonArray) {
                JsonObject obj = elemento.getAsJsonObject();
                String tipo = obj.get("tipo").getAsString();
                
                switch (tipo) {
                    case "fisico":
                        inventario.add(gson.fromJson(obj, JuegoFisico.class));
                        break;
                    case "digital":
                        inventario.add(gson.fromJson(obj, JuegoDigital.class));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo inventario: " + e.getMessage());
        }
    }
    public ArrayList<VideoJuego> getInventario() {
        return inventario;}
}