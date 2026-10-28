package com.gamevault.controller;

import com.gamevault.model.InventarioManager;
import com.gamevault.model.Videojuego;

import java.util.List;

public class InventarioController {
    private InventarioManager inventarioManager;

    public InventarioController() {
        this.inventarioManager = new InventarioManager();
    }

    public List<Videojuego> getInventario() {
        return inventarioManager.getInventario();
    }
}