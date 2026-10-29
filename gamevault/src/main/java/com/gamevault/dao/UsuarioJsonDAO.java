package com.gamevault.dao;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamevault.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UsuarioJsonDAO implements UsuarioDAO {
    private final Path archivo;
    private final Gson gson = new Gson();
    private final Type tipoLista = new TypeToken<List<Usuario>>() {
    }.getType();

    public UsuarioJsonDAO(String ruta_archivo) {
        this.archivo = Path.of(ruta_archivo);
    }

    @Override
    public List<Usuario> obtenerTodos() {
        if (!Files.exists(archivo)) {
            return new ArrayList<>();
        }
        try {
            String contenido = Files.readString(archivo);
            List<Usuario> alumnos = gson.fromJson(contenido, tipoLista);
            return alumnos != null ? alumnos : new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer " + archivo, e);
        }
    }

    @Override
    public Optional<Usuario> buscarPorRut(String rut) {
        return obtenerTodos().stream()
                .filter(a -> a.getRut() == rut)
                .findFirst();
    }

}
