package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {
    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public DispositivoManager(){
        cargarDatos();
    }

    public void cargarDatos(){
        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");
        if (stream == null) {
            throw new IllegalStateException("El JSON dispositivos.json no se ha encontrado");
            
        }
        Gson gson = new Gson();
        InputStreamReader reader = new InputStreamReader(stream);
        JsonObject[] arregloGson = gson.fromJson(reader, JsonObject[].class);
        for (JsonObject i : arregloGson) {
            String tipo = i.get("tipo").getAsString();
            switch (tipo) {
                case "notebook":
                    Notebook notebook = gson.fromJson(i, Notebook.class);
                    if (!esValido(notebook)) {
                        throw new IllegalArgumentException("Dispositivo invalido ID=" + notebook.getId() + "Modelo =" + notebook.getModelo());
                    }
                    dispositivos.add(notebook);
                    break;
                case "smartphone":
                    Smartphone smartphone = gson.fromJson(i, Smartphone.class);
                    if(!esValido(smartphone)){
                        throw new IllegalArgumentException("Dispositivo invalido ID=" + smartphone.getId() + "Modelo =" + smartphone.getModelo());
                    }
                    dispositivos.add(smartphone);
                    break;
                default:
                    break;
            }
            
        }

    }
    private boolean esValido(Dispositivo d){
        return d.getPrecio() > 0;
    }
    public ArrayList<Dispositivo> getDispositivos(){
        return dispositivos;
    }
    public void agregarDispositivo(Dispositivo nuevo){
        if (!esValido(nuevo)) {
            throw new IllegalArgumentException("Id del dispositivo =" + nuevo.getId() + "Modelo" + nuevo.getModelo());

            
        }
        dispositivos.add(nuevo);

    }
}

