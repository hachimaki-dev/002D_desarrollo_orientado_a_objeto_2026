package com.camilodiaz2.github;

import javax.swing.text.Position;

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

public class GithubApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image logoGithub = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");

        ImageView imgViewLogoGithub = new ImageView(logoGithub);
        imgViewLogoGithub.setFitHeight(60);
        imgViewLogoGithub.setFitWidth(60);

        Label lblInicioSesion = new Label("Sign in to GitHub");
        lblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox banner = new VBox(imgViewLogoGithub, lblInicioSesion);
        banner.setAlignment(Pos.TOP_CENTER);

        Label lblUserName = new Label("Username or email address");
        TextField txtUserName = new TextField();
        
        Label lblPassword = new Label("Password");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPromptText("Ingrese su contraseña");

        Button btnSignIn = new Button("Sign in");
        btnSignIn.setMaxWidth(Double.MAX_VALUE);
        btnSignIn.setStyle("-fx-background-color: #1c8139;" + "-fx-text-fill: #ffffff;" + "-fx-font-weight: bold;");
        btnSignIn.setOnAction(e -> {
            System.out.println("El usuario escrito es: " + txtUserName.getText());
            System.out.println("La contraseña escrita es: " + txtPassword.getText());

            if (txtUserName.getText().equals("admin") && txtPassword.getText().equals("mipass"))
            {
                mostrarSceneAdmin(stage, txtUserName.getText());
            }
            else
            {
                System.out.println("Error. Ingrese correctamente sus datos.");
            }
        });

        VBox formularioLogin = new VBox(10, lblUserName, txtUserName, lblPassword, txtPassword, btnSignIn);

        VBox mainVBox = new VBox(5, banner, formularioLogin);
        mainVBox.setPadding(new Insets(20));


        Scene loginScene = new Scene(mainVBox, 400, 806);

        stage.setScene(loginScene);

        stage.show();
    }

    void mostrarSceneAdmin(Stage stage, String nombre)
    {
        Label lblSaludo = new Label("Bienvenido, nombre");
        lblSaludo.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox mainVBox = new VBox(5, lblSaludo);
        mainVBox.setPadding(new Insets(20));


        Scene admingScene = new Scene(mainVBox, 300, 300);

        stage.setScene(admingScene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
    El usuario es "admin" y la pass es "megustaelpanconmiel94"
    Al hacer click en el boton de login, si el usuario es el mismo que admin y la pass es la misma, debería hacer login (cambiar de Scene)
    que salude al usuario, de lo contrario, se le avisa que se equivocó de datos.
*/


/*
    Hacer un login con base de datos (Oracle)
*/