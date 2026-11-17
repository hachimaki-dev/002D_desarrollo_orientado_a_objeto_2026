package com.figueroawa.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override

    public void start(Stage primaryStage) throws Exception {

        TextField txf_user_name = new TextField();

        Button btn_insertar = new Button("Hazme click para insertar");
        Button btn_ver = new Button("Hazme click para ver la bd");

        // TODA CONEXION HACIA UNA DB REQUIERA 3 COSA

        // 1. Requiere una CADENA DE CNX

        String ruta_conexion_db = "jdbc:oracle:thin:@localhost:1521:ORCL";

        // 2. Requiere el usuario

        String nombre_de_usuario_db = "usuario_desarrollador";

        // 3. Es la password con la que autentico al usuario de la BD

        String password_de_la_db = "123456";

        btn_insertar.setOnAction(ev -> {

            String nombre_usuario = txf_user_name.getText();

            try {

                DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).isValid(2);

                String sql_insertar = "INSERT INTO TEST(nombre) VALUES('" + nombre_usuario + "')";

                try {

                    DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db)

                            .prepareStatement(sql_insertar).executeUpdate();

                    System.out.println("Usuario insertado");

                } catch (Exception ex) {

                    System.out.println("Hubo problemas para insetar el usuario");

                }

            } catch (Exception e) {

                System.out.println("No me pude conectar a la BD");

            }

        });

        btn_ver.setOnAction(e -> {
            String sql = "SELECT id, nombre FROM test ORDER BY id";

            try {

                Connection conn = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");

                    System.out.println("ID: " + id + " | Nombre: " + nombre);
                }

            } catch (Exception ex) {
                // TODO: handle exception
            }
        });

        VBox contenedor = new VBox(10, btn_ver, btn_insertar, txf_user_name);

        Scene escena_principal = new Scene(contenedor, 720, 400);

        primaryStage.setScene(escena_principal);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
