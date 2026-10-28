package com.gamevault.model;

public class JuegoDigital extends Videojuego{
    private int tamañoGB;
    private String codigoActivacion;
    
    public JuegoDigital(String titulo, String plataforma, String portada, int tamañoGB, String codigoActivacion) {
        super(titulo, plataforma, portada);
        this.tamañoGB = tamañoGB;
        this.codigoActivacion = codigoActivacion;
    }

    public int getTamañoGB() {
        return tamañoGB;
    }

    public void setTamañoGB(int tamañoGB) {
        this.tamañoGB = tamañoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    public void setCodigoActivacion(String codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }

    
}
