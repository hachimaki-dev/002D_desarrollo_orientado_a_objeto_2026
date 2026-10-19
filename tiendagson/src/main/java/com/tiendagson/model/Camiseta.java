package com.tiendagson.model;

public class Camiseta extends Producto {
    private String talla;
    

    @Override 
    public String descripcion(){
        return "Camiseta talla " + talla + ": " + getNombre();
    }


    public void setTalla(String talla) {
        this.talla = talla;
    }
    
}
