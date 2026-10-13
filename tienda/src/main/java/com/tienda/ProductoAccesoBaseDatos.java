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
    public void eliminar(Producto p) throws SQLException{
        String eliminar = "DELETE FROM producto WHERE id = ?";
        try (Connection con = Conexion.obtener();
    PreparedStatement ps = con.prepareStatement(eliminar)) {
        ps.setInt(1, p.getId());
    }

    }
    public void actualizar(Producto p) throws SQLException{
        String actualizar = "UPDATE producto SET nombre = ? , precio = ? , stock = ? WHERE id = ?";
        try(Connection con = Conexion.obtener();
    PreparedStatement ps = con.prepareStatement(actualizar)) {
        ps.setString(1, p.getNombre());
        ps.setDouble(2, p.getPrecio());
        ps.setInt(3, p.getStock());
        ps.setInt(4, p.getId());

        ps.executeUpdate();

    }
    }


}