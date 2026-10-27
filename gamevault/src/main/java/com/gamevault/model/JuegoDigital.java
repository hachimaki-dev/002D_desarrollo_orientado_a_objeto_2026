package com.gamevault.model;

public class JuegoDigital extends Videojuego {

    private int tamañoGB;
    private int codigoActivacion;

    public JuegoDigital(int codigoActivacion, int tamañoGB, String plataforma, String portadaUrl, String titulo) {
        super(plataforma, portadaUrl, titulo);
        this.codigoActivacion = codigoActivacion;
        this.tamañoGB = tamañoGB;
    }

    public int getTamañoGB() {
        return tamañoGB;
    }

    public int getCodigoActivacion() {
        return codigoActivacion;
    }

}
