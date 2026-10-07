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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GitHubApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Image log_hithub = new Image("https://www.pngmart.com/files/23/Github-Logo-PNG-Photo-1.png");
        ImageView imgview_logoGitHub = new ImageView(log_hithub);
        imgview_logoGitHub.setFitHeight(60);
        imgview_logoGitHub.setFitWidth(100);

        Label lblIniciodesesion = new Label("Sing in to Git Hub");
        lblIniciodesesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;" + "-fx-text-fill: #fff");

        VBox banner = new VBox(imgview_logoGitHub, lblIniciodesesion);
        banner.setAlignment(Pos.TOP_CENTER);

        Label lbluser_name = new Label("Username or email addres");
        lbluser_name.setStyle("-fx-font-size: 14px;" + "-fx-font-weight: bold;" + "-fx-text-fill: #fff" );
        TextField txf_usarname = new TextField();
        txf_usarname.setPrefHeight(40);
        txf_usarname.setPrefWidth(352);
        txf_usarname.setStyle("-fx-border-wight: 10;" + "-fx-border-radius: 6;" + "-fx-background-radius: 5;" + "-fx-background-color: #0d1117;" + "-fx-border-color: #3d444d;");
        txf_usarname.setFont(new Font(16.5));
        

        Label lblpassword = new Label("Password");
        lblpassword.setStyle("-fx-font-size: 14px;" + "-fx-font-weight: bold;" + "-fx-text-fill: #fff" );
        PasswordField txf_Password = new PasswordField(); 
        txf_Password.setPrefHeight(40);
        txf_Password.setPrefWidth(352);
        txf_Password.setStyle("-fx-border-wight: 10;" + "-fx-border-radius: 6;" + "-fx-background-radius: 5;" + "-fx-background-color: #0d1117;" + "-fx-border-color: #3d444d;");
        txf_Password.setFont(new Font(16.5));

        Button btn_login = new Button("Sing in");
        btn_login.setPrefHeight(40);
        btn_login.setPrefWidth(352);
        btn_login.setStyle("-fx-Background-color: #238636;" + "-fx-text-fill: #fff;" + "-fx-weight: bold;" + "-fx-font-size: 15px;" + "-fx-border-wight: 10;" + "-fx-border-radius: 6;" + "-fx-background-radius: 5;");

        Label lblMensaje = new Label();
        lblMensaje.setStyle("-fx-font-size: 13px;");
        btn_login.setOnAction(e -> {

            String usuario = txf_usarname.getText().trim();
            String password = txf_Password.getText();

            if (usuario.equals("Admin") && password.equals("1234")) {
                lblMensaje.setText("Ha iniciado sesión correctamente");
                lblMensaje.setStyle("-fx-text-fill: #3fb950;");

                System.out.println("Bienvenido " + usuario);
            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos.");
                lblMensaje.setStyle("-fx-text-fill: #f85149;");
            }
        });

        HBox hb_linea = new HBox();
        hb_linea.setAlignment(Pos.CENTER);

        Label lblor = new Label("or");
        lblor.setStyle(
            "-fx-text-fill: #fff;" +
            "-fx-font-size: 14px;"
        );

        Label lineaIzquierda = new Label("────────────");
        lineaIzquierda.setStyle("-fx-text-fill: #3d444d;");

        Label lineaDerecha = new Label("────────────");
        lineaDerecha.setStyle("-fx-text-fill: #3d444d;");

        hb_linea.getChildren().addAll(lineaIzquierda, lblor, lineaDerecha);
        hb_linea.setSpacing(8);

        Button btnGoogle = new Button("Continue with Google");
        btnGoogle.setPrefHeight(48);
        btnGoogle.setMaxWidth(Double.MAX_VALUE);
        btnGoogle.setStyle(
                "-fx-background-color: #212830;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 15px;" +
                "-fx-border-color: #3d444d;" +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 6px;" +
                "-fx-background-radius: 6px;"
        );

        Button btnApple = new Button("Continue with Apple");
        btnApple.setPrefHeight(48);
        btnApple.setMaxWidth(Double.MAX_VALUE);
        btnApple.setStyle(
                "-fx-background-color: #212830;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 15px;" +
                "-fx-border-color: #3d444d;" +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 6px;" +
                "-fx-background-radius: 6px;"
        );

        Label lblNew = new Label("New to GitHub? ");
        lblNew.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;"
        );

        Label lblCreate = new Label("Create an account");
        lblCreate.setStyle(
                "-fx-text-fill: #4493f8;" +
                "-fx-font-size: 14px;"
        );

        HBox createAccount = new HBox(lblNew, lblCreate);
        createAccount.setAlignment(Pos.CENTER);

        Label lblPasskey = new Label("Sign in with a passkey");
        lblPasskey.setStyle(
                "-fx-text-fill: #4493f8;" +
                "-fx-font-size: 14px;"
        );

        HBox passKey = new HBox(lblPasskey);
        passKey.setAlignment(Pos.CENTER);

        
        VBox formulario_login = new VBox(8, lbluser_name, txf_usarname, lblpassword, txf_Password, btn_login);
        formulario_login.setPadding(new Insets(10, 12, 5 , 5 ));

        VBox interfaz = new VBox(9, banner, formulario_login, hb_linea, btnGoogle, btnApple, createAccount, passKey);
        interfaz.setPadding(new Insets(20));
        interfaz.setStyle("-fx-Background-color: #0d1117");

        Scene Login_scene = new Scene(interfaz, 375, 667);

    
        stage.setScene(Login_scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
