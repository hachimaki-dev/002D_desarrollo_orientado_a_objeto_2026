package com.gamevault.Model;

public class Videojuego {
    protected String tipo;
    protected String titulo;
    protected String plataforma;
    protected String portadaURL;

    public Videojuego(String tipo, String titulo, String plataforma, String portadaURL) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.portadaURL = portadaURL;
    }

    public String getPortadaURL() {
        return portadaURL;
    }

    public void setPortadaURL(String portadaURL) {
        this.portadaURL = portadaURL;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
}
