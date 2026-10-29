package com.gamevault.model.Dao;

import java.util.ArrayList;

import com.gamevault.model.Videojuego;

public interface InventarioDao {
    ArrayList<Videojuego> obtenerTodos();
}
