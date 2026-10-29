package com.hachimakidev.techstore.model.Dao;

import java.util.List;

import com.hachimakidev.techstore.model.Smartphone;

public interface SmartphoneDao {

    List<Smartphone> guardarTodos();
    void guardar(List<Smartphone> Smartphone);
    List<Smartphone> obtenerTodos();
    
} 
