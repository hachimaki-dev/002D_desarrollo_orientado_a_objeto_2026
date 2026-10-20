package com.seba1304256.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {
    ArrayList<User>user_Arraylist = new ArrayList<>();


    public UserManager(){
        loadData();
    }
    
    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/user_data.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson_libreria = new Gson();
        User[] users = gson_libreria.fromJson(reader, User[].class);

        for (User user : users) {
            user_Arraylist.add(user);
        }

        



    }    
    public void seraVerdad(){
        for (User user : user_Arraylist) {
            System.out.println(user.getRut());
            System.out.println(user.getNombre());
            System.out.println(user.getEmail());
            System.out.println(user.getEdad());

        }
    }



}
