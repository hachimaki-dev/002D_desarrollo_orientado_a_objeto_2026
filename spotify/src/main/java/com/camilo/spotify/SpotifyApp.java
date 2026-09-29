package com.camilo.spotify;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Label lblTituloCancion = new Label("Título canción: ");
        lblTituloCancion.setStyle("-fx-background-color:rgb(87, 156, 221);" + "-fx-background-radius: 20px;" + "-fx-padding: 5 20;" + "-fx-text-fill: #ffffff");

        TextField txtTituloCancion = new TextField();
        txtTituloCancion.setPromptText("Ingrese el tìtulo de la canción");
        txtTituloCancion.setStyle("-fx-background-radius: 120px");

        Label lblArtista = new Label("Artista: ");
        TextField txtArtista = new TextField();
        txtArtista.setPromptText("Ingrese el nombre del artista");

        Button btnGuardarCancion = new Button("Registrar canción");
        btnGuardarCancion.setStyle("-fx-background-color: #4ae23c;" + "-fx-text-fill:rgb(255, 255, 255);" + "-fx-background-radius: 120px");

        VBox registroUsuario = new VBox(5, lblTituloCancion, txtTituloCancion, lblArtista, txtArtista, btnGuardarCancion);
        registroUsuario.setPadding(new Insets(20));

        Scene ventana = new Scene(registroUsuario, 600, 300);

        stage.setScene(ventana);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
