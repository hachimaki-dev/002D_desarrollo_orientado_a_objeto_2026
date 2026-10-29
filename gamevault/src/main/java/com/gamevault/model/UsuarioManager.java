package com.gamevault.model;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class UsuarioManager{
    private ArrayList<Usuario> user_ArrayList = new ArrayList<>();
    public UsuarioManager(){
        loadData();
    }
    public void loadData(){
        try{
            InputStream is = getClass().getResourceAsStream("/usuarios.json");
            if (is != null){
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                Gson gson = new Gson();
                Usuario[] usuarios = gson.fromJson(reader, Usuario[].class);
                if (usuarios != null){
                    for (Usuario user : usuarios){
                        user_ArrayList.add(user);
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Error cargando usuarios: " + e.getMessage());
        }
    }
    public ArrayList<Usuario> getUsuarios(){
        return user_ArrayList;
    }
}