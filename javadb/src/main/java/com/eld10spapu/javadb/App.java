package com.eld10spapu.javadb;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField txf_username = new TextField();

        Button btn_insertar = new Button("Hazme click para insertar");
        Button btn_mostrar_tabla = new Button("Hazme click para mostrar usuarios");

        // Creando conexion hacia la base de datos
        // 1. cadena de conexion
        String ruta_conexion_db = "jdbc:oracle:thin:@localhost:1521:ORCL";
        // 2. usuario
        String nombre_de_usuario_db = "usuario_desarrollador";
        // 3. contraseña del usuario
        String password_de_la_db = "123456";
        btn_insertar.setOnAction(ev -> {
            String nombre_usuario = txf_username.getText();
            try {
                DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).isValid(2);

                String sql_insertar = "INSERT INTO TEST(nombre) VALUES('" + nombre_usuario + "')";
                try {
                    DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db)
                            .prepareStatement(sql_insertar).executeUpdate();
                    System.out.println("Usuario insertado");
                } catch (Exception ex) {
                    System.out.println("Hubo problemas para insertar el usuario");
                }

            } catch (Exception e) {

            }
        });

        btn_mostrar_tabla.setOnAction(eve -> {
            try {
                String sql_select = "SELECT nombre FROM TEST";
                ResultSet rs = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).prepareStatement(sql_select).executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("nombre"));
                }

            } catch (Exception e) {
                System.out.println("ERROR");
            }
        });

        VBox contenedor = new VBox(txf_username, btn_insertar, btn_mostrar_tabla);

        Scene escena_principal = new Scene(contenedor, 720, 400);

        primaryStage.setScene(escena_principal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
