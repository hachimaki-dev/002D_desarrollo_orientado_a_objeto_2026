package com.videojuego.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.videojuego.controller.ControladorUsuario;
import com.videojuego.model.Usuario;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Interfaz  {

    public Scene homeScene(){

        VBox buscardor_socios = incioComponentesDatosUsuarios(); // variables que guardan lo que retorna el metodo

        VBox vbox_principal = new VBox(20, buscardor_socios); //para que sea mas limpiecito el codigo
        vbox_principal.setPadding(new Insets (20));

        Scene incio_interfaz = new Scene(vbox_principal, 720, 480);
        return incio_interfaz;
    }

    

    public VBox incioComponentesDatosUsuarios(){
        Label lbl_rut_usuario = new Label("Ingrese RUT: ");

        TextField txt_rut_usuario_buscar = new TextField();
        txt_rut_usuario_buscar.setPromptText("ej: 11.111.111-1");

        Button btn_bucar_usuario = new Button("Buscar socio");

        HBox hbox_buscador_socio = new HBox(10, lbl_rut_usuario, txt_rut_usuario_buscar, btn_bucar_usuario);

        Label lbl_rut = new Label("RUT: ________ ");
        Label lbl_nombre_socio = new Label("Socio: _______");
        Label lbl_nivel = new Label("Nivel: ________");
        Label lbl_email = new Label("Email: _______________");

        HBox hbox_info_datos_usuarios = new HBox(10, lbl_rut, lbl_nombre_socio, lbl_nivel, lbl_email);

        VBox vbox_menu = new VBox(10, hbox_buscador_socio, hbox_info_datos_usuarios);


        btn_bucar_usuario.setOnAction(e -> {
            ControladorUsuario controladorUsuario = new ControladorUsuario();

            String rut_buscado = txt_rut_usuario_buscar.getText(); //variable para guardar el rut ingresado
            Usuario socio = controladorUsuario.buscar_socio_rut(rut_buscado); // le paso la variable y no el text.get

            lbl_rut.setText(socio.getRut());
            lbl_nombre_socio.setText(socio.getNombre());
            lbl_nivel.setText(socio.getNivel());
            lbl_email.setText(socio.getEmail()); 
        });
        
        return vbox_menu;
    }
}
