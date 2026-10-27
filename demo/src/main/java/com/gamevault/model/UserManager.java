package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager{

    private ArrayList<User> lista_usuarios = new ArrayList<>();

    public UserManager() {
        leerUser();
    }

    public void leerUser(){
        try {            
            InputStream stream = getClass().getResourceAsStream("/users.json");
            InputStreamReader reader = new InputStreamReader(stream);
            Gson gson = new Gson();
            User[] arreglogson = gson.fromJson(reader, User[].class);
        
            for (User u : arreglogson) {
                lista_usuarios.add(u);}

            }
        
        catch (Exception E) {
            System.out.println("Error al cargar users.json" + E);
        }




    }

    public User buscarPorRut(String rut) {
        for (User u : lista_usuarios) {
            if (u.getRut().equalsIgnoreCase(rut)) {
                return u;
                
            }
            
        }
        return null;
    }
    
}
