package com.zinedine.youtube;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YoutubeApp extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        
        Label lbltitulo = new Label("Youtube ");
        lbltitulo.setStyle("-fx-text-fill: #ffffff");
        lbltitulo.setScaleX(2);
        lbltitulo.setScaleY(2);
        lbltitulo.setTranslateX(230);
        lbltitulo.setTranslateY(10);
        TextField txtpibles = new TextField();
        txtpibles.setTranslateY(10);
        Button btn = new Button("Tocame :)");
        btn.setTranslateY(10);
        VBox vbox = new VBox(10, lbltitulo, txtpibles, btn);
        vbox.setStyle("-fx-background-color: #000");
        Scene escena = new Scene(vbox, 500, 600);

        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
