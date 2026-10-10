package com.tienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoAccesoBaseDatos {


    public List<Producto> listar() throws SQLException {
        String sql = "SELECT id, nombre, precio, stock FROM producto ORDER BY id";
        List<Producto> lista = new ArrayList<>();

        try (Connection con = Conexion.obtener();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                ));
            }
        }
        return lista;
    }
    public void insertar(Producto p) throws SQLException{
        String sql = "INSERT INTO producto (nombre, precio, stock) VALUES (?, ?, ?)";
         try (Connection con = Conexion.obtener();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, p.getNombre());
        ps.setDouble(2, p.getPrecio());
        ps.setInt(3, p.getStock());

        ps.executeUpdate();
    }
    }

}