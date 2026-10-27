package com.gamevault.view;

import com.gamevault.model.JuegoDigital;
import com.gamevault.model.JuegoFisico;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PantallaPrincipal {

    

    public Scene pantallaPrincipal(){
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
        Scene pantallaPrincipal = new Scene(main,720,480);
        return pantallaPrincipal;


    }
}
