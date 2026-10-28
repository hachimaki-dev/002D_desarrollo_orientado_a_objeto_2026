package com.gamevault;

import java.util.ArrayList;

import com.gamevault.controller.UsuarioController;
import com.gamevault.model.JuegoDigital;
import com.gamevault.model.JuegoFisico;
import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;
import com.gamevault.model.Videojuego;

public class Prueba {

    public static void main(String[] args) {
        try {
            ArrayList<Videojuego> lista = new ArrayList<>();
            UsuarioManager e = new UsuarioManager();
            ArrayList<Usuario> lista2 = e.cargarDatos();
            for (Usuario u : lista2) {
                System.out.println(u.getNombre());
                
            }
            for (Videojuego v : lista) {
                System.out.println(v);
                
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error" + e.getMessage());
        }
    }
}
