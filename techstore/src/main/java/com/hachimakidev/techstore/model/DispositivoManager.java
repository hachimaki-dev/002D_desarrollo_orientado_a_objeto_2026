package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

    ArrayList<Dispositivo> dispositivo_arraylist = new ArrayList<>();

    public DispositivoManager() {
        loadDispositivo();
    }

    public void loadDispositivo() {

        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");

        if (stream == null) {
            throw new IllegalStateException("No se encontró dispositivos.json en resources");

        }

        try (InputStreamReader reader = new InputStreamReader(stream))  {
            Gson gson = new Gson();

            JsonObject[] dispositivos = gson.fromJson(reader, JsonObject[].class);

            for (JsonObject dispositivo : dispositivos) {
                String tipo = dispositivo.get("tipo").getAsString();

                switch (tipo) {
                    case "Notebook":
                        int ramGb = dispositivo.get("ramGB").getAsInt();
                        String procesador = dispositivo.get("procesador").getAsString();
                        int precio = dispositivo.get("precio").getAsInt();
                        String modelo = dispositivo.get("modelo").getAsString();
                        String marca = dispositivo.get("marca").getAsString();
                        int id = dispositivo.get("id").getAsInt();

                        Notebook notebook = new Notebook(id, marca, modelo, precio, false, ramGb, procesador);

                         dispositivo_arraylist.add(notebook);

                        break;

                    case "Smartphone":
                        int id1 = dispositivo.get("id").getAsInt();
                        String marca1 = dispositivo.get("marca").getAsString();
                        String modelo1 = dispositivo.get("modelo").getAsString();
                        int precio1 = dispositivo.get("precio").getAsInt();
                        boolean disponible = dispositivo.get("disponible").getAsBoolean();
                        int almacenamientoGb = dispositivo.get("almacenamientoGb").getAsInt();
                        int camaparaMp = dispositivo.get("camaraMp").getAsInt();

                        Smartphone smartphone = new Smartphone(id1, marca1, modelo1, precio1, disponible, almacenamientoGb, camaparaMp);

                        dispositivo_arraylist.add(smartphone);

                        break;


                    default:
                        System.out.println("Tipo de dispositivo desconocido" + tipo);

                        break;
                }
            }
        } catch (java.io.IOException e) {
            throw new IllegalStateException("No se pudo leer dispositivos.json");
        }

    }

    public ArrayList<Dispositivo> geDispositivos() {
        return dispositivo_arraylist;
    }
    public void mostrarDispositivo(){
        for (Dispositivo d : dispositivo_arraylist) {
            System.out.println(d.getMarca());
            
        }
    }

}
