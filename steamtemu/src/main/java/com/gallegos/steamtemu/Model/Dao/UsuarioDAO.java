package com.gallegos.steamtemu.Model.Dao;

import java.util.List;

import com.gallegos.steamtemu.Model.Usuario;

public interface UsuarioDAO {
    List<Usuario> obtenerTodos();
    Usuario buscarPorRut(String rut);
}
