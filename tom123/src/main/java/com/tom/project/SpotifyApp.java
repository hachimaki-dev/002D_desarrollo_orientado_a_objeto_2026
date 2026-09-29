package com.tom.project;

import javafx.application.Application;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SpotifyApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
         
        
       
        Label lbltitulonombre = new Label("Titulo cancion: ");

        lbltitulonombre.setStyle("-fx-background-color:#4eb939");





        Label lblArtista = new Label("Artista: ");

        
        
        TextField txttitulocancion = new TextField();
        txttitulocancion.setPromptText("ingrese el nombre de la cancion");


        TextField txtArtista = new TextField();
        txtArtista.setPromptText("Ingrese el nombre del artista");

        Button btnguardarcancion = new Button("Registrar");

        btnguardarcancion.setStyle("-fx-background-color:#35e235");

        VBox registro_usuario = new VBox(5,lbltitulonombre,txttitulocancion,lblArtista,txtArtista,btnguardarcancion);

        Scene ventana = new Scene(registro_usuario,600,400);

        registro_usuario.setPadding(new Insets(20));

        stage.setScene(ventana);

        stage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
