package com.gamevault.controller;
import com.gamevault.dao.InventarioDao;
import com.gamevault.dao.InventarioDaoJson;
import com.gamevault.model.VideoJuego;
import java.util.List;

public class InventarioController{
    private InventarioDao inventarioDao;
    public InventarioController() {
        this.inventarioDao = new InventarioDaoJson(); 
    }
    public List<VideoJuego> obtenerInventario(){
        return inventarioDao.obtenerTodos();
    }
}