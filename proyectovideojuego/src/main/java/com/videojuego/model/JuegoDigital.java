package com.videojuego.model;

public class JuegoDigital extends VideoJuego {
    private int tamañoGb;
    private String codigoActivacion;
   
       public JuegoDigital(String plataforma, String portadaUrl, String titulo, int tamañoGb, String codigoActivacion) {
        super(plataforma, portadaUrl, titulo);
        this.tamañoGb = tamañoGb;
        this.codigoActivacion = codigoActivacion;
    }
    
    public int getTamañoGb() {
        return tamañoGb;
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }

 
}
