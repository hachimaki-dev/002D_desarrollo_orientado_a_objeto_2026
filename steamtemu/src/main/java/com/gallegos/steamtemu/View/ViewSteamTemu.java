package com.gallegos.steamtemu.View;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.gallegos.steamtemu.Model.Usuario;
import com.gallegos.steamtemu.Model.Dao.UsuarioDAO;
import com.gallegos.steamtemu.Model.Dao.UsuarioDaoJson;


public class ViewSteamTemu {

    public Scene steamtemu(){
        Label lbl_Encabezado = new Label("SteamTemu | Gestionador de juegos y Socios Gamer");
        lbl_Encabezado.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-font-weight: bold;");

        Label lbl_separador = new Label("├───────────────────────────────────────────────┤");
        lbl_separador.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-font-weight: bold;");

        HBox Encabezado = new HBox(5, lbl_Encabezado);

        Label lbl_informacion_socio = new Label("Consulta Gamer Socio");
        lbl_informacion_socio.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-font-weight: bold;");
        
        Label lbl_rut_ingresar = new Label("Ingrese RUT:");
        lbl_rut_ingresar.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-font-weight: bold;");
        
        VBox Informacion_Socio = new VBox(10, lbl_informacion_socio, lbl_rut_ingresar);

        TextField rut_ingresado = new TextField();
        rut_ingresado.setPromptText("Ej: 11.111.111.1");
        rut_ingresado.setStyle("-fx-font-size: 14px;");

        Button btn_buscar_rut = new Button("Buscar Socio");
        btn_buscar_rut.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px; -fx-font-weight: bold; -fx-background-color: #0d0f18; -fx-border-color: #1f1f20;");

        Label lbl_resultado_nombre = new Label("Socio: -");
        lbl_resultado_nombre.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px;" + " -fx-font-weight: bold;");
        
        Label lbl_resultado_email = new Label("Email: -");
        lbl_resultado_email.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px;" + " -fx-font-weight: bold;");

        Label lbl_resultado_nivel = new Label("Nivel: -");
        lbl_resultado_nivel.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15px;" + " -fx-font-weight: bold;");

        btn_buscar_rut.setOnAction(e -> {
            UsuarioDAO usuarioDao = new UsuarioDaoJson();
            String rutBuscado = rut_ingresado.getText();

            Usuario encontrado = usuarioDao.buscarPorRut(rutBuscado);
            
            if (encontrado != null) {
                lbl_resultado_nombre.setText("Socio: " + encontrado.getNombre());
                lbl_resultado_nombre.setStyle("-fx-text-fill: #01ff12;" + " -fx-font-weight: bold;" + "-fx-font-size: 15px;");
                lbl_resultado_email.setText("Email: " + encontrado.getEmail());
                lbl_resultado_nivel.setText("Nivel: " + encontrado.getNivelGamer());
            } else {
                lbl_resultado_nombre.setText("Socio no encontrado");
                lbl_resultado_nombre.setStyle("-fx-text-fill: #f30109;" + " -fx-font-weight: bold;" + "-fx-font-size: 15px;");
                lbl_resultado_email.setText("Email: -");
                lbl_resultado_nivel.setText("Nivel: -");
            }
        });

        HBox informacion_media = new HBox(10, rut_ingresado, btn_buscar_rut);

        VBox ViewMain = new VBox(10);
        ViewMain.setPadding(new Insets(15));
        ViewMain.setStyle("-fx-background-color: #0d0f18; -fx-font-family: 'Courier New', monospace;");

        ViewMain.getChildren().addAll(
            Encabezado, 
            lbl_separador, 
            Informacion_Socio, 
            informacion_media, 
            lbl_resultado_nombre, 
            lbl_resultado_email, 
            lbl_resultado_nivel
        );

        Scene Steam_Temu = new Scene(ViewMain, 720, 480);

        return Steam_Temu;
    }
}
