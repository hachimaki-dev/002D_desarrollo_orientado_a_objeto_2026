package com.gamevault.model.Dao;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.gamevault.model.Usuario;
import com.gamevault.model.UsuarioManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UsuarioDaojson implements UsuarioDao  {
    private ArrayList<Usuario> listaUsuarios;

    public UsuarioDaojson(){
        this.listaUsuarios = new ArrayList<>();
        cargarDatos();
    }

    public void cargarDatos(){
        try(InputStream cargar_usuario = UsuarioManager.class.getResourceAsStream("/usuarios.json")) {

            if (cargar_usuario == null){

                System.err.println("No se ha encontrado ningun usuario dentro de la coleccion");
                return;


            }

            Reader lector = new InputStreamReader(cargar_usuario);

            Gson gson = new Gson();

            Type tipoLista = new TypeToken<ArrayList<Usuario>>() {}.getType();
            this.listaUsuarios = gson.fromJson(lector, tipoLista);
            System.out.println("Usuario cargados. total: " + listaUsuarios.size());



            
        } catch (Exception e) {
            System.err.println("Error al procesar el JSON de usuarios: " + e.getMessage());
            e.printStackTrace();
            
        }
    }
    @Override 
    public ArrayList<Usuario> obtenerTodos(){
        return listaUsuarios;
    }
    @Override 
    public Usuario buscarPorRut(String rut){
        if (listaUsuarios == null || rut == null){
            return null;
        }
        for (Usuario usuario : listaUsuarios) {

            if(usuario.getRut().equals(rut)){
                return usuario;
            }
            
        }
        return null;
    }

}
