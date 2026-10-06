package com.leztdui.github;

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

        Image logo_gh = new Image(
            "https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png"
        );

        ImageView imgView_logo_gh = new ImageView(logo_gh);
        imgView_logo_gh.setFitWidth(60);
        imgView_logo_gh.setFitHeight(60);

        Label lblInicioSesion = new Label("Sign in to GitHub");
        lblInicioSesion.setStyle(
            "-fx-font-size: 20px; -fx-font-weight: bold;"
        );

        VBox banner = new VBox(10, imgView_logo_gh, lblInicioSesion);
        banner.setAlignment(Pos.TOP_CENTER);

        Label lblusername = new Label("Username or email address");

        TextField txf_user_name = new TextField();

        Label lblpassword = new Label("Password");

        PasswordField tfx_password = new PasswordField();

        Button btn_Sign_in = new Button("Sign in");

        btn_Sign_in.setMaxWidth(Double.MAX_VALUE);

        btn_Sign_in.setStyle(
            "-fx-background-color: rgb(13, 155, 0);" +
            "-fx-text-fill: #ffffff;" +
            "-fx-font-weight: bold;"
        );
        btn_Sign_in.setOnAction(e ->{
            if(txf_user_name.getText().toString().equals("Admin"));
             tfx_password.getText().toString().equals("contraseña");
             System.out.println("Bienvenido");
            
        });

        btn_Sign_in.setOnAction(e -> {
            System.out.println(txf_user_name.getText());
        });

        VBox formulario_login = new VBox(
            10,
            lblusername,
            txf_user_name,
            lblpassword,
            tfx_password,
            btn_Sign_in
        );

        VBox interfaz = new VBox(20, banner, formulario_login);

        interfaz.setPadding(new Insets(20));

        Scene login_scene = new Scene(interfaz, 375, 667);

        stage.setScene(login_scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
