package com.surlodge.alexzzz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.surlodge.alexzzz.Model.Destino;
import com.surlodge.alexzzz.SQL.ConexionDB;

public class DestinoDAO {
    //NOTA 6.1: Devuelve la lista de destinos desde Oracle para llenar el ComboBox.
    public List<Destino> listarDestinos() throws SQLException {
        //NOTA 6.2: SQL ordenado por ciudad para mostrarlo ordenado en la interfaz.
        String sql = "SELECT id, ciudad, region FROM destinos ORDER BY ciudad ASC";
        //NOTA 6.3: Lista donde guardaremos cada fila convertida en objeto Destino.
        List<Destino> destinos = new ArrayList<>();

        //NOTA 6.4: try-with-resources cierra conn, ps y rs solos al terminar.
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            //NOTA 6.5: rs.next() avanza fila por fila mientras haya registros.
            while (rs.next()) {
                int id = rs.getInt("id");
                String ciudad = rs.getString("ciudad");
                String region = rs.getString("region");

                // NOTA 6.6: Respetamos el orden (id, ciudad, region) del constructor de Destino.
                Destino destino = new Destino(id, ciudad, region);
                destinos.add(destino);
            }
        }

        //NOTA 6.7: Retornamos la lista cargada (vacía si no había filas, nunca recursivo).
        return destinos;
    }
}