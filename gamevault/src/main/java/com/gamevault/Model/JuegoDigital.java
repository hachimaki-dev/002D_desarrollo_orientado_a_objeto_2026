package com.gamevault.Model;

public class JuegoDigital extends Videojuego {
    private float tamanoGB;
    private String codigoActivacion;

    public JuegoDigital(String tipo, String titulo, String plataforma, String portadaURL, float tamanoGB,
            String codigoActivacion) {
        super(tipo, titulo, plataforma, portadaURL);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }

    public float getTamanoGB() {
        return tamanoGB;
    }

    public void setTamanoGB(float tamanoGB) {
        this.tamanoGB = tamanoGB;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

    public void setCodigoActivacion(String codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }
}
