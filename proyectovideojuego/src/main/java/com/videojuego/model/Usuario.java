package com.videojuego.model;

public class Usuario {
    private String rut;
    private String nombre;
    private String nivel;
    private String email;
    
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario(String rut, String nombre, String nivel, String email) {
        this.rut = rut;
        this.nombre = nombre;
        this.nivel = nivel;
        this.email = email;
    }

}
