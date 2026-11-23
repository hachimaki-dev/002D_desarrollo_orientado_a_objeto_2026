package com.surlodge.alexzzz.Model;

public class HabitacionHotel extends Alojamiento{
    //NOTA4.1 SE CREA HABITACION CON SU METODO CONSTRUCTOR, GETTERS, SETTERS, METODOS ABSTRACTOS Y HERENCIAS
    private int piso;
    private boolean incluyeDesayuno;

    public HabitacionHotel(int id, String nombre, String nombreCiudad, int idDestino, int precioNoche, int piso, boolean incluyeDesayuno) {
        super(id, nombre, nombreCiudad, idDestino, precioNoche);
        this.piso = piso;
        this.incluyeDesayuno = incluyeDesayuno;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }
    
    @Override 
    public String getTipo(){
        return "HOTEL";
    }
    @Override 
    public int calcularPrecioFinal(){
        if (isincluyeDesayuno) {
            return 12000 + getPrecioNoche();
        }else{
            return getPrecioNoche();
        }
    }
    @Override 
    public String getDetalle(){
        if (incluyeDesayuno) {
            return "Tipo: " + getTipo() + ". Piso: " + getPiso() + ". Incluye Desayuno";
        }else{
            return "Tipo: " + getTipo() + ". Piso: " + getPiso() + ". No Incluye Desayuno";
        }
    };
    //NOTA4.2 SEGUIMOS CON CABANA
}
