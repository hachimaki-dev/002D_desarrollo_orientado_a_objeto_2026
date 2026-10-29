package com.hachimakidev.techstore.controller;

import com.hachimakidev.techstore.model.Dispositivo;

public class DispositivoController {

    public Dispositivo SolicitartipodeDispositivo(String tipo){
        DispositivoManager DispositivoManager = new DispositivoManager();
        Dispositivo dispositivo = DispositivoManager.SolicitartipodeDispositivo(tipo);
        return dispositivo;
        

    }

    // TODO 1: Instanciar DispositivoManager como atributo del controlador.

    // TODO 2: Crear el método que retorne la lista de dispositivos desde el manager hacia la vista.

    // TODO 3: Crear el método para validar y agregar un nuevo Notebook o Smartphone a la lista del manager.

}

