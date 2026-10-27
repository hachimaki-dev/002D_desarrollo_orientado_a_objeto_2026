package com.gamevault.controller;
import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;

public class UsuarioController {
    public void buscarPorRut(String rut){
         for(UsuarioManager encontrarRut : user_ArrayList())
      if(encontrarRut.getRut().equals(rut)){
        return encontrarRut;
      }
    }
    return null;
  }


