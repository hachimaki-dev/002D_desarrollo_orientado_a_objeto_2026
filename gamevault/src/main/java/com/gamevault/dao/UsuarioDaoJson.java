package com.gamevault.dao;
import com.gamevault.model.Usuario;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJson implements UsuarioDao {
    private List<Usuario> usuarios = new ArrayList<>();
    public UsuarioDaoJson() {
        cargarDesdeJson();
    }
    private void cargarDesdeJson() {
        try {
            InputStream is = getClass().getResourceAsStream("/usuarios.json");
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                Gson gson = new Gson();
                Usuario[] array = gson.fromJson(reader, Usuario[].class);
                if (array != null) {
                    for (Usuario u : array) {
                        usuarios.add(u);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error en UsuarioDAOJson: " + e.getMessage());
        }
    }
    @Override
    public Usuario obtenerPorRut(String rut) {
        if (rut == null || rut.trim().isEmpty()) return null;
        String rutLimpio = rut.replaceAll("[^0-9kK]", "").toLowerCase();

        for (Usuario u : usuarios) {
            if (u.getRut() != null) {
                String uRutLimpio = u.getRut().replaceAll("[^0-9kK]", "").toLowerCase();
                if (uRutLimpio.equals(rutLimpio)) {
                    return u;
                }
            }
        }
        return null;
    }
    @Override
    public List<Usuario> obtenerTodos() {
        return usuarios;
    }
}