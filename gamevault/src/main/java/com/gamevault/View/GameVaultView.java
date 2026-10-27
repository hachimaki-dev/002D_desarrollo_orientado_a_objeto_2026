package com.gamevault.View;

import com.gamevault.Controller.InventarioController;
import com.gamevault.Controller.UsuarioController;
import com.gamevault.Model.Videojuego;
import com.gamevault.Model.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameVaultView {
    public Scene gameVault(){
        
        ///////////////// CREANDO PANEL SUPERIOR /////////////////
        Label lbl_user_rut = new Label("Rut: ");

        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");

        Button btn_user_search = new Button("Buscar ♥");

        HBox hbox_user_search = new HBox(10, lbl_user_rut, txf_user_rut, btn_user_search);

        Label lbl_user_data_rut =  new Label("Rut: ________");
        Label lbl_user_data_nombre =  new Label("Nombre: ________");
        Label lbl_user_data_email =  new Label("Email: ________");
        Label lbl_user_data_nivelGamer =  new Label("Nivel Gamer: ________");
        Label lbl_no_existe = new Label("");

        VBox vbox_user_data = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_nivelGamer, lbl_no_existe);


        VBox main_user = new VBox(10,hbox_user_search, vbox_user_data);

        ///////////////// CREANDO PANEL INFERIOR /////////////////
        TableView<Videojuego> tableView_inventario = new TableView<>();

        TableColumn<Videojuego, String> columnaTipo = new TableColumn<>("Tipo");
        TableColumn<Videojuego, String> columnaTitulo = new TableColumn<>("Titulo");
        TableColumn<Videojuego, String> columnaPlataforma = new TableColumn<>("Plataforma");

        columnaTipo.setCellValueFactory(
            new PropertyValueFactory<>("tipo")
        );

        columnaTitulo.setCellValueFactory(
            new PropertyValueFactory<>("titulo")
        );

        columnaPlataforma.setCellValueFactory(
            new PropertyValueFactory<>("plataforma")
        );

        InventarioController i = new InventarioController();

        ObservableList<Videojuego> videojuegos =
            FXCollections.observableArrayList(
                i.obtenerInventario()
            );

        tableView_inventario.setItems(videojuegos);

        tableView_inventario.getColumns().add(columnaTipo);
        tableView_inventario.getColumns().add(columnaTitulo);
        tableView_inventario.getColumns().add(columnaPlataforma);
        
        VBox main_inventario = new VBox(10, tableView_inventario);

        ///////////////// CREANDO PANEL MAIN /////////////////
        VBox main = new VBox(10, main_user, main_inventario);

        Scene home_scene = new Scene(main, 720, 480);


        btn_user_search.setOnAction(e -> {
            UsuarioController userController = new UsuarioController();
            Usuario usuarioBuscado = userController.buscarPorRut(txf_user_rut.getText());

            if (usuarioBuscado != null)
            {
                lbl_user_data_rut.setText("Rut: " + usuarioBuscado.getRut());
                lbl_user_data_nombre.setText("Nombre: " + usuarioBuscado.getNombre());
                lbl_user_data_email.setText("Email: " + usuarioBuscado.getEmail());
                lbl_user_data_nivelGamer.setText("Nivel Gamer: " + usuarioBuscado.getNivelGamer());
                lbl_no_existe.setText("");
            }
            else
            {
                lbl_user_data_rut.setText("Rut: ________");
                lbl_user_data_nombre.setText("Nombre: ________");
                lbl_user_data_email.setText("Email: ________" );
                lbl_user_data_nivelGamer.setText("Nivel Gamer: ________");
                lbl_no_existe.setText("El usuario de rut: " + txf_user_rut.getText() + " no existe");
            }
            
        });


        return home_scene;

    }
}
