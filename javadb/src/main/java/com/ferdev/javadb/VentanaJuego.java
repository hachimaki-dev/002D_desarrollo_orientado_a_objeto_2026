package com.ferdev.javadb;

import java.math.BigDecimal;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaJuego extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tienda");
        TextField txfNombre = new TextField();
        txfNombre.setPromptText("Ingrese el nombre");
        TextField txfPrecio = new TextField();
        txfPrecio.setPromptText("Ingrese el precio");
        TextField txfConsola = new TextField();
        txfConsola.setPromptText("Ingrese la consola");
        Button btnInsertar = new Button("Ingresar");
        btnInsertar.setOnAction(e -> {
            String nombre = txfNombre.getText();
            String consola = txfConsola.getText();
            try {
                BigDecimal precio = new BigDecimal(txfPrecio.getText());
                Main.insertarSql(nombre, precio, consola);
            } catch (NumberFormatException ex) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setContentText("El precio debe ser un numero" + ex.getMessage());
                alerta.showAndWait();

            } catch(SQLException ex1) {
                Alert alertaSql = new Alert(Alert.AlertType.WARNING);
                alertaSql.setContentText("No se pudo conectar a la base de datos" + ex1.getMessage());
                alertaSql.showAndWait();

            }
        });
        VBox contenedor = new VBox(txfNombre , txfPrecio , txfConsola , btnInsertar);
        Scene primaryScene = new Scene(contenedor , 720 , 400);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
    }
}
