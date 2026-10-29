package com.gallegos.steamtemu.Model;

public class JuegoDigital extends Videojuego{
    private double tamanoGB;
    private String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portada, double tamanoGB, String codigoActivacion) {
        super(titulo, plataforma, portada);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }

    public double getTamanoGB() { return tamanoGB; }
    public String getCodigoActivacion() { return codigoActivacion; }

    @Override
    public String getFormatoStr() {
        return "Digital";
    }

    @Override
    public String getDetalleFormateado() {
        return tamanoGB + " GB";
    }
}
