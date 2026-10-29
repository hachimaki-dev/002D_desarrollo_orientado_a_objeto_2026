package com.gamevault.Controller;

import java.util.ArrayList;

import com.gamevault.Model.Videojuego;
import com.gamevault.Model.InventarioManager;

public class InventarioController {
    InventarioManager inventarioManager;

    public InventarioController()
    {
        inventarioManager = new InventarioManager();
    }

    public ArrayList<Videojuego> obtenerInventario()
    {
        return inventarioManager.obtenerInventario();
    }
}
