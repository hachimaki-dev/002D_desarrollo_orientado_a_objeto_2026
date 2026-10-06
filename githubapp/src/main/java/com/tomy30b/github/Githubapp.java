package com.tomy30b.github;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Githubapp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
         
        Image logo_github = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTefOFcY0PQkwzCC70C9jRX-509U8pU_8zf92DN2lLIvQ&s");

        ImageView verimagen_logo_gh = new ImageView(logo_github);

        verimagen_logo_gh.setFitHeight(60);
        verimagen_logo_gh.setFitWidth(60);
        
        Label lblInicioSesion = new Label("Sign in to GitHub");

        lblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");
        
        VBox contenedor = new VBox(5,verimagen_logo_gh,lblInicioSesion);

        contenedor.setAlignment(Pos.TOP_CENTER);
        
        Label lbl_user_name = new Label("Username or Email Adress");

        TextField txF_username = new TextField("");

        Label lbl_password = new Label("Password");

        PasswordField txF_password =  new PasswordField();
        Button boton_login = new Button("Sign In");

        boton_login.setMaxWidth(Double.MAX_VALUE);
        boton_login.setStyle("-fx-background-color:#05802a;" + "-fx-text-fill:#ffffff;" + "-fx-font-weight: bold;");
        boton_login.setOnAction(e -> {

            String nombre = txF_username.getText().strip();





            String password = txF_password.getText().strip();

            if(nombre.equals("ADMIN") && password.equals("1234")){

                System.out.println("USUARIO REGISTRADO");
                
                System.out.println("Usuario: " + nombre);
                System.out.println("Contraseña: " + password);

                Label lbl_bienvenida = new Label("BIENVENIDO!!!");

                Scene nuevainterfaz = new Scene(lbl_bienvenida);

                stage.setScene(nuevainterfaz);


            }else{

                System.out.println("Contraseña incorrecta");


            }
            
            
        });

        VBox formulario_login = new VBox(lbl_user_name,txF_username,lbl_password,txF_password,boton_login);

        VBox contenedor_padre = new VBox(contenedor,formulario_login);

        contenedor_padre.setPadding(new Insets(20));

        Scene login_scene = new Scene(contenedor_padre);


        

        stage.setScene(login_scene);

        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
