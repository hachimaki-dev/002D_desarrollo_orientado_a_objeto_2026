package com.gallegos.steamtemu.Model;

public class JuegoFisico extends Videojuego {
    private int stockTienda;
    private int pesoGramos;

    public JuegoFisico(String titulo, String plataforma, String portada, int stockTienda, int pesoGramos) {
        super(titulo, plataforma, portada);
        this.stockTienda = stockTienda;
        this.pesoGramos = pesoGramos;
    }

    public int getStockTienda() { return stockTienda; }
    public int getPesoGramos() { return pesoGramos; }

    @Override
    public String getFormatoStr() {
        return "Físico";
    }

    @Override
    public String getDetalleFormateado() {
        return stockTienda + " unid.";
    }
}
