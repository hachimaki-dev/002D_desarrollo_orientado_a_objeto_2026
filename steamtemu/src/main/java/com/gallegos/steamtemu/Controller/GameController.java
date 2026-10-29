package com.gallegos.steamtemu.Controller;

import java.util.List;

import com.gallegos.steamtemu.Model.GameManager;
import com.gallegos.steamtemu.Model.Videojuego;

public class GameController {
    private List<Videojuego> inventario;

    public GameController() {
        this.inventario = GameManager.cargarInventario();
    }

    public List<Videojuego> obtenerInventario() {
        return inventario;
    }
}
