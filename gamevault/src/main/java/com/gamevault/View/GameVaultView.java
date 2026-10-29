package com.gamevault.View;

import com.gamevault.controller.InventarioController;
import com.gamevault.controller.UsuarioController;
import com.gamevault.model.JuegoDigital;
import com.gamevault.model.JuegoFisico;
import com.gamevault.model.Usuario;
import com.gamevault.model.Videojuego;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameVaultView extends  Application{
    private UsuarioController usuarioController;
    private InventarioController inventarioController;
    @Override
    public void start(Stage stage) throws Exception {
        usuarioController = new UsuarioController();
        inventarioController = new InventarioController();
        Label lb_titulo_interfaz = new Label("GAMEVAULT — GESTIÓN DE INVENTARIO Y SOCIOS GAMER");

        HBox collecion_titulo_interfaz = new HBox(lb_titulo_interfaz);

                
        Label lbl_titulo_panel_superior = new Label("[PANEL SUPERIOR: CONSULTA DE SOCIO GAMER] ");

        VBox colleccion_lbl_superior = new VBox(lbl_titulo_panel_superior);


        TextField txt_rut = new TextField("Ingrese rut: ");
        Button btn_rut = new Button("Buscar socio");

        HBox panel_superior = new HBox( txt_rut, btn_rut);

        Label lbl_rut_usuario = new Label("RUT: _________________ ");

        Label lbl_socio = new Label("Socio: _________________");

        Label lbl_nivel_usuario = new Label("Nivel: _______________");

        Label lbl_Email_usuario = new Label("Email: ______________");

        VBox datos_usuario = new VBox(lbl_rut_usuario,lbl_socio,lbl_nivel_usuario,lbl_Email_usuario);

        

        

        btn_rut.setOnAction(e -> {

         Usuario socio = usuarioController.buscarPorRut(txt_rut.getText());

         if(socio != null){

            lbl_rut_usuario.setText("RUT: "+ socio.getRut());
            lbl_socio.setText("Socio: "+ socio.getNombre());
            lbl_Email_usuario.setText("Email: "+ socio.getEmail());
            lbl_nivel_usuario.setText("Nivel: "+ socio.getNivelGamer());

        
         }else{

            lbl_socio.setText("Socio: No encontrado");
         }


            
        });

        Label lbl_titulo_panel_inferior = new Label("PANEL INFERIOR: INVENTARIO DE VIDEOJUEGOS TABLEVIEW");
        
        TableView<Videojuego> tablaInventario = new TableView<>();
        TableColumn<Videojuego,String> ColumnaTitulo = new TableColumn<>("Titulo");
        ColumnaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        ColumnaTitulo.setPrefWidth(200);

        TableColumn<Videojuego,String> ColumnaConsola = new TableColumn<>("Consola");
        ColumnaConsola.setCellValueFactory(new PropertyValueFactory<>("plataforma")); 
        ColumnaConsola.setPrefWidth(100);

        TableColumn<Videojuego,String> ColumnaFormato = new TableColumn<>("Formato");
        ColumnaFormato.setCellValueFactory(cellData -> {

            if(cellData.getValue() instanceof JuegoFisico) {

                return new SimpleStringProperty("Fisico");


            }
            if(cellData.getValue() instanceof JuegoDigital){

                return new SimpleStringProperty("Digital");
            }
            return new SimpleStringProperty("Desconocido");
                
        });

        TableColumn<Videojuego,String> ColumnaDetalle = new TableColumn<>("Detalle");
        ColumnaDetalle.setCellValueFactory(cellData ->{
           if (cellData.getValue() instanceof JuegoFisico){
            JuegoFisico juegofisico = (JuegoFisico) cellData.getValue();
            return new SimpleStringProperty(juegofisico.getStockTienda() + "unid.");
            }
           if (cellData.getValue() instanceof JuegoDigital){

            JuegoDigital juegodigital = (JuegoDigital) cellData.getValue();
            return new SimpleStringProperty(juegodigital.getTamanoGB() + " GB");
            }
            return new SimpleStringProperty("");

        });

        TableColumn<Videojuego,String> ColumnaPortada = new TableColumn<>("Portada");
        ColumnaPortada.setCellValueFactory(new PropertyValueFactory<>("portada"));

        tablaInventario.getColumns().addAll(ColumnaFormato,ColumnaTitulo,ColumnaConsola,ColumnaDetalle,ColumnaPortada);
        
        tablaInventario.setItems(FXCollections.observableArrayList(inventarioController.obtenerInventario()));
        VBox panel_inferior = new VBox(10,lbl_titulo_panel_inferior,tablaInventario);
        
        VBox interfaz = new VBox(collecion_titulo_interfaz,colleccion_lbl_superior, panel_superior,datos_usuario,panel_inferior);
        Scene menu = new Scene(interfaz, 550, 600); 
        stage.setScene(menu);
        stage.show();

        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
