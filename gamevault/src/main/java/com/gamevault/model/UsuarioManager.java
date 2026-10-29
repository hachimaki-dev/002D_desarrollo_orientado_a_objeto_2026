package com.gamevault.model;
import com.google.gson.reflect.TypeToken; // <-- El import clave
import java.lang.reflect.Type;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import com.google.gson.Gson;

public class UsuarioManager {
    private ArrayList<Usuario> ListaUsuarios;


    public UsuarioManager(){

        this.ListaUsuarios = new ArrayList<>();


    }

    public void  CargarDatos(){

        try(InputStream cargar_usuario = UsuarioManager.class.getResourceAsStream("/usuarios.json")) {

            if (cargar_usuario == null){

                System.err.println("No se ha encontrado ningun usuario dentro de la coleccion");
                return;


            }

            Reader lector = new InputStreamReader(cargar_usuario);

            Gson gson = new Gson();

            Type tipoLista = new TypeToken<ArrayList<Usuario>>() {}.getType();
            this.ListaUsuarios = gson.fromJson(lector, tipoLista);
            System.out.println("Usuario cargados. total: " + ListaUsuarios.size());



            
        } catch (Exception e) {
            System.err.println("Error al procesar el JSON de usuarios: " + e.getMessage());
            e.printStackTrace();
            
        }
        
    }
     public ArrayList<Usuario> getListaUsuarios() {
        return ListaUsuarios;
    
    }

}
    