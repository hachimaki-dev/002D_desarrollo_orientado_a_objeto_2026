package com.videojuego.controller;

import java.util.ArrayList;

import com.videojuego.model.InventarioAdministrador;
import com.videojuego.model.VideoJuego;

public class ControladorInventario {
    private InventarioAdministrador inventario_admin = new InventarioAdministrador();
    public ArrayList<VideoJuego> obtenerInventario(){

        return inventario_admin.getInventario(); 
    }

}
