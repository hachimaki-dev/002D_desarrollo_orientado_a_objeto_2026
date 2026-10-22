package com.hachimakidev.biblioapp.model;

public class Revista extends Material {

    private int numeroEdicion;
    private String periodicidad;

    public Revista(int id, String titulo, String fecha_publicacion, boolean esta_disponible, int numeroEdicion,
            String periodicidad) {
        super(id, titulo, fecha_publicacion, esta_disponible);
        this.numeroEdicion = numeroEdicion;
        this.periodicidad = periodicidad;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

}
