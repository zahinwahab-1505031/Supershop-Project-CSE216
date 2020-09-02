/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.text.ParseException;
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

/**
 *
 * @author Zahin
 */
public class AssignBranchPage {
    public static void AssignBranch() throws SQLException{
  Stage newCust = new Stage();
             GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        //root.setGridLinesVisible(true);
        
        Label ID=new Label("EMPLOYEE_ID");
        Label NB=new Label("NEW BRANCH");
        
        
        TextField IDV=new TextField();
        TextField PBV=new TextField();
        TextField NBV=new TextField();
        Button login=new Button("ASSIGN");
        HBox loginContainer=new HBox();
        loginContainer.getChildren().addAll(login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
      //  Label warning=new Label();
        
        
        root1.add(ID, 0,0);
        root1.add(NB, 0,1);
        root1.add(IDV, 1,0);
        root1.add(NBV, 1,1);       
        
        root1.add(loginContainer, 2,3);
       
     
        login.setOnAction(e1->{
      try {
        if(Query.getBranch(IDV.getText())!=null) {
            ErrorPage.Error("This employee has a branch assigned already");
            IDV.clear();
            NBV.clear();
        } 
        else {
            Query.assignBranch(IDV.getText(), NBV.getText());
        }
           
      } catch (SQLException ex) {
          Logger.getLogger(NewCustomerPage.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ParseException ex) {
          Logger.getLogger(AssignBranchPage.class.getName()).log(Level.SEVERE, null, ex);
      }
  
      
        });
       
             Scene newCusTScene = new Scene(root1,500,500) ;  
             newCusTScene.getStylesheets().add("startPageDesign.css");
             newCust.setScene(newCusTScene);
               newCust.show();
         
                }
}
