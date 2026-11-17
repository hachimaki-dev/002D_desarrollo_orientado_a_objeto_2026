package com.ferdev.javadb;

import java.sql.Driver;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField txfUsername = new TextField();
        Button btnInsertar = new Button("Insertar");
        // Conexion de base de datos mala , se debe de hacer privado para que ninguna otra instancia la modifique
        String conexionDB = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
        // Necesita un usuario
        String user = "fernando1";
        // Necesita una contraseña
        String password = "fernando123";
        // DriverManager obtiene un metodo para la conexion de la base de datos
        btnInsertar.setOnAction(e ->{
            try {
            DriverManager.getConnection(conexionDB , user , password).isValid(2);

            String sqlInsertar = "INSERT INTO test (nombre) VALUES('Fernando')";
            try {
                DriverManager.getConnection(conexionDB , user , password).prepareStatement(sqlInsertar).executeUpdate();
                System.out.println("Usuario insertado");
            } catch (Exception ex) {
                System.out.println("Hubieron problemas");
            }
            
        } catch (Exception er) {
            // TODO: handle exception
        }

        });
        Button btnBuscar = new Button();
        btnBuscar.setOnAction(e -> {
            String sqlBuscar = "SELECT * FROM test";
            try {
                while (DriverManager.getConnection(conexionDB , user , password).prepareStatement(sqlBuscar).executeQuery().next()) {
                    
                }
            } catch (Exception er) {
                // TODO: handle exception
            }
        });


        VBox contenedor = new VBox(btnInsertar);
        Scene mainScene = new Scene(contenedor , 720 , 400);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
