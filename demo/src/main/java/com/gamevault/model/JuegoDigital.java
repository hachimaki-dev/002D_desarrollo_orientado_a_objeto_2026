package com.gamevault.model;

public class JuegoDigital extends Videojuego{
    private float tamanioGB;
    private String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portada, float tamanioGB, String codigoActivacion) {
        super(titulo, plataforma, portada);
        this.tamanioGB = tamanioGB;
        this.codigoActivacion = codigoActivacion;
    }
    public float getTamanioGB() {
        return tamanioGB;
    }
    public String getCodigoActivacion() {
        return codigoActivacion;
    }

}
