package com.hachimakidev.automarket.model;

public class Automovil extends Vehiculo {

    private int puertas;
    private String transmision;

    public Automovil() {}

    public Automovil(int id, String marca, String modelo, int precio, boolean disponible, int puertas, String transmision) {
        super(id, marca, modelo, precio, disponible);
        this.puertas = puertas;
        this.transmision = transmision;
    }

    @Override
    public String getTipo() {
        return "Automóvil";
    }

    @Override
    public String getEspecificacion() {
        return puertas + " puertas · " + transmision;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
}

