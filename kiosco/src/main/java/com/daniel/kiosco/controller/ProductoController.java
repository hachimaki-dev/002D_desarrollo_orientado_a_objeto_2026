package com.daniel.kiosco.controller;

import java.util.ArrayList;

import com.daniel.kiosco.dao.ProductoDAO;
import com.daniel.kiosco.model.Producto;

public class ProductoController {
    private ProductoDAO productoDAO;

    public ProductoController(){
        this.productoDAO = new ProductoDAO();
    }

    public boolean registrarProducto(String nombre, String categoria, int precio, int stock){
        if (nombre == null || nombre.isBlank() || categoria == null || categoria.isBlank() || precio < 0 || stock < 0){
            return false;
        }

        Producto producto = new Producto(nombre, categoria, precio, stock);
        return productoDAO.guardar(producto);
    }

    public ArrayList<Producto> obtenerProductos(){
        return productoDAO.obtenerTodos();
    }

    public boolean actualizarProducto(int id, String nombre, String categoria, int precio, int stock){
        if (id <= 0 || nombre == null || nombre.isBlank() || categoria == null || categoria.isBlank() || precio < 0 || stock < 0) {
            return false;
        }

        Producto producto = new Producto(id,nombre, categoria, precio, stock);
        return productoDAO.actualizar(producto);
    }

    public boolean eliminarProducto (int id){
        if (id <= 0) {
            return false;
        }
        return productoDAO.eliminar(id);
    }
}
