package com.gamevault.model;

public class JuegoFisico extends Videojuego {
    private int stockTienda;
    private int pesoGramos;
    public JuegoFisico(String titulo, String plataforma, String portadaUrl, int stockTienda, int pesoGramos) {
        super(titulo, plataforma, portadaUrl);
        this.stockTienda = stockTienda;
        this.pesoGramos = pesoGramos;
    }
    @Override 
    public String getFormato(){
        return "Fisico";
    }
    
}
