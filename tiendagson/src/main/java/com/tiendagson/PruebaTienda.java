package com.tiendagson;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.tiendagson.model.Producto;

public class PruebaTienda extends Application {
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Producto> lista_Productos = new ArrayList<>();
        Producto[] productos = leerProductos();
        for (Producto producto : productos) {
            lista_Productos.add(producto);
        }
        Label lbl_informacion = new Label();
        TextField ingresarInformacion = new TextField();
        ingresarInformacion.setPromptText("Ingrese el ID");
        Button btn = new Button("Buscar");
        Button btn2 = new Button("Mostrar todos los productos");
        btn.setOnAction(e -> {
            boolean flag = false;
            for (Producto p : productos) {
                if (ingresarInformacion.getText().trim().toLowerCase().equals(p.getNombre().toLowerCase())) {
                    flag = true;
                    lbl_informacion.setText("Encontrado!" + " [ " + p.getNombre() + " ] " + "[" + p.getStock() + "]");
                    
                }
                
                
            }
             if (flag == false) {
                    lbl_informacion.setText("No encontrado!");
                }
        });
        btn2.setOnAction(e -> {
            String textoGuardado = "";
            for (Producto p_mostrado : lista_Productos) {
                textoGuardado = textoGuardado + "\n[ID: " + p_mostrado.getId() + "]" + "\n[NOMBRE: " + p_mostrado.getNombre() + "]" + "[STOCK: " + p_mostrado.getStock() + "]";
            }
            lbl_informacion.setText(textoGuardado);
        });
        VBox contenedor = new VBox(ingresarInformacion , btn , lbl_informacion , btn2);
        Scene escenaPrincipal = new Scene(contenedor , 300 , 150);
        primaryStage.setScene(escenaPrincipal);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public Producto[] leerProductos(){
        // Lee el archivo Json ccon InputStream
        InputStream stream = getClass().getResourceAsStream("/productos.json");
        // Convierte en bytes a texto , el inputstreamreader transforma el byte de inputstream a texto
        InputStreamReader leer = new InputStreamReader(stream);
        // Gson solo lee texto y Producto se crea con el metodo aplicado de Gson
        Gson gson = new Gson();
        Producto[] arregloGson = gson.fromJson(leer, Producto[].class);
        return arregloGson;
    }
    
}
