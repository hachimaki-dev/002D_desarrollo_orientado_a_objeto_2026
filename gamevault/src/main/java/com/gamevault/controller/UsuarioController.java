package com.gamevault.controller;

import java.util.Optional;

import com.gamevault.model.Usuario;
import com.gamevault.repository.UsuarioRepository;

public class UsuarioController {

    private final UsuarioRepository repositorio;

    public UsuarioController(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario buscarPorRut(String rut) {
        String rutLimpio = rut.trim();
        Optional<Usuario> resultado = repositorio.buscarPorRut(rutLimpio);
        return resultado.orElse(null);
    }
}