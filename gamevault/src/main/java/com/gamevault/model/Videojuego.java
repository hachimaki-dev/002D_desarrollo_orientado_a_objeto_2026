package com.gamevault.model;

public abstract class Videojuego{
    
    private String titulo;
    private String plataforma;
    private String  portadaUrl;

    public Videojuego(String plataforma, String portadaUrl, String titulo) {
        this.plataforma = plataforma;
        this.portadaUrl = portadaUrl;
        this.titulo = titulo;
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

}
