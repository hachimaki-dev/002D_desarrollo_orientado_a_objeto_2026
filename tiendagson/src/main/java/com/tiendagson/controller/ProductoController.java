package com.tiendagson.controller;
import com.tiendagson.model.Producto;
import com.tiendagson.model.ProductoManager;

public class ProductoController {
    private ProductoManager manager;
    
    public ProductoController(){
        manager = new ProductoManager();

    }
    
    public Producto buscarProducto(String idIngresado){
        Producto[] productos = manager.leerProductos();
        for (Producto p : productos) {
            if (p.getId().equalsIgnoreCase(idIngresado.trim())) {
                return p;
                
            }
            
        }
        return null;
    }
}
