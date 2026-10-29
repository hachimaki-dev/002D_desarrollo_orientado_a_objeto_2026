package com.gamevault.dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamevault.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UsuarioJsonDAO implements UsuarioDAO {
    private final String rutaArchivo;
    private final Gson gson = new Gson();
    private final Type tipoLista = new TypeToken<List<Usuario>>() {
    }.getType();

    public UsuarioJsonDAO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<Usuario> obtenerTodos() {
        try (InputStream stream = getClass().getResourceAsStream(rutaArchivo)) {
            if (stream == null) {
                return new ArrayList<>();
            }
            InputStreamReader reader = new InputStreamReader(stream);
            List<Usuario> usuarios = gson.fromJson(reader, tipoLista);
            return usuarios != null ? usuarios : new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo" + rutaArchivo, e);
        }
    }

    @Override
    public Optional<Usuario> buscarPorRut(String rut) {
        return obtenerTodos().stream()
                .filter(u -> u.getRut().equals(rut))
                .findFirst();
    }

}
