package com.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class UserManager {

    ArrayList<User> userArrayList = new ArrayList<>();

    public UserManager()
    {
        loadData();
    }

    public void loadData()
    {
        InputStream cadena = getClass().getResourceAsStream("/user_data.json");

        InputStreamReader reader = new InputStreamReader(cadena);

        Gson gson = new Gson();

        User[] users = gson.fromJson(reader, User[].class);

        for (User u : users)
        {
            userArrayList.add(u);
        }
    }

    public void mostrarUsuarios()
    {
        for (User u : userArrayList)
        {
            System.out.println("------");
            System.out.println(u.getRut());
            System.out.println(u.getNombre());
            System.out.println(u.getEdad());
            System.out.println(u.getEmail());
            System.out.println(u.isPuede());
        }
    }
}
