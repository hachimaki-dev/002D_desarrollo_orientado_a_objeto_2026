package com.hachimakidev.biblioapp.controller;

import com.hachimakidev.biblioapp.model.MaterialManager;

public class MaterialController {
    

    public void verMateriales(){
        MaterialManager materialManager = new MaterialManager();
        materialManager.verificarMaterial();
    }
}
