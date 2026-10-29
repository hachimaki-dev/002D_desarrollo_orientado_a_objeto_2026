package com.gamevault;

import com.gamevault.controller.UsuarioController;
import com.gamevault.dao.UsuarioDAO;
import com.gamevault.dao.UsuarioJsonDAO;
import com.gamevault.repository.UsuarioRepository;
import com.gamevault.view.GameVaultView;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        UsuarioDAO dao = new UsuarioJsonDAO("/usuarios.json");
        UsuarioRepository repositorio = new UsuarioRepository(dao);
        UsuarioController controller = new UsuarioController(repositorio);

        primaryStage.setScene(new GameVaultView(controller).gameVaultScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
