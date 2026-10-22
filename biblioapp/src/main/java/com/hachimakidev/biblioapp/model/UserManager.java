package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;



import com.google.gson.Gson;

public class UserManager {

    ArrayList<User> user_ArrayList = new ArrayList<>();


    public UserManager(){
        loadData();
    }
 

    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/user_data.json");

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        User[] users = gson.fromJson(lector, User[].class);

        for( User usuario :  users){
            user_ArrayList.add(usuario);
        }
    }

    public User buscarUsuarioPorRut(String rut){for(User u : user_ArrayList){
        if ( u.getRut().equals(rut) ){
            return u;
        }
    }
    return null;
} 

    public void seraVerdad(){
        for(User user : user_ArrayList){
            System.out.println("--------");
            System.out.println(user.getRut());
            System.out.println(user.getNombre());
            System.out.println(user.getEdad());
            System.out.println(user.getEmail());
            System.out.println(user.isPuede_solicitar_prestamos());
        }
    }

}
