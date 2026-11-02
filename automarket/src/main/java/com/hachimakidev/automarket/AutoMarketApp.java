package com.hachimakidev.automarket;

import com.hachimakidev.automarket.view.HomeView;

import javafx.application.Application;
import javafx.stage.Stage;

public class AutoMarketApp extends Application {

    @Override
    public void start(Stage stage) {
        HomeView home_view = new HomeView();

        stage.setTitle("AutoMarket — Inventario de Vehículos");
        stage.setScene(home_view.homeScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

