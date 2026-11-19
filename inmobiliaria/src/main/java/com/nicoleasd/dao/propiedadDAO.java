package com.nicoleasd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nicoleasd.database.ConexionDB;
import com.nicoleasd.model.Propiedad;

public class propiedadDAO {

    public boolean guardar(Propiedad propiedad){
        String sql = "INSERT INTO propiedades (tipo, direccion, arriendo_base, metros_cuadrados) VALUES (?, ?, ?, ?)";
    
        try (Connection conn = ConexionDB.obtenerConexion();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, propiedad.getTipo());
            ps.setString(2, propiedad.getDireccion());
            ps.setInt(3, propiedad.getArriendoBase());
            ps.setInt(4, propiedad.getArriendoBase());

            



        } catch (Exception e) {
            // TODO: handle exception
        }

    
    }

}
