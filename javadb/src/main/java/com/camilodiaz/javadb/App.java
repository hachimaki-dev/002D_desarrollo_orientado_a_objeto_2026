package com.camilodiaz.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField txtUsername = new TextField();

        Button btn_insertar = new Button("Hazme click para insertar");
        Button btn_obtenerUsuarios = new Button("Mostrar usuarios en consola");

        // Toda conexión hacia una DB requiere 3 cosas
        // 1. Requiere una cadena de CNX.
        // 2. Requiere el usuario.
        // 3. Requiere la password con la que autentico al usuario de la DB.
        
        String rutaConexionDb = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String nombreUsuarioDb = "usuario_desarrollador";
        String passwordDeLaDb = "123456";

        btn_insertar.setOnAction(ev -> {
            String username = txtUsername.getText();

            try
            {
                DriverManager.getConnection(rutaConexionDb, nombreUsuarioDb, passwordDeLaDb).isValid(2);

                String sqlInsertar = "INSERT INTO TEST(nombre) VALUES('" + username + "')";

                try
                {
                    DriverManager.getConnection(rutaConexionDb, nombreUsuarioDb, passwordDeLaDb).prepareStatement(sqlInsertar).executeUpdate();

                    System.out.println("Usuario insertado.");
                }
                catch (Exception ex)
                {
                    System.out.println("Hubo problemas para insertar el usuario.");
                }
            }
            catch (Exception e)
            {
                System.out.println("No se pudo conectar a la base de datos");
            }
        });

        btn_obtenerUsuarios.setOnAction(ev -> {
            ArrayList<String> lista = new ArrayList<>();
            String sql = "SELECT nombre FROM TEST ORDER BY id ASC";

            try (Connection conn = DriverManager.getConnection(rutaConexionDb, nombreUsuarioDb, passwordDeLaDb);
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String username = rs.getString("nombre");

                    lista.add(username);
                }

                System.out.println(lista);

            } catch (SQLException e) {
                System.out.println("Error al listar usuarios: " + e.getMessage());
            }
        });

        /*Connection conn = */

        

        VBox contenedor = new VBox(txtUsername, btn_insertar, btn_obtenerUsuarios);

        Scene escena_principal = new Scene(contenedor, 700, 400);

        primaryStage.setScene(escena_principal);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
