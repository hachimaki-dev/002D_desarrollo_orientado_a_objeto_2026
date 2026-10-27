package com.tiendajuegos.Modelo;

public class Usuario {
    private int rut;
    private String nombre;
    private String email;
    private String nivelGamer;

    public Usuario(int rut, String nombre , String email, String nivelGamer){
        this.rut = rut;
        this.nombre = nombre;
        this.email = email;
        this.nivelGamer = nivelGamer;

    }
    
    public int setRut(){return rut;}
    public  String setNombre(){return  nombre;}
    public  String setEmail(){return email;}
    public String setNivelGamer(){return nivelGamer;}

    public void getRut(int rut){this.rut = rut;}
    public  void getNombre (String nombre){this.nombre = nombre;}
    public  void getEmail(String email){this.email = email;}
    public  void getNivelGamer (String nivelGamer){this.nivelGamer = nivelGamer;}
}
