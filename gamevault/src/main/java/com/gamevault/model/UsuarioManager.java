package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioManager {
    ArrayList<Usuario> user_ArrayList = new ArrayList<>();

    public UsuarioManager(){
        loadData();
    }

    public void loadData(){
        InputStream cadenaUsuario = getClass().getResourceAsStream("/usuarios.json");
        InputStreamReader lectorUsuario = new InputStreamReader(cadenaUsuario);

        Gson gson = new Gson();

        Usuario[] usuarios = gson.fromJson(lectorUsuario, Usuario[].class);

        for ( Usuario usuario : usuarios){
            user_ArrayList.add(usuario);
        }
    }
}
