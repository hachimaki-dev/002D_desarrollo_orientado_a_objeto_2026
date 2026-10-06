package com.gallegos155.github;

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

public class GitHubApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Image log_hithub = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");
        ImageView imgview_logoGitHub = new ImageView(log_hithub);
        imgview_logoGitHub.setFitHeight(60);
        imgview_logoGitHub.setFitWidth(60);

        Label lblIniciodesesion = new Label("Sing in to Git Hub");
        lblIniciodesesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;  ");

        VBox banner = new VBox(imgview_logoGitHub, lblIniciodesesion);
        banner.setAlignment(Pos.TOP_CENTER);

        Label lbluser_name = new Label("Username or email addres");
        lbluser_name.setStyle("-fx-font-size: 10px;" + "-fx-font-weight: bold;");
        TextField txf_usarname = new TextField();
        txf_usarname.setStyle("-fx-border-wight: 10;" + "-fx-border-radius: 5;" + "-fx-background-radius: 5;");


        Label lblpassword = new Label("Password");
        lblpassword.setStyle("-fx-font-size: 10px;" + "-fx-font-weight: bold;");
        PasswordField txf_Password = new PasswordField(); 
        txf_Password.setStyle("-fx-border-wight: 10;" + "-fx-border-radius: 5;" + "-fx-background-radius: 5;");

        Button btn_login = new Button("Sing in");
        btn_login.setMaxWidth(Double.MAX_VALUE);
        btn_login.setStyle("-fx-Background-color: #2bbb0a;" + "-fx-text-fill: #fff;" + "-fx-weight: bold;");
        btn_login.setOnAction(e -> {System.err.println("Bienvenido " + lbluser_name);});

        VBox formulario_login = new VBox(10, lbluser_name, txf_usarname, lblpassword, txf_Password, btn_login);

        VBox interfaz = new VBox(5, banner, formulario_login);
        interfaz.setPadding(new Insets(20));
        interfaz.setStyle("-fx-Background-color: #f1ecec");

        Scene Login_scene = new Scene(interfaz, 375, 667);

    
        stage.setScene(Login_scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
