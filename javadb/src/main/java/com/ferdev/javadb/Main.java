package com.ferdev.javadb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {
    private static final String conexionDB = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
    private static final String user = "fernando1";
    private static final String password = "fernando123";
    public static void main(String[] args) {
        try(Connection con = DriverManager.getConnection(conexionDB, user , password)) {
            System.out.println("Conexion exitosa!");
            
        } catch (SQLException e) {
            System.err.println("No se pudo conectar la base de datos al Java" + e.getMessage());
        }
    }
    public static int insertarSql(String nombre , BigDecimal precio , String consola) throws SQLException{
        String insertar = "INSERT INTO JUEGOS (nombre , precio , consola) VALUES (? , ? , ?)";
        try (Connection con = DriverManager.getConnection(conexionDB , user , password);){
            PreparedStatement p = con.prepareStatement(insertar);
            p.setString(1, nombre);
            p.setBigDecimal(2, precio);
            p.setString(3, consola);
            return p.executeUpdate();
        }
    }
    public static ArrayList<Juego> listarSql() throws SQLException{
        ArrayList<Juego> lista = new ArrayList<>();
        String listar = "SELECT * FROM JUEGOS";
        try (Connection con = DriverManager.getConnection(conexionDB , user , password)){
            PreparedStatement p = con.prepareStatement(listar);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                Juego nuevo = new Juego();
                nuevo.setId(rs.getInt("id"));
                nuevo.setNombre(rs.getString("nombre"));
                nuevo.setPrecio(rs.getBigDecimal("precio"));
                nuevo.setConsola(rs.getString("consola"));
                lista.add(nuevo);
            }
            return lista;
        } 
    }
    public static int actualizarSql(String nombre , BigDecimal precio , String consola , int id) throws SQLException{
        String actualizar = "UPDATE JUEGOS SET nombre = ? , precio = ? , consola = ? WHERE id = ?";
        try(Connection con = DriverManager.getConnection(conexionDB , user , password)) {
            PreparedStatement p = con.prepareStatement(actualizar);
            p.setString(1, nombre);
            p.setBigDecimal(2, precio);
            p.setString(3, consola);
            p.setInt(4, id);
            return p.executeUpdate();
        }
    }
    public static int eliminarSql(int id) throws SQLException{
        String eliminar = "DELETE FROM JUEGOS WHERE id = ?";
        try(Connection con = DriverManager.getConnection(conexionDB , user , password)) {
            PreparedStatement p = con.prepareStatement(eliminar);
            p.setInt(1, id);
            return p.executeUpdate();  
        } 
    }
}