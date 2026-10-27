package com.gamevault.model;

public class Usuario {

    private String rut;
    private String nombre;
    private String email;
    private String nivelGamer;

    public Usuario(String nivelGamer, String email, String nombre, String rut) {
        this.nivelGamer = nivelGamer;
        this.email = email;
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNivelGamer() {
        return nivelGamer;
    }

}
