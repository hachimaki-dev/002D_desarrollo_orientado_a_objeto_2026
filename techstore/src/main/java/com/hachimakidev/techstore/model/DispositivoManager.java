package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

    ArrayList<Dispositivo> dispositivos_arraylist = new ArrayList<>();

    public DispositivoManager{
        load_dispositivos();
    }

    public void load_dispositivos(){
        InputStream cadena = getClass().getResourceAsStream("/dispositivos.json");

        if (cadena == null) {
            throw new IllegalStateException("No se encontró dispositivos.json en resources");
        }

        try (InputStreamReader lector = new InputStreamReader(cadena);) {
            Gson gson = new Gson();

            JsonObject[] dispositivos = gson.fromJson(lector, JsonObject[].class);

            for (JsonObject dispositivo : dispositivos) {
                String tipo = dispositivo.get("tipo").getAsString();

                switch (tipo) {
                    case "notebook": 
                        int id = dispositivo.get("id").getAsInt();

                        String marca = dispositivo.get("marca").getAsString();

                        String modelo = dispositivo.get("modelo").getAsString();

                        int precio = dispositivo.get("precio").getAsInt();

                        boolean disponible = dispositivo.get("disponible").getAsBoolean();

                        int ramGb = dispositivo.get("ramGb").getAsInt();

                        String procesador = dispositivo.get("procesador").getAsString();

                        Notebook notebook = new Notebook(id, marca, modelo, precio, disponible, ramGb, procesador);

                        dispositivos_arraylist.add(notebook);

                        break;

                    case "smartphone":
                        int id_smartphone = dispositivo.get("id").getAsInt();

                        String marca_smartphone = dispositivo.get("marca").getAsString();

                        String modelo_smartphone = dispositivo.get("modelo").getAsString();

                        int precio_smartphone = dispositivo.get("precio").getAsInt();

                        boolean disponible_smartphone = dispositivo.get("disponible").getAsBoolean();

                        int almacenamientoGb = dispositivo.get("almacenamientoGb").getAsInt();

                        int camaraMp = dispositivo.get("camaraMp").getAsInt();

                        
                        break;
                
                    default:
                        break;
                }
            }
            
        } catch (java.io.IOException e) {
            // TODO: handle exception
        } 



    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.

}

}

