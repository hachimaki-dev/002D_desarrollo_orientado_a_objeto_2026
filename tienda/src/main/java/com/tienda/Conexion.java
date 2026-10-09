package com.tienda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
    private static final String USUARIO = "fernando";
    private static final String CLAVE = "ClaveApp123";

    public static Connection obtener() throws SQLException{
        return DriverManager.getConnection(URL , USUARIO , CLAVE);
    }
}
