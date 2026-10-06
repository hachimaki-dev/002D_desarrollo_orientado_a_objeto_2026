package com.figueroawa.github;

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
    static String hardcodedUsername = new String("admin");
    static String hardcodedPassword = new String("megustaelpanconmiel94");

    @Override
    public void start(Stage stage) throws Exception {

        Scene sceneLogin = createSceneLogIn(stage);

        stage.setScene(sceneLogin);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Scene createSceneLogIn(Stage stage) {
        // Banner
        Image imgGithubLogo = new Image(
                "https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");
        ImageView imgviewGithubLogo = new ImageView(imgGithubLogo);
        imgviewGithubLogo.setFitHeight(60);
        imgviewGithubLogo.setFitWidth(60);
        Label lblSignIn = new Label("Sign in to GitHub");
        lblSignIn.setStyle("-fx-font-size:20px;" + "-fx-font-weight: bold;");

        VBox vboxSignInBanner = new VBox(imgviewGithubLogo, lblSignIn);
        vboxSignInBanner.setAlignment(Pos.TOP_CENTER);

        // Form
        Label lblUsernameOrEmail = new Label("Username or email address");
        lblUsernameOrEmail.setStyle("-fx-font-weight: bold;");
        TextField txtUsernameOrEmail = new TextField();
        txtUsernameOrEmail.setMinHeight(36);

        Label lblPassword = new Label("Password");
        lblPassword.setStyle("-fx-font-weight: bold;");
        PasswordField pswPassword = new PasswordField();
        pswPassword.setMinHeight(36);

        Button btnSignIn = new Button("Sign In");
        btnSignIn.setMinHeight(36);
        btnSignIn.setMaxWidth(Double.MAX_VALUE);
        btnSignIn.setStyle("-fx-background-color: #0a8940;" + "-fx-text-fill: #ffffff;" + "-fx-font-weight: bold");
        btnSignIn.setOnAction(e -> {
            String strUsernameOrEmail = new String(txtUsernameOrEmail.getText());
            String strPassword= new String(pswPassword.getText());
            System.out.println("Username: " + strUsernameOrEmail);
            System.out.println("Password: " + strPassword);
            if (strUsernameOrEmail.equals(hardcodedUsername) && strPassword.equals(hardcodedPassword)) {
                Scene sceneSuccessfulLogin = createSceneSuccessfulLogin();
                stage.setScene(sceneSuccessfulLogin);
            } else {
                System.out.println("nope");
            }
        });

        VBox vboxSignInForm = new VBox(10, lblUsernameOrEmail, txtUsernameOrEmail, lblPassword, pswPassword, btnSignIn);

        VBox vboxSignIn = new VBox(10, vboxSignInBanner, vboxSignInForm);
        vboxSignIn.setPadding(new Insets(30));
        vboxSignIn.setStyle("-fx-background-color: #ffffff");

        Scene sceneLogIn = new Scene(vboxSignIn, 375, 667);

        return sceneLogIn;

    }

    public static Scene createSceneSuccessfulLogin() {
        Label lblSuccessfulLogin = new Label("Login exitoso!");

        Scene sceneSuccessfulLogin = new Scene(lblSuccessfulLogin);

        return sceneSuccessfulLogin;
    }
}
