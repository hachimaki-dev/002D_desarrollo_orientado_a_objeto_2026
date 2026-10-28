package com.videojuego.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioAdministrador {

    private ArrayList<Usuario> socios_Arraylist = new ArrayList<>();

    
    public UsuarioAdministrador(){ //cuando se cree una instacia de UsuarioAdministrador, se carga automatico cargarDatos Usuario
        cargarDatosUsuarios();
    }

    public void cargarDatosUsuarios() {
        InputStream capturador = getClass().getResourceAsStream("/InventarioUsuario.json");
        InputStreamReader lector = new InputStreamReader(capturador);

        Gson gson = new Gson();
        Usuario[] socios = gson.fromJson(lector, Usuario[].class); //cada objeto del json lo transforma clase tipo usuario

       for (Usuario usuario : socios ) {

        socios_Arraylist.add(usuario);

       }
    }

    public Usuario retornarUsuarioPorRut(String rut){
        for (Usuario usuario : socios_Arraylist) { // si el rut buscado coincide, va a retornar la info del rut con el q coincidio
            if(usuario.getRut().equals(rut)){
                return usuario;
            }
        }
        return null;
    }


}
