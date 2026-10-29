package com.gallegos.steamtemu.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    
    public static List<Usuario> cargarUsuarios() {
        try (Reader reader = new InputStreamReader(UsuarioManager.class.getResourceAsStream("/UserData.json"))) {
            Type listType = new TypeToken<ArrayList<Usuario>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Usuario buscarPorRut(String rut) {
        if (rut == null) return null;
        String rutBuscado = rut.trim();
        
        // Cargamos la lista directamente desde el JSON
        List<Usuario> usuarios = cargarUsuarios();
        
        for (Usuario u : usuarios) {
            if (u.getRut().equalsIgnoreCase(rutBuscado)) {
                return u;
            }
        }
        return null;
    }
}