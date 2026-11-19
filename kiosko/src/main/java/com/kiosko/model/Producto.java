package com.kiosko.model;

public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int precio;
    private int stock;

    public Producto(int id, String nombre, String categoria, int precio, int stock)
    {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
//
    public Producto(String nombre, String categoria, int precio, int stock)
    {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
}

/*
    Clase Producto con id, nombre, categoria, precio y stock, aplicando sobrecarga de constructores (sin id para insertar y con id para leer).
Clase ProductoDAO con los 4 métodos CRUD: guardar(), obtenerTodos(), actualizar() y eliminar() usando PreparedStatement.
*/