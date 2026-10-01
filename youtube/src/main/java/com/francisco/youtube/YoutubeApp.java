package com.francisco.youtube;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class YoutubeApp extends Application{
    @Override
    public void start(Stage stage) throws Exception {
         // TODO Auto-generated method stub
         Label titulo = new Label("YouTube");
         TextField txtNumero = new TextField("Número telefonico: ");
         TextField txtClave = new TextField("Clave: ");
         TextField txtConfirmacionClave = new TextField("Cofirmación de clave: ");
         TextField codVerificador = new TextField("Please enter the verification code: ");
         Button boton = new Button("Register Now");
         VBox vbox = new VBox(6, titulo,txtNumero,txtClave,txtConfirmacionClave,codVerificador, boton);
         
         Scene escena = new Scene(vbox, 320, 640);
         stage.setScene(escena);
         stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
