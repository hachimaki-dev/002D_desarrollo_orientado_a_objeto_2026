package com.hachimakidev.biblioapp.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MaterialManager {

    public MaterialManager(){
        loadData();
    }

    public ArrayList<Material> materiales = new ArrayList<>();
    

    public void loadData(){
        InputStream stream_material = getClass().getResourceAsStream("/material_data.json");

        InputStreamReader lector = new InputStreamReader(stream_material);

        Gson gson = new Gson();

        JsonObject[] materialesJson = gson.fromJson(lector, JsonObject[].class);

        for (JsonObject jObject : materialesJson){
            if (jObject.get("tipo").getAsString().equals("libro")) {
                Libro libro = gson.fromJson(jObject, Libro.class);
                materiales.add(libro);
            }
            else if(jObject.get("tipo").getAsString().equals("revista")){
                Revista revista = gson.fromJson(jObject, Revista.class);
                materiales.add(revista);

            }
        }
    }

    public void verificarMaterial(){
        for(Material ma : materiales){
            if(ma instanceof Libro){
                Libro libro = (Libro) ma;
                System.out.println("------LIBRO-------");
                System.out.println(libro.getTitulo());
                System.out.println(libro.getTitulo());
            }
            else if(ma instanceof Revista){
                Revista revista = (Revista) ma;
                System.out.println("------Revista-------");
                System.out.println(revista.getTitulo());
                System.out.println(revista.getNumeroEdicion());
                System.out.println(revista.getNumeroEdicion());
            }
        }
    }
}
