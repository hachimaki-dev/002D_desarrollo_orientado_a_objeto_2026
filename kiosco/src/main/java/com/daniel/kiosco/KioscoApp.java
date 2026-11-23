package com.daniel.kiosco;

import com.daniel.kiosco.view.ProductoView;

import javafx.application.Application;
import javafx.stage.Stage;

public class KioscoApp extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        ProductoView vista = new ProductoView();
        stage.setTitle("Kiosco ELD10SPAPU - Oracle JDBC + MVC + DAO");
        stage.setScene(vista.crearEscena());
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
