package com.nicoleasd.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    public UserManager(){
        loadData();
    }

    ArrayList<User> user_ArrayList = new ArrayList<>();

    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/user_data.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();
        User[] users = gson.fromJson(reader, User[].class);

        for (User user : users) {
            user_ArrayList.add(user);
        }
    }

   
}
