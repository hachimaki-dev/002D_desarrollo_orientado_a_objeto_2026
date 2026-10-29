package com.gamevault.controller;

import com.gamevault.model.Usuario;
import com.gamevault.dao.UsuarioDAO;

public class UsuarioController {
    private final UsuarioDAO dao;

    public UsuarioController(UsuarioDAO dao) {
        this.dao = dao;
    }

    
    public Usuario buscarPorRut(String rut) {
        if (rut == null || rut.trim().isEmpty()) {
            throw new IllegalArgumentException("El RUT no puede ser nulo o vacio.");
        }

        String rutBuscado = normalizarRut(rut);

        for (Usuario u : dao.obtenerUsuarios()) {
            if (normalizarRut(u.getRut()).equals(rutBuscado)) {
                return u;
            }
        }
        return null;
        }

        private String normalizarRut(String rut) {
            return rut.replace(".", "").replace(" ", "").toUpperCase();
        }
    }



