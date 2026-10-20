package com.zizager.View;

import com.zizager.Controller.UserController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScene {
    
    public Scene homeScene(){
        
        Label lbl_user_rut = new Label("Rut: ");

        TextField txt_user_rut = new TextField();
        txt_user_rut.setPromptText("ej: 11.111.111-1");

        Button btn_user_search = new Button("Buscar <3");

        HBox hbox_user_search = new HBox(10, lbl_user_rut, txt_user_rut, btn_user_search);

        Label lbl_user_data_rut = new Label("Rut:_____________________________");
        Label lbl_user_data_nombre = new Label("Nombre:_____________________________");
        Label lbl_user_data_email = new Label("Email:_____________________________");
        Label lbl_user_data_edad = new Label("Edad:_____________________________");
        Label lbl_user_data_puede_pedir = new Label("Puede solicitar libros?:_____________________________");

        VBox vbox_user_data = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre,lbl_user_data_email,lbl_user_data_edad,lbl_user_data_puede_pedir);

        VBox main = new VBox(10, hbox_user_search,vbox_user_data);


        Scene home_scene = new Scene(main, 720, 480);


        btn_user_search.setOnAction(e -> {
            UserController userController = new UserController();
            userController.test();
        });
        return home_scene;


    }

}
