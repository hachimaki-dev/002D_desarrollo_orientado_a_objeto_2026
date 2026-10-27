package com.tiendajuegos.Vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Vista {

    public Scene vista(){

    Label lblTitulo = new Label("GAMEVAULT - GESTION DE INVENTARIO Y SOCIOS GAMER");
    Label lblSuperio = new Label("PANEL SUPERIOR : CONSULTA DE SOCIOS GAMER");
    Label lblIngresarRut = new Label("ingrese rut: ");
    Label lblGmail = new Label("gmail: ");
    Label lblRut = new Label("RUT: ");
    Label lblSocio = new Label("socio: ");
    Label lblnivel = new Label("nivel: ");
    

    TextField txfIngresarRut = new TextField();
    Button btnBuscarSocio = new Button("buscar socio ");

    HBox datosRut = new HBox(10, lblIngresarRut, txfIngresarRut, btnBuscarSocio);
    HBox datosSocio = new HBox(100, lblRut, lblSocio, lblnivel);

    Label lblInferior = new Label("panel inferior: invetario de videojuegos en tableview");
    Label lblFormato = new Label("formato ");
    Label lblTituloInferior = new Label("titulo");
    Label lbLConsola = new Label("consola");
    Label lblDetalle = new Label("detalle");
    Label lblPortada = new Label("portada");

    Label lblFormato1 = new Label("___");
    Label lblFormato2 = new Label("___");
    Label lblFormato3 = new Label("___");
    Label lblFormato4 = new Label("___");

    Label Titulo1 = new Label("___");
    Label Titulo2 = new Label("___");
    Label Titulo3 = new Label("___");
    Label Titulo4 = new Label("___");

    Label Consola1 = new Label("___");
    Label Consola2 = new Label("___");
    Label Consola3 = new Label("___");
    Label Consola4 = new Label("___");

    Label Detalles1 = new Label("___");
    Label Detalles2 = new Label("___");
    Label Detalles3 = new Label("___");
    Label Detalles4 = new Label("___");

    Label portada1 = new Label("___");
    Label portada2= new Label("___");
    Label portada3 = new Label("___");
    Label portada4 = new Label("___");

    VBox formato = new VBox(10, lblFormato1, lblFormato2, lblFormato3, lblFormato4);
    VBox titulo = new VBox(10, Titulo1, Titulo2, Titulo3, Titulo4);
    VBox consola = new VBox(10, Consola1, Consola2, Consola3, Consola4);
    VBox detalles = new VBox(10, Detalles1, Detalles2, Detalles3, Detalles4);
    VBox portada = new VBox(10, portada1, portada2, portada3, portada4);

    HBox datosInferior = new HBox(10, formato, titulo, consola, detalles, portada);
    HBox titulosInferior = new HBox(10, lblFormato, lblTitulo, lbLConsola, lblDetalle, lblPortada);
    VBox Maininferior = new VBox(10, titulosInferior, datosInferior);
    VBox MainSuperior = new VBox(10, datosRut, datosSocio);
    VBox Main = new VBox(10, MainSuperior, Maininferior);

    Scene vista = new Scene(Main, 720, 480);

    return vista;

    }

    
    
}
