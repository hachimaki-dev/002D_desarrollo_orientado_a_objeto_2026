package com.kat000.github;

import java.time.format.TextStyle;
import java.util.Scanner;

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

public class GitHubApp extends Application {
    @Override 
    public void start(Stage stage) throws Exception {

        Image logo_GitHub = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");

        ImageView imgView = new ImageView(logo_GitHub);
        imgView.setFitHeight(60);
        imgView.setFitWidth(60);

        Label lblInicioSesion = new Label("Sign in in to GitHub");

        VBox banner = new VBox(imgView, lblInicioSesion);

        banner.setAlignment(Pos.TOP_CENTER);
        lblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        Label lblUserName = new Label("Username or email addres");
        TextField txfUserName = new TextField();
        txfUserName.setPromptText("UserName or Email addres");
        Label lblPassword = new Label("Password");
        PasswordField txfPassword = new PasswordField();
        txfPassword.setPromptText("Password");
        Button signIn = new Button("Sig In");
        signIn.setMaxWidth(Double.MAX_VALUE);
        signIn.setStyle("-fx-background-color:rgb(18, 127, 4);" + "-fx-font-weight: bold;" + "-fx-text-fill:rgb(255, 255, 255);");
        signIn.setOnAction(e -> {System.out.println("Hola");});
        VBox formulario_login = new VBox(10, lblUserName, txfUserName, lblPassword, txfPassword, signIn);

        VBox interfaz = new VBox(10, banner, formulario_login);
        interfaz.setPadding(new Insets(20));
        
        Scene loginScene = new Scene(interfaz, 375, 667);

        stage.setScene(loginScene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
//Usuario es admin y password es la que quiera.
}
