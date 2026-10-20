package com.biblioapp.view;

import com.biblioapp.controller.UserController;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScene {
    public Scene homeScene()
    {
        Label lblUserRut = new Label("Rut: ");
        
        TextField txtUserRut = new TextField();
        txtUserRut.setPromptText("ej: 11.111.111-1");

        Button btnUserSearch = new Button("Buscar");

        HBox hboxUserSearch = new HBox(10, lblUserRut, txtUserRut, btnUserSearch);

        Label lblUserDataRut = new Label("Rut: ______");
        Label lblUserDataNombre = new Label("Nombre: ______");
        Label lblUserDataEmail = new Label("Email: ______");
        Label lblUserDataEdad = new Label("Edad: ______");
        Label lblUserDataPuedePedir = new Label("¿Puede solicitar libros? ______");

        VBox vboxUserData = new VBox(5, lblUserDataRut, lblUserDataNombre, lblUserDataEmail, lblUserDataEdad, lblUserDataPuedePedir);

        VBox vboxMain = new VBox(hboxUserSearch, vboxUserData);

        Scene homeScene = new Scene(vboxMain, 720, 480);

        btnUserSearch.setOnAction(e -> {
            UserController userController = new UserController();
            userController.test();
        });

        return homeScene;
    }
}
