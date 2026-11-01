package com.hachimakidev.techstore.view;

import com.hachimakidev.techstore.controller.DispositivoController;
import com.hachimakidev.techstore.model.Dispositivo;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

// imports: DispositivoController, Dispositivo, TableView, TableColumn,
// PropertyValueFactory, FXCollections, Label, Button, VBox/HBox, Insets

public class CatalogoView {

    private DispositivoController controller = new DispositivoController();

    public VBox catalogo() {
        // 1. TableView<Dispositivo> tabla
        TableView<Dispositivo> tabla = new TableView<>();
        TableColumn<Dispositivo , Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabla.getColumns().add(colId);
        TableColumn<Dispositivo , String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tabla.getColumns().add(colTipo);
        TableColumn<Dispositivo , String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tabla.getColumns().add(colMarca);
        TableColumn<Dispositivo , String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        tabla.getColumns().add(colModelo);
        TableColumn<Dispositivo , Integer> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tabla.getColumns().add(colPrecio);
        TableColumn<Dispositivo , String> colEspecificacion = new TableColumn<>("Especificacion");
        colEspecificacion.setCellValueFactory(new PropertyValueFactory<>("especificacion"));
        tabla.getColumns().add(colEspecificacion);
        TableColumn<Dispositivo , Boolean> colDisponible = new TableColumn<>("Disponible");
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));
        tabla.getColumns().add(colDisponible);
        tabla.setItems(FXCollections.observableArrayList(controller.obtenerDispositivos()));
        ComboBox<String> cmbTipo = new ComboBox<>();
        cmbTipo.getItems().addAll("Notebook" , "Smartphone");
        TextField txtMarca = new TextField();
        txtMarca.setPromptText("Agregar Marca");
        TextField txtModelo = new TextField();
        txtModelo.setPromptText("Agregar Modelo");
        TextField txtPrecio = new TextField();
        txtPrecio.setPromptText("Agregar Precio");
        TextField txtRamGb = new TextField();
        txtRamGb.setPromptText("Agregar Ram");
        TextField txtProcesador = new TextField();
        txtProcesador.setPromptText("Agregar Procesador");
        TextField txtAlmacenamientoGb = new TextField();
        txtAlmacenamientoGb.setPromptText("Agregar Almacenamiento en GB");
        TextField txtCamaraMp = new TextField();
        txtCamaraMp.setPromptText("Agregar Megapixeles de Camara");
        VBox CamposNotebook = new VBox(5 , txtRamGb , txtProcesador);
        VBox CamposSmartphone = new VBox(5 , txtAlmacenamientoGb , txtCamaraMp);
        CamposNotebook.setVisible(false);
        CamposNotebook.setManaged(false);
        CamposSmartphone.setVisible(false);
        CamposSmartphone.setManaged(false);
        cmbTipo.setOnAction(e -> {
                String tipo = cmbTipo.getValue();
                CamposNotebook.setVisible(tipo.equals("Notebook"));
                CamposNotebook.setManaged(tipo.equals("Notebook"));
                CamposSmartphone.setVisible(tipo.equals("Smartphone"));
                CamposSmartphone.setManaged(tipo.equals("Smartphone"));
        });
        return new VBox(10 , tabla , cmbTipo , txtMarca , txtModelo , txtPrecio , CamposNotebook , CamposSmartphone);
}

}