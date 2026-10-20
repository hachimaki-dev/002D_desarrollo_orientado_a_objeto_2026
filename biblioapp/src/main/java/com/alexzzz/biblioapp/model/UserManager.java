package com.alexzzz.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    ArrayList<User> user_Arraylist = new ArrayList<>();

    public UserManager(){
        loadData();
    }
    
    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/user_data.json");

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        User[] users = gson.fromJson(lector, User[].class);

        for (User usuario : users) {
            user_Arraylist.add(usuario);
        }
    }


    public void vamos_a_ver_si_esto_es_verdad(){
        for (User user : user_Arraylist) {
            System.out.println(user.getRut());
        }
    }
}
