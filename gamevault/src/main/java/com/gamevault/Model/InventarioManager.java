package com.gamevault.Model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class InventarioManager {
    ArrayList<Videojuego> videojuegos_Arraylist = new ArrayList<>();


    public InventarioManager(){
        loadData();
    }
 

    public void loadData(){
        InputStream cadena = getClass().getResourceAsStream("/inventario.json");

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        Videojuego[] videojuegos = gson.fromJson(lector, Videojuego[].class);

        for( Videojuego v :  videojuegos){
            videojuegos_Arraylist.add(v);
        }
    }

    public ArrayList<Videojuego> obtenerInventario()
    {
        return videojuegos_Arraylist;
    }

    public void seraVerdad(){
        for(Videojuego videojuego : videojuegos_Arraylist){
            System.out.println("--------");
            System.out.println(videojuego.getTipo());
            System.out.println(videojuego.getTitulo());
            System.out.println(videojuego.getPlataforma());
            System.out.println(videojuego.getPortadaURL());
        }
    }
}
