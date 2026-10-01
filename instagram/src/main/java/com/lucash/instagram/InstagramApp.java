package com.lucash.instagram;

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
        lbltitulo.setStyle("-fx-text-fill:rgb(255, 255, 255)");
        TextField txtIngresoDeNombre = new TextField();
        Button btn = new Button("Login");
        btn.setOpacity(1);
        lbltitulo.setTranslateX(124);
        lbltitulo.setTranslateY(10);
        btn.setTranslateY(10);
        btn.setTranslateX(124);
        txtIngresoDeNombre.setTranslateY(10);
        lbltitulo.setScaleX(2);
        lbltitulo.setScaleY(2);
        
        
        
        VBox vbox = new VBox(5, lbltitulo, txtIngresoDeNombre, btn);
        vbox.setStyle("-fx-background-color: #000000");
        Scene escena = new Scene(vbox, 320, 640);
        stage.setScene(escena);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
