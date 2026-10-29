package com.gamevault.view;

import com.gamevault.controller.InventarioController;
import com.gamevault.controller.UsuarioController;
import com.gamevault.dao.UsuarioDAOJson;
import com.gamevault.model.Usuario;
import com.gamevault.model.Videojuego;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameVaultView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Videojuego> tabla = new TableView<>();
        TableColumn<Videojuego, String> colTitulo = new TableColumn<>("Titulo");
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tabla.getColumns().add(colTitulo);
        InventarioController invCtrl = new InventarioController();
        tabla.setItems(FXCollections.observableArrayList(invCtrl.obtenerInventario()));
        TableColumn<Videojuego , String> colPlataforma = new TableColumn<>("Plataforma");
        colPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        tabla.getColumns().add(colPlataforma);
        
        VBox contenedor = new VBox();
        Scene scenePrincipal = new Scene(contenedor);
        TextField rutField = new TextField();
        Label lblBase = new Label(); 
        contenedor.getChildren().add(rutField);
        contenedor.getChildren().add(lblBase);
        Button btn_BuscarRut = new Button("Buscar socio");
        contenedor.getChildren().add(btn_BuscarRut);
        contenedor.getChildren().add(tabla);
        btn_BuscarRut.setOnAction(e -> {
            UsuarioController u = new UsuarioController(new UsuarioDAOJson());
            Usuario socio = u.buscarPorRut(rutField.getText());
            if (socio == null) {
                lblBase.setText("Socio no encontrado");
                
            }else{
                lblBase.setText(socio.getNombre() + "|" + socio.getNivelGamer());
            }
        });
        primaryStage.setScene(scenePrincipal);
        primaryStage.show();

        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
