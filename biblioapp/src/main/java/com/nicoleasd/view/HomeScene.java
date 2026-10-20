package com.nicoleasd.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScene {
    public Scene homeScene(){

        Label lbl_user_rut = new Label("Rut: ");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");

        Button btn_user_search = new Button("Buscar");

        HBox hbox_user_search = new HBox(10, lbl_user_rut, txf_user_rut, btn_user_search);
        
        Label lbl_user_data = new  Label("Rut_________________");
        Label lbl_user_data_nombre = new Label("Nombre: ______");
        Label lbl_user_data_email = new  Label("email___________");
        Label lbl_user_data_edad = new Label("Edad: _________");
        Label lbl_user_data_libros = new Label("libros s/n __________");

        VBox vbox_user_data = new VBox(5, lbl_user_data, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_libros);

        VBox main = new VBox(10, hbox_user_search, vbox_user_data);


        Scene home_scene = new Scene(main, 720, 480);
        return home_scene;

    }
}
