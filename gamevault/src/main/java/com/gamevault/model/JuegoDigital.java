package com.gamevault.model;

public class JuegoDigital extends Videojuego {

    private int tamanoGB;
    private String codigoActivacion;
    
    public int getTamanoGB() {
        return tamanoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    public JuegoDigital(String titulo, String plataforma, String portadaUrl, int tamanoGB, String codigoActivacion) {
        super(titulo, plataforma, portadaUrl);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }



    
}