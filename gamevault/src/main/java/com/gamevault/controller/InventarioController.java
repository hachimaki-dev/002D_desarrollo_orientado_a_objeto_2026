package com.gamevault.controller;

import com.gamevault.model.InventarioManager;
import com.gamevault.model.Videojuego;
import java.util.ArrayList;

public class InventarioController {
    InventarioManager manager = new InventarioManager();

    public ArrayList<Videojuego> obtenerInventario() {
        ArrayList<Videojuego> arraylist_videojuegos = manager.obtenerInventario();
        return arraylist_videojuegos;
    }
}
