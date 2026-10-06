package com.andrewfarias452.github;

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
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GithubApplication extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    Image logo_gh = new Image("https://images.seeklogo.com/logo-png/30/2/github-logo-png_seeklogo-304612.png");
    ImageView imgView_logo_gh = new ImageView(logo_gh);
    imgView_logo_gh.setFitWidth(60);
    imgView_logo_gh.setFitHeight(60);
    
    Label lblInicioSesion = new Label("Sign in to GitHub");
    lblInicioSesion.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #1F2328;");

    VBox banner = new VBox(15, imgView_logo_gh, lblInicioSesion);
    banner.setAlignment(Pos.TOP_CENTER);
    banner.setPadding(new Insets(20, 0, 20, 0));

    String estiloCamposBase = 
        "-fx-background-color: transparent;" + 
        "-fx-text-fill: #1F2328;" + 
        "-fx-font-size: 14px;" +
        "-fx-padding: 6 12 6 12;";

    Label lbl_user_name = new Label("Username or email address");
    lbl_user_name.setStyle("-fx-font-size: 14px; -fx-text-fill: #1F2328; -fx-font-weight: 500;");
    
    TextField txf_user_name = new TextField();
    txf_user_name.setPromptText("Enter your username");
    txf_user_name.setStyle(
        "-fx-background-color: #F6F8FA;" + 
        "-fx-border-color: #D0D7DE;" + 
        "-fx-border-radius: 6px;" + 
        "-fx-background-radius: 6px;" + 
        "-fx-padding: 6 12 6 12;" + 
        "-fx-font-size: 14px;"
    );

    Label lbl_password = new Label("Password");
    lbl_password.setStyle("-fx-font-size: 14px; -fx-text-fill: #1F2328; -fx-font-weight: 500;");
    
    PasswordField txf_password = new PasswordField(); 
    txf_password.setStyle(estiloCamposBase);
    
    TextField txf_password_visible = new TextField(); 
    txf_password_visible.setVisible(false); 
    txf_password_visible.setStyle(estiloCamposBase);
    
    StackPane contenedorPassword = new StackPane(txf_password, txf_password_visible);
    HBox.setHgrow(contenedorPassword, Priority.ALWAYS); 
    
    Button btn_mostrar = new Button("👁"); 
    btn_mostrar.setStyle(
        "-fx-background-color: transparent;" + 
        "-fx-text-fill: #57606A;" + 
        "-fx-font-size: 16px;" + 
        "-fx-cursor: hand;" + 
        "-fx-padding: 0 10 0 10;"
    );

    HBox caja_falsa_password = new HBox(contenedorPassword, btn_mostrar);
    caja_falsa_password.setAlignment(Pos.CENTER_LEFT);
    caja_falsa_password.setStyle(
        "-fx-background-color: #F6F8FA;" + 
        "-fx-border-color: #D0D7DE;" +     
        "-fx-border-radius: 6px;" + 
        "-fx-background-radius: 6px;"
    );

    btn_mostrar.setOnAction(e -> {
        if (txf_password.isVisible()) {
            txf_password_visible.setText(txf_password.getText());
            txf_password_visible.setVisible(true);
            txf_password.setVisible(false);
            btn_mostrar.setText("🙈"); 
        } else {
            txf_password.setText(txf_password_visible.getText());
            txf_password.setVisible(true);
            txf_password_visible.setVisible(false);
            btn_mostrar.setText("👁"); 
        }
    });

    Label lbl_error = new Label();
    lbl_error.setStyle("-fx-text-fill: #cf222e; -fx-font-size: 13px; -fx-font-weight: bold;");
    lbl_error.setVisible(false);

    Button btn_sign_in = new Button("Sign in");
    btn_sign_in.setMaxWidth(Double.MAX_VALUE);
    btn_sign_in.setStyle(
        "-fx-background-color: #1F883D;" + 
        "-fx-text-fill: #FFFFFF;" + 
        "-fx-font-weight: bold;" + 
        "-fx-font-size: 14px;" + 
        "-fx-border-radius: 6px;" + 
        "-fx-background-radius: 6px;" + 
        "-fx-padding: 8 16 8 16;" + 
        "-fx-cursor: hand;"
    );

    btn_sign_in.setOnAction(e -> {
        String usuarioIngresado = txf_user_name.getText().trim();
        String passwordFinal = txf_password.isVisible() ? txf_password.getText() : txf_password_visible.getText();

        if (usuarioIngresado.equals("admin") && passwordFinal.equals("megustaelpanconmiel")) {
            lbl_error.setVisible(false);
            
            Label lbl_bienvenido = new Label("¡Bienvenido, " + usuarioIngresado + "!");
            lbl_bienvenido.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #1F2328;");
            
            VBox root_bienvenida = new VBox(lbl_bienvenido);
            root_bienvenida.setAlignment(Pos.CENTER);
            root_bienvenida.setPadding(new Insets(25));
            root_bienvenida.setStyle("-fx-background-color: #FFFFFF;");
            
            Scene escena_bienvenida = new Scene(root_bienvenida, 375, 667);
            stage.setScene(escena_bienvenida);
        } else {
            lbl_error.setText("Usuario y contraseña incorrecto");
            lbl_error.setVisible(true);
        }
    });

    VBox formulario_login = new VBox(8, lbl_user_name, txf_user_name, lbl_password, caja_falsa_password, lbl_error, btn_sign_in);
    formulario_login.setSpacing(12);
    VBox.setMargin(btn_sign_in, new Insets(10, 0, 0, 0)); 

    VBox interfaz = new VBox(15, banner, formulario_login);
    interfaz.setPadding(new Insets(25));
    interfaz.setStyle("-fx-background-color: #FFFFFF;"); 

    Scene login_scene = new Scene(interfaz, 375, 667);
    stage.setTitle("Sign in to GitHub");
    stage.setScene(login_scene);
    stage.setResizable(false); 
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
