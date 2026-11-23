package com.surlodge.alexzzz.Model;

public class Cabana extends Alojamiento{
    //NOTA5.1 SE CREA CABANA CON SU METODO CONSTRUCTOR, GETTERS, SETTERS, METODOS ABSTRACTOS Y HERENCIAS
    private int capacidad;
    private boolean tieneTinaja;

    public Cabana(int id, String nombre, String nombreCiudad, int idDestino, int precioNoche, int capacidad, boolean tieneTinaja) {
        super(id, nombre, nombreCiudad, idDestino, precioNoche);
        this.capacidad = capacidad;
        this.tieneTinaja = tieneTinaja;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isTieneTinaja() {
        return tieneTinaja;
    }

    public void setTieneTinaja(boolean tieneTinaja) {
        this.tieneTinaja = tieneTinaja;
    }
    @Override 
    public String getTipo(){
        return "CABANA";
    }
    @Override 
    public int calcularPrecioFinal(){
        if (tieneTinaja) {
            return 25000 + getPrecioNoche();
        }else{
            return getPrecioNoche();
        }
    }
    @Override 
    public String getDetalle(){
        if (tieneTinaja) {
            return "Tipo: " + getTipo() + ". Capacidad: " + getCapacidad() + ". Incluye Tinaja";
        }else{
            return "Tipo: " + getTipo() + ". Capacidad: " + getCapacidad() + ". No Incluye Tinaja";
        }
    };
    //NOTA5.2 SEGUIMOS CON EL DAO
}
