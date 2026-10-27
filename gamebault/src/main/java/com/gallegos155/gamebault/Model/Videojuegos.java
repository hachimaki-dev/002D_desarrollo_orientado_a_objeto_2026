package com.gallegos155.gamebault.Model;

public abstract class Videojuegos {
    private String formato;
    private String titulo;
    private String consola;
    private int detalle;
    private String portada;

    public Videojuegos(String formato, String titulo, String consola, int detalle, String portada) {
        this.formato = formato;
        this.titulo = titulo;
        this.consola = consola;
        this.detalle = detalle;
        this.portada = portada;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getDetalle() {
        return detalle;
    }

    public void setDetalle(int detalle) {
        this.detalle = detalle;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
