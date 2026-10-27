package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class InventarioManager {
    ArrayList<VideoJuego> inventario_Arraylist = new ArrayList<>();

    public InventarioManager(){
        loadData();
    }

    public void loadData(){
        InputStream cadenaInventario = getClass().getResourceAsStream("/inventario.json");

        InputStreamReader lectorInventario = new InputStreamReader(cadenaInventario);

        Gson gson = new Gson();

        VideoJuego[] inventario = gson.fromJson(lectorInventario, VideoJuego[].class);

        for ( VideoJuego Inventario : inventario){
            inventario_Arraylist.add (Inventario);
        }
    }

    
}
