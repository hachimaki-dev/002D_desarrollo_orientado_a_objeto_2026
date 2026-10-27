package com.tiendajuegos.Modelo;

abstract class Videojuego {

    private String titulo;
    private String plataforma;
    private String portada;

    public Videojuego(String titulo, String plataforma, String portada){
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.portada = portada;
    }

    public String setTitulo(){return titulo;}
    public String setPlataforma(){return plataforma;}
    public String setPortada(){return portada;}

    public void getTitulo(String titulo){this.titulo = titulo;}
    public void getPlataforma(String plataforma){this.plataforma = plataforma;}
    public void getPortada(String portada){this.portada = portada;}
        
}
