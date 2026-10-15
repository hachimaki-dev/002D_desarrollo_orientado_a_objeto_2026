package com.gallegos115.biblioapp;

import com.gallegos115.biblioapp.View.HomeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bibliotech extends Application{
    
    @Override
    public void start(Stage stage) {

        HomeView home_view = new HomeView();

        stage.setTitle("BiblioTech");
        stage.setScene(home_view.homeScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
