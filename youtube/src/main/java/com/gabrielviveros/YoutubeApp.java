package com.gabrielviveros;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class YoutubeApp extends Application{
    
@Override
public void start(Stage stage) throws Exception {

    //TITULO:
    Label lblTitulo = new Label("Youtube");
    lblTitulo.setStyle("-fx-text-fill:rgb(255, 255, 255);" + "-fx-padding: 50 100 30 100;");

    
    //NOMBRE
    TextField txtNombreCompleto = new TextField();
    txtNombreCompleto.setPromptText(" 👤 Full Name ");
    txtNombreCompleto.setStyle("-fx-background-radius: 5px");

    //EMAIL
    TextField txtEmail = new TextField();
    txtEmail.setPromptText("✉️ Enter Your Email");
    txtEmail.setStyle("-fx-background-radius: 5px");

    //PASSWORD
    TextField txtPassWord = new TextField();
    txtPassWord.setPromptText("🔒 Password");
    txtPassWord.setStyle("-fx-background-radius: 5px");

    //RESETPASSWORD
    TextField txtResePassWord = new TextField();
    txtPassWord.setPromptText("🔒 Reset Password");
    txtResePassWord.setStyle("-fx-background-radious: 5px");


    VBox vbox = new VBox(10, lblTitulo, txtNombreCompleto, txtEmail, txtPassWord, txtResePassWord);
    vbox.setStyle("-fx-background-color:rgb(0, 0, 0)");
    vbox.setPadding(new Insets(20));

    Scene escena = new Scene(vbox, 320, 640);

    stage.setScene(escena);
    stage.show();
}

public static void main(String[] args) {
    launch(args);
}
}
