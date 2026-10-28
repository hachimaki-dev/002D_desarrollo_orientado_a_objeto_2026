package com.gamevault;

import com.gamevault.view.GameVaultView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instancia y ejecuta la vista de GameVault
        GameVaultView view = new GameVaultView();
        view.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args); // Ahora sí reconoce launch()
    }
}