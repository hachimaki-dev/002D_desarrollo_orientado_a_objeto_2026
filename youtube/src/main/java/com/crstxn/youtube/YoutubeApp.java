package com.crstxn.youtube;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class YoutubeApp extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        // TODO Auto-generated method stub

        Label lblTitulo = new Label("Youtube");    
     
        // Cambia el texto a blanco y aumenta su tamaño
        lblTitulo.setStyle("-fx-text-fill: #FFFFFF; -fx-font-size: 20px; -fx-font-weight: bold;");
        Image imagen = new Image("https://static.vecteezy.com/system/resources/thumbnails/018/930/572/small/youtube-logo-youtube-icon-transparent-free-png.png");
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(40);       
        imageView.setPreserveRatio(true);



        VBox vbox = new VBox(5, imageView, lblTitulo);
        vbox.setStyle("-fx-background-color: #000000");
        Scene escena = new Scene(vbox, 320, 640);

        stage.setScene(escena);
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);

    }
}
