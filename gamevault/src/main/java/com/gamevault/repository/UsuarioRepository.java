package com.gamevault.repository;

import java.util.List;
import java.util.Optional;

import com.gamevault.dao.UsuarioDAO;
import com.gamevault.model.Usuario;

public class UsuarioRepository {
    private final UsuarioDAO dao;

    public UsuarioRepository(UsuarioDAO dao) {
        this.dao = dao;
    }

    public List<Usuario> todos() {
        return dao.obtenerTodos();
    }

    public Optional<Usuario> buscarPorRut(String rut) {
        return dao.buscarPorRut(rut);
    }
}