package com.daniel.kiosco.view;

import com.daniel.kiosco.controller.ProductoController;
import com.daniel.kiosco.model.Producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ProductoView {
    
    private ProductoController controller;
    private TableView<Producto> tablaProductos;

    private TextField txtNombre;    
    private TextField txtCategoria;
    private TextField txtPrecio;
    private TextField txtStock;
    private Label lblEstado;

    private int idSeleccionado = -1;

    public ProductoView(){
        this.controller = new ProductoController();
    }

    public Scene crearEscena(){
        VBox panelFormulario = crearPanelFormulario();
        VBox panelTabla = crearPanelTabla();

        HBox.setHgrow(panelTabla,Priority.ALWAYS);

        HBox raiz = new HBox(20,panelFormulario,panelTabla);
        raiz.setPadding(new Insets(20));

        cargarDatosEnTabla();
        return new Scene(raiz,920,500);
    }

    private VBox crearPanelFormulario(){
        Label lblTitulo = new Label("Kiosco");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        txtNombre = new TextField();
        txtNombre.setPromptText("");

        txtCategoria = new TextField();
        txtCategoria.setPromptText("");

        txtPrecio = new TextField();
        txtPrecio.setPromptText("");

        txtStock = new TextField();
        txtStock.setPromptText("");

        Button btnGuardar = new Button("Guardar");
        Button btnActualizar = new Button("Actualizar");
        Button btnElminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.setOnAction(e -> accionGuardar());
        btnActualizar.setOnAction(e -> accionActualizar());
        btnElminar.setOnAction(e -> accionEliminar());
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        HBox filaBotones = new HBox(8,btnGuardar,btnActualizar,btnElminar,btnLimpiar);

        lblEstado = new Label("Listo. Conectado a Oracle");

        VBox panel = new VBox(10,lblTitulo,
            new Label("Nombre"), txtNombre,
            new Label("Categoria"), txtCategoria,
            new Label("Precio"), txtPrecio,
            new Label("Stock"), txtStock,
            filaBotones,
            lblEstado
        );
        panel.setPrefWidth(320);
        return panel;
    }
    private VBox crearPanelTabla(){
        Label lblSubtitulo = new Label("Registros en Orable Database");
        lblSubtitulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        tablaProductos = new TableView<>();

        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(60);

        TableColumn<Producto, String> colNombre = new TableColumn<>("NOMBRE");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, String> colCategoria = new TableColumn<>("CATEGORIA");
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        TableColumn<Producto,Integer> colPrecio = new TableColumn<>("PRECIO");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        TableColumn<Producto,Integer> colStock = new TableColumn<>("STOCK");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tablaProductos.getColumns().add(colId);
        tablaProductos.getColumns().add(colNombre);
        tablaProductos.getColumns().add(colCategoria);
        tablaProductos.getColumns().add(colPrecio);
        tablaProductos.getColumns().add(colStock);


        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null){
                idSeleccionado = seleccionado.getId();
                txtNombre.setText(seleccionado.getNombre());
                txtCategoria.setText(seleccionado.getCategoria());
                txtPrecio.setText(Integer.toString(seleccionado.getPrecio()));
                txtStock.setText(Integer.toString(seleccionado.getStock()));
                lblEstado.setText("Editando producto ID #" + idSeleccionado);
            }
        });

        VBox.setVgrow(tablaProductos, Priority.ALWAYS);
        return new VBox(10,lblSubtitulo,tablaProductos);
    }

    private void accionGuardar(){
        boolean exito = controller.registrarProducto(
            txtNombre.getText(),
            txtCategoria.getText(),
            Integer.parseInt(txtPrecio.getText()),
            Integer.parseInt(txtStock.getText())
        );

        if (exito){
            lblEstado.setText("Producto guardado correctamente en Oracle.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("Error: Completa todos los campos o cambia el nombre");
        }
    }

    private void accionActualizar(){
        if (idSeleccionado == -1){
            lblEstado.setText(("Selecciona primero un usuario de la tabla."));
            return;
        }

        boolean exito = controller.actualizarProducto(
            idSeleccionado,
            txtNombre.getText(),
            txtCategoria.getText(),
            Integer.parseInt(txtPrecio.getText()),
            Integer.parseInt(txtStock.getText())
        );

        if (exito){
            lblEstado.setText("Producto ID #" + idSeleccionado + " actualizado.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("Error al actualizar los datos.");
        }
    }

    private void accionEliminar(){
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero un producto en la tabla.");
            return;
        } 

        boolean exito = controller.eliminarProducto(idSeleccionado);

        if (exito) {
            lblEstado.setText("Producto eliminado de Oracle.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("No se pudo eliminar el usuario.");
        }
    }

    private void cargarDatosEnTabla(){
        ObservableList<Producto> datos = FXCollections.observableArrayList(controller.obtenerProductos());
        tablaProductos.setItems(datos);
    }

    private void limpiarFormulario(){
        idSeleccionado = -1;
        txtNombre.clear();
        txtCategoria.clear();
        txtPrecio.clear();
        txtStock.clear();
        tablaProductos.getSelectionModel().clearSelection();
    }
}
