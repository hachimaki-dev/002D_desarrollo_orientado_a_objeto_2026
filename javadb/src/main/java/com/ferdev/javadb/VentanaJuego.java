package com.ferdev.javadb;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaJuego extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tienda");
        TextField txfNombre = new TextField();
        txfNombre.setPromptText("Ingrese el nombre");
        TextField txfPrecio = new TextField();
        txfPrecio.setPromptText("Ingrese el precio");
        TextField txfConsola = new TextField();
        txfConsola.setPromptText("Ingrese la consola");
        TableView<Juego> tabla = new TableView<>();
        TableColumn<Juego , Integer> colId = new TableColumn<>("Id");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Juego , String> colNombre = new TableColumn<>("Juego");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Juego , BigDecimal> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        TableColumn<Juego , String> colConsola = new TableColumn<>("Consola");
        colConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
        tabla.getColumns().addAll(colId , colNombre , colPrecio , colConsola);
        cargarTabla(tabla);

        tabla.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                txfNombre.setText(seleccionado.getNombre());
                txfPrecio.setText(seleccionado.getPrecio().toPlainString());
                txfConsola.setText(seleccionado.getConsola());
            }
    
        });

        Button btnInsertar = new Button("Ingresar");
        btnInsertar.setOnAction(e -> {
            String nombre = txfNombre.getText();
            String consola = txfConsola.getText();
            try {
                BigDecimal precio = new BigDecimal(txfPrecio.getText());
                Main.insertarSql(nombre, precio, consola);
                cargarTabla(tabla);
            } catch (NumberFormatException ex) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setContentText("El precio debe ser un numero" + ex.getMessage());
                alerta.showAndWait();

            } catch(SQLException ex1) {
                Alert alertaSql = new Alert(Alert.AlertType.WARNING);
                alertaSql.setContentText("No se pudo conectar a la base de datos" + ex1.getMessage());
                alertaSql.showAndWait();

            }
        });
        Button btnActualizar = new Button("Actualizar");
        btnActualizar.setOnAction(e -> {
            cargarTabla(tabla);        
        });

        Button btnEliminar = new Button("Borrar");
        btnEliminar.setOnAction(e -> {
            Juego seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                Alert alertaJuego = new Alert(Alert.AlertType.WARNING);
                alertaJuego.setContentText("Seleccione un juego primero");
                alertaJuego.showAndWait();
                return;

            }
            try {
                Main.eliminarSql(seleccionado.getId());
                cargarTabla(tabla);
            } catch (SQLException error) {
                System.err.println("Error en la base de datos");
                
            }

        });
        Button btnModificar = new Button("Modificar seleccionado");
        btnModificar.setOnAction(e -> {
            Juego seleccionado = tabla.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                Alert alertaJuego = new Alert(Alert.AlertType.WARNING);
                alertaJuego.setContentText("Seleccione un juego primero");
                alertaJuego.showAndWait();
                return;
            }
            try {
                BigDecimal precio = new BigDecimal(txfPrecio.getText());
                Main.actualizarSql(txfNombre.getText(), precio, txfConsola.getText(), seleccionado.getId());
                cargarTabla(tabla);
            } catch (NumberFormatException ex) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setContentText("El precio debe ser un numero " + ex.getMessage());
                alerta.showAndWait();
            } catch (SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setContentText("Error en la base de datos: " + ex.getMessage());
                alerta.showAndWait();
            }
        });
        VBox contenedor = new VBox(tabla , txfNombre , txfPrecio , txfConsola , btnInsertar , btnActualizar , btnEliminar , btnModificar);
        Scene primaryScene = new Scene(contenedor , 720 , 400);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        
    }
    public static void cargarTabla(TableView<Juego> tabla){
        try {
            ArrayList<Juego> lista = Main.listarSql();
            tabla.setItems(FXCollections.observableArrayList(lista));
        } catch (SQLException e) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setContentText("No se pudo listar");
            alerta.showAndWait();
        }
    }
}
