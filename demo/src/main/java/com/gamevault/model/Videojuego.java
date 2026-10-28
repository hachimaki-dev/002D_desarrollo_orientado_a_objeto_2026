package com.gamevault.model;

public abstract class Videojuego {
    private String titulo;
    private String plataforma;
    private String portadaUrl;

    public Videojuego(String titulo , String plataforma , String portadaUrl){
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.portadaUrl = portadaUrl;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getPortadaUrl() {
        return portadaUrl;
    }
    @Override 
    public String toString(){
        return titulo;
    }
    public abstract String getFormato();
}
