/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Zahin
 */
public class ErrorPage {
    public static void Error(String error){
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        Label Warning = new Label(error);
      DropShadow borderGlow = new DropShadow();
borderGlow.setColor(Color.RED);
borderGlow.setOffsetX(0f);
borderGlow.setOffsetY(0f);
borderGlow.setWidth(100);
borderGlow.setHeight(100);

        Stage stage= new Stage();
        Button btn = new Button("CANCEL");
        btn.setEffect(borderGlow);
        root.add(Warning, 0, 0);
        root.add(btn, 0, 1);
        btn.setOnAction(e->{
            stage.close();
        });
         Scene scene=new Scene(root,400,400);  
        scene.getStylesheets().add("startPageDesign.css");

          root.getStyleClass().add("my-root"); 
          btn.getStyleClass().add("my-button1");
        stage.setScene(scene);            
        stage.show();
    }
}
