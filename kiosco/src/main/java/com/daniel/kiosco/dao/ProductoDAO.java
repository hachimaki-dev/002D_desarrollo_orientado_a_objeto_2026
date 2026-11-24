package com.daniel.kiosco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daniel.kiosco.database.ConexionDB;
import com.daniel.kiosco.model.Producto;

public class ProductoDAO {
    public boolean guardar(Producto producto) {
    String sql_insert = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";

    try (Connection conn = ConexionDB.obtenerConexion();
         PreparedStatement ps = conn.prepareStatement(sql_insert)) {

        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getCategoria());
        ps.setInt(3, producto.getPrecio());
        ps.setInt(4, producto.getStock());

        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;

    } catch (SQLException e) {
        System.out.println("Error al guardar producto: " + e.getMessage());
        return false;
    }
}

    public ArrayList<Producto> obtenerTodos(){
        ArrayList<Producto> lista = new ArrayList<>();
        String sql_select = "SELECT id,nombre,categoria,precio,stock FROM productos ORDER BY id ASC";

        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery()){
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int precio = rs.getInt("precio");
                int stock = rs.getInt("stock");

                Producto producto = new Producto(id, nombre, categoria, precio, stock);
                lista.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Producto producto){
        String sql_update = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql_update)){
                ps.setString(1,producto.getNombre());
                ps.setString(2,producto.getCategoria());
                ps.setInt(3,producto.getPrecio());
                ps.setInt(4,producto.getStock());
                ps.setInt(5,producto.getId());
            
                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;  
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id){
        String sql_delete = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql_delete)){
                ps.setInt(1, id);
                
                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar un producto: " + e.getMessage());
            return false;
        }
    }
}