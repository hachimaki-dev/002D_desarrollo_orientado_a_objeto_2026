package com.videojuego;

import com.videojuego.view.Interfaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application{   

    @Override
    public void start(Stage primeraScena) throws Exception {
       
        Interfaz incio_interfaz = new Interfaz();


        
        primeraScena.setScene(incio_interfaz.homeScene());
        primeraScena.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
