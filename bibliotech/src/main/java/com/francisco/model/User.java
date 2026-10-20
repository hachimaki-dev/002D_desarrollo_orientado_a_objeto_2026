package com.francisco.model;

public class User {
   private String rut;
   private String nombre;
   private String email;
    private int edad;
    private boolean pedir_prestamo;
    
    public User(String rut, String nombre, String email, int edad, boolean pedir_prestamo) {
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.pedir_prestamo = pedir_prestamo;
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
    public boolean isPedir_prestamo() {
        return pedir_prestamo;
    }
    public void setPedir_prestamo(boolean pedir_prestamo) {
        this.pedir_prestamo = pedir_prestamo;
    }
}
