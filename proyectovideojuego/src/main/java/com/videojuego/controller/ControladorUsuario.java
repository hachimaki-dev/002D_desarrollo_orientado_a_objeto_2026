package com.videojuego.controller;

import com.videojuego.model.Usuario;
//import com.videojuego.model.Usuario;
import com.videojuego.model.UsuarioAdministrador;

public class ControladorUsuario {
    
    public Usuario buscar_socio_rut(String rut){
        UsuarioAdministrador user_admind = new UsuarioAdministrador();
        Usuario socio_buscado = user_admind.retornarUsuarioPorRut(rut);
        return socio_buscado;
    }

}