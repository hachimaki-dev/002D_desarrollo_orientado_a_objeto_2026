package com.gamevault.dao;

import java.util.List;
import java.util.Optional;

import com.gamevault.model.Usuario;

public interface UsuarioDAO {
    List<Usuario> obtenerTodos();
    Optional<Usuario> buscarPorRut(String rut);
}
