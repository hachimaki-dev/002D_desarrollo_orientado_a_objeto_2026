package com.gamevault.view;

import com.gamevault.controller.InventarioController;
import com.gamevault.controller.UsuarioController;
import com.gamevault.model.Usuario;
import com.gamevault.model.Videojuego;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameVaultView {

    private UsuarioController usuarioController;
    private InventarioController inventarioController;

    public GameVaultView() {
        this.usuarioController = new UsuarioController();
        this.inventarioController = new InventarioController();
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("GAMEVAULT — GESTIÓN DE INVENTARIO Y SOCIOS GAMER");

        VBox mainLayout = new VBox(15);
        mainLayout.setPadding(new Insets(15));
        mainLayout.setStyle("-fx-background-color: #1e1e2e;");

        // Header Title
        Label titleLabel = new Label("GAMEVAULT — GESTIÓN DE INVENTARIO Y SOCIOS GAMER");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #f5e0dc;");
        
        // -------------------------------------------------------------------
        // PANEL SUPERIOR: CONSULTA DE SOCIO GAMER
        // -------------------------------------------------------------------
        VBox topPanel = new VBox(10);
        topPanel.setStyle("-fx-border-color: #cba6f7; -fx-border-radius: 5; -fx-padding: 10; -fx-background-color: #313244;");

        Label searchTitle = new Label("[ PANEL SUPERIOR: CONSULTA DE SOCIO GAMER ]");
        searchTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #cba6f7;");

        HBox searchBox = new HBox(10);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        Label lblRutInput = new Label("Ingrese RUT:");
        lblRutInput.setStyle("-fx-text-fill: #cdd6f4;");
        
        TextField txtRut = new TextField();
        txtRut.setPromptText("19.876.543-2");
        
        Button btnBuscar = new Button("Buscar Socio");
        btnBuscar.setStyle("-fx-background-color: #89b4fa; -fx-text-fill: #11111b; -fx-font-weight: bold;");

        searchBox.getChildren().addAll(lblRutInput, txtRut, btnBuscar);

        // Informacion del Socio
        Label lblInfo1 = new Label("RUT: --  |  Socio: --  |  Nivel: --");
        lblInfo1.setStyle("-fx-text-fill: #a6adc8; -fx-font-size: 13px;");
        Label lblInfo2 = new Label("Email: --");
        lblInfo2.setStyle("-fx-text-fill: #a6adc8; -fx-font-size: 13px;");

        btnBuscar.setOnAction(e -> {
            String rutIngresado = txtRut.getText();
            Usuario user = usuarioController.buscarPorRut(rutIngresado);
            if (user != null) {
                lblInfo1.setText("RUT: " + user.getRut() + "  |  Socio: " + user.getNombre() + "  |  Nivel: " + user.getNivelGamer());
                lblInfo2.setText("Email: " + user.getEmail());
            } else {
                lblInfo1.setText("Usuario no encontrado.");
                lblInfo2.setText("");
            }
        });

        topPanel.getChildren().addAll(searchTitle, searchBox, lblInfo1, lblInfo2);

        // -------------------------------------------------------------------
        // PANEL INFERIOR: INVENTARIO DE VIDEOJUEGOS EN TABLEVIEW
        // -------------------------------------------------------------------
        VBox bottomPanel = new VBox(10);
        bottomPanel.setStyle("-fx-border-color: #89b4fa; -fx-border-radius: 5; -fx-padding: 10; -fx-background-color: #313244;");

        Label tableTitle = new Label("[ PANEL INFERIOR: INVENTARIO DE VIDEOJUEGOS EN TABLEVIEW ]");
        tableTitle.setStyle("-fx-font-weight: bold; -fx-text-fill: #89b4fa;");

        TableView<Videojuego> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Videojuego, String> colFormato = new TableColumn<>("Formato");
        colFormato.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));

        TableColumn<Videojuego, String> colTitulo = new TableColumn<>("Título");
        colTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));

        TableColumn<Videojuego, String> colConsola = new TableColumn<>("Consola");
        colConsola.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getConsola()));

        TableColumn<Videojuego, String> colDetalle = new TableColumn<>("Detalle");
        colDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDetalle()));

        TableColumn<Videojuego, ImageView> colPortada = new TableColumn<>("Portada");
        colPortada.setCellValueFactory(cellData -> {
            try {
                String rutaImagen = cellData.getValue().getImagen();
                Image img = new Image(getClass().getResourceAsStream("/" + rutaImagen));
                ImageView imgView = new ImageView(img);
                imgView.setFitWidth(40);
                imgView.setFitHeight(40);
                imgView.setPreserveRatio(true);
                return new javafx.beans.property.SimpleObjectProperty<>(imgView);
            } catch (Exception ex) {
                return new javafx.beans.property.SimpleObjectProperty<>(new ImageView());
            }
        });

        table.getColumns().addAll(colFormato, colTitulo, colConsola, colDetalle, colPortada);

        ObservableList<Videojuego> data = FXCollections.observableArrayList(inventarioController.getInventario());
        table.setItems(data);

        bottomPanel.getChildren().addAll(tableTitle, table);

        mainLayout.getChildren().addAll(titleLabel, topPanel, bottomPanel);

        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}