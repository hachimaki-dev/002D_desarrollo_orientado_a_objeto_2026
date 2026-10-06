package com.eld10spapu.github;

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
import javafx.stage.Stage;

public class GithubApplication extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Image logo_gh = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");

        ImageView imgview_logo_gh = new ImageView(logo_gh);
        imgview_logo_gh.setFitWidth(60);
        imgview_logo_gh.setFitHeight(60);

        Label lblInicioSesion = new Label("Sign in to GitHub");
        lblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox banner = new VBox(10,imgview_logo_gh,lblInicioSesion);
        banner.setAlignment(Pos.TOP_CENTER);

        Label lbl_username = new Label("Username or email address");
        TextField txf_username = new TextField();

        Label lbl_password = new Label("Password");
        PasswordField txf_password = new PasswordField();

        Button btn_sign_in = new Button("Sign in");
        btn_sign_in.setMaxWidth(Double.MAX_VALUE);
        btn_sign_in.setStyle("-fx-background-color: #1f883d;" + "-fx-text-fill: #ffffff;" + "-fx-font-weight: bold;");
        btn_sign_in.setOnAction( e -> {
            String usuario = txf_username.getText();
            String password = txf_password.getText();

            if (usuario == "ADMIN" && password == "123456"){
                System.out.println("cambiar escena");
            }

            System.out.println("DATOS USUARIO:");
            System.out.println("USUARIO: "+ usuario);
            System.out.println("Contraseña: " + password);
        }); 

        VBox formulario_login = new VBox(10,lbl_username,txf_username,lbl_password,txf_password,btn_sign_in);

        VBox interfaz = new VBox(banner,formulario_login);
        interfaz.setPadding(new Insets(20));

        Scene login_scene = new Scene(interfaz,375,667);
        stage.setScene(login_scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//Tarea n°1 Ocultar el password al escribirla
//   Para ocultar la contraseña al escribirla en la interfaz hay que usar "PasswordField" en vez de "TextField"
//Tarea n°2 Al darle click en sign in aparezca en la terminal los datos de el usuario
//   Para guardar los datos debes crear las variables que las van a almacenar incluyendo el "TextField" o "PasswordField" y agregandoles el metodo de ".getText()"

//Tarea EXTRA: El usuario es ADMIN y la password es "123456" al hacer click en sign in, si el usuario y la contraseña ya existe debe cambiar de escena apareciendo un mensaje de bienvenida con sus datos