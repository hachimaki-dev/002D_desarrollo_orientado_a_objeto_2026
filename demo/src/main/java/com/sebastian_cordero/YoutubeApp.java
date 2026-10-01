package com.sebastian_cordero;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class YoutubeApp extends Application {
    @Override 
    public void start(Stage stage) throws Exception {
        Label lblTitulo = new Label("Youtube");
        lblTitulo.setStyle("-fx-text-fill:rgb(255, 255, 255)");
        lblTitulo.setFont(new Font("Arial", 50));

        TextField txt = new TextField("Ingresa usuario");
        txt.setStyle("-fx-text-fill:rgb(56, 56, 56)");

        VBox vbox = new VBox(5, lblTitulo, txt);
        vbox.setStyle("-fx-background-color:rgb(0, 0, 0)");
        vbox.setAlignment(Pos.BASELINE_CENTER);


        Scene escena = new Scene(vbox, 320, 640);

        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
