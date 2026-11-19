package com.ferdev.javadb;

import java.math.BigDecimal;

public class Juego {
    private int id;
    private String nombre;
    private BigDecimal precio;
    private String consola;
    
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
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public String getConsola() {
        return consola;
    }
    public void setConsola(String consola) {
        this.consola = consola;
    }
    
}
