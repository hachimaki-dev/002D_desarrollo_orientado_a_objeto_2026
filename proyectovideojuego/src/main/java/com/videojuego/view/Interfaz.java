package com.videojuego.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.videojuego.model.UsuarioAdministrador;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class Interfaz  {

    public Scene interfaz(){


    Label lbl_rut =new Label("Ingrese rut:");

    TextField txt_rut = new TextField();
    
    Button btn_buscar_socio = new Button("Buscar socio");

    HBox buscador_socio = new HBox(10, lbl_rut, txt_rut, btn_buscar_socio);

    Label lbl_socio_datos_rut = new Label("Rut: ____________");


        return interfaz();
    }


    
}
