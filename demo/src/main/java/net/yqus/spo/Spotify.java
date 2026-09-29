package net.yqus.spo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Spotify extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label lbltitulo = new Label("Hola mundo");
        TextField txttitulocancion = new TextField();
        Button boton = new Button("PRESIONAME");
        VBox registro_usuario = new VBox(10 , lbltitulo ,txttitulocancion, boton);
        registro_usuario.setPadding(new Insets(20));
        Scene ventana = new Scene(registro_usuario , 600 , 400);
        stage.setScene(ventana);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
