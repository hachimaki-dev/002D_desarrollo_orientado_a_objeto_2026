package com.gallegos.steamtemu;

import com.gallegos.steamtemu.View.ViewSteamTemu;

import javafx.application.Application;
import javafx.stage.Stage;

public class SteamTemu extends Application {
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        PrimaryStage.setScene(new ViewSteamTemu().steamtemu());
        PrimaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
