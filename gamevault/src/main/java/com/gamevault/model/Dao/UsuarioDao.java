package com.gamevault.model.Dao;

import java.util.ArrayList;

import com.gamevault.model.Usuario;

public interface UsuarioDao {

    ArrayList<Usuario> obtenerTodos();
    Usuario buscarPorRut(String rut);
} 
