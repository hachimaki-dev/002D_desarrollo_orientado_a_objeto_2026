package com.gamevault.controller;

import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;
import com.gamevault.repository.UsuarioRepository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class UsuarioController {
    @FXML
    private ListView<Usuario> listaUsuarios;

    private UsuarioRepository repositorio;
    private final ObservableList<Usuario> datos = FXCollections.observableArrayList();

    public void setRepositorio(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
        recargar();
    }

    @FXML
    private void initialize() {
        listaUsuarios.setItems(datos);
    }

    private void recargar() {
        datos.setAll(repositorio.todos());
    }

    // implementación antigua
    UsuarioManager manager = new UsuarioManager();

    public Usuario buscarPorRut(String rut) {
        String rut_limpio = rut.trim();
        Usuario u = manager.buscarPorRut(rut_limpio);
        return u;
    }
}