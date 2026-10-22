package com.hachimakidev.biblioapp.controller;

import com.hachimakidev.biblioapp.model.User;
import com.hachimakidev.biblioapp.model.UserManager;

public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.seraVerdad();
    }

    public User solicitarUsuarioPorRut(String rut)
    {
        UserManager userManager = new UserManager();

        return userManager.getUserByRut(rut);
    }
}
