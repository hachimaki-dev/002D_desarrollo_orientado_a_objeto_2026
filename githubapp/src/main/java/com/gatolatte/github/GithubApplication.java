package com.gatolatte.github;

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

    //IMAGEN
    Image logo_gh = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");
    ImageView imgView_logo_gh = new ImageView(logo_gh);
    imgView_logo_gh.setFitWidth(60);
    imgView_logo_gh.setFitHeight(60);

    //TITULO
    Label lblInicioSesion = new Label("Sign in to GitHub");
    lblInicioSesion.setStyle("-fx-front-size: 20px;" + "-fx-font-weight: bold;");

    VBox banner = new VBox(imgView_logo_gh, lblInicioSesion);
    banner.setAlignment(Pos.CENTER);

    //USUARIO
    Label lbl_user_name = new Label("Username or email addres");
    TextField txf_user_name = new TextField();

    //CONTRASEÑA
    Label lbl_password = new Label("Password");
    PasswordField txf_password = new PasswordField();

    //BOTON
    Button btn_sign_in = new Button("Sign in");
    btn_sign_in.setMaxWidth(Double.MAX_VALUE);
    btn_sign_in.setStyle("-fx-background-color:rgba(36, 167, 19, 0.86);" + "-fx-text-fill: #fff;" + "-fx-front-weight: bold;");

    btn_sign_in.setOnAction( e -> {
        System.out.println("miau");
    } );


    //FORMULARIO
    VBox formulario_login = new VBox(10, lbl_user_name, txf_user_name, lbl_password, txf_password, btn_sign_in);

    VBox interfaz = new VBox(5, banner, formulario_login);

    interfaz.setPadding(new Insets(20));

    Scene login_scene = new Scene(interfaz, 375, 667);
    
    stage.setScene(login_scene);

    stage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }


}