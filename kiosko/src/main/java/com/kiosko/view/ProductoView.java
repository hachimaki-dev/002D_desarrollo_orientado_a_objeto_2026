package com.kiosko.view;

import com.kiosko.model.Producto;
import com.kiosko.controller.ProductoController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ProductoView {
    private ProductoController controller;
    private TableView<Producto> tablaUsuarios;

    private TextField txtNombre;
    private TextField txtCategoria;
    private TextField txtPrecio;
    private TextField txtStock;
    
    private Label lblEstado;

    // Guarda el ID de la fila seleccionada en la tabla (-1 indica que no hay selección)
    private int idSeleccionado = -1;

    public ProductoView() {
        this.controller = new ProductoController();
    }
  
    public Scene crearEscena(){
        
        VBox panelFormulario = crearPanelFormulario();
        VBox panelTabla = crearPanelTabla();

        // Permite que el panel de la tabla se estire ocupando todo el espacio derecho
        HBox.setHgrow(panelTabla, Priority.ALWAYS);

        HBox raiz = new HBox(20, panelFormulario, panelTabla);
        raiz.setPadding(new Insets(20));

        // Apenas se construye la ventana, cargamos las filas desde Oracle
        cargarDatosEnTabla();

        


      /*  btn_user_search.setOnAction(e -> {
          //  UserController userController = new UserController();
          //  userController.test();
        });*/


        return new Scene(raiz, 920, 500);
    }    

    private VBox crearPanelFormulario() {
        Label lblTitulo = new Label("Gestión de Cuentas");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        txtNombre = new TextField();
        txtNombre.setPromptText("Ej: carlitos_dev");

        txtCategoria = new TextField();
        txtCategoria.setPromptText("Ej: carlitos@duoc.cl");

        txtPrecio = new PasswordField();
        txtPrecio.setPromptText("Contraseña");

        cmbRol = new ComboBox<>();
        cmbRol.getItems().addAll("ESTUDIANTE", "DOCENTE", "ADMIN");
        cmbRol.setPromptText("Seleccione un rol");
        cmbRol.setMaxWidth(Double.MAX_VALUE);

        Button btnGuardar = new Button("Guardar");
        Button btnActualizar = new Button("Actualizar");
        Button btnEliminar = new Button("Eliminar");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.setOnAction(e -> accionGuardar());
        btnActualizar.setOnAction(e -> accionActualizar());
        btnEliminar.setOnAction(e -> accionEliminar());
        btnLimpiar.setOnAction(e -> limpiarFormulario());

        HBox filaBotones = new HBox(8, btnGuardar, btnActualizar, btnEliminar, btnLimpiar);

        lblEstado = new Label("Listo. Conectado a Oracle.");

        VBox panel = new VBox(10,
                lblTitulo,
                new Label("Username:"), txtNombre,
                new Label("Correo:"), txtCategoria,
                new Label("Contraseña:"), txtPrecio,
                new Label("Rol:"), cmbRol,
                filaBotones,
                lblEstado
        );
        panel.setPrefWidth(320);
        return panel;
    }

    private VBox crearPanelTabla() {
        Label lblSubtitulo = new Label("Registros en Oracle Database");
        lblSubtitulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        tablaUsuarios = new TableView<>();

        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(60);

        TableColumn<Producto, String> colUser = new TableColumn<>("Username");
        colUser.setCellValueFactory(new PropertyValueFactory<>("username"));
        colUser.setPrefWidth(140);

        TableColumn<Producto, String> colCorreo = new TableColumn<>("Correo");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colCorreo.setPrefWidth(200);

        TableColumn<Producto, String> colRol = new TableColumn<>("Rol");
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        colRol.setPrefWidth(120);

        tablaUsuarios.getColumns().add(colId);
        tablaUsuarios.getColumns().add(colUser);
        tablaUsuarios.getColumns().add(colCorreo);
        tablaUsuarios.getColumns().add(colRol);

        // Escuchador: cuando el producto hace clic en una fila, copiamos sus datos al formulario
        tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                idSeleccionado = seleccionado.getId();
                txtNombre.setText(seleccionado.getNombre());
                txtCategoria.setText(seleccionado.getCategoria());
                txtPrecio.setText(String.valueOf(seleccionado.getPrecio()));
                txtStock.setText(String.valueOf(seleccionado.getStock()));
                lblEstado.setText("Editando producto ID #" + idSeleccionado);
            }
        });

        VBox.setVgrow(tablaUsuarios, Priority.ALWAYS);
        return new VBox(10, lblSubtitulo, tablaUsuarios);
    }

    private void accionGuardar() {
        boolean exito = controller.registrarProducto(
                txtNombre.getText(),
                txtCategoria.getText(),
                txtPrecio.getText(),
                cmbRol.getValue()
        );

        if (exito) {
            lblEstado.setText("Producto guardado correctamente en Oracle.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("Error: Completa todos los campos o cambia el username.");
        }
    }

    private void accionActualizar() {
        if (idSeleccionado == -1) {
            lblEstado.setText("Selecciona primero un producto en la tabla.");
            return;
        }

        boolean exito = controller.actualizarProducto(
                idSeleccionado,
                txtNombre.getText(),
                txtCategoria.getText(),
                txtPrecio.getText(),
                cmbRol.getValue()
        );

        if (exito) {
            lblEstado.setText("Producto ID #" + idSeleccionado + " actualizado.");
            limpiarFormulario();
            cargarDatosEnTabla();
        } else {
            lblEstado.setText("Error al actualizar los datos.");
        }
    }

    private void accionEliminar() {
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
            lblEstado.setText("No se pudo eliminar el producto.");
        }
    }

    private void cargarDatosEnTabla() {
        ObservableList<Producto> datos = FXCollections.observableArrayList(
                controller.obtenerProductos()
        );
        tablaUsuarios.setItems(datos);
    }

    private void limpiarFormulario() {
        idSeleccionado = -1;
        txtNombre.clear();
        txtCategoria.clear();
        txtPrecio.clear();
        cmbRol.setValue(null);
        tablaUsuarios.getSelectionModel().clearSelection();
    }

}
