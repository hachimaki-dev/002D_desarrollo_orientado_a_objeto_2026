package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {
    private ArrayList<Dispositivo> lista_dispositivo = new ArrayList<>();
    public DispositivoManager(){
        loadDispositivo();
    }

    public void loadDispositivo(){
        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");
        if (stream == null) {
            throw new IllegalStateException("no se encontro dispositivos.json en resources");
            
        }

        try (InputStreamReader reader = new InputStreamReader(stream)){

            Gson gson = new Gson();

            JsonObject[] dispositivos = gson.fromJson(reader, JsonObject[].class);

            for (JsonObject dispositvo : dispositivos) {
                String tipo = dispositvo.get("tipo").getAsString();
                int id = dispositvo.get("id").getAsInt();
                String marca = dispositvo.get("marca").getAsString();
                String modelo = dispositvo.get("modelo").getAsString();
                int precio = dispositvo.get("precio").getAsInt();
                boolean disponible = dispositvo.get("disponible").getAsBoolean();

                switch(tipo){

                    case "notebook":
                        int ramGb = dispositvo.get("ramGb").getAsInt();
                        String procesador = dispositvo.get("procesador").getAsString();
                        Notebook notebook = new Notebook(id, marca,modelo,precio,disponible,ramGb,procesador);
                        lista_dispositivo.add(notebook);
                        break;

                    case "smartphone":
                        int almacenamientoGb = dispositvo.get("almacenamientoGb").getAsInt();
                        int camaraMp = dispositvo.get("camaraMp").getAsInt();
                        Smartphone smartphone = new Smartphone(id,marca,modelo,precio,disponible,almacenamientoGb,camaraMp);
                        lista_dispositivo.add(smartphone);
                        break;

                    default:
                        System.out.println("Tipo de dispositivo desconocido " + tipo);
                        break;
                        
                }
            }

        }catch(java.io.IOException e){
            throw new IllegalStateException("no se pudo leer dipositivo.json",e);
        }
    }
    public ArrayList<Dispositivo> getDispositivos(){
        return lista_dispositivo;
    }
    public void mostrarDispositivos(){
        for (Dispositivo dispositivo : lista_dispositivo) {
            System.out.println(dispositivo.getModelo());
        }
    }
}

