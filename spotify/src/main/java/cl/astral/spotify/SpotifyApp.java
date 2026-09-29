package cl.astral.spotify; /* Define el contenedor */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SpotifyApp extends Application { /* (public class SpotifyApp) Declara la clase pública llamada en este caso SpotifyApp | 
    • (extends Apliccation) Hereda las características de Application. Esto le dice a Java que este programa no es una simple consola de texto, sino una aplicación de ventana gráfica.
. */

    @Override /* Indica que estás modificando el método obligatorio start que viene de Application. */
    public void start(Stage stage) throws Exception { /*Es el punto de partida real de la interfaz. (throws exception) Es una medida de seguridad por si ocurre algún error inesperado al iniciar la ventana.) */

        Label lblTituloCancion = new Label("Titulo cancion: "); /*para ingresar texto nmas, strings y eso */

        TextField txtTituloCancion = new TextField();
        txtTituloCancion.setPromptText("Ingrese el titulo de la cancion"); /* para campos donde ingresar texto, el codigo abajito es para que aiga ese textito transparente dentro de estos */

        Button btnGuardarCancion = new Button("registrar cancion"); /*boton para interactuar */

        Label lblNombreArtista = new Label("Nombre artista: ");

        TextField txtNombreArtista = new TextField();
        txtNombreArtista.setPromptText("Ingrese el nombre del artista");

        VBox contenido = new VBox(10, lblTituloCancion, txtTituloCancion, lblNombreArtista, txtNombreArtista, btnGuardarCancion); /*  Crea una VB (Vertical Box). Todo lo que se meta aquí se apilará uno abajo del otro en orden. 
        sirve mucho pq (Scene) no permite mas de una propiedad asi que es buena forma de compactar todo y obvio necesario para poder tener todo dentro de la ventana */

        contenido.setPadding(new Insets(20)); /* esto le añade un margen u espaciado, evitando que los textos y botones queden pegaditos al borde de la ventana */

        Scene ventana = new Scene(contenido, 500, 300 ); /* crea la ventana (el contenido dentro de la ventana pues) y contenido le asigna el panel vbox o hbox que se acaba de crear */


        stage.setScene(ventana); /* monta la escena (ventana) sobre el escenario principal (stage). */
        stage.show(); /* hace que la ventana sea visible en la pantalla del usuario, sin esta línea, el programa correría en segundo plano pero no se vería nada.
 */
    
    }

    public static void main(String[] args) { /* main es el punto de entrada que busca Java al ejecutar el archivo. */
        launch(args); /* es un método interno de JavaFX que se encarga de preparar todo el sistema gráfico tras bambalinas y, finalmente, llama de forma automática al método start que explicamos arriba.
 */
    }
    
}

