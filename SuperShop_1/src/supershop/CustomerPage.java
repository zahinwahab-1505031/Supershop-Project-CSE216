/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Zahin
 */
public class CustomerPage {

    public static void Customer(String empID,Stage stage) throws SQLException {
        Button back = new Button("BACK");
           GridPane profileRoot = new GridPane();
        profileRoot.setAlignment(Pos.CENTER_LEFT);
        profileRoot.setHgap(10);
        profileRoot.setVgap(10);
        ImageView dp = new ImageView();
        Image im = new Image("dummy-profile-pic.png");
           
            dp.setImage(im);
             dp.setFitWidth(200);
            dp.setFitHeight(200);
        HBox finalroot = new HBox();
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setHgap(10);
        root.setVgap(10);
        HBox finalHB = new HBox();
        finalHB.setSpacing(20);
        Button btn = new Button("EDIT PROFILE");
        Button btn1 = new Button("BUY PRODUCTS");
        Button btn2 = new Button("LOG OUT");
        btn.setPrefSize(300,70);
        btn1.setPrefSize(300,70);
        btn2.setPrefSize(300,70);
        root.add(btn, 0, 1);
        root.add(btn1, 0, 3);
        root.add(btn2, 0, 6);
        
        profileRoot.add(dp,0,0);
        VBox grp1 = new VBox();
        grp1.setPadding(new Insets(100,100,100,50));
       // String empID = Query.rs.getString("REG_CUS_ID");
      //  String name = Query.rs.getString("NAME");
        Button ID = new Button(empID);
        ID.setPrefSize(200,30);
        profileRoot.add(ID, 0, 1);
        VBox grp2 = new VBox();
        VBox grp3 = new VBox(); 
        VBox grp4 = new VBox(); 
        VBox grp5 = new VBox(); 
         VBox grp6 = new VBox(); 
        grp2.setPadding(new Insets(100,100,100,50));
        grp3.setPadding(new Insets(100,100,100,10));
        grp4.setPadding(new Insets(100,100,100,10));
        grp5.setPadding(new Insets(100,100,100,10));
        grp6.setPadding(new Insets(100,100,100,50));
        finalroot.setSpacing(10);
        finalroot.setPrefSize(1000,1000);
               Customer customer = Query.getCustomerInfo(empID);
                SeeCustProfilePage.SeeCustProfile(customer);
      grp6.getChildren().add(SeeCustProfilePage.SeeCustProfile(customer));
        finalroot.getChildren().addAll(profileRoot,grp6);
        finalHB.getChildren().addAll(finalroot,root);
       
        btn.setOnAction((ActionEvent e) -> {
            try {
               
         grp1.getChildren().clear();
grp2.getChildren().clear();
grp3.getChildren().clear();
grp4.getChildren().clear();
finalroot.getChildren().remove(grp1);
finalroot.getChildren().remove(grp2);
finalroot.getChildren().remove(grp3);
finalroot.getChildren().remove(grp4); 

grp5.getChildren().clear();
finalroot.getChildren().remove(grp5); 
grp6.getChildren().clear();
finalroot.getChildren().remove(grp6); 
                         Customer cust = Query.getCustomerInfo(empID);
                EditCustProfilePage.EditCustProfile(cust);
      grp1.getChildren().add( EditCustProfilePage.EditCustProfile(cust));
        
         finalroot.getChildren().add(grp1);

            } catch (SQLException ex) {

            }
        }
        );
        
    btn1.setOnAction((ActionEvent e) -> {
            try {
               
         grp1.getChildren().clear();
grp2.getChildren().clear();
grp3.getChildren().clear();
grp4.getChildren().clear();
finalroot.getChildren().remove(grp1);
finalroot.getChildren().remove(grp2);
finalroot.getChildren().remove(grp3);
finalroot.getChildren().remove(grp4); 

grp5.getChildren().clear();
finalroot.getChildren().remove(grp5); 
grp6.getChildren().clear();
finalroot.getChildren().remove(grp6); 
                //         Customer cust = Query.getCustomerInfo(empID);
              //  EditCustProfilePage.EditCustProfile(cust);
     Product_Loader.ProductShow(ID.getText(),stage);

            } catch (SQLException ex) {

            }  catch (IOException ex) {
                   Logger.getLogger(CustomerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        );
                 
        
           
        btn2.setOnAction(e -> {
            stage.close();
        }
        );
   
        Scene scene = new Scene(finalHB,1000,1000);
      scene.getStylesheets().add("startPageDesign.css");
      finalHB.getStylesheets().add("my-root1"); 
        stage.setScene(scene);
        stage.setTitle("MANAGER");
        stage.show();

    }
}
