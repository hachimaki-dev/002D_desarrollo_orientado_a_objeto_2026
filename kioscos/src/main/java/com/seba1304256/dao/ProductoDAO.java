package com.seba1304256.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.seba1304256.database.ConexionDB;
import com.seba1304256.model.Producto;

public class ProductoDAO {
    public boolean guardar(Producto producto){
        String sql = "INSERT INTO productos (nombre, categoria, precio, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, producto.getNombre());
                ps.setString(2, producto.getCategoria());
                ps.setInt(3, producto.getPrecio());
                ps.setInt(4, producto.getStock());
                int filaAfectadas = ps.executeUpdate();
                return filaAfectadas > 0;
            
        } catch (SQLException e) {
           System.out.println("error al guardar" + e.getMessage());
           return false;
        }

    
    }
    public ArrayList<Producto> obtenerTodo(){
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT id,nombre,categoria,precio,stock FROM productos ODER BY ASC";
        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int precio = rs.getInt("precio");
                int stock = rs.getInt("stock");

                Producto u = new Producto(id,nombre, categoria, precio, stock);
                lista.add(u);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar usuario" + e.getMessage());
        }
        return lista;
    }
    public boolean actualizar(Producto producto ){
        String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ){
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());
            int filaAfectadas = ps.executeUpdate();
            return filaAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id){
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            int filaAfectadas = ps.executeUpdate();
            return filaAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            return false;
            
        }
    }
}
