package com.nicoleasd.github;

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

        Image logo_gh = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoNijwKjzxw3R_RVp7KbuN5isRug1vp5YJwRgefppmabymVMAkDq9xHV8&s=10");

        ImageView imgView_logo_gh = new ImageView(logo_gh);
        imgView_logo_gh.setFitHeight(60);
        imgView_logo_gh.setFitWidth(60);



        Label iblInicioSesion = new Label(" Sign in to GitHub");

        iblInicioSesion.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");


        VBox banner = new VBox(imgView_logo_gh, iblInicioSesion); //CONTENEDORRRRRRRRRRRRRRRRR

        banner.setAlignment(Pos.TOP_CENTER);

        Label lbl_user_name = new Label("Username or email address");
        TextField txf_user_name = new TextField();


        Label lbl_password = new Label("Password");
        TextField txf_password = new TextField();


        Button btn_sign_in = new Button("Sign in");
        btn_sign_in.setMaxWidth(Double.MAX_VALUE);
        btn_sign_in.setStyle("-fx-background-color: #1f883d;" + "-fx-text-fill: #255;");

        btn_sign_in.setOnAction( e -> {System.out.println("Wena wena");});


        VBox formulario_login = new VBox(5, lbl_user_name, txf_user_name, lbl_password, txf_password, btn_sign_in); //CONTENEDORRRRRRRRRRRRRRRRR

        VBox interfaz = new VBox(10, banner, formulario_login); //CONTENEDORRRRRRRRRRRRRRRR
        interfaz.setPadding(new Insets(20));

        Scene login_scene = new Scene(interfaz, 375, 667);

        stage.setScene(login_scene);

        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}