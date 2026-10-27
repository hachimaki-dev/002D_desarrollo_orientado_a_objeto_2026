package com.tiendajuegos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

    @Override 
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setScene(vista.vista());
        primaryStage.setTitle("Trabajo esforzado MVC");
        primaryStage.show();


    }
}
