package com.crstxn1.javadb;

import java.sql.Connection;
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

        Button obtener_usuarios = new Button();

        TextField txf_user_name = new TextField();

        Button btn_insertar = new Button("Hazme click para insertar");

        String ruta_conexion_db = "jdbc:oracle:thin:@localhost:1521:ORCL";

        String nombre_user_db = "usuario_desarrollador";

        String password_db = "123456";

        btn_insertar.setOnAction(ev -> {
            String nombre_usuario = txf_user_name.getText();
            try {

                DriverManager.getConnection(ruta_conexion_db, nombre_user_db, password_db).isValid(2);

                String sql_insertar = "INSERT INTO TEST(NOMBRE) VALUES('" + nombre_usuario + "')";

                try {
                    DriverManager.getConnection(ruta_conexion_db, nombre_user_db, password_db)
                            .prepareStatement(sql_insertar).executeUpdate();

                    System.out.println("Usuario insertado");
                } catch (Exception e) {
                    System.out.println("Hubo problemas");
                }

            } catch (Exception e) {
                System.out.println(("No me pude conectar a la bd"));
            }

        });

        obtener_usuarios.setOnAction();

        VBox contenedor = new VBox(btn_insertar, txf_user_name, obtener_usuarios);

        Scene escena_principal = new Scene(contenedor, 720, 400);

        primaryStage.setScene(escena_principal);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
