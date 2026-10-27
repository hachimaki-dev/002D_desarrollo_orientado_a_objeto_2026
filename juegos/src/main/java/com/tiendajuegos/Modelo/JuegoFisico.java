package com.tiendajuegos.Modelo;

public class JuegoFisico extends Videojuego {

    private int stockTienda;
    private int pesoGramos;

    public JuegoFisico(String titulo, String plataforma, String portada, int stockTienda, int pesoGramos){
        super(titulo, plataforma, portada);
        this.stockTienda = stockTienda;
        this.pesoGramos = pesoGramos;
    }

    public int setStockTienda(){return stockTienda;}
    public int setPesoGramos(){return pesoGramos;}

    public void getStockTienda(int stockTienda){this.stockTienda = stockTienda;}
    public void getPesoGramos(int pesoGramos){this.pesoGramos = pesoGramos;}

    
}
