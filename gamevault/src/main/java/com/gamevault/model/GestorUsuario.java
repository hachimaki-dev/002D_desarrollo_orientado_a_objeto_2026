package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class GestorUsuario {

    ArrayList<Usuario> usuario_ArrayList = new ArrayList<>();

    public GestorUsuario(){
        cargarInformacion();
    }
    public void cargarInformacion(){
        InputStream informacion = getClass().getResourceAsStream("/usuarios.json");
        InputStreamReader lector = new InputStreamReader(informacion);

        Gson gson = new Gson();

        Usuario[] usuario = gson.fromJson(lector, Usuario[].class);

        for (Usuario info_usuario : usuario) {
            usuario_ArrayList.add(info_usuario);
        }
    }

    public void existe(){
        
    }
}
