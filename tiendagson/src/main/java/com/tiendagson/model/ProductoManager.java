package com.tiendagson.model;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class ProductoManager {

    public Producto[] leerProductos(){
        // Lee el archivo Json ccon InputStream
        InputStream stream = getClass().getResourceAsStream("/productos.json");
        // Convierte en bytes a texto , el inputstreamreader transforma el byte de inputstream a texto
        InputStreamReader leer = new InputStreamReader(stream);
        // Gson solo lee texto y Producto se crea con el metodo aplicado de Gson
        Gson gson = new Gson();
        Producto[] arregloGson = gson.fromJson(leer, Bebida[].class);
        return arregloGson;
    }
}
