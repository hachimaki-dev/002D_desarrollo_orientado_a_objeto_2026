package com.videojuego.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioAdministrador {

    ArrayList<Usuario> usuario_Arraylist = new ArrayList<>();

    public void UsuarioAdministrador(){
        cargarUsuarios();
    }
    
    public void cargarUsuarios() {
        InputStream cadena = getClass().getResourceAsStream("/InventarioUsuario.json");
        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();
        Usuario[] arreglo = gson.fromJson(lector, Usuario[].class);

       for (Usuario usuario : arreglo ) {

        usuario_Arraylist.add(usuario);

       }
    }

    

}
