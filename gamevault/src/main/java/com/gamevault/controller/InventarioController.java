package com.gamevault.controller;

import java.util.ArrayList;


import com.gamevault.model.Videojuego;
import com.gamevault.model.Dao.InventarioDao;
import com.gamevault.model.Dao.InventarioDaoJson;

public class InventarioController {

    private InventarioDao inventarioDao;

    public InventarioController(){

        this.inventarioDao = new InventarioDaoJson();


    }
    
    public ArrayList<Videojuego> obtenerInventario(){

        return inventarioDao.obtenerTodos();
    }
}
