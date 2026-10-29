package com.gamevault.controller;
import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;

public class UsuarioController{
    private UsuarioManager usuarioManager;

    public UsuarioController(){
        this.usuarioManager = new UsuarioManager();
    }
    public Usuario buscarPorRut(String rut){
        if (rut == null || rut.trim().isEmpty()){
            return null;
        }
        String rutBuscadoLimpio = rut.replaceAll("[^0-9kK]", "").toLowerCase();
        for (Usuario u : usuarioManager.getUsuarios()){
            if (u.getRut() != null){
                String uRutLimpio = u.getRut().replaceAll("[^0-9kK]", "").toLowerCase();
   
                if (uRutLimpio.equals(rutBuscadoLimpio)){
                    return u;
                }
            }
        }
        return null;
    }
}