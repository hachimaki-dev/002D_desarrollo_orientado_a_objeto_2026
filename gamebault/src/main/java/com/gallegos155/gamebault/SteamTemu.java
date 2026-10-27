package com.gallegos155.gamebault;

import com.gallegos155.gamebault.View.HomeScene;

import javafx.application.Application;
import javafx.stage.Stage;

public class SteamTemu extends Application {
    
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        
        PrimaryStage.setScene(new HomeScene().steamtemu());
        PrimaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
