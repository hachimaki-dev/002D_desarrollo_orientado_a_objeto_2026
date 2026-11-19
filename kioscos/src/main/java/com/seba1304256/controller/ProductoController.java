package com.seba1304256.controller;

import com.seba1304256.dao.ProductoDAO;


public class ProductoController {
    private ProductoDAO productoDAO;

    public ProductoController(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public boolean registrarProducto(String nombre,String categoria, int precio, int stock){
        if (nombre == null || nombre.isBlank() || categoria == null ||categoria.isBlank()|| precio == null|| precio.isBlank()||stock == null || stock.isBlank()) {
            
        }
    }

}
