package com.alexzzz.biblioapp.model;

public class User {

    private String rut;
    private String nombre;
    private String email;
    private int edad;
    private boolean puede_solicitar_prestamos;

    public User(int edad, String email, String nombre, boolean puede_solicitar_prestamos, String rut) {
        this.edad = edad;
        this.email = email;
        this.nombre = nombre;
        this.puede_solicitar_prestamos = puede_solicitar_prestamos;
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isPuede_solicitar_prestamos() {
        return puede_solicitar_prestamos;
    }

    public void setPuede_solicitar_prestamos(boolean puede_solicitar_prestamos) {
        this.puede_solicitar_prestamos = puede_solicitar_prestamos;
    }

}
