package com.tiendagson.model;

public class Celular extends Producto {
    private String gama;

    @Override 
    public String descripcion(){
        return "Gama celular :" + gama + ":" + getNombre();

    }
    public void setGama(String gama){
        this.gama = gama;
    }
    
}
