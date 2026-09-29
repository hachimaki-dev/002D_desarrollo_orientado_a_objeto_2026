package com.danopazom.spotify;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Label lblTituloCancion = new Label("Titulo canción: ");
        lblTituloCancion.setStyle("-fx-background-color: rgb(52,152,219);" + "-fx-background-radius: 20;" + "-fx-padding: 5 20;" + "-fx-text-fill: #ffffff;");

        TextField txtTituloCancion = new TextField();
        txtTituloCancion.setPromptText("Ingrese el título de la canción");
        txtTituloCancion.setStyle( "-fx-background-radius: 20;");

        Button btnGuardarCancion = new Button("Registrar canción");
        btnGuardarCancion.setStyle("-fx-background-color:rgb(44, 224, 28);" + "-fx-background-radius: 20;" + "-fx-text-fill: #ffffff;");


        Label lblArtista = new Label("Artista: ");
        lblArtista.setStyle("-fx-background-color: rgb(52,152,219);" + "-fx-background-radius: 20;" + "-fx-padding: 5 20;" + "-fx-text-fill: #ffffff;");
        
        TextField txtArtista = new TextField();
        txtArtista.setPromptText("Ingrese el nombre del artista");
        txtArtista.setStyle( "-fx-background-radius: 20;");        


        VBox registro_usuario = new VBox(10, lblTituloCancion,txtTituloCancion,lblArtista,txtArtista,btnGuardarCancion); 

        Scene ventana = new Scene(registro_usuario, 500,300);

        registro_usuario.setPadding(new Insets(20));

        stage.setScene(ventana);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}