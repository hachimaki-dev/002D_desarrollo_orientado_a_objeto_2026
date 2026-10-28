package com.gamevault.model;

public class Usuario {
    private String rut;
    private String nombre;
    private String email;
    private String nivelGamer;
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
    public String getNivelGamer() {
        return nivelGamer;
    }
    public void setNivelGamer(String nivelGamer) {
        if (!"Bronce".equals(nivelGamer) && !"Plata".equals(nivelGamer) && !"Leyenda Gamer".equals(nivelGamer)) {
            throw new IllegalArgumentException("Debe ser Bronce , Plata o Leyenda Gamer");
            
        }
        this.nivelGamer = nivelGamer;
    }
    
}
