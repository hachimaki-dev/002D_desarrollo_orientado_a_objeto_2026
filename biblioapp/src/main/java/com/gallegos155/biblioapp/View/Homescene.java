package com.gallegos155.biblioapp.View;

import com.gallegos155.biblioapp.Controller.UserController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Homescene {
    

    public Scene homeScene(){

        Label lbl_user_rut = new Label("Rut: ");

        TextField tfx_user_rut = new TextField();
        tfx_user_rut.setPromptText("Ej: 11.111.111-1");

        Button btn_user_search = new Button("Buscar ");

        HBox hbox_user_search = new HBox(10, lbl_user_rut, tfx_user_rut, btn_user_search);


        Label lbl_user_data_rut = new Label("Rut:  ______ ");
        Label lbl_user_data_nombre = new Label("Nombre: ______");
        Label lbl_user_data_email = new Label("Email: _______");
        Label lbl_user_data_edad = new Label("Edad: ___________");
        Label lbl_user_data_puede_pedir = new Label("¿Puede solicitar libros:? _______");

        VBox vbox_user_data = new VBox(lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_puede_pedir);

        VBox main = new VBox(hbox_user_search, vbox_user_data);

        Scene home_scene = new Scene(main, 720, 480);
        btn_user_search.setOnAction(e -> {
            UserController usercontroller = new UserController();
            usercontroller.test();
        });
        return home_scene;

    }
        
}
