package com.spotifyjava;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label tituloCancion = new Label("Titulo de la cancion: ");
        TextField campoTitulo = new TextField();
        campoTitulo.setPromptText("Ingrese el titulo");

        Label lbArtista = new Label("Artista: ");
        TextField campoArtista = new TextField();
        campoArtista.setPromptText("Ingrese el nombre del artista");

        Button btnGuardarCancion = new Button("Registrar cancion");


        VBox registro_usuario = new VBox(tituloCancion, campoTitulo, lbArtista, campoArtista, btnGuardarCancion);
        registro_usuario.setPadding(new Insets(20));
        Scene escena = new Scene(registro_usuario, 400, 200);

        stage.setTitle("Registro de Canciones");
        stage.setScene(escena);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }


}
