package com.gamevault.view;

import com.gamevault.controller.UsuarioController;
import com.gamevault.model.Usuario;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameVaultView {

    UsuarioController controller = new UsuarioController();

    public Scene gameVaultScene() {

        Label lbl_user_rut = new Label("Rut: ");
        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("Ejemplo: 11.111.111-1");
        Button btn_user_rut = new Button("Buscar");
        HBox hbox_user_rut = new HBox(5, lbl_user_rut, txf_user_rut, btn_user_rut);

        Label lbl_rut = new Label("RUT: ");
        Label lbl_socio = new Label("Socio: ");
        Label lbl_nivel = new Label("Nivel: ");
        Label lbl_email = new Label("Email: ");

        btn_user_rut.setOnAction(e -> {
            lbl_rut.setText("RUT: -");
            lbl_socio.setText("Socio: -");
            lbl_nivel.setText("Nivel: -");
            lbl_email.setText("Email: -");

            String rut_ingresado = txf_user_rut.getText();
            Usuario usuario = controller.buscarPorRut(rut_ingresado);

            if (usuario != null) {
                lbl_rut.setText("RUT: " + usuario.getRut());
                lbl_socio.setText("Socio: " + usuario.getNombre());
                lbl_nivel.setText("Nivel: " + usuario.getNivelGamer());
                lbl_email.setText("Email: " + usuario.getEmail());

            }
        });

        VBox vbox_consulta_socio = new VBox(5, hbox_user_rut, lbl_rut, lbl_socio, lbl_nivel, lbl_email);

        VBox main = new VBox(15, vbox_consulta_socio);
        main.setPadding(new Insets(20));

        Scene scene = new Scene(main, 720, 480);

        return scene;
    }

}
