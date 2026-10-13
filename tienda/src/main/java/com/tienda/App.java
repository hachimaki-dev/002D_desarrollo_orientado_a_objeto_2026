package com.tienda;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    private TableView<Producto> tabla;
    private final ProductoAccesoBaseDatos dao = new ProductoAccesoBaseDatos();

    @Override
    public void start(Stage stage) {
        tabla = crearTabla();
        recargarTabla();

        BorderPane raiz = new BorderPane(tabla);
        raiz.setBottom(crearFormulario());

        stage.setTitle("Mi primera tiendita");
        stage.setScene(new Scene(raiz, 700, 400));
        stage.show();
    }

    private TableView<Producto> crearTabla() {
        TableView<Producto> tabla = new TableView<>();

        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tabla.getColumns().add(colId);
        tabla.getColumns().add(colNombre);
        tabla.getColumns().add(colPrecio);
        tabla.getColumns().add(colStock);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        return tabla;
    }

    private HBox crearFormulario() {
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");

        TextField txtStock = new TextField();
        txtStock.setPromptText("Stock");

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(e -> {
            try {
                String nombre = txtNombre.getText().trim();
                if (nombre.isEmpty()) {
                    avisarError(Alert.AlertType.WARNING, "NOMBRE NO PUEDE ESTAR VACIO");
                    return;
                }
                double precio = Double.parseDouble(txtPrecio.getText().trim().replace(',', '.'));
                int stock = Integer.parseInt(txtStock.getText().trim());

                dao.insertar(new Producto(0, nombre, precio, stock));
                recargarTabla();

                txtNombre.clear();
                txtPrecio.clear();
                txtStock.clear();
            } catch (NumberFormatException ex) {
                avisarError(Alert.AlertType.ERROR, "PRECIO Y STOCK DEBEN SER ENTEROS");
            } catch (SQLException ex) {
                avisarError(Alert.AlertType.ERROR, "ERROR EN LA BASE DE DATOS " + ex.getMessage());
            }
        });

        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setOnAction(e -> eliminarSeleccionado());

        HBox barra = new HBox(10, txtNombre, txtPrecio, txtStock, btnGuardar, btnEliminar);
        barra.setPadding(new Insets(10));
        return barra;
    }

    private void eliminarSeleccionado() {
        Producto seleccionado = tabla.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            avisarError(Alert.AlertType.WARNING, "Selecciona un producto primero.");
            return;
        }
        try {
            dao.eliminar(seleccionado);
            recargarTabla();
        } catch (SQLException ex) {
            avisarError(Alert.AlertType.ERROR, "NO SE PUDO ELIMINAR " + ex.getMessage());
        }
    }

    private void recargarTabla() {
        try {
            tabla.setItems(FXCollections.observableArrayList(dao.listar()));
        } catch (SQLException ex) {
            avisarError(Alert.AlertType.ERROR, "NO SE PUDO CARGAR LA TABLA CORRECTAMENTE " + ex.getMessage());
        }
    }

    private void avisarError(Alert.AlertType tipo, String mensaje) {
        Alert alerta = new Alert(tipo, mensaje);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}