package com.gamevault.model;

import com.gamevault.Descargable;

public class JuegoDigital extends Videojuego implements Descargable {
    private double tamanoGB;
    private String codigoActivacion;
    public JuegoDigital(String titulo, String plataforma, String portadaUrl, double tamanoGB, String codigoActivacion) {
        super(titulo, plataforma, portadaUrl);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }
    @Override 
    public String getFormato(){
        return "Digital";

    }
    @Override 
    public void descargar(){
        System.out.println("Descargando.." + getTitulo());
    }
    
}
