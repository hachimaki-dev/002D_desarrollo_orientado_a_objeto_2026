package com.tomy30b;

import java.sql.DriverManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserApp extends Application {
    
     @Override

  public void start(Stage primaryStage) throws Exception {
    TextField txf_user_name = new TextField();
    

    Button btn_insertar = new Button("Hazme click para insertar");


    Button btn_buscar_A_todos = new Button();



   
    //TODA CONEXION REQUIERE ESTAS 3 COSAS
    //!. cadena de conexion URL
    //2. usuario
    //3. contraseña
    String ruta_conexion_db = "jdbc:oracle:thin:@localhost:1521:ORCL";

    String nombre_usuario_db = "usuario_desarrollador";

    String password_db = "123456";

     btn_insertar.setOnAction(ef -> {
        String nombre_usuario = txf_user_name.getText();
          
         try {

        DriverManager.getConnection(ruta_conexion_db,nombre_usuario_db,password_db).isValid(2);

        String sql_insertar = "INSERT INTO TEST(nombre) VALUES('Pepito')";
        try {
            DriverManager.getConnection(ruta_conexion_db,nombre_usuario_db,password_db).prepareStatement(sql_insertar).executeUpdate();

            System.out.println("Usuario Insertado");
            
        } catch (Exception ex) {
            System.out.println("Pasaron cositas");
        }

        
    } catch (Exception e) {
        
    }
    });

    btn_buscar_A_todos.setOnAction(ed -> {

        String sql_buscar_todo = "SELECT * FROM TEST";

        try {
            DriverManager.getConnection(ruta_conexion_db,nombre_usuario_db,password_db).prepareStatement(sql_buscar_todo).executeUpdate();
            
        } catch (Exception e) {
            
        }

        


    });

   

    



    VBox contenedor = new VBox(10,btn_insertar,txf_user_name,btn_buscar_A_todos);



    Scene escena_principal = new Scene(contenedor, 720, 400);



    primaryStage.setScene(escena_principal);   

    primaryStage.show(); 

    

  }



  public static void main(String[] args) {

    launch(args);

  }

  

}

