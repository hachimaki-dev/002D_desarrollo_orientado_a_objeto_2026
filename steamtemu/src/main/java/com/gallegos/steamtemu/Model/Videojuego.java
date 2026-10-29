package com.gallegos.steamtemu.Model;

public abstract class Videojuego {
    protected String titulo;
    protected String plataforma;
    protected String portada;

    public Videojuego(String titulo, String plataforma, String portada) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.portada = portada;
    }

    public String getTitulo() { return titulo; }
    public String getPlataforma() { return plataforma; }
    public String getPortada() { return portada; }

    public abstract String getDetalleFormateado();
    public abstract String getFormatoStr();
}
