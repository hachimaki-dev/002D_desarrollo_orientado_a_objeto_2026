package com.tienda;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        TableView<Producto> tabla = new TableView<>();

        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tabla.getColumns().addAll(colId, colNombre, colPrecio, colStock);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);

        try {
            tabla.setItems(FXCollections.observableArrayList(new ProductoAccesoBaseDatos().listar()));
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Error de base de datos: " + e.getMessage()).show();
        }

        BorderPane raiz = new BorderPane(tabla);
        stage.setTitle("Mi Tienda");
        stage.setScene(new Scene(raiz, 600, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}