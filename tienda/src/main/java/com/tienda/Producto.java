package com.tienda;

public class Producto {
    private final int id;
    private final String nombre;
    private final double precio;
    private final int stock;
    public Producto(int id , String nombre , double precio , int stock){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }

}
