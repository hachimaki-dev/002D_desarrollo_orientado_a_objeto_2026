package com.ferdev.biblioapp.view;

import com.ferdev.biblioapp.controller.UserController;
import com.ferdev.biblioapp.model.User;

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
            UserController userController = new UserController();
            User userFound = userController.SolicitarUserRut(txf_rut.getText());
            lbl_user_data_nombre.setText("Nombre :" + userFound.getNombre());
            lbl_user_data_edad.setText("Edad" + userFound.getEdad());
            lbl_user_data_rut.setText("Rut" + userFound.getRut());
            lbl_user_data_email.setText("Email" + userFound.getEmail());
            lbl_user_data_puede_pedir.setText("Puede pedir" + userFound.isPuede_solicitar_prestamos());

        });
        return home_Scene;
 
    }
    
}
