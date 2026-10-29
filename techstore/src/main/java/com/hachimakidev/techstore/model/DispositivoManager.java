package com.hachimakidev.techstore.model;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DispositivoManager {
    /*
        ---------------------------------------------
        -------------- CLASE TERMINADA --------------
        ---------------------------------------------
    */

    // (LISTO) TODO 1: Declarar la lista polimórfica ArrayList<Dispositivo> para
    // almacenar notebooks y smartphones.

    // (LISTO) TODO 2: En el constructor, llamar al método que carga los datos desde
    // "/dispositivos.json".

    // (LISTO) TODO 3: Implementar el método de carga usando Gson y JsonObject[]:
    // - Si el campo "tipo" es "notebook", convertir el JsonObject a Notebook.class
    // y agregarlo a la lista.
    // - Si el campo "tipo" es "smartphone", convertir el JsonObject a
    // Smartphone.class y agregarlo a la lista.

    // (LISTO) TODO 4: Implementar un método getter para retornar la lista de
    // dispositivos y un método para agregar un nuevo Dispositivo.

    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public DispositivoManager() {
        loadData();
    }

    public void loadData() {
        InputStream cadena = getClass().getResourceAsStream("/dispositivos.json");

        if (cadena == null) {
            throw new IllegalStateException("No se encontró dispositivos.json en resources");
        }

        InputStreamReader lector = new InputStreamReader(cadena);

        Gson gson = new Gson();

        JsonObject[] dispositivosCargados = gson.fromJson(lector, JsonObject[].class);

        for (JsonObject dispositivo : dispositivosCargados) {

            String tipo = dispositivo.get("tipo").getAsString();

            int id = dispositivo.get("id").getAsInt();
            String marca = dispositivo.get("marca").getAsString();
            String modelo = dispositivo.get("modelo").getAsString();
            int precio = dispositivo.get("precio").getAsInt();
            boolean disponible = dispositivo.get("disponible").getAsBoolean();

            switch (tipo) {

                case "notebook":
                    int ramGb = dispositivo.get("ramGb").getAsInt();
                    String procesador = dispositivo.get("procesador").getAsString();

                    Notebook notebook = new Notebook(id, marca, modelo, precio, disponible, ramGb, procesador);

                    dispositivos.add(notebook);

                    break;

                case "smartphone":

                    int almacenamientoGb = dispositivo.get("almacenamientoGb").getAsInt();
                    int camaraMp = dispositivo.get("camaraMp").getAsInt();

                    Smartphone smartphone = new Smartphone(id, marca, modelo, precio, disponible, almacenamientoGb, camaraMp);

                    dispositivos.add(smartphone);

                    break;

                default:
                    System.out.println("Tipo de dispositivo desconocido: " + tipo);

                    break;
            }
        }
    }

    public ArrayList<Dispositivo> obtenerDispositivos() {
        return dispositivos;
    }

    public void agregarNuevoDispositivo(Dispositivo d) {
        dispositivos.add(d);
    }
}
