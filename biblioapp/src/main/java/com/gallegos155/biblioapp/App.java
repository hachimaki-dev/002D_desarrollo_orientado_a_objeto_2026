package com.gallegos155.biblioapp;

import com.gallegos155.biblioapp.View.Homescene;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

 @Override
 public void start(Stage primaryStage) throws Exception {

    primaryStage.setScene(new Homescene().homeScene());
    primaryStage.show();
}
 public static void main(String[] args) {
    launch(args);
 }

}
