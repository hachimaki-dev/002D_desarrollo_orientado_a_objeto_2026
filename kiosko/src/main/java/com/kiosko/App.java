package com.kiosko;

import com.kiosko.view.ProductoView;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends  Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new ProductoView().crearEscena() );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
