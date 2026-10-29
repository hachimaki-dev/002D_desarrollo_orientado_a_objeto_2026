package com.gamevault.model;

public abstract class VideoJuego {
    private String titulo;
    private String plataforma;
    private String portadaUrl;
    
    public VideoJuego(String titulo, String plataforma, String portadaUrl) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.portadaUrl = portadaUrl;
    }

    public VideoJuego() {
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
