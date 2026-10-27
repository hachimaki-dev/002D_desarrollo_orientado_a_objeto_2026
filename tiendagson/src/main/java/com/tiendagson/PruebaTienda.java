package com.tiendagson;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.tiendagson.controller.ProductoController;
import com.tiendagson.model.Producto;
import com.tiendagson.model.ProductoManager;

public class PruebaTienda extends Application {
    @Override
    public void start(Stage primaryStage) {
        ProductoManager manager = new ProductoManager();
        Producto[] productos = manager.leerProductos();
        ArrayList<Producto> lista_Productos = new ArrayList<>();
        for (Producto producto : productos) {
            lista_Productos.add(producto);
        }
        Label lbl_informacion = new Label();
        TextField ingresarInformacion = new TextField();
        ingresarInformacion.setPromptText("Ingrese el ID");
        Button btn = new Button("Buscar");
        Button btn2 = new Button("Mostrar todos los productos");
        ProductoController controller = new ProductoController();
        btn.setOnAction(e -> {
            Producto encontrado = controller.buscarProducto(ingresarInformacion.getText().trim());
            if (encontrado != null) {
                lbl_informacion.setText("Encontrado :" + encontrado.getNombre());
                lbl_informacion.setText("Codigo ID :" + encontrado.getId());
                lbl_informacion.setText("Stock :" + encontrado.getStock());
            } else{
                lbl_informacion.setText("No encontrado");
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
}
