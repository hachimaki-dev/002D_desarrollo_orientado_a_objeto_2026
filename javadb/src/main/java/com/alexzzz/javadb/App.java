package com.alexzzz.javadb;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField txf_user_name = new TextField();
        Button btn_insertar = new Button("Hazme click para insertar");

        //TODA CONEXION HACIA UNA DB REQUIERE 3 COSAS
        //1. Requiere una CADENA DE CNX
        String ruta_conexion_db = "jdbc:oracle:thin:@localhost:1521:ORCL";
        //2. Requiere el usuario
        String nombre_de_usuario_db = "usuario_desarrollador";
        //3. Es la password con la que autentico al usuario de la BD
        String password_de_la_db = "123456";

        btn_insertar.setOnAction(ev ->{
            String nombre_usuario = txf_user_name.getText();
            try{

            Boolean se_logro = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).isValid(2);


            String sql_insertar = "INSERT INTO TEST(nombre) VALUES('" + nombre_usuario  + "')";

            try{
                DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).prepareStatement(sql_insertar).executeUpdate();
                System.out.println("Usuario Insertado");

            } catch(Exception ex){
                System.out.println("Hubo problemas para insertar el usuario");
            }

        } catch (Exception e){
            System.out.println("No me pude conectar a la base de datos");
        }
        });

    
        Button btn_todos_los_usuarios = new Button("Hazme click para imprimir los usuarios");

        btn_todos_los_usuarios.setOnAction(eve -> {
            String sql = "SELECT * FROM TEST ORDER BY id ASC";

            try(Connection conn = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db);
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery())
            {
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    System.out.println("El id: " + id + ". El nombre: " + nombre);
                }

            }catch(Exception even){
                System.out.println("No se pudo papito :(");
            }
        });

        VBox contenedor = new VBox(10, btn_insertar, txf_user_name, btn_todos_los_usuarios);

        Scene escena_main = new Scene(contenedor, 720, 400);

        primaryStage.setScene(escena_main);
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
