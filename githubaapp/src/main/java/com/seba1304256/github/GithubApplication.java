package com.seba1304256.github;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        

        
        Label iblIniciarsesion =new Label("Sign in to Github");
        iblIniciarsesion.setStyle("-fx-font-size: 20px;"+ "-fx-font-weight: bold;");
        VBox banner = new VBox(imgview_logo_gh, iblIniciarsesion);
        banner.setAlignment(Pos.TOP_CENTER);


        Label lbl_user_name = new Label("Username or email addres");
        TextField txf_user_name = new TextField();
        Label lbl_password = new Label("password");
        TextField txf_password = new TextField();
        passwordField txf_password =new passwordField();
        
        Button btn_sign_in = new Button("Sign in");
        btn_sign_in.setMaxWidth(Double.MAX_VALUE);
        btn_sign_in.setStyle("-fx-background-color:#0a8940;"+ "-fx-text-fill:#fff;"+ "-fx-font-weight: bold;");
        btn_sign_in.setOnAction(e -> {System.err.println("Machucao");});
        VBox formulario_login = new VBox(10,lbl_user_name,txf_user_name,lbl_password,txf_password,btn_sign_in);
        VBox interfaz = new VBox(10,banner,formulario_login);
        interfaz.setPadding(new Insets(20));
        Scene logiScene = new Scene(interfaz, 375,667);
        stage.setScene(logiScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
