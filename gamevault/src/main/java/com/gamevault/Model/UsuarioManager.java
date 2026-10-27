package com.gamevault.Model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UsuarioManager {
    ArrayList<Usuario> user_ArrayList = new ArrayList<>();


    public UsuarioManager(){
        loadData();
    }
 

    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/usuario.json");

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        Usuario[] users = gson.fromJson(lector, Usuario[].class);

        for( Usuario usuario :  users){
            user_ArrayList.add(usuario);
        }
    }

    public Usuario buscarPorRut(String rut)
    {
        for (Usuario u : user_ArrayList)
        {
            if (u.getRut().equals(rut)) return u;
        }

        return null;
    }

    public void seraVerdad(){
        for(Usuario user : user_ArrayList){
            System.out.println("--------");
            System.out.println(user.getRut());
            System.out.println(user.getNombre());
            System.out.println(user.getEmail());
            System.out.println(user.getNivelGamer());
        }
    }
}
