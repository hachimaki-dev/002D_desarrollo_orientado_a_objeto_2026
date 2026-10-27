package com.gallegos155.gamebault.Model;

public class JuegoFisico extends Videojuegos {
 private int stock;
 private int pesoGramos;
 public JuegoFisico(String formato, String titulo, String consola, int detalle, String portada, int stock,
        int pesoGramos) {
    super(formato, titulo, consola, detalle, portada);
    this.stock = stock;
    this.pesoGramos = pesoGramos;
}
 public int getStock() {
    return stock;
 }
 public void setStock(int stock) {
    this.stock = stock;
 }
 public int getPesoGramos() {
    return pesoGramos;
 }
 public void setPesoGramos(int pesoGramos) {
    this.pesoGramos = pesoGramos;
 }


}
