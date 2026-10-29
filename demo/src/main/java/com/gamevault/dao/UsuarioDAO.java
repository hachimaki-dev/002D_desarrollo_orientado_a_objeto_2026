package com.gamevault.dao;

import java.util.List;
import com.gamevault.model.Usuario;

public interface UsuarioDAO {
    void guardarUsuario(Usuario usuario);
    List <Usuario> obtenerUsuarios();
}