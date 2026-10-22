package com.hachimakidev.biblioapp.model;

public abstract class Material {

    private int id;
    private String titulo;
    private String fecha_publicacion;
    private boolean esta_disponible;

    
    public Material(int id, String titulo, String fecha_publicacion, boolean esta_disponible) {
        this.id = id;
        this.titulo = titulo;
        this.fecha_publicacion = fecha_publicacion;
        this.esta_disponible = esta_disponible;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getFecha_publicacion() {
        return fecha_publicacion;
    }
    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    public boolean isEsta_disponible() {
        return esta_disponible;
    }
    public void setEsta_disponible(boolean esta_disponible) {
        this.esta_disponible = esta_disponible;
    }

    
}
