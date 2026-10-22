package com.ferdev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {
    ArrayList<User> lista_usuarios = new ArrayList<>();
    public UserManager(){
        leerDatos();
    }
    public void leerDatos(){
        InputStream stream = getClass().getResourceAsStream("/user.json");
        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        User[] arregloUsers = gson.fromJson(reader, User[].class);
        for (User u : arregloUsers) {
            lista_usuarios.add(u);
            
        }
    }
    public User buscarUsuarioRut(String rut){
        for (User u : lista_usuarios) {
            if (u.getRut().equals(rut)) {
                return u;
            }
        }
        
        return null;

    }
    public void prueba(){
        for (User user : lista_usuarios) {
            System.out.println(user.getRut());
            System.out.println(user.getNombre());
            System.out.println(user.getEmail());
            System.out.println(user.getEdad());
        }
    }
    
}
