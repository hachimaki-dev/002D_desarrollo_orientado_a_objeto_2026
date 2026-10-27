package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class InventarioManager {

    ArrayList<Videojuego> arraylist_videojuegos = new ArrayList<>();

    public InventarioManager() {
        loadData();
    }

    public void loadData() {
        Gson gson = new Gson();
        InputStream stream = getClass().getResourceAsStream("/inventario.json");
        InputStreamReader reader = new InputStreamReader(stream);

        Videojuego[] array_videojuegos = gson.fromJson(reader, Videojuego[].class);

        for (Videojuego v : array_videojuegos) {
            arraylist_videojuegos.add(v);
        }
    }

    public ArrayList<Videojuego> obtenerInventario() {
        return arraylist_videojuegos;
    }
}