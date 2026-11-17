package com.seba1304256.javadb;

import java.sql.DriverManager;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage arg0) throws Exception {
        TextField txf_user_name = new TextField();
        Button btn_insertar = new Button("Hazme click para insertar ");
        

        String ruta_conexion_db = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String nombre_de_usuario_db = "usuario_desarrollador";
        String contraseña_usuario_db = "123456";
        
        btn_insertar.setOnAction(ev -> {
            String nombre_usuario = txf_user_name.getText();
            try {

                DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, contraseña_usuario_db).isValid(2);
                String sql_insert = "INSERT INTO TEST(nombre) VALUES('" + nombre_usuario + "')";
                try {
                    DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, contraseña_usuario_db)
                            .prepareStatement(sql_insert).executeUpdate();
                    System.out.println("usuario insertado");
                } catch (Exception ex) {
                    System.out.println("hubo problema en insertar");
                }

            } catch (Exception e) {
                // TODO: handle exception
            }
        
            
        
        });
        Button btn_mostrar_consola = new Button("mostrar");
        btn_mostrar_consola.setOnAction(eve -> {
                
                try {
                    String sql_select = "SELECT id, nombre FROM test ORDER BY id ASC ";
                    ResultSet rs = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, contraseña_usuario_db).prepareStatement(sql_select).executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString("nombre"));}
                } catch (Exception e) {
                    // TODO: handle exception
                }

                
            });
        VBox contendor = new VBox(btn_insertar, txf_user_name,btn_mostrar_consola);
        Scene escena_principal = new Scene(contendor, 720, 400);

        arg0.setScene(escena_principal);
        arg0.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
