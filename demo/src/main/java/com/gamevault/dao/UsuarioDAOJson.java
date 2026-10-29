package com.gamevault.dao;

import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOJson implements UsuarioDAO {

    private final List<Usuario> usuarios = new ArrayList<>();

    public UsuarioDAOJson() {
        usuarios.addAll(new UsuarioManager().cargarDatos());
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return new ArrayList<>(usuarios);
    }
}