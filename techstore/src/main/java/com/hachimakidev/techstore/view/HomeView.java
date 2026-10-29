package com.hachimakidev.techstore.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HomeView {

    public Scene homeScene() {
        CatalogoView catalogo_view = new CatalogoView();
        VBox box_catalogo = catalogo_view.catalogo();
        Label lbl_titulo_superior = new Label("TechStore---Catalogo de Notebooks y smartphones");
        

        Scene home_scene = new Scene(box_catalogo, 820, 560);
        return home_scene;
    }
}

