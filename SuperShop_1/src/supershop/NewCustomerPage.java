/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
public class NewCustomerPage {
    public static void NewCustomer() throws SQLException{
  Stage newCust = new Stage();
             GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        //root.setGridLinesVisible(true);
        ChoiceBox CustomerGenderV = new ChoiceBox(FXCollections.observableArrayList("MALE","FEMALE","NO GENDER"));
	
        Label CustomerName=new Label("NAME");
        Label CustomerAddress=new Label("ADDRESS");
        Label CustomerPhoneNumber=new Label("PHONE NUMBER");
        Label CustomerEmailID=new Label("EMAIL ID");
        Label CustomerGender=new Label("GENDER");
        Label CustomerDateOfBirth=new Label("DATE OF BIRTH");
        Label CustomerOccupation=new Label("OCCUPATION");
        
        TextField CustomerNameV=new TextField();
        TextField CustomerAddressV=new TextField();
        TextField CustomerPhoneNumberV=new TextField();
        TextField CustomerEmailIDV=new TextField();
          final DatePicker CustomerDateOfBirthV = new DatePicker();
        TextField CustomerOccupationV =new TextField();
        Button login=new Button("SIGN UP");
        Button back = new Button ("BACK");
        HBox loginContainer=new HBox();
        loginContainer.getChildren().addAll(back,login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
      //  Label warning=new Label();
        
        
        root1.add(CustomerName, 0,0);
        root1.add(CustomerAddress, 0,1);
        root1.add(CustomerPhoneNumber, 0,2);
        root1.add(CustomerEmailID, 0,3);
          root1.add(CustomerGender, 0,4);
        root1.add(CustomerDateOfBirth, 0,5);
        root1.add(CustomerOccupation, 0,6);
        root1.add(CustomerNameV, 1,0);
        root1.add(CustomerAddressV, 1,1);
        root1.add(CustomerPhoneNumberV, 1,2);
        root1.add(CustomerEmailIDV, 1,3); 
        
             root1.add(CustomerGenderV, 1,4);
        root1.add(CustomerDateOfBirthV, 1,5);
        root1.add(CustomerOccupationV, 1,6);
        
        root1.add(loginContainer, 3,7);
        login.setOnAction(e1->{
      try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.US);
String formattedValue = (CustomerDateOfBirthV.getValue()).format(formatter);
          Query.addCustomer(CustomerNameV.getText(), CustomerPhoneNumberV.getText(),CustomerAddressV.getText(),CustomerEmailIDV.getText(),(String)CustomerGenderV.getValue(),formattedValue,CustomerOccupationV.getText());
              CustomerNameV.clear();
          CustomerAddressV.clear();
          CustomerPhoneNumberV.clear();
          CustomerEmailIDV.clear();
          CustomerOccupationV.clear();
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
