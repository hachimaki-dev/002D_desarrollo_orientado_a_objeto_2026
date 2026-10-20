package com.seba1304256.view;

import com.seba1304256.controller.User_controlador;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScene {
    public Scene homeScene(){

        Label lbl_user_rut = new Label("Rut :");

        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("11.111.111-1");
        Button btn_user_search = new Button("buscar <3");
        HBox hbox_user_search = new HBox(10,lbl_user_rut,txf_user_rut,btn_user_search);
        
        
        Label lbl_user_data_rut = new Label("rut________");
        Label lbl_user_data_nombre = new Label("nombre");
        Label lbl_user_data_email = new Label("email________");
        Label lbl_user_data_edad = new Label("edad________");
        Label lbl_user_data_libros = new Label("puedo solicitar libro?________");
        VBox vbox_user_data = new VBox(10,lbl_user_data_rut,lbl_user_data_nombre,lbl_user_data_email,lbl_user_data_edad,lbl_user_data_libros);

        VBox main = new VBox(hbox_user_search,vbox_user_data);
        Scene home_scene = new Scene(main,720,480);
        btn_user_search.setOnAction(e -> {
            User_controlador user_controlador = new User_controlador();
            user_controlador.test();
        });
        return home_scene;


    }
}
