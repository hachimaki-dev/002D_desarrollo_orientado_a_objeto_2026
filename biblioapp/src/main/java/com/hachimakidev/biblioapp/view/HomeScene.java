package com.hachimakidev.biblioapp.view;

import com.hachimakidev.biblioapp.controller.UserController;
import com.hachimakidev.biblioapp.model.User;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScene {
  
    public Scene homeScene(){
        
        Label lbl_user_rut = new Label("Rut: ");

        TextField txf_user_rut = new TextField();
        txf_user_rut.setPromptText("ej: 11.111.111-1");

        Button btn_user_search = new Button("Buscar ♥");

        HBox hbox_user_search = new HBox(10, lbl_user_rut, txf_user_rut, btn_user_search);

        Label lbl_user_data_rut =  new Label("Rut: ________");
        Label lbl_user_data_nombre =  new Label("Nombre: ________");
        Label lbl_user_data_email =  new Label("Email: ________");
        Label lbl_user_data_edad =  new Label("Edad: ________");
        Label lbl_user_data_puede_pedir =  new Label("Puede solicitar libros?: ________");

        VBox vbox_user_data = new VBox(5, lbl_user_data_rut, lbl_user_data_nombre, lbl_user_data_email, lbl_user_data_edad, lbl_user_data_puede_pedir);


        VBox main = new VBox(10,hbox_user_search, vbox_user_data);

        Scene home_scene = new Scene(main, 720, 480);


        btn_user_search.setOnAction(e -> {
            UserController userController = new UserController();

            String rut_textfield = txf_user_rut.getText();

            User usuario_encontrado = userController.solicitarUsuarioPorRut(rut_textfield);

            String usuario_nombre = usuario_encontrado.getNombre();

            String usuario_rut = usuario_encontrado.getRut();

            String usuario_correo = usuario_encontrado.getEmail();

            int usuario_edad = usuario_encontrado.getEdad();

            boolean usuario_puede_pedir = usuario_encontrado.isPuede_solicitar_prestamos();

            lbl_user_data_nombre.setText("Nombre: " + usuario_nombre);

            lbl_user_data_rut.setText("Rut: " + usuario_rut);

            lbl_user_data_email.setText("Email: " + usuario_correo);

            lbl_user_data_edad.setText("Edad: " + usuario_edad + "");

            lbl_user_data_puede_pedir.setText("Puede solicitar libros?: " + usuario_puede_pedir + "");
        });


        return home_scene;

    }    

}
