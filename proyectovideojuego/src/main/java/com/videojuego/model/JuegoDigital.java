package com.videojuego.model;

public class JuegoDigital extends VideoJuego {
    private double tamanoGB;
    private String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portadaUrl, double tamanoGB, String codigoActivacion) {
        super(titulo, plataforma, portadaUrl);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }

    public double getTamanoGB() {
        return tamanoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }
}