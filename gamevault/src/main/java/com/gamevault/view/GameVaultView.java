package com.gamevault.view;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class GameVaultView{
        public Scene GameVaultView(){
          TextField txf_user_rut = new TextField();
             
          VBox main = new VBox(5,txf_user_rut);
          Scene GameVaultView = new Scene(main,720, 360);
          return GameVaultView;  
        }
   
}
