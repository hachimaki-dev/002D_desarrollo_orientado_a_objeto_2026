package com.hachimakidev.biblioapp.model;

public class Revista extends Material {
    String editorial;
    String periodicidad;
    
    public Revista(String nombre, String titulo, String publicacion, String editorial, String periodicidad) {
        super(nombre, titulo, publicacion);
        this.editorial = editorial;
        this.periodicidad = periodicidad;
    }
}
