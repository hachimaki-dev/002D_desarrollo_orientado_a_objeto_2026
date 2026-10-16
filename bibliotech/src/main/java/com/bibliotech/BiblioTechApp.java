package com.bibliotech;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BiblioTechApp extends Application {
    @Override
    public void start(Stage stage) {
    configurarVentana(stage);
    stage.show();
    }

    private void configurarVentana(Stage stage) {
    stage.setTitle("BiblioTech");
    stage.setScene(crearVistaEscena());
    }
    
    public VBox crearPantallaBusqueda(){
        Label lblRutUsuario = new Label("Ingrese su rut");
        TextField txtRutUsuario = new TextField();
        Button btnIngresar = new Button("Buscar");
        HBox busqueda = new HBox(lblRutUsuario , txtRutUsuario , btnIngresar);
        VBox contenedorLogin = new VBox(busqueda);
        return contenedorLogin;
    }
    public Scene crearVistaEscena(){
        VBox contenedor = crearPantallaBusqueda();
        Scene escenaPrincipal = new Scene(contenedor , 600 , 300);
        return escenaPrincipal;
    }

    public static void main(String[] args) {
        launch(args);
    }

}