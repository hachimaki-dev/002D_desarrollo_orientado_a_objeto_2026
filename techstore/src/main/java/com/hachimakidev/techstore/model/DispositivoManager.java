package com.hachimakidev.techstore.model;

import java.util.List;

import com.hachimakidev.techstore.model.Dao.NotebookDao;
import com.hachimakidev.techstore.model.Dao.NotebookJsonDao;
import com.hachimakidev.techstore.model.Dao.SmartPhoneJsonDao;
import com.hachimakidev.techstore.model.Dao.SmartphoneDao;

public class DispositivoManager {

    private List<Notebook> notebooks;
    private List<Smartphone> smartphones;

    private NotebookDao notebookDao;
    private SmartphoneDao smartphoneDao;

    public DispositivoManager(){
        this.notebookDao = new NotebookJsonDao();
        this.smartphoneDao = new SmartPhoneJsonDao();
        cargarDatos();
    }

    public void agregarNotebook(Notebook notebook){
        Notebook.add(notebook);
    }

    public void agregarSmartphone(Smartphone smartphone){
        Smartphone.add(smartphone);
    }

    public List<Notebook> getNotebooks(){
        return notebooks;
    }

    public List<Smartphone> gSmartphones(){
        return smartphones;
    }

    public void guardarDatos(){
        notebookDao.guardar(notebooks);
        smartphoneDao.guardar(smartphones);
    }

    public void cargarDatos(){
        this.notebooks = notebookDao.obtenerTodos();
        this.smartphones = smartphoneDao.obtenerTodos();
    }

}