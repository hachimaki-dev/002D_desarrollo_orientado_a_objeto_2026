package com.gamevault.controller;

import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;

public class UsuarioController {
    private UsuarioManager usuarioManager;

    public UsuarioController() {
        this.usuarioManager = new UsuarioManager();
    }

    public Usuario buscarPorRut(String rut) {
        if (rut == null || rut.trim().isEmpty()) {
            return null;
        }
        return usuarioManager.buscarPorRut(rut.trim());
    }
}