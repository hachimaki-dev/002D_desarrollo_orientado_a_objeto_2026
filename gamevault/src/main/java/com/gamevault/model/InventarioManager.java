package com.gamevault.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class InventarioManager {
    

    public ArrayList<Videojuego> cargarInventario(){

        ArrayList<Videojuego> inventario = new ArrayList<>();

        Gson gson = new Gson();


        InputStream cargarDatos = getClass().getResourceAsStream("/inventario.json");

        if(cargarDatos == null){

            System.out.println("No se encontro el archivo /inventario.json");

            return inventario;

        }
        try(Reader lector = new InputStreamReader(cargarDatos)) {
            
            JsonObject[] jsonObjects = gson.fromJson(lector, JsonObject[].class);

            if(jsonObjects == null){

                return inventario;
            }
            for (JsonObject obj : jsonObjects) {

                if(obj.has("tipo")){

                    String tipo = obj.get("tipo").getAsString();

                    switch (tipo.toUpperCase()) {
                        case "FISICO":
                            JuegoFisico fisico = gson.fromJson(obj,JuegoFisico.class);
                            inventario.add(fisico);
                            break;


                        case "DIGITAL":
                            JuegoDigital digital = gson.fromJson(obj,JuegoDigital.class); 
                                inventario.add(digital);
                            break;
                    
                        default:
                            System.out.println("Tipo de juego desconocido"+ tipo);
                            break;
                    }
                }

                
            }
        }catch (Exception e){

            e.printStackTrace();
        }
        return inventario;
    }
}
