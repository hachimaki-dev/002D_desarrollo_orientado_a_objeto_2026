package com.gamevault.model;

public class JuegoDigital extends VideoJuego{
    private int tamanoGB;
    private String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portadaUrl, int tamanoGB, String codigoActivacion){
        super(titulo, plataforma, portadaUrl);
        this.tamanoGB = tamanoGB;
        this.codigoActivacion = codigoActivacion;
    }

    public JuegoDigital(){
    }
    
    public int getTamanoGB(){
        return tamanoGB;
    }
    public void setTamanoGB(int tamanoGB){
        this.tamanoGB = tamanoGB;
    }
    public String getCodigoActivacion(){
        return codigoActivacion;
    }
    public void setCodigoActivacion(String codigoActivacion){
        this.codigoActivacion = codigoActivacion;
    }
}