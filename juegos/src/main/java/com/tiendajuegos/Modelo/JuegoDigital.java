package com.tiendajuegos.Modelo;

public class JuegoDigital extends Videojuego {

    private int tamañoGB;
    private String codigoActivacion;

    public JuegoDigital(String titulo, String plataforma, String portada, int tamañoGB, String codigoActivacion){
        super(titulo, plataforma, portada);

        this.tamañoGB = tamañoGB;
        this.codigoActivacion = codigoActivacion;

    }
    public int setTamañoGB(){return tamañoGB;}
    public String setCodigoActivacion(){return codigoActivacion;}

    public void getTamañoGb(int tamañoGB){this.tamañoGB = tamañoGB;}
    public void getCodigoActivacion (String codigoActivacion){this.codigoActivacion = codigoActivacion;}
}
