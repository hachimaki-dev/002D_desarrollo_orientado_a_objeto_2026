package com.gamevault.controller;

import java.util.ArrayList;

import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;

public class UsuarioController {

    public Usuario buscarPorRut(String rut){
        UsuarioManager manager = new UsuarioManager();
        ArrayList<Usuario> usuarios = manager.cargarDatos();
        for (Usuario u : usuarios) {
            if (u.getRut().equals(rut)) {
                return u;
                
            }
            
        }
        return null;

    }
    
}
