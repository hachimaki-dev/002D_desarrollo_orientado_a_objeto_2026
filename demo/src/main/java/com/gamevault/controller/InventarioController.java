package com.gamevault.controller;

import java.util.ArrayList;

import com.gamevault.model.InventarioManager;
import com.gamevault.model.Videojuego;

public class InventarioController {
    public ArrayList<Videojuego> obtenerInformacion(){
        InventarioManager manager = new InventarioManager();
        return manager.cargarInventario();
    }
    
}
