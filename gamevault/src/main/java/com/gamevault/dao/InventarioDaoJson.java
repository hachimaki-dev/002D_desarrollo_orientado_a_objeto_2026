package com.gamevault.dao;
import com.gamevault.model.JuegoDigital;
import com.gamevault.model.JuegoFisico;
import com.gamevault.model.VideoJuego;
import com.google.gson.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InventarioDaoJson implements InventarioDao{
    private List<VideoJuego> inventario = new ArrayList<>();
    public InventarioDaoJson(){
        cargarDesdeJson();
    }
    private void cargarDesdeJson(){
        try{
            InputStreamReader reader = new InputStreamReader(getClass().getResourceAsStream("/inventario.json"));
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            Gson gson = new Gson();
            for (JsonElement elemento : jsonArray){
                JsonObject obj = elemento.getAsJsonObject();
                String tipo = obj.get("tipo").getAsString();
                switch (tipo){
                    case "fisico":
                        inventario.add(gson.fromJson(obj, JuegoFisico.class));
                        break;
                    case "digital":
                        inventario.add(gson.fromJson(obj, JuegoDigital.class));
                        break;
                }
            }
        } catch (Exception e){
            System.out.println("Error en InventarioDAOJson: " + e.getMessage());
        }
    }
    @Override
    public List<VideoJuego> obtenerTodos(){
        return inventario;
    }
}