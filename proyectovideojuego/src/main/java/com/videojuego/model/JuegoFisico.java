package com.videojuego.model;

public class JuegoFisico extends VideoJuego{
    private int stockTienda;
    private int pesoGramos;


    public JuegoFisico(int pesoGramos, int stockTienda, String plataforma, String portadaUrl, String titulo) {
        super(plataforma, portadaUrl, titulo);
        this.pesoGramos = pesoGramos;
        this.stockTienda = stockTienda;
    }


    public int getStockTIenda() {
        return stockTienda;
    }

    public void setStockTIenda(int stockTIenda) {
        this.stockTienda = stockTIenda;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(int pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

}
