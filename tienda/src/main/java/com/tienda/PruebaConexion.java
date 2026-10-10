package com.tienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {
        String sql = "SELECT id, nombre, precio, stock FROM producto";
        try {
    new ProductoAccesoBaseDatos().insertar(new Producto(0, "Webcam", 35.00, 8));
    System.out.println("Producto insertado");
} catch (SQLException e) {
    System.out.println("Error al insertar: " + e.getMessage());
}

        try (Connection con = Conexion.obtener();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("¡Conectado a Oracle!");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                System.out.println(id + " | " + nombre + " | " + precio + " | " + stock);
            }

        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
        
    }
    
}
