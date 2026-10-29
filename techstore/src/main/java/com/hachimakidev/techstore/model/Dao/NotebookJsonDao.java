package com.hachimakidev.techstore.model.Dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hachimakidev.techstore.model.Notebook;

public class NotebookJsonDao implements NotebookDao {

    private final String archivo = "Notebook.json";
    private final Gson gson = new Gson();

    @Override 
    public List<Notebook> obtenerTodos(){

        File file = new File(archivo);
        if(!file.exists()){return new ArrayList<>();}
        try(FileReader reader = new FileReader(file)){
            Type tipo = new TypeToken<ArrayList<Notebook>>() {}.getType();
            List<Notebook> lista = gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch ( IOException e) {System.out.println("Error al leer Notebookc." + e.getMessage()); return new ArrayList<>();}
    }

        @Override 
        public void guardar(List<Notebook> notebook){
            try(FileWriter writer = new FileWriter(archivo)){
                gson.toJson(notebook, writer);
            }catch (IOException e) {System.out.println("Error al guardar Notebooks." + e.getMessage());
        } 
    }
    
}
