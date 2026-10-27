package com.gamevault;

import com.gamevault.View.GameVaultView;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene( new GameVaultView().gameVault() );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
