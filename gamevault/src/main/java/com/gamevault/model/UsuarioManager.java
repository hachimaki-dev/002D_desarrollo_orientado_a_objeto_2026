package com.gamevault.model;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UsuarioManager {

    ArrayList<Usuario> arraylist_usuarios = new ArrayList<>();

    public UsuarioManager() {
        loadData();
    }

    public void loadData() {
        Gson gson = new Gson();
        InputStream stream = getClass().getResourceAsStream("/usuarios.json");
        InputStreamReader reader = new InputStreamReader(stream);

        Usuario[] array_usuarios = gson.fromJson(reader, Usuario[].class);

        for (Usuario u : array_usuarios) {
            arraylist_usuarios.add(u);
        }
    }

    public Usuario buscarPorRut(String rut) {
        for (Usuario u : arraylist_usuarios) {
            if (u.getRut().equals(rut)) {
                return u;
            }
        }
        return null;
    }
}
