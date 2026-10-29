package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

    ArrayList<Dispositivo> lista_dispositivos = new ArrayList<>();

    public DispositivoManager(){
        cargarDatos();
    }
    
    public void cargarDatos(){
        InputStream stream = getClass().getResourceAsStream("/dispositivos.json");
        InputStreamReader lector = new InputStreamReader(stream);

        Gson gson = new Gson();

        JsonObject[] dispositivos = gson.fromJson(lector, JsonObject[].class);

        for (JsonObject d : dispositivos) {

            String tipo = d.get("tipo").getAsString();

            switch (tipo) {
                case "notebook":

                    int id = d.get("id").getAsInt();

                    String marca = d.get("marca").getAsString();

                    String modelo = d.get("modelo").getAsString();

                    int precio = d.get("precio").getAsInt();

                    boolean disponible = d.get("disponible").getAsBoolean();

                    int ramgb = d.get("ramGb").getAsInt();

                    String procesador = d.get("procesador").getAsString();

                    Notebook note = new Notebook(id, marca, modelo, precio, disponible, ramgb, procesador);

                    lista_dispositivos.add(note);
                    
                    break;

                case "smartphone":

                    int ID = d.get("id").getAsInt();

                    String Marca = d.get("Marca").getAsString();

                    String Modelo = d.get("Modelo").getAsString();

                    int Precio = d.get("Precio").getAsInt();

                    boolean Disponible = d.get("Disponible").getAsBoolean();

                    int Almacenamiento = d.get("Almacenamiento").getAsInt();

                    int CamaraMp = d.get("CamaraMp").getAsInt();

                    Smartphone celu = new Smartphone(ID, Marca, Modelo, Precio, Disponible, Almacenamiento, CamaraMp);

                    lista_dispositivos.add(celu);

                    break;
                default:
                    throw new AssertionError();
            }
        }




    }
    
    
    
    
    
    
    
    
    
    // TODO 1: Declarar la lista polimórfica ArrayList<Dispositivo> para almacenar notebooks y smartphones.

    // TODO 2: En el constructor, llamar al método que carga los datos desde "/dispositivos.json".

    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.

}

