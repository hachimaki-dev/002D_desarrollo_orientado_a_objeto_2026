package com.gallegos155.gamebault.Controller;

import com.gallegos155.gamebault.Model.User;
import com.gallegos155.gamebault.Model.UserManager;

public class UserController {
    public User solicitarUsuarioPorRut(String rut){

        UserManager userManager = new UserManager();
        User usuario = userManager.buscarUsuarioPorRut(rut);
        return usuario;
    }
}
