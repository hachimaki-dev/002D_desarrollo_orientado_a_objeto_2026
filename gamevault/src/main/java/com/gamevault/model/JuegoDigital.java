package com.gamevault.model;

public class JuegoDigital extends Videojuego {

    private int tamañoGB;
    private String codigoActivacion;

    public JuegoDigital(String codigoActivacion, int tamañoGB, String plataforma, String portadaUrl, String titulo) {
        super(plataforma, portadaUrl, titulo);
        this.codigoActivacion = codigoActivacion;
        this.tamañoGB = tamañoGB;
    }

    public int getTamañoGB() {
        return tamañoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

}
