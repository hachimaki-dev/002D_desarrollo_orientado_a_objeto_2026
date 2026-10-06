package com.zizager.github;

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

        Image logo_github = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");

        ImageView imgView_logo_github = new ImageView(logo_github);
        imgView_logo_github.setFitWidth(60);
        imgView_logo_github.setFitHeight(60);

        Label lblInicioSesion = new Label("Sign in to GitHub");
        lblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");

        VBox banner = new VBox(imgView_logo_github, lblInicioSesion);
        banner.setAlignment(Pos.TOP_CENTER);


        Label lbl_username = new Label("Username or email address");
        TextField txf_user_name = new TextField();

        Label lbl_password = new Label("Password");
        PasswordField txf_password = new PasswordField();

        Button btn_sign_in = new Button("Sign in");
        btn_sign_in.setMaxWidth(Double.MAX_VALUE);
        btn_sign_in.setStyle("-fx-background-color: #1F883D;" + "-fx-text-fill: #fff;" + "-fx-font-weight: bold;");

        btn_sign_in.setOnAction( e -> {
            System.out.println("Nombre del usuario escrito es: " + txf_user_name.getText());
            System.out.println("La contraseña escrita es: " + txf_password.getText());

            if (txf_user_name.getText() == "admin" && txf_password.getText()== "megustaelpanconmiel94") {
                
            }else{
                
            }
        });

        VBox formulario_login = new VBox(10, lbl_username, txf_user_name, lbl_password, txf_password, btn_sign_in);
        
        VBox VboxMain = new VBox(5, banner, formulario_login);

        VboxMain.setPadding(new Insets(20));

        Scene login_scene = new Scene(VboxMain, 400, 806);
        
        stage.setScene(login_scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}