package com.gamevault.model;

public class JuegoFisico extends Videojuego {
    
    private int stockTienda;
    private float pesoGramos;

    public JuegoFisico(String titulo,String plataforma,String portadaUrl,int stockTienda,float pesoGramos){

    super(titulo, plataforma, portadaUrl);
    this.stockTienda = stockTienda;
    this.pesoGramos = pesoGramos;
}

    
public int getStockTienda() {
        return stockTienda;
    }


    public float getPesoEnGramos() {
        return pesoGramos;
    }


}