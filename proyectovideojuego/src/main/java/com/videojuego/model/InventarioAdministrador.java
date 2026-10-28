package com.videojuego.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class InventarioAdministrador  {

    private ArrayList<VideoJuego> inventarios_juegos = new ArrayList<>();

    public InventarioAdministrador(){
        cargarInventario();
    }

    public void cargarInventario(){
        InputStream capturador = getClass().getResourceAsStream("/InventarioJuegos.json");
        InputStreamReader lector = new InputStreamReader(capturador);
        

        Gson gson = new Gson();
        VideoJuego[] inventario = gson.fromJson(lector, VideoJuego[].class);

        for (VideoJuego videoJuego : inventario) {
            inventarios_juegos.add(videoJuego);
            
        }
    }
}
