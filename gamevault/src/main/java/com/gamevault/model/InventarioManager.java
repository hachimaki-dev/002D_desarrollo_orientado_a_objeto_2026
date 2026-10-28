package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class InventarioManager {
    
    ArrayList<Videojuego> juego_ArrayList = new ArrayList<>();

    public InventarioManager(){
        cargarInformacion();
    }
    public void cargarInformacion(){
        InputStream informacion = getClass().getResourceAsStream("/inventario.json");
        InputStreamReader lector = new InputStreamReader(informacion);

        Gson gson = new Gson();

        Videojuego[] juego = gson.fromJson(lector, Videojuego[].class);

        for (Videojuego info_juego : juego){
            juego_ArrayList.add(info_juego);
        }
    }

    public void existe(){
        
    }
}
