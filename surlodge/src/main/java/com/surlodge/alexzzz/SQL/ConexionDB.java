package com.surlodge.alexzzz.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    //NOTA 1.0 CONEXIONDB es literalmente para que el proyecto se conecte a la base de datos. Es un enchufe entre ambos
    //Nota 1.1 Final significa que es una constante. Evita errores de tipeo o sobreescritura
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
    private static final String USER = "usuario_desarrollador";
    private static final String PASSWORD = "Oracle12345";

    //NOTA1.2 Se crea el metodo llamado conectar, para que lo llamen otras instancias

    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    //NOTA 1.3 Seguimos creando el MODEL, especificamente DESTINO
}
