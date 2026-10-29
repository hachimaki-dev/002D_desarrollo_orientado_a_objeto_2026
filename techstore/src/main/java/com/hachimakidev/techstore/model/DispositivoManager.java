package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.util.ArrayList;

public class DispositivoManager {

    ArrayList<dispotivos> lista_dispositivos = new ArrayList<>();

    public void loaddate(){
        InputStream cadena = getClass().getResourceAsStream("/dispositivos.josn");

        InputStream lector = new InputStream(cadena);

        Gson gson = new Gson();

        dispositivo[] Dispositivo = gson.fromJson(lector, Dispositivo[].class);

        for(Dispositivo buscar_dispositivo: dispositivo){
            lista_dispositivos.add(dispositivo);
        }
    }

    public Dispositivo(String tipo){
        for(Dispositivo tipo_de_dispositivo : lista_dispositivos){
            if(tipo_de_dispositivo.getTipo().equals(tipo)){
               return tipo_de_dispositivo; 
            }

            return null;
        }
    }

    public DispositivoManager(){
        loaddate();
    }

    // TODO 1: Declarar la lista polimórfica ArrayList<Dispositivo> para almacenar notebooks y smartphones.

    // TODO 2: En el constructor, llamar al método que carga los datos desde "/dispositivos.json".

    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.
}

