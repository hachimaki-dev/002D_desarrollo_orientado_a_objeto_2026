package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class InventarioManager {
    public ArrayList<Videojuego> cargarInventario(){
        InputStream stream = InventarioManager.class.getResourceAsStream("/inventario.json");
        Gson gson = new Gson();
        JsonObject[] datos = gson.fromJson(new InputStreamReader(stream), JsonObject[].class);
        ArrayList<Videojuego> lista = new ArrayList<>();
        for (JsonObject o : datos) {
            switch (o.get("tipo").getAsString()) {
                case "fisico":
                    lista.add(new JuegoFisico(o.get("titulo").getAsString(), o.get("plataforma").getAsString(), o.get("portada").getAsString(), o.get("stockTienda").getAsInt(), o.get("pesoGramos").getAsInt()));
                    
                    break;
                case "digital":
                    lista.add(new JuegoDigital(o.get("titulo").getAsString(), o.get("plataforma").getAsString(), o.get("portada").getAsString(), o.get("tamanoGB").getAsDouble(), o.get("codigoActivacion").getAsString()));
                    break;

                default:
                    break;
            }
            
        }
        return lista;
    }
}
