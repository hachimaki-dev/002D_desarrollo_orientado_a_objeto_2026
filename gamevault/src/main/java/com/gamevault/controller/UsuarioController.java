package com.gamevault.controller;



import com.gamevault.model.Usuario;

import com.gamevault.model.Dao.UsuarioDao;
import com.gamevault.model.Dao.UsuarioDaojson;

public class UsuarioController {
    private UsuarioDao usuarioDao;

    

    public UsuarioController(){

        this.usuarioDao = new UsuarioDaojson();
    }

    public Usuario buscarPorRut(String rut){

        return usuarioDao.buscarPorRut(rut);


    }
}
