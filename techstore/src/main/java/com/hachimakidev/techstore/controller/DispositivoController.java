package com.hachimakidev.techstore.controller;

import java.util.ArrayList;

import com.hachimakidev.techstore.model.Dispositivo;
import com.hachimakidev.techstore.model.DispositivoManager;

public class DispositivoController {

    DispositivoManager manager = new DispositivoManager();

    public ArrayList<Dispositivo> obtenerDispositivos(){
        ArrayList<Dispositivo> arraylist_Dispositivos = manager.obtenerDispositivos();
        return arraylist_Dispositivos;
    }

    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.
    public void agregarDispositivo(String tipo, String marca, String modelo, String precio, String disponible, String atr_unico1, String atr_unico2) {
        if (tipo.equals("Notebook")) {
            ArrayList<Dispositivo> arraylist_dispositivos = manager.obtenerDispositivos();
            int id_mas_alto = 0;
            for (Dispositivo d : arraylist_dispositivos) {
                int id = d.getId();
                if (id > id_mas_alto) {
                    id_mas_alto = id;
                }
            }
            int id = id_mas_alto += 1;
            try {
                Integer precio_parseado = Integer.parseInt(precio);
                
            } catch (Exception e) {
                System.out.println("Pon un número hijo de la lanza camotes");
            }
            try {
                Integer ram_parseada = Integer.parseInt(atr_unico1);
                
            } catch (Exception e) {
                System.out.println("Pon un número hijo de la lanza camotes");
            }

        }
    }

}

