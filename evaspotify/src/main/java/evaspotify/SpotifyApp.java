package evaspotify;

import java.applet.Applet;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
//TITULO
        Label lblTituloCancion = new Label("Titulo canción: ");
        lblTituloCancion.setStyle("-fx-background-color:hsl(187, 90.70%, 79.00%)" + "-fx-background-radious: 20px" + "-fx-padding: 20, 5" + "-fx-text-fill:rgb(240, 29, 29)");

        TextField txtTituloCancion = new TextField();
        txtTituloCancion.setPromptText("Ingrese el título de la canción...");
        txtTituloCancion.setStyle("-fx-background-radius: 20px");
//ARTISTA
        Label lblArtista = new Label("Artista: ");

        TextField txtArtista = new TextField();
        txtArtista.setPromptText("Ingrese el nombre del artista...");
        txtArtista.setStyle("-fx-background-radius: 20px");
//BOTON
        Button btnGuardarCancion = new Button("Registrar canción");

        btnGuardarCancion.setStyle("-fx-background-color:rgb(252, 177, 242);" + "-fx-text-fill:rgb(175, 230, 252)" + "-fx-background-radius: 20px");
        VBox registro_usuario = new VBox(10, lblTituloCancion, txtTituloCancion, lblArtista, txtArtista, btnGuardarCancion);

        registro_usuario.setPadding(new Insets(20));

        Scene ventana = new Scene(registro_usuario, 600, 400);


        stage.setScene(ventana);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
