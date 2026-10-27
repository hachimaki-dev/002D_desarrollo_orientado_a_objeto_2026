package com.hachimakidev.biblioapp.controller;

import com.hachimakidev.biblioapp.model.User;
import com.hachimakidev.biblioapp.model.UserManager;

public class UserController {
    
    public void test(){
        UserManager userManager = new UserManager();
        userManager.seraVerdad();
    }

    public User solicitarUsuarioPorRut(String rut){
        UserManager manager_usuario = new UserManager();
        User usuario = manager_usuario.buscar_usuario_por_rut(rut);
        return usuario;
    }

}