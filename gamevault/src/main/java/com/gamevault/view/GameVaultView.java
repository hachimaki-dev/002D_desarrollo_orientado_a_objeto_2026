package com.gamevault.view;

import com.gamevault.controller.InventarioController;
import com.gamevault.model.JuegoDigital;
import com.gamevault.model.JuegoFisico;
import com.gamevault.model.Videojuego;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameVaultView {
    public class VideojuegoView {

        private TableView<Videojuego> tablaInventario;
        private InventarioController inventarioController;

        public VideojuegoView(){
            inventarioController = new InventarioController();
            configurarTabla();
            cargarTabla();
        }

        private void configurarTabla(){
            tablaInventario = new TableView<>();
            TableColumn<Videojuego, String> colTipo = new TableColumn<>("Tipo");
            colTipo.setCellValueFactory(data -> {
                Videojuego videojuego = data.getValue();
                if (videojuego instanceof JuegoFisico){
                    return new SimpleStringProperty("Físico");
                } else if (videojuego instanceof JuegoDigital){
                    return new SimpleStringProperty("Digital");
                }
                return new SimpleStringProperty("Desconocido");
            });
            TableColumn<Videojuego, String> colTitulo = new TableColumn<>("Título");
            colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            TableColumn<Videojuego, String> colPlataforma = new TableColumn<>("Plataforma");
            colPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
            TableColumn<Videojuego, String> colPortada = new TableColumn<>("Portada");
            colPortada.setCellValueFactory(new PropertyValueFactory<>("portada"));
            colPortada.setCellFactory(col -> new TableCell<Videojuego,String>(){
                private final ImageView imageView = new ImageView();

                @Override 
                protected void updateItem(String urlImage, boolean empty){
                    super.updateItem(urlImage, empty);
                    if (empty || urlImage == null || urlImage.isEmpty()) {
                        setGraphic(null);
                    } else {
                        try {
                            Image imagen = new Image(urlImage, 50,50,true,true,true);
                            imageView.setImage(imagen);
                            setGraphic(imageView);
                        } catch (Exception e) {
                            setGraphic(null);
                        }
                    }
                }
            });
            TableColumn<Videojuego, String> colStockTienda = new TableColumn<>("Stock");
            colStockTienda.setCellValueFactory(data -> {
                if (data.getValue() instanceof JuegoFisico) {
                    JuegoFisico juegoFisico = (JuegoFisico) data.getValue();
                    return new SimpleStringProperty(String.valueOf(juegoFisico.getStockTienda()));
                }
                return new SimpleStringProperty("-");
            });
            TableColumn<Videojuego, String> colPesoGramo = new TableColumn<>("Peso (g)");
            colPesoGramo.setCellValueFactory(new PropertyValueFactory<>("pesoGramo"));
            TableColumn<Videojuego, String> colTamañoGB = new TableColumn<>("Tamaño (GB)");
            colTamañoGB.setCellValueFactory(new PropertyValueFactory<>("tamañoGB"));
            TableColumn<Videojuego, String> colCodigoActivacion = new TableColumn<>("Código Activación");
            colCodigoActivacion.setCellValueFactory(new PropertyValueFactory<>("codigoActivacion"));
        }
        private void cargarTabla(){
            ObservableList<Videojuego> inventario = FXCollections.observableArrayList(
                InventarioController.getInventario()
            );   
            tablaInventario.setItems(inventario);
        }
        public VBox getVistaInventario(){
            return new VBox(tablaInventario)
        }
    }
    

    public Scene GameVaultView(){
        Label lbl_panel_superior = new Label("CONSULTA DE SOCIO GAMER");
        
        Label lbl_rut = new Label("Ingrese RUT: ");
        TextField txfrutusuario = new TextField();
        txfrutusuario.setPromptText("ej: 11.111.111-1");
        Button btn_buscar_usuario = new Button("Buscar socio");
        btn_buscar_usuario.setOnAction(e -> {
            
        });
        HBox hbox_informacion_ingresada = new HBox(lbl_rut,txfrutusuario,btn_buscar_usuario);

        Label lbl_usuario_informacion_rut = new Label("Rut:");
        Label lbl_usuario_informacion_socio = new Label("Socio:");
        Label lbl_usuario_informacion_nivel = new Label("Nivel:");
        Label lbl_usuario_informacion_email= new Label("Email:");
        HBox hbox_informacion_usuario = new HBox(50,lbl_usuario_informacion_rut,lbl_usuario_informacion_socio,lbl_usuario_informacion_nivel,lbl_usuario_informacion_email);

        Label lbl_panel_inferior = new Label("INVENTARIO DE VIDEOJUEGOS EN TABLEVIEW");

        




        VBox main = new VBox(lbl_panel_superior,hbox_informacion_ingresada,hbox_informacion_usuario);
        Scene GameVaultView = new Scene(main,720,480);
        return GameVaultView;


    }
}
