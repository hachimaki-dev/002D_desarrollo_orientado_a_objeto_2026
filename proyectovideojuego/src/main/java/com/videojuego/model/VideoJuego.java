package com.videojuego.model;

public class VideoJuego {
    private String titulo; 
    private String plataforma;
    private String portadaUrl;

    public VideoJuego() {
    }

    public VideoJuego(String plataforma, String portadaUrl, String titulo) {
        this.plataforma = plataforma;
        this.portadaUrl = portadaUrl;
        this.titulo = titulo;
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
    public String getPortadaUrl() {
        return portadaUrl;
    }
    public void setPortadaUrl(String portadaUrl) {
        this.portadaUrl = portadaUrl;
    }

    
}
