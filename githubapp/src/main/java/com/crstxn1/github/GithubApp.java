package com.crstxn1.github;

import javax.swing.text.PasswordView;

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

public class GithubApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image logo_gh = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");

        ImageView imgview_logo = new ImageView(logo_gh);
        imgview_logo.setFitWidth(60);
        imgview_logo.setFitHeight(60);
        
        Label lblInicioSesion = new Label("Sign in to GitHub");

        lblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox banner = new VBox(imgview_logo, lblInicioSesion );

        banner.setAlignment(Pos.TOP_CENTER);

        Label lblUser_name = new Label("Username or email address");

        TextField txf_user_name = new TextField();

        Label lblPassword = new Label("Password");

        PasswordField txf_password = new PasswordField();

        Button btn_singin = new Button("Sign in");
        btn_singin.setMaxWidth(Double.MAX_VALUE);
        btn_singin.setStyle("-fx-background-color:#0a8940;" + "-fx-text-fill: #fff;" + "-fx-font-weight: bold;");

        btn_singin.setOnAction( e -> {
            String usuario = txf_user_name.getText();
            String password = txf_password.getText();

            System.out.println("Usuario: " + usuario);
            System.out.println("Password: " + password);
        } );

        VBox formulario_login = new VBox(10, lblUser_name, txf_user_name, lblPassword, txf_password, btn_singin);

        formulario_login.setPadding(new Insets(10));

        VBox interfaz = new VBox(5, banner, formulario_login);

        interfaz.setPadding(new Insets(20));

        interfaz.setStyle("-fx-background-color: #fff;");



        



        

        Scene loginScene = new Scene(interfaz, 375, 667);

        stage.setScene(loginScene);

        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
