package com.gallegos.steamtemu.Model.Dao;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.gallegos.steamtemu.Model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UsuarioDaoJson implements UsuarioDAO{
    @Override
    public List<Usuario> obtenerTodos() {
        try (Reader reader = new InputStreamReader(UsuarioDaoJson.class.getResourceAsStream("/UserData.json"))) {
            Type listType = new TypeToken<ArrayList<Usuario>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Usuario buscarPorRut(String rut) {
        if (rut == null) return null;
        String rutBuscado = rut.trim();
        
        List<Usuario> usuarios = obtenerTodos();
        for (Usuario u : usuarios) {
            if (u.getRut().equalsIgnoreCase(rutBuscado)) {
                return u;
            }
        }
        return null;
    }
}
