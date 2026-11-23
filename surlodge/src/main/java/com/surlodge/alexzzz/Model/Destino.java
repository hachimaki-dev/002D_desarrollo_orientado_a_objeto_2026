package com.surlodge.alexzzz.Model;

public class Destino {
    //NOTA2.1 SE CREA DESTINO CON SU METODO CONSTRUCTOR, GETTERS Y SETTERS
    private int id;
    private String ciudad;
    private String region;

    public Destino( int id, String ciudad, String region) {
        this.id = id;
        this.ciudad = ciudad;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override 
    public String toString(){
        return ciudad;
    }

    //NOTA2.2 SEGUIMOS CON ALOJAMIENTO
}
