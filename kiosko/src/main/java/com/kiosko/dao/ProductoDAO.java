package com.kiosko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kiosko.database.ConexionDB;
import com.kiosko.model.Producto;

public class ProductoDAO {
    // 1. OPERACIÓN CREAR (INSERT)
    public boolean guardar(Producto producto) {
        String sql = "INSERT INTO productos (username, correo, password, rol) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Error al guardar producto: " + e.getMessage());
            return false;
        }
    }
    
    // 2. OPERACIÓN LEER TODOS (SELECT)
    public ArrayList<Producto> obtenerTodos() {
        ArrayList<Producto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, categoria, precio, stock FROM productos ORDER BY id ASC";

        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int precio = rs.getInt("precio");
                int stock = rs.getInt("stock");

                Producto u = new Producto(id, nombre, categoria, precio, stock);
                lista.add(u);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Error al listar productos: " + e.getMessage());
        }

        return lista;
    }

    // 3. OPERACIÓN ACTUALIZAR (UPDATE)
    public boolean actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, stock = ? WHERE id = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getCategoria());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId()); // El 5° signo '?' corresponde al WHERE id = ?

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        }
        catch (SQLException e)
        {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    // 4. OPERACIÓN ELIMINAR (DELETE)
    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        }
        catch (SQLException e)
        {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}
