package com.gamevault.view;
import com.gamevault.controller.InventarioController;
import com.gamevault.controller.UsuarioController;
import com.gamevault.model.JuegoDigital;
import com.gamevault.model.JuegoFisico;
import com.gamevault.model.Usuario;
import com.gamevault.model.VideoJuego;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameVaultView extends Application{
    private UsuarioController usuarioController = new UsuarioController();
    private InventarioController inventarioController = new InventarioController();
    @Override
    public void start(Stage primaryStage){
        Label title = new Label("GameVault - GESTIÓN Y SOCIOS");
        TextField txtRut = new TextField();
        txtRut.setPromptText("Ej: 12.345.678-9 o 12345678");
        Button btnBuscar = new Button("Buscar Socio");
        HBox searchBox = new HBox(10, txtRut, btnBuscar);
        Label lblRut = new Label("Rut: ");
        Label lblNombre = new Label("Usuario: ");
        Label lblNivel = new Label("Nivel Gamer: ");
        Label lblEmail = new Label("Email: ");
        HBox userBox1 = new HBox(20, lblRut, lblNombre);
        HBox userBox2 = new HBox(20, lblNivel, lblEmail);
        VBox userInfoBox = new VBox(5, searchBox, userBox1, userBox2);
        btnBuscar.setOnAction(e ->{
            String input = txtRut.getText();
            Usuario u = usuarioController.buscarPorRut(input);
            if (u != null){
                lblRut.setText("Rut: " + u.getRut());
                lblNombre.setText("Usuario: " + u.getNombre());
                lblNivel.setText("Nivel Gamer: " + u.getNivelGamer());
                lblEmail.setText("Email: " + u.getEmail());
            } else{
                lblRut.setText("Rut: No encontrado");
                lblNombre.setText("Usuario: -");
                lblNivel.setText("Nivel Gamer: -");
                lblEmail.setText("Email: -");
            }
        });

        TableView<VideoJuego> tabla = new TableView<>();
        TableColumn<VideoJuego, String> colTitulo = new TableColumn<>("Título");
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        TableColumn<VideoJuego, String> colPlataforma = new TableColumn<>("Plataforma");
        colPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        TableColumn<VideoJuego, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(cellData -> 
            new SimpleStringProperty(cellData.getValue() instanceof JuegoFisico ? "Físico" : "Digital")
        );
        TableColumn<VideoJuego, String> colDetalle = new TableColumn<>("Detalles Específicos");
        colDetalle.setCellValueFactory(cellData ->{
            VideoJuego juego = cellData.getValue();
            if (juego instanceof JuegoFisico){
                JuegoFisico fisico = (JuegoFisico) juego;
                return new SimpleStringProperty("Stock: " + fisico.getStockTienda() + " u. | Peso: " + fisico.getPesoGramos() + "g");
            } else if (juego instanceof JuegoDigital){
                JuegoDigital digital = (JuegoDigital) juego;
                return new SimpleStringProperty("Tamaño: " + digital.getTamanoGB() + " GB | Cód: " + digital.getCodigoActivacion());
            }
            return new SimpleStringProperty("-");
        });
        tabla.getColumns().addAll(colTitulo, colPlataforma, colTipo, colDetalle);
        tabla.setItems(FXCollections.observableArrayList(inventarioController.obtenerInventario()));

        VBox root = new VBox(15, title, userInfoBox, tabla);
        root.setPadding(new Insets(15));

        primaryStage.setScene(new Scene(root, 650, 480));
        primaryStage.setTitle("GameVault");
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}