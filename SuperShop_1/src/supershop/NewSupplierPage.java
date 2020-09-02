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
public class NewSupplierPage {
    public static void NewSupplier() throws SQLException{
  Stage newCust = new Stage();
             GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        //root.setGridLinesVisible(true);
        
        Label SuppName=new Label("NAME");
        Label SuppAddress=new Label("ADDRESS");
        Label SuppPhoneNumber=new Label("PHONE NUMBER");
        Label SuppEmailID=new Label("EMAIL ID");
        
        
        TextField SuppNameV=new TextField();
        TextField SuppAddressV=new TextField();
        TextField SuppPhoneNumberV=new TextField();
        TextField SuppEmailIDV=new TextField();
        Button login=new Button("Sign Up");
        HBox loginContainer=new HBox();
        loginContainer.getChildren().add(login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
      //  Label warning=new Label();
        
        
        root1.add(SuppName, 0,0);
        root1.add(SuppAddress, 0,1);
        root1.add(SuppPhoneNumber, 0,2);
        root1.add(SuppEmailID, 0,3);
        root1.add(SuppNameV, 1,0);
        root1.add(SuppAddressV, 1,1);
        root1.add(SuppPhoneNumberV, 1,2);
        root1.add(SuppEmailIDV, 1,3);          
        
        root1.add(loginContainer, 2,3);
        login.setOnAction(e1->{
         
      try {
          Query.addSupplier(SuppNameV.getText(), SuppPhoneNumberV.getText(),SuppAddressV.getText(),SuppEmailIDV.getText());
      } catch (SQLException ex) {
          Logger.getLogger(NewSupplierPage.class.getName()).log(Level.SEVERE, null, ex);
      }
            
        });
             Scene newCusTScene = new Scene(root1,500,500) ;  
             newCust.setScene(newCusTScene);
               newCust.show();
         
                }
}
