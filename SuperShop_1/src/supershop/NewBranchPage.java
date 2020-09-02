/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Zahin
 */
public class NewBranchPage {
    public static void NewBranch() throws SQLException{
  Stage newCust = new Stage();
             GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        //root.setGridLinesVisible(true);
        
        
        Label BranchAddress=new Label("ADDRESS");
        Label BranchPhoneNumber=new Label("PHONE NUMBER");
        Label BranchEmailID=new Label("EMAIL ID");
        
        
        
        TextField BranchAddressV=new TextField();
        TextField BranchPhoneNumberV=new TextField();
        TextField BranchEmailIDV=new TextField();
        Button login=new Button("SIGN UP");
        Button back = new Button ("CLOSE");
        HBox loginContainer=new HBox();
        loginContainer.getChildren().addAll(back,login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
     
        root1.add(BranchAddress, 0,1);
        root1.add(BranchPhoneNumber, 0,2);
        root1.add(BranchEmailID, 0,3);
        root1.add(BranchAddressV, 1,1);
        root1.add(BranchPhoneNumberV, 1,2);
        root1.add(BranchEmailIDV, 1,3);          
        
        root1.add(loginContainer, 2,4);
        login.setOnAction(e1->{
      try {
          Query.addBranch( BranchPhoneNumberV.getText(),BranchAddressV.getText(),BranchEmailIDV.getText());
          
          BranchAddressV.clear();
          BranchPhoneNumberV.clear();
          BranchEmailIDV.clear();
          
      } catch (SQLException ex) {
          Logger.getLogger(NewCustomerPage.class.getName()).log(Level.SEVERE, null, ex);
      }
  
      
        });
        back.setOnAction(e->{
            newCust.close();
        });
             Scene newCusTScene = new Scene(root1,500,500) ;  
             newCusTScene.getStylesheets().add("startPageDesign.css");
             newCust.setScene(newCusTScene);
               newCust.show();
         
                }
}
