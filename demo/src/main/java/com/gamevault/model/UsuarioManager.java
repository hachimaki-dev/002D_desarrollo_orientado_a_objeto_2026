package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UsuarioManager {
    public ArrayList<Usuario> cargarDatos(){
        InputStream stream = UsuarioManager.class.getResourceAsStream("/usuarios.json");
        Gson gson = new Gson();
        ArrayList<Usuario> lista = gson.fromJson(new InputStreamReader(stream), new TypeToken<ArrayList<Usuario>>(){}.getType());
        for (Usuario u : lista) {
            u.setNivelGamer(u.getNivelGamer());
            
        }
        return lista;

    }
}
