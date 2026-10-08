package com.github;

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
import javafx.stage.Stage;

public class githubApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image logo_gb = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");

        ImageView imgView_logo = new ImageView(logo_gb);
        imgView_logo.setFitHeight(60);
        imgView_logo.setFitWidth(60);

        Label lblInicioSesion = new Label("Sign in to GitHub");
        lblInicioSesion.setStyle("-fx-font-size:20px;" + "-fx-font-weight: bold;");

        VBox banner = new VBox(imgView_logo , lblInicioSesion);
        banner.setAlignment(Pos.TOP_CENTER);
        
        Label lbl_user_name = new Label("Username or email address");

        TextField txf_user_name = new TextField();
        Label lbl_password = new Label("Password");
        PasswordField txf_password = new PasswordField();

        Button btn_sign_in = new Button("Sign in");
        btn_sign_in.setMaxWidth(Double.MAX_VALUE);
        btn_sign_in.setStyle("-fx-background-color: #0a8940;" + "-fx-text-fill: #fff;" + "-fx-font-weight:bold");
        btn_sign_in.setOnAction( e -> {
            stage.setScene(showHomeScreen());
        });

        VBox formulario_login = new VBox(10 ,lbl_user_name , txf_user_name , lbl_password , txf_password , btn_sign_in);

        VBox interfaz = new VBox(5 ,banner , formulario_login);
        interfaz.setPadding(new Insets(20));
        interfaz.setStyle("-fx-background-color: #fff");

        Scene login_scene = new Scene(interfaz , 375 , 667);

        stage.setScene(login_scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static Scene showHomeScreen(){
        Button btn_burger_menu = new Button("|||");
        btn_burger_menu.setStyle("-fx-background-color : #f6f8fa;" + "-fx-border-color : #e2e6eb;" + "-fx-border-radius: 4px");
        Image img_logo_gh = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");
        ImageView imageView_logo_gh = new ImageView(img_logo_gh);
        imageView_logo_gh.setFitWidth(32);
        imageView_logo_gh.setFitHeight(32);
        Label lbldashboard = new Label("Dashboard");
        lbldashboard.setStyle("-fx-font-weight: bold;");

        HBox home_box_navbar = new HBox(5 ,btn_burger_menu , imageView_logo_gh , lbldashboard);
        home_box_navbar.setAlignment(Pos.CENTER_LEFT);
        home_box_navbar.setStyle("-fx-background-color:f6f8fa;");
        home_box_navbar.setPadding(new Insets(12));

        VBox homeBox = new VBox(home_box_navbar);
        homeBox.setStyle("-fx-background-color:white;");

        Scene homesScene = new Scene(homeBox , 375 , 667);
        return homesScene;

    }
}
