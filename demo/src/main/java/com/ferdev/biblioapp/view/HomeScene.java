package com.ferdev.biblioapp.view;

import com.ferdev.biblioapp.controller.UserController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScene {
    public static Scene homeScene(){
        Label lbl_rut = new Label("Rut");
        TextField txf_rut = new TextField();
        txf_rut.setPromptText("Ejemplo : 11.111.111-1");
        Button btn_user_search = new Button("Buscar");
        HBox hbox_user_search = new HBox(10 , lbl_rut , txf_rut , btn_user_search);
        Label lbl_user_data_rut = new Label();
        Label lbl_user_data_nombre = new Label();
        Label lbl_user_data_email = new Label();
        Label lbl_user_data_edad = new Label();
        Label lbl_user_data_puede_pedir = new Label();
        VBox user_data = new VBox(5 , lbl_user_data_rut , lbl_user_data_nombre , lbl_user_data_edad , lbl_user_data_email , lbl_user_data_puede_pedir);
        VBox main = new VBox(10, hbox_user_search , user_data);
        Scene home_Scene = new Scene(main);
        btn_user_search.setOnAction(e -> {
            UserController usercontroller = new UserController();
            usercontroller.Test();
        });
        return home_Scene;
 
    }
    
}
