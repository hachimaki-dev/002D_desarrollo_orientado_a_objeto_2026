package com.gamevault.controller;

import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;

public class UsuarioController {
    UsuarioManager manager = new UsuarioManager();

    public Usuario buscarPorRut(String rut) {
        String rut_limpio = rut.trim();
        Usuario u = manager.buscarPorRut(rut_limpio);
        return u;
    }
}

