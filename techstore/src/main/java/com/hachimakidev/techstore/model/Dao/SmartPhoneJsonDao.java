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
import com.hachimakidev.techstore.model.Smartphone;

public class SmartPhoneJsonDao implements SmartphoneDao {

    private final String archivo = "Smartphone.json";
    private final Gson gson = new Gson();

    @Override 
    public List<Smartphone> obtenerTodos(){

        File file = new File(archivo);
        if(!file.exists()){return new ArrayList<>();}
        try(FileReader reader = new FileReader(file)){
            Type tipo = new TypeToken<ArrayList<Smartphone>>() {}.getType();
            List<Smartphone> lista = gson.fromJson(reader, tipo);
            return lista != null ? lista : new ArrayList<>();
        } catch ( IOException e) {System.out.println("Error al leer Smartphone." + e.getMessage()); return new ArrayList<>();}
    }

        @Override 
        public void guardar(List<Smartphone> Smartphone){
            try(FileWriter writer = new FileWriter(archivo)){
                gson.toJson(Smartphone, writer);
            }catch (IOException e) {System.out.println("Error al guardar Smartphone." + e.getMessage());
        } 
    }

        @Override
        public List<Smartphone> guardarTodos() {
            throw new UnsupportedOperationException("Unimplemented method 'guardarTodos'");
        }
    
}
