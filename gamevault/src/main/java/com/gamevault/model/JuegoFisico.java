package com.gamevault.model;

public class JuegoFisico extends Videojuego{
    
    private int stockTienda;
    private int pesoGramos;

    public JuegoFisico(int pesoGramos, int stockTienda, String plataforma, String portadaUrl, String titulo) {
        super(plataforma, portadaUrl, titulo);
        this.pesoGramos = pesoGramos;
        this.stockTienda = stockTienda;
    }

    public int getStockTienda() {
        return stockTienda;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

}
