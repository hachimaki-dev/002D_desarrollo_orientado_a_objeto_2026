package com.gallegos115.biblioapp.Controller;

import com.gallegos115.biblioapp.Model.User;
import com.gallegos115.biblioapp.Model.UserManager;

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
