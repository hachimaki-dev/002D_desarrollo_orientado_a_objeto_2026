package com.hectorg.youtube;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YoutubeApp extends Application {
    @Override 
    public void start(Stage stage) throws Exception{

        
        Label lblTitulo = new Label("Youtube");
        VBox vbox = new VBox(5, lblTitulo);
        vbox.setStyle("-fx-background-color: #000");


        Scene escena = new Scene(vbox, 520, 640);

        stage.setScene(escena);
        stage.show();




    }

    public static void main(String[] args) {
        launch(args);
    }
}
