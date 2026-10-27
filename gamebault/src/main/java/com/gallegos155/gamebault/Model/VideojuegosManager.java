package com.gallegos155.gamebault.Model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class VideojuegosManager {
    ArrayList<Videojuegos> videojuegos_Arraylist = new ArrayList<>();


    public VideojuegosManager(){
        loadData();
    }
 

    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/GameDatas.json");

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        Videojuegos[] Videojuegos = gson.fromJson(lector, Videojuegos[].class);

        for( Videojuegos juego : videojuegos_Arraylist ){
            videojuegos_Arraylist.add(juego);
        }
    }


    public videojuego buscarJuego(String videojuego){

        for( videojuego juego : videojuegos_Arraylist ){
            if(juego.getNombre().equals(videojuego)){
                return juego;
            }

            
        }

        return null;
    }

}
