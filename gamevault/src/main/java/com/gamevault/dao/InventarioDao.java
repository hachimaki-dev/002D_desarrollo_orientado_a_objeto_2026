package com.gamevault.dao;
import com.gamevault.model.VideoJuego;
import java.util.List;

public interface InventarioDao {
    List<VideoJuego> obtenerTodos();
}
