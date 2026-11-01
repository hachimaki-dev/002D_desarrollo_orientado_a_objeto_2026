package com.hachimakidev.techstore.controller;

import java.util.ArrayList;

import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.DispositivoManager;

public class DispositivoController {
     private DispositivoManager manager = new DispositivoManager();
     public ArrayList<Dispositivo> obtenerDispositivos(){
        return manager.getDispositivos();
     }
     public void agregarDispositivo(Dispositivo nuevo){
      manager.agregarDispositivo(nuevo);

     }


    // TODO 2: Crear el método que retorne la lista de dispositivos desde el manager hacia la vista.

    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.

}

