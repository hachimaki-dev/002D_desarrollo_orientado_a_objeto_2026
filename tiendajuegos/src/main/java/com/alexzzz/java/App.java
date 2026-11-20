package com.alexzzz.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label LBLTITULOCUESTIONARIO = new Label("FORMULARIO VIDEOJUEGO");
        LBLTITULOCUESTIONARIO.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        TextField txf_nombre_juego = new TextField();
        txf_nombre_juego.setPromptText("Ingrese el nombre de su juego");
        txf_nombre_juego.setPrefColumnCount(20);
        TextField txf_precio_juego = new TextField();
        txf_precio_juego.setPromptText("Ingrese el precio de su juego");
        txf_precio_juego.setPrefColumnCount(20);
        TextField txf_consola_juego = new TextField();
        txf_consola_juego.setPromptText("Ingrese el nombre de la consola compatible");
        txf_consola_juego.setPrefColumnCount(20);
        Button btn_insertar = new Button("Hazme click para insertar");
        Button btn_actualizar = new Button("Actualizar seleccionado");
        Button btn_eliminar = new Button("Eliminar seleccionado");

        // TODA CONEXION HACIA UNA DB REQUIERE 3 COSAS
        // 1. Requiere una CADENA DE CNX
        String ruta_conexion_db = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
        // 2. Requiere el usuario
        String nombre_de_usuario_db = "usuario_desarrollador";
        // 3. Es la password con la que autentico al usuario de la BD
        String password_de_la_db = "Oracle12345";

        // TABLEVIEW SIMPLE (cada fila es una lista de textos: [id, nombre, precio, consola])
        ObservableList<List<String>> filas_juegos = FXCollections.observableArrayList();
        TableView<List<String>> tabla_juegos = new TableView<>(filas_juegos);

        TableColumn<List<String>, String> col_id = new TableColumn<>("ID");
        col_id.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().get(0)));

        TableColumn<List<String>, String> col_nombre = new TableColumn<>("Nombre");
        col_nombre.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().get(1)));

        TableColumn<List<String>, String> col_precio = new TableColumn<>("Precio");
        col_precio.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().get(2)));

        TableColumn<List<String>, String> col_consola = new TableColumn<>("Consola");
        col_consola.setCellValueFactory(dato -> new SimpleStringProperty(dato.getValue().get(3)));

        tabla_juegos.getColumns().addAll(col_id, col_nombre, col_precio, col_consola);
        tabla_juegos.setPrefHeight(200);

        // Al seleccionar una fila en la tabla, pasa sus datos a los TextField para editarlos fácil
        tabla_juegos.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, filaSeleccionada) -> {
            if (filaSeleccionada != null) {
                txf_nombre_juego.setText(filaSeleccionada.get(1));
                txf_precio_juego.setText(filaSeleccionada.get(2));
                txf_consola_juego.setText(filaSeleccionada.get(3));
            }
        });


        btn_insertar.setOnAction(ev -> {
            String nombre_juego = txf_nombre_juego.getText();
            int precio_juego = Integer.parseInt(txf_precio_juego.getText());
            String consola_juego = txf_consola_juego.getText();
            try {

                Boolean se_logro = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).isValid(2);

                String sql_insertar = "INSERT INTO JUEGOS (nombre, precio, consola) VALUES ('" + nombre_juego + "', " + precio_juego + ", '" + consola_juego + "')";

                try {
                    DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db).prepareStatement(sql_insertar).executeUpdate();
                    System.out.println("Usuario Insertado");

                } catch (Exception ex) {
                    System.out.println("Hubo problemas para insertar el videojuego");
                }

            } catch (Exception e) {
                System.out.println("No me pude conectar a la base de datos");
            }
        });


        Button btn_todos_los_juegos = new Button("Hazme click para imprimir los juegos");

        btn_todos_los_juegos.setOnAction(eve -> {
            String sql = "SELECT * FROM JUEGOS ORDER BY id ASC";

            try (Connection conn = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db);
                 PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                filas_juegos.clear();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    int precio = rs.getInt("precio");
                    String consola = rs.getString("consola");
                    System.out.println(id + ". " + nombre + " $" + precio + ". Consola Compatible: " + consola);

                    filas_juegos.add(Arrays.asList(
                            String.valueOf(id),
                            nombre,
                            String.valueOf(precio),
                            consola
                    ));
                }

            } catch (Exception even) {
                System.out.println("No se pudo papito :(");
            }
        });


        btn_actualizar.setOnAction(ev -> {
            List<String> filaSeleccionada = tabla_juegos.getSelectionModel().getSelectedItem();
            if (filaSeleccionada == null) {
                System.out.println("Selecciona un juego en la tabla para actualizar");
                return;
            }

            int id_juego = Integer.parseInt(filaSeleccionada.get(0));
            String nombre_juego = txf_nombre_juego.getText();
            int precio_juego = Integer.parseInt(txf_precio_juego.getText());
            String consola_juego = txf_consola_juego.getText();

            String sql_actualizar = "UPDATE JUEGOS SET nombre = ?, precio = ?, consola = ? WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db);
                 PreparedStatement ps = conn.prepareStatement(sql_actualizar)) {

                ps.setString(1, nombre_juego);
                ps.setInt(2, precio_juego);
                ps.setString(3, consola_juego);
                ps.setInt(4, id_juego);
                ps.executeUpdate();
                System.out.println("Juego actualizado con ID: " + id_juego);
                btn_todos_los_juegos.fire();

            } catch (Exception e) {
                System.out.println("No se pudo actualizar el juego");
            }
        });


        btn_eliminar.setOnAction(ev -> {
            List<String> filaSeleccionada = tabla_juegos.getSelectionModel().getSelectedItem();
            if (filaSeleccionada == null) {
                System.out.println("Selecciona un juego en la tabla para eliminar");
                return;
            }

            int id_juego = Integer.parseInt(filaSeleccionada.get(0));
            String sql_eliminar = "DELETE FROM JUEGOS WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(ruta_conexion_db, nombre_de_usuario_db, password_de_la_db);
                 PreparedStatement ps = conn.prepareStatement(sql_eliminar)) {

                ps.setInt(1, id_juego);
                ps.executeUpdate();
                System.out.println("Juego eliminado con ID: " + id_juego);

                btn_todos_los_juegos.fire();

            } catch (Exception e) {
                System.out.println("No se pudo eliminar el juego");
            }
        });

        HBox HBOXPREGUNTASCUESTIONARIO = new HBox(15, txf_nombre_juego, txf_precio_juego, txf_consola_juego);
        HBOXPREGUNTASCUESTIONARIO.setAlignment(Pos.CENTER);

        HBox HBOXBOTONES = new HBox(15, btn_insertar, btn_todos_los_juegos, btn_actualizar, btn_eliminar);
        HBOXBOTONES.setAlignment(Pos.CENTER);

        VBox VBOXCUESTIONARIO = new VBox(15, LBLTITULOCUESTIONARIO, HBOXPREGUNTASCUESTIONARIO, HBOXBOTONES, tabla_juegos);
        VBOXCUESTIONARIO.setAlignment(Pos.CENTER);
        VBOXCUESTIONARIO.setPadding(new Insets(25));

        VBox VBOXMAIN = new VBox(VBOXCUESTIONARIO);

        Scene escena_main = new Scene(VBOXMAIN, 1050, 580);

        primaryStage.setScene(escena_main);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}