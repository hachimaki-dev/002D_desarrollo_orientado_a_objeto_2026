package com.surlodge.alexzzz.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.surlodge.alexzzz.Model.Alojamiento;
import com.surlodge.alexzzz.Model.Cabana;
import com.surlodge.alexzzz.Model.HabitacionHotel;
import com.surlodge.alexzzz.SQL.ConexionDB;

public class AlojamientoDAO {

    // NOTA 7.1: Método que trae todos los alojamientos desde Oracle ya mezclados con su ciudad,
    // ordenados según lo que pida la pantalla ("PRECIO_DESC", "NOMBRE_ASC" o precio ascendente por defecto).
    public List<Alojamiento> listarAlojamientos(String orden) throws SQLException {
        String orderBy;

        // NOTA 7.2: Validamos 'orden' con un if/else fijo en vez de meterlo directo como parámetro '?' en el SQL,
        // porque SQL no deja poner nombres de columna ni ASC/DESC con '?' y así evitamos inyección SQL o errores.
        if ("PRECIO_DESC".equalsIgnoreCase(orden)) {
            orderBy = "a.precio_noche DESC";
        } else if ("NOMBRE_ASC".equalsIgnoreCase(orden)) {
            orderBy = "a.nombre ASC";
        } else {
            // NOTA 7.3: Si llega cualquier otra cosa o viene vacío, ordena por precio de menor a mayor.
            orderBy = "a.precio_noche ASC";
        }

        // NOTA 7.4: Usamos alias ('a' para alojamientos y 'd' para destinos) y INNER JOIN para traer d.ciudad
        // usando id_destino = d.id, así en la tabla se ve el nombre de la ciudad y no solo un número.
        String sql = "SELECT a.id, a.tipo, a.nombre, a.precio_noche, a.id_destino, d.ciudad, " +
                     "a.piso, a.incluye_desayuno, a.capacidad, a.tiene_tinaja " +
                     "FROM alojamientos a " +
                     "INNER JOIN destinos d ON a.id_destino = d.id " +
                     "ORDER BY " + orderBy;

        // NOTA 7.5: Lista polimórfica de Alojamiento: acá caben tanto HabitacionHotel como Cabana.
        List<Alojamiento> lista = new ArrayList<>();

        // NOTA 7.6: try-with-resources abre la conexión, prepara el SQL y ejecuta la consulta;
        // al salir del bloque, Java cierra conn, ps y rs automáticamente para no dejar conexiones abiertas.
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // NOTA 7.7: rs.next() mueve el cursor a la siguiente fila devuelta por Oracle;
            // devuelve true mientras haya filas y false cuando ya no quedan más.
            while (rs.next()) {
                // NOTA 7.8: Leemos las columnas comunes que tienen tanto hoteles como cabañas.
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                String nombre = rs.getString("nombre");
                int precioNoche = rs.getInt("precio_noche");
                int idDestino = rs.getInt("id_destino");
                String ciudad = rs.getString("ciudad");

                // NOTA 7.9: Si el registro es un HOTEL, sacamos sus columnas propias (piso e incluye_desayuno).
                if ("HOTEL".equalsIgnoreCase(tipo)) {
                    int piso = rs.getInt("piso");
                    // NOTA 7.10: En Oracle incluye_desayuno es NUMBER(1) (1 o 0); compararlo con == 1 lo pasa a boolean.
                    boolean incluyeDesayuno = rs.getInt("incluye_desayuno") == 1;

                    // NOTA 7.11: Instanciamos HabitacionHotel respetando el orden de parámetros de tu constructor.
                    HabitacionHotel hotel = new HabitacionHotel(id, nombre, ciudad, idDestino, precioNoche, piso, incluyeDesayuno);
                    lista.add(hotel);

                // NOTA 7.12: Si el registro es una CABANA, sacamos sus columnas propias (capacidad y tiene_tinaja).
                } else if ("CABANA".equalsIgnoreCase(tipo)) {
                    int capacidad = rs.getInt("capacidad");
                    // NOTA 7.13: Igual que arriba, convertimos el 1/0 de Oracle a true/false.
                    boolean tieneTinaja = rs.getInt("tiene_tinaja") == 1;

                    // NOTA 7.14: Instanciamos Cabana respetando el orden exacto de su constructor.
                    Cabana cabana = new Cabana(id, nombre, ciudad, idDestino, precioNoche, capacidad, tieneTinaja);
                    lista.add(cabana);
                }
            }
        }

        // NOTA 7.15: Devolvemos la lista completa para que el controller la muestre en la TableView.
        return lista;
    }
}