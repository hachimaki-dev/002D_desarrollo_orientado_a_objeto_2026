package com.camilo_diaz.youtube;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class YoutubeApp extends Application{
    
    @Override 
    public void start(Stage stage) throws Exception
    {
        Label lblTitulo = new Label("Youtube");
        lblTitulo.setFont(new Font("Arial", 20));
        
        TextField txtNombreCompleto = crearTextField("Full Name");
        TextField txtEmail = crearTextField("Enter Your Email");
        TextField txtPassword = crearTextField("Password");
        TextField txtResetPassword = crearTextField("Reset Password");

        Button btnLogin = new Button("Log in");
        btnLogin.setStyle("-fx-background-color:rgb(238, 19, 19);" + "-fx-text-fill:rgb(255, 255, 255);" + "-fx-background-radius: 120px");

        VBox vBox = new VBox(5, lblTitulo, txtNombreCompleto, txtEmail, txtPassword, txtResetPassword, btnLogin);
        vBox.setStyle("-fx-background-color: #000000");
        vBox.setAlignment(Pos.BASELINE_CENTER);

        Scene scene = new Scene(vBox, 340, 640);

        stage.setScene(scene);
        stage.show();
    }

    static TextField crearTextField(String text)
    {
        TextField txtField = new TextField();

        txtField.setPromptText(text);
        txtField.setStyle("-fx-text-box-border: red;" + "-fx-background-color:rgb(49, 49, 49);" + "-fx-text-fill:rgb(204, 204, 204);" + "-fx-background-radius: 8px");
        txtField.setMaxWidth(300); 

        return txtField;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
