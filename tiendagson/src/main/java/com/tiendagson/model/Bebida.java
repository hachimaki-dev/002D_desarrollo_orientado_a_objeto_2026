package com.tiendagson.model;

public class Bebida extends Producto {
    private String volumen;

    @Override 
    public String descripcion(){
        return "Volumen bebida : " + volumen + "|" + getNombre();
    }
    
}
