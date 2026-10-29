package com.gamevault.dao;

import java.util.ArrayList;
import java.util.List;
import com.gamevault.model.Usuario;

public class UsuarioDAOMemoria implements UsuarioDAO {
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override 
    public void guardarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
