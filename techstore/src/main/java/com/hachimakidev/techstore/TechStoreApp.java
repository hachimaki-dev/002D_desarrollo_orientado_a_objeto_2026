package com.hachimakidev.techstore;

import com.hachimakidev.techstore.view.HomeView;

import javafx.application.Application;
import javafx.stage.Stage;

public class TechStoreApp extends Application {

    @Override
    public void start(Stage stage) {
        HomeView home_view = new HomeView();

        stage.setTitle("TechStore — Inventario de Dispositivos");
        stage.setScene(home_view.homeScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
