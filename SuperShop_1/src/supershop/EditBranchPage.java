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
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Zahin
 */
public class EditBranchPage {
    public static void EditBranch(String mid) throws SQLException{
  Stage newCust = new Stage();
             GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        //root.setGridLinesVisible(true);
        
        Label ID=new Label("EMPLOYEE_ID");
        Label PB=new Label("PREVIOUS BRANCH");
        Label NB=new Label("NEW BRANCH");
        
        
        TextField IDV=new TextField();
        TextField PBV=new TextField();
        TextField NBV=new TextField();
        Button login=new Button("CHANGE");
        HBox loginContainer=new HBox();
        loginContainer.getChildren().addAll(login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
      //  Label warning=new Label();
        
        
        root1.add(ID, 0,0);
        root1.add(PB, 0,1);
        root1.add(NB, 0,2);
        root1.add(IDV, 1,0);
        root1.add(PBV, 1,1);
        root1.add(NBV, 1,2);       
        
        root1.add(loginContainer, 2,3);
        IDV.setOnAction(e1->{
      try {
          if(Query.ifEmployeeUnderManager(IDV.getText(), mid)==false){
              ErrorPage.Error("THIS EMPLOYEE IS NOT CURRENTLY WORKING UNDER YOU");
              IDV.clear(); 
          }
          else {
              
            PBV.setText(Query.getBranch(IDV.getText()));
          }
      } catch (SQLException ex) {
          Logger.getLogger(EditBranchPage.class.getName()).log(Level.SEVERE, null, ex);
      }
        });
        login.setOnAction(e1->{
      try {
          if(Query.ifEmployeeUnderManager(IDV.getText(), mid)==true){
           
              String newbranch = NBV.getText();
              try {
                  Query.updateBranch(IDV.getText(), PBV.getText(), NBV.getText());
                    ErrorPage.Error("CHANGE DONE");
                  newCust.close();
              } catch (ParseException ex) {
                  Logger.getLogger(EditBranchPage.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          else {
              ErrorPage.Error("THIS EMPLOYEE IS NOT CURRENTLY WORKING UNDER YOU");
              IDV.clear();
          }
           
      } catch (SQLException ex) {
          Logger.getLogger(NewCustomerPage.class.getName()).log(Level.SEVERE, null, ex);
      }
  
      
        });
       
             Scene newCusTScene = new Scene(root1,500,500) ;  
             newCusTScene.getStylesheets().add("startPageDesign.css");
             newCust.setScene(newCusTScene);
               newCust.show();
         
                }
}
