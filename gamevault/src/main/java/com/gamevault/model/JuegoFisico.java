package com.gamevault.model;

public class JuegoFisico extends Juego{
    private int stockTienda;
    private int pesoGramo;
    
    public JuegoFisico(String titulo, String plataforma, String portada, int stockTienda, int pesoGramo) {
        super(titulo, plataforma, portada);
        this.stockTienda = stockTienda;
        this.pesoGramo = pesoGramo;
    }

    public int getStockTienda() {
        return stockTienda;
    }

    public void setStockTienda(int stockTienda) {
        this.stockTienda = stockTienda;
    }

    public int getPesoGramo() {
        return pesoGramo;
    }

    public void setPesoGramo(int pesoGramo) {
        this.pesoGramo = pesoGramo;
    }

    
}
