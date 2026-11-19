package com.seba1304256.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.seba1304256.Main;

public class ConexionDB {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL";


    private static final String USER = "usuario_desarrollador";
    private static final String PASS = "123456";
    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void main(String[] args) {
        try (Connection conn = obtenerConexion()){
            System.out.println("conexion exitosa");
        } catch (SQLException e) {
            System.out.println("error al conectar:" + e.getMessage());
        }
    }
}
