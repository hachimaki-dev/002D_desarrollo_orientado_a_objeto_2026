package com.hachimakidev.techstore.controller;

import java.util.ArrayList;

import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.DispositivoManager;
import com.hachimakidev.techstore.model.Notebook;
import com.hachimakidev.techstore.model.Smartphone;

public class DispositivoController {

    // (LISTO) TODO 1: Instanciar DispositivoManager como atributo del controlador.

    // (LISTO) TODO 2: Crear el método que retorne la lista de dispositivos desde el manager hacia la vista.

    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.

    DispositivoManager inventarioManager;

    public DispositivoController()
    {
        inventarioManager = new DispositivoManager();
    }

    public ArrayList<Dispositivo> obtenerDispositivos()
    {
        return inventarioManager.obtenerDispositivos();
    }

    public void agregarNuevoDispositivo(String tipo, int id, String marca, String modelo, int precio, boolean disponible, int ramGb, String procesador)
    {
        switch (tipo)
        {
            case "notebook" :
                agregarNuevoNotebook();
                break;
            case "smartphone" :
               // agregarNuevoSmartphone();
                break;
            default :

        }
        
       // inventarioManager.agregarNuevoDispositivo(d);
    }

    public void agregarNuevoNotebook()
    {
        Notebook notebook = new Notebook(/*id, marca, modelo, precio, disponible, ramGb, procesador*/);

        inventarioManager.agregarNuevoDispositivo(notebook);
    }

    public void agregarNuevoSmartphone(Smartphone s)
    {
        inventarioManager.agregarNuevoDispositivo(s);
    }
}   

