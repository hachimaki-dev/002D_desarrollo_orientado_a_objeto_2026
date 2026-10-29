package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DispositivoManager {

    ArrayList<Dispositivo> arraylist_dispositivos = new ArrayList<>();

    // TODO 2: En el constructor, llamar al método que carga los datos desde
    // "/dispositivos.json".

    public DispositivoManager() {
        loadData();
    }

    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    public void loadData() {
        arraylist_dispositivos.clear();

        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");

        if (stream == null) {
            System.out.println("No se encontró dispositivos.json");
            return;
        }

        InputStreamReader reader = new InputStreamReader(stream);
        JsonArray dispositivos = JsonParser.parseReader(reader).getAsJsonArray();

        Gson gson = new Gson();

        for (int i = 0; i < dispositivos.size(); i++) {
            JsonObject d = dispositivos.get(i).getAsJsonObject();

            String tipo = d.get("tipo").getAsString();
            int id = d.get("id").getAsInt();
            String marca = d.get("marca").getAsString();
            String modelo = d.get("modelo").getAsString();
            int precio = d.get("precio").getAsInt();
            boolean disponible = d.get("disponible").getAsBoolean();

            if (tipo.equals("notebook")) {
                Notebook notebook = gson.fromJson(d, Notebook.class);
                arraylist_dispositivos.add(new Notebook(id, marca, modelo, precio, disponible, notebook.getRamGb(),
                        notebook.getProcesador()));
            } else if (tipo.equals("smartphone")) {
                Smartphone smartphone = gson.fromJson(d, Smartphone.class);
                arraylist_dispositivos.add(new Smartphone(id, marca, modelo, precio, disponible,
                        smartphone.getAlmacenamientoGb(), smartphone.getCamaraMp()));
            }
        }
    }

    public ArrayList<Dispositivo> obtenerDispositivos() {
        return arraylist_dispositivos;
    }

}
