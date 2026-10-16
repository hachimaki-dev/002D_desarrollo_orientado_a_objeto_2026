package com.bibliotech.controller;

import com.bibliotech.model.User;
import com.bibliotech.model.UserManager;

public class UserController {
    private UserManager manager;

    public UserController() {
        manager = new UserManager();
    }

    public boolean datosDisponibles() {
        return manager.isDatosCargados();
    }

    public User buscarUsuario(String rut_ingresado) {
        String rut_limpio = rut_ingresado.trim();
        return manager.buscarPorRut(rut_limpio);
    }
}
