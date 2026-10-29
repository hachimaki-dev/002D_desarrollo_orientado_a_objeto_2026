package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {

    ArrayList<Dispositivo> lista_dispositivos = new ArrayList<>();

    public DispositivoManager() {
    }

   public void cargarDatos(){
    InputStream stream = getClass().getResourceAsStream("/dispositivos.json");
    
    if (stream == null) {
        throw new IllegalStateException("No se encontró biblioteca.json en resources");
    }

    try (InputStreamReader reader =  new InputStreamReader(stream)){
            
            Gson gson = new Gson();
            JsonObject[] dispositivos = gson.fromJson(reader, JsonObject[].class);
        
        for(JsonObject dispositivo : dispositivos){
            String tipo = dispositivo.get("tipo").getAsString();
            switch (tipo) {
                case "Notebook":
                    int id_notebook = dispositivo.get("id").getAsInt();
                    String marca_notebook = dispositivo.get("marca").getAsString();
                    String modelo_notebook = dispositivo.get("modelo").getAsString();
                    int precio_notebook = dispositivo.get("precio").getAsInt();
                    boolean disponible_notebook = dispositivo.get("disponible").getAsBoolean();
                    int tam_GB = dispositivo.get("ramGb").getAsInt();
                    String procesador_notebook = dispositivo.get("procesador").getAsString();
                    Notebook notebook = new Notebook(id_notebook, marca_notebook, modelo_notebook, precio_notebook, disponible_notebook, tam_GB, procesador_notebook);
                    lista_dispositivos.add(notebook);
                    break;
                case "Smartphone":
                    int id_smartphone = dispositivo.get("id").getAsInt();
                    String marca_smartphone = dispositivo.get("marca").getAsString();
                    String modelo_smartphone = dispositivo.get("modelo").getAsString();
                    int precio_smartphone = dispositivo.get("precio").getAsInt();
                    boolean disponible_smartphone = dispositivo.get("disponible").getAsBoolean();
                    int almacenamiento_smartphone = dispositivo.get("almacenamientoGb").getAsInt();
                    int camara_smartphone = dispositivo.get("camaraMp").getAsInt();

                    Smartphone smartphone = new Smartphone(id_smartphone, marca_smartphone, modelo_smartphone, precio_smartphone, disponible_smartphone, almacenamiento_smartphone, camara_smartphone);
                    lista_dispositivos.add(smartphone);


                    break;
                default:
                       System.out.println("Tipo de material desconocido: " + tipo);
                    break;
            }
        }
    }catch(java.io.IOException e){

        throw new IllegalStateException(
                    "No se pudo leer dispositivos.json", e);
 

    }
   }
   public ArrayList<Dispositivo> getDispositivos(){
       return lista_dispositivos;
   }
   public void mostrarDispositivos(){

    for (Dispositivo dispositivo: lista_dispositivos){

        System.out.println(dispositivo.getTipo());
    }
   }

   public void agregarDispositivo(Dispositivo nuevo){
    man


    // TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    //   - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class y agregarlo a la lista.
    //   - Si el campo "tipo" es "smartphone", convertir el JsonObject a Smartphone.class y agregarlo a la lista.

    // TODO 4: Implementar un método getter para retornar la lista de dispositivos y un método para agregar un nuevo Dispositivo.

}

