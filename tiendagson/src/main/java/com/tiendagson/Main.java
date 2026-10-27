package com.tiendagson;

import java.util.ArrayList;

import com.tiendagson.model.Alimento;
import com.tiendagson.model.Bebida;
import com.tiendagson.model.Camiseta;
import com.tiendagson.model.Celular;
import com.tiendagson.model.Producto;

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
        Bebida bebida = new Bebida();
        bebida.setNombre("Fanta");
        lista.add(alimento);
        for (Producto p : lista) {
            System.out.println(p.descripcion());
            
        }


        PruebaTienda.main(args);
    }
}