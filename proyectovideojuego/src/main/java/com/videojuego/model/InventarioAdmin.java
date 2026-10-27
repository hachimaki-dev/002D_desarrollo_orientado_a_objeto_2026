package com.videojuego.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class InventarioAdmin  {

    private ArrayList<VideoJuego> inventarios_juegos = new ArrayList<>();

    public InventarioAdmin(){
        cargarInventario();
    }

    public void cargarInventario(){
        InputStream cadena = getClass().getResourceAsStream("/InventarioJuegos.json");
        InputStreamReader lector = new InputStreamReader(cadena);
        

        Gson gson = new Gson();
        VideoJuego[] arreglo = gson.fromJson(lector, VideoJuego[].class);

        for (VideoJuego videoJuego : arreglo) {
            inventarios_juegos.add(videoJuego);
            
        }
    }
}
