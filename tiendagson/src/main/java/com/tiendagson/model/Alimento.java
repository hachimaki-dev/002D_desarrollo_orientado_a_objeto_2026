package com.tiendagson;

public class Alimento extends Producto {
    private String vencimiento;

    @Override 
    public String descripcion(){
        return "Fecha de vencimiento " + vencimiento + getNombre();
    }
    public void setCategoria(String vencimiento){
        this.vencimiento = vencimiento;
    }
    
}
