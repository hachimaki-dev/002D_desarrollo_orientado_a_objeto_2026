package com.example;

//import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class App extends Application {

    @Override

    public void start(Stage primaryStage) throws Exception {

        Button btn_insertar = new Button("Hazme click para insertar");
        // TODA CONEXION HACIA UNA DB REQUIERA 3 COSA
        // 1. Requiere una CADENA DE CNX
        String ruta_conexion_db = "jdbc:oracle:thin:@localhost:1521:ORCL";
        // 2. Requiere el usuario
        String nombre_de_usuario_db = "usuario_desarrollador";
        // 3. Es la password con la que autentico al usuario de la BD
        String password_de_la_db = "123456";
        btn_insertar.setOnAction(ev -> {
            try {
                DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).isValid(2);
                String sql_insertar = "INSERT INTO TEST(nombre) VALUES('Pepito')";
                try {
                    DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).prepareStatement(sql_insertar).executeUpdate();
                    System.out.println("Usuario insertado");
                } catch (Exception ex) {
                    System.out.println("Hubo problemas para insetar el usuario");
                }
            } catch (Exception e) {
                System.out.println("No me pude conectar a la BD");
            }
        });
        VBox contenedor = new VBox(btn_insertar);
        Scene escena_principal = new Scene(contenedor, 720, 400);
        primaryStage.setScene(escena_principal);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}