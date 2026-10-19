package com.tiendagson;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> lista = new ArrayList<>();
        Camiseta c = new Camiseta();
        c.setTalla("M");
        c.setNombre("Polera basica");
        lista.add(c);
        Celular cel = new Celular();
        cel.setGama("Alta");
        cel.setNombre("Samsung");
        lista.add(cel);
        Alimento alimento = new Alimento();
        alimento.setCategoria("Lacteos");
        alimento.setNombre("Leche");
        lista.add(alimento);
        for (Producto p : lista) {
            System.out.println(p.descripcion());
            
        }


        PruebaTienda.main(args);
    }
}