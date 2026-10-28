package com.videojuego.model;

public class JuegoFisico extends VideoJuego{
    private int stockTienda;
    private int pesoGramos;


    public JuegoFisico(String titulo, String plataforma, String portadaUrl, int stockTienda, int pesoGramos) {
        super(titulo, plataforma, portadaUrl);
        this.stockTienda = stockTienda;
        this.pesoGramos = pesoGramos;
    }



    public int getStockTienda() {
        return stockTienda;
    }

    public void setStockTienda(int stockTIenda) {
        this.stockTienda = stockTIenda;
    }

    public int getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(int pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

}
