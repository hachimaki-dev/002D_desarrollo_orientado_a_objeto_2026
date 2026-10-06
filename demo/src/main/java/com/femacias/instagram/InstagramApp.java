package com.femacias.instagram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstagramApp extends Application {

    @Override
    public void start(Stage ventanaPrincipal) {
        Label lbltitulo = new Label("Instagram");

        TextField campoNumeroTelefonico = new TextField();
        campoNumeroTelefonico.setPromptText("Ingrese su numero de telefono");

        VBox contendorPrincipal = new VBox(10 , lbltitulo , campoNumeroTelefonico);
        Button botonPrueba = new Button("Holaa!!");
        contendorPrincipal.getChildren().add(botonPrueba);

        Scene escenaPrincipal = new Scene(contendorPrincipal , 600 , 400);

        ventanaPrincipal.setTitle("Instagram");
        ventanaPrincipal.setScene(escenaPrincipal);
        ventanaPrincipal.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}