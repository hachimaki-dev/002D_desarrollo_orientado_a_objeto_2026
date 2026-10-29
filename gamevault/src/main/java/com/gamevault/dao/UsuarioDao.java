package com.gamevault.dao;
import com.gamevault.model.Usuario;
import java.util.List;

public interface UsuarioDao{
    Usuario obtenerPorRut(String rut);
    List<Usuario> obtenerTodos();
}