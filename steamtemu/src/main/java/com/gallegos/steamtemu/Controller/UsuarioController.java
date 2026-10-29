package com.gallegos.steamtemu.Controller;

import java.util.List;

import com.gallegos.steamtemu.Model.Usuario;
import com.gallegos.steamtemu.Model.UsuarioManager;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        this.usuarios = UsuarioManager.cargarUsuarios();
    }

    public Usuario buscarPorRut(String rut) {
        if (rut == null) return null;
        String rutBusqueda = rut.trim();
        for (Usuario u : usuarios) {
            if (u.getRut().equalsIgnoreCase(rutBusqueda)) {
                return u;
            }
        }
        return null;
    }
}
