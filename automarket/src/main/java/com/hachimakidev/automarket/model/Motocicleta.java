package com.hachimakidev.automarket.model;

public class Motocicleta extends Vehiculo {

    private int cilindradaCc;
    private int velocidadMaxKmh;

    public Motocicleta() {}

    public Motocicleta(int id, String marca, String modelo, int precio, boolean disponible, int cilindradaCc, int velocidadMaxKmh) {
        super(id, marca, modelo, precio, disponible);
        this.cilindradaCc = cilindradaCc;
        this.velocidadMaxKmh = velocidadMaxKmh;
    }

    @Override
    public String getTipo() {
        return "Motocicleta";
    }

    @Override
    public String getEspecificacion() {
        return cilindradaCc + " cc · " + velocidadMaxKmh + " km/h";
    }

    public int getCilindradaCc() {
        return cilindradaCc;
    }

    public void setCilindradaCc(int cilindradaCc) {
        this.cilindradaCc = cilindradaCc;
    }

    public int getVelocidadMaxKmh() {
        return velocidadMaxKmh;
    }

    public void setVelocidadMaxKmh(int velocidadMaxKmh) {
        this.velocidadMaxKmh = velocidadMaxKmh;
    }
}

