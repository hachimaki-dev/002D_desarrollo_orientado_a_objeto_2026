package com.gallegos155.gamebault.View;


import com.gallegos155.gamebault.Model.User;
import com.gallegos155.gamebault.Model.UserManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScene {

    public Scene steamtemu(){
        // Encabezado hecho por Vicente //
        Label lbl_encabezado = new Label("Steam Temu - Juegos Baratos");        
        HBox encabezado = new HBox(5, lbl_encabezado);


        //Infromacion hecho por gallegos//
        Label lbl_informacion_user = new Label("Consulta de Socio Gamer");
        TextField txf_rut_user = new TextField("Ingrese Rut: ");
        Button btn_BuscarSocio = new Button("Buscar Socio.");

        btn_BuscarSocio.setOnAction(e -> {
            UserManager nose = new UserManager();
            String userAbuscar = txf_rut_user.getText();
            User encontrado = nose.buscarUsuarioPorRut(userAbuscar);
            encontrado.getNombre();
            System.err.println(encontrado);
            
            
            String usuario_nombre = encontrado.getNombre();
        



        });

        HBox informacion_user = new HBox(10, lbl_informacion_user, txf_rut_user,btn_BuscarSocio);

        Label lbl_Separador = new Label("----------------------------------------------------------");

        Label lbl_MostrarInventario = new Label("Inventario de videojuegos");

        Label lbl_Formato = new Label("Fprmato");
        Label lbl_Titulo = new Label("Titulo");
        Label lbl_Consola = new Label("Consola");
        Label lbl_Detalles = new Label("Detalles");
        Label lbl_Portada = new Label("Portada");

        HBox informacion_Juego = new HBox(20, lbl_Formato,lbl_Titulo,lbl_Consola,lbl_Detalles,lbl_Portada); 
        
    
        HBox main = new HBox(encabezado, informacion_user, informacion_Juego);
        Scene home_scene = new Scene(main, 720, 480);

        return home_scene;
    }
}
