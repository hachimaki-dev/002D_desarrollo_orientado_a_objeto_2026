package com;

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

public class GitHubApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Image logo_github = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");
        
        ImageView imgView_log_gh = new ImageView(logo_github);
        imgView_log_gh.setFitHeight(60);
        imgView_log_gh.setFitWidth(60);
        

        Label lblInicioSession = new Label("Sign in to GitHub");
        lblInicioSession.setStyle("-fx-font-size: 20px;" + "-fx-font-weight: bold;");
        VBox banner = new VBox(imgView_log_gh, lblInicioSession);

        banner.setAlignment(Pos.TOP_CENTER);

        Label lbl_user_name = new Label("Username or email address");
        
        TextField txf_user_name = new TextField();
        txf_user_name.setPromptText("usuario");

        Label lbl_password = new Label("Password");

        PasswordField pstxf_password = new PasswordField();
        pstxf_password.setPromptText("contraseña");

        Button btn_sign_in = new Button("Sign in");
        btn_sign_in.setMaxWidth(Double.MAX_VALUE);
        btn_sign_in.setStyle("-fx-background-color:#1f883d;" + "-fx-text-fill: #fff;" + "-fx-font-weight: bold;");

        btn_sign_in.setOnAction( e -> {
            String usuario = txf_user_name.getText();
            String contraseña = pstxf_password.getText();
            String adminname = "ADMIN";
            int adminpassword = 67;
            System.out.println("tamo aca");
            if (usuario.equals(adminname) && contraseña.equals(adminpassword)) {
                System.out.println("ventana epica");
            }
            System.out.println("no entro xdd");
            System.out.println("Usuario: " + usuario);
            System.out.println("Contraseña: " + contraseña);
        } );

        VBox formuladio_login = new VBox(10, lbl_user_name, txf_user_name, lbl_password, pstxf_password, btn_sign_in);


        VBox interfaz = new VBox(banner, formuladio_login);
        interfaz.setPadding(new Insets(20));
        Scene login_scene = new Scene(interfaz, 375, 667);
        
        stage.setScene(login_scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
//el usuario es admin y la password es me gusta el pan con miel, si al ingresar el campo de texto son estos se cambia de escena