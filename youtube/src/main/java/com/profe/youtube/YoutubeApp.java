package com.profe.youtube;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YoutubeApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub

        VBox cajita = cajita();


        Scene escena = new Scene(cajita, 320, 640);

        stage.setScene(escena);
        stage.show();
    }

    public static VBox cajita(){
        Label lblTitulo = new Label("Youtube");
        VBox vbox = new VBox(5, lblTitulo);
        vbox.setStyle("-fx-background-color: #000;");

        return vbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
