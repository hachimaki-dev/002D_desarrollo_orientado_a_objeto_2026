package com.gamevault;

import com.gamevault.view.PantallaPrincipal;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new PantallaPrincipal().pantallaPrincipal());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
