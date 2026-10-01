package com.figueroawa.youtube;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class YoutubeApp extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Logo Youtube
        Image imgLogo = new Image(new FileInputStream(
                "/home/selena2/Escritorio/002D_desarrollo_orientado_a_objeto_2026/youtube/src/main/resources/img/logo.png"));
        ImageView imgviewLogo = new ImageView(imgLogo);
        imgviewLogo.setFitWidth(200);
        imgviewLogo.setPreserveRatio(true);

        // TextFields
        TextField txtNombreCompleto = new TextField();

        VBox vbox = new VBox(20, imgviewLogo);

        Scene scene = new Scene(vbox, 320, 600, Color.BLACK);

        stage.setScene(scene);
        stage.show();
    }
}