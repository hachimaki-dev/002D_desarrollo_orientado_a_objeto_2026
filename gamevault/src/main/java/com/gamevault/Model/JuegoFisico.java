package com.gamevault.Model;

public class JuegoFisico extends Videojuego {
    private int stockTienda;
    private int pesoEnGramos;

    public JuegoFisico(String tipo, String titulo, String plataforma, String portadaURL, int stockTienda,
            int pesoEnGramos) {
        super(tipo, titulo, plataforma, portadaURL);
        this.stockTienda = stockTienda;
        this.pesoEnGramos = pesoEnGramos;
    }

    public int getStockTienda() {
        return stockTienda;
    }

    public void setStockTienda(int stockTienda) {
        this.stockTienda = stockTienda;
    }

    public int getPesoEnGramos() {
        return pesoEnGramos;
    }

    public void setPesoEnGramos(int pesoEnGramos) {
        this.pesoEnGramos = pesoEnGramos;
    }
}
