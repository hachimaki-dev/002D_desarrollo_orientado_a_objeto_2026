package com.gallegos155.gamebault.Model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {
    ArrayList<User> user_ArrayList = new ArrayList<>();

    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/UserData.json");

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        User[] users = gson.fromJson(lector, User[].class);

        for( User usuario :  users){
            user_ArrayList.add(usuario);
        }
    }
     public User buscarUsuarioPorRut(String rut){

        for( User usuario : user_ArrayList ){
            if(usuario.getRut().equals(rut)){
                return usuario;
            }
        }
           return null;  
        
    }
     public UserManager(){
        loadData();
    }
}
