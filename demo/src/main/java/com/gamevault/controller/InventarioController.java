package com.gamevault.controller;

import com.gamevault.model.InventarioManager;
import com.gamevault.model.Videojuego;
import java.util.ArrayList;

public class InventarioController {
    public ArrayList<Videojuego> obtenerInventario(){
        InventarioManager manager = new InventarioManager();
        return manager.cargarInventario();
    }
}
