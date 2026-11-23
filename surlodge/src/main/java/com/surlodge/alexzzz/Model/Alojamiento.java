package com.surlodge.alexzzz.Model;

public abstract class Alojamiento {
    //NOTA3.1 SE CREA ALOJAMIENTO CON SU METODO CONSTRUCTOR, GETTERS, SETTERS Y METODOS ABSTRACTOS
    private int id;
    private String nombre;
    private int precioNoche;
    private int idDestino;
    private String nombreCiudad;

    public Alojamiento(int id, String nombre, String nombreCiudad, int idDestino, int precioNoche) {
        this.id = id;
        this.idDestino = idDestino;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
        this.precioNoche = precioNoche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(int precioNoche) {
        this.precioNoche = precioNoche;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public abstract String getTipo();
    public abstract int calcularPrecioFinal();
    public abstract String getDetalle();
    //NOTA3.2 SEGUIMOS CON ALOJAMIENTO HABITACION HOTEL
}
