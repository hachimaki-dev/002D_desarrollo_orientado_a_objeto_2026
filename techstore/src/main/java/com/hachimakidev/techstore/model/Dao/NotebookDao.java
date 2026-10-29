package com.hachimakidev.techstore.model.Dao;

import java.util.List;

import com.hachimakidev.techstore.model.Notebook;

public interface NotebookDao {
    List<Notebook> obtenerTodos();
    void guardar(List<Notebook> notebook);

} 
