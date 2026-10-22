package com.ferdev.biblioapp.controller;

import com.ferdev.biblioapp.model.User;
import com.ferdev.biblioapp.model.UserManager;

public class UserController {
    public void Test(){
        UserManager userManager = new UserManager();
        userManager.prueba();
    }
    public User SolicitarUserRut(String rut){
        UserManager manageruser = new UserManager();
        User user = manageruser.buscarUsuarioRut(rut);
        return user;

    }
}
