package com.gamevault.Controller;

import com.gamevault.Model.Usuario;
import com.gamevault.Model.UsuarioManager;

public class UsuarioController {
    UsuarioManager userManager;

    public UsuarioController()
    {
        userManager = new UsuarioManager();
    }

    public Usuario buscarPorRut(String rut)
    {
        return userManager.buscarPorRut(rut);
    }
}
