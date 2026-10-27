package com.hachimakidev.biblioapp.model;

public class Libro extends Material {
    String autor;
    int paginas;
    
    public Libro(String nombre, String titulo, String publicacion, String autor, int paginas) {
        super(nombre, titulo, publicacion);
        this.autor = autor;
        this.paginas = paginas;
    }

}
