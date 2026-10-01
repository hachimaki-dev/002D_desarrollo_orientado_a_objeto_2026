package com.femacias.instagram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InstagramApp extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Label lbltitulo = new Label("Instagram");
        lbltitulo.setStyle("-fx-background-color:rgb(87, 156, 221);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #ffffff");

        TextField txtnumerotelefono = new TextField();
        txtnumerotelefono.setPromptText("Ingrese su numero");

        VBox vbox = new VBox(5 , lbltitulo , txtnumerotelefono );
        vbox.setStyle("-fx-background-color:FFFFF");
        Button Boton = Boton();
        Scene escena = new Scene(vbox , 600 , 400);
        stage.setScene(escena);
        stage.show();
        Boton();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static Button Boton(){
        Button btnRegistrarse = new Button("Registarse");
        btnRegistrarse.setStyle("-fx-background-color:rgb(7, 149, 214);" + "-fx-text-fill:rgb(255, 255, 255);" + "-fx-background-radius: 20px");
        return btnRegistrarse;
    }
    public static void registrarseInstagram(){
     
    }
}
