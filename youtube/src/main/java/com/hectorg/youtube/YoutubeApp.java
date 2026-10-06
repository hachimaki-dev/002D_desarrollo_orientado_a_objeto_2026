package com.hectorg.youtube;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class YoutubeApp extends Application {

    @Override
    public void start(Stage stage) {

        Rectangle fondoLogo = new Rectangle(48, 32);
        fondoLogo.setArcWidth(10);
        fondoLogo.setArcHeight(10);
        fondoLogo.setFill(Color.web("#FF0000"));

        Polygon play = new Polygon(
                -5.0, -9.0,
                -5.0, 9.0,
                10.0, 0.0
        );
        play.setFill(Color.WHITE);

        StackPane icono = new StackPane(fondoLogo, play);

        Label youtube = new Label("YouTube");
        youtube.setTextFill(Color.WHITE);
        youtube.setStyle(
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        HBox logo = new HBox(9, icono, youtube);
        logo.setAlignment(Pos.CENTER);
        logo.setPadding(new javafx.geometry.Insets(5, 0, 10, 0));

        TextField nombre = new TextField();
        nombre.setPromptText("Full Name");

        TextField email = new TextField();
        email.setPromptText("Enter Your Email");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button reset = new Button("⌑  Reset Password");

        Button login = new Button("Log in");

        String estiloCampo =
                "-fx-background-color: #080808;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #777;" +
                "-fx-border-color: #333;" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10 12;";

        nombre.setStyle(estiloCampo);
        email.setStyle(estiloCampo);
        password.setStyle(estiloCampo);

        nombre.setPrefSize(340, 43);
        email.setPrefSize(340, 43);
        password.setPrefSize(340, 43);

        reset.setPrefSize(340, 43);
        reset.setStyle(
                "-fx-background-color: #080808;" +
                "-fx-text-fill: #777;" +
                "-fx-border-color: #333;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;" +
                "-fx-font-size: 13px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-padding: 10 12;"
        );

        login.setPrefSize(340, 48);
        login.setStyle(
                "-fx-background-color: #FF0000;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 7;" +
                "-fx-cursor: hand;"
        );

        login.setOnMouseEntered(e ->
                login.setStyle(
                        "-fx-background-color: #CC0000;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 19px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 7;" +
                        "-fx-cursor: hand;"
                )
        );

        login.setOnMouseExited(e ->
                login.setStyle(
                        "-fx-background-color: #FF0000;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 19px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 7;" +
                        "-fx-cursor: hand;"
                )
        );

        Label google = new Label("G");
        google.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 23px;" +
                "-fx-font-weight: bold;"
        );

        Label apple = new Label("●");
        apple.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 23px;"
        );

        HBox redes = new HBox(28, google, apple);
        redes.setAlignment(Pos.CENTER);
        redes.setPadding(new javafx.geometry.Insets(12, 0, 8, 0));

        Label textoCuenta = new Label("Don't have an account?");
        textoCuenta.setTextFill(Color.web("#666"));
        textoCuenta.setStyle("-fx-font-size: 11px;");

        Label signup = new Label("Sign up");
        signup.setTextFill(Color.WHITE);
        signup.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        HBox registro = new HBox(3, textoCuenta, signup);
        registro.setAlignment(Pos.CENTER);

        VBox contenido = new VBox(
                13,
                logo,
                nombre,
                email,
                password,
                reset,
                login,
                redes,
                registro
        );

        contenido.setAlignment(Pos.CENTER);
        contenido.setPrefWidth(380);

        VBox principal = new VBox(contenido);
        principal.setAlignment(Pos.CENTER);
        principal.setStyle("-fx-background-color: #000000;");

        Scene escena = new Scene(principal, 520, 640);

        stage.setTitle("YouTube");
        stage.setScene(escena);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}