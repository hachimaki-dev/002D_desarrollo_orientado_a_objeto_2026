package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class InventarioManager {
    private ArrayList<Videojuego> lista_videojuegos = new ArrayList<>();

    public Videojuego[] leerinventario(){
        


        InputStream stream = getClass().getResourceAsStream("/users.json");
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        Videojuego[] arreglogson = gson.fromJson(reader, Videojuego[].class);
        return arreglogson;
    }
    
}
