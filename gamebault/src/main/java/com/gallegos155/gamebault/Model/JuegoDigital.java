package com.gallegos155.gamebault.Model;

public class JuegoDigital extends Videojuegos {
    private int tamañoGB;
    private int codigoActivacion;
   
    public JuegoDigital(String formato, String titulo, String consola, int detalle, String portada, int tamañoGB,
            int codigoActivacion) {
        super(formato, titulo, consola, detalle, portada);
        this.tamañoGB = tamañoGB;
        this.codigoActivacion = codigoActivacion;
    }
    public int getTamañoGB() {
        return tamañoGB;
    }
    public void setTamañoGB(int tamañoGB) {
        this.tamañoGB = tamañoGB;
    }
    public int getCodigoActivacion() {
        return codigoActivacion;
    }
    public void setCodigoActivacion(int codigoActivacion) {
        this.codigoActivacion = codigoActivacion;
    }
}
