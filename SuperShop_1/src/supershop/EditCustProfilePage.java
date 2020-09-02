/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Zahin
 */
public class EditCustProfilePage {
     public static Parent EditCustProfile(Customer customer) throws SQLException{
     
        String id = customer.getREG_CUS_ID();
        String Name = customer.getNAME();
        String add = customer.getADDRESS();
      String pn = customer.getPHONE_NUMBER();
      String ma = customer.getEMAIL_ID();
      String points = customer.getPOINTS();
      String pass = customer.getPASSWORD();
      
      
        Stage epstage = new Stage();
        Button Done = new Button("DONE");
        GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
    
        Label CustName=new Label("NAME");
        Label CustAddress=new Label("ADDRESS");
        Label CustPhoneNumber=new Label("PHONE NUMBER");
        Label CustEmailID=new Label("EMAIL ID");
        Label CustPoints=new Label("POINTS");
        Label CustPassword=new Label("PASSWORD");
        
        
        TextField CustNameV=new TextField();
        TextField CustAddressV=new TextField();
        TextField CustPhoneNumberV=new TextField();
        TextField CustEmailIDV=new TextField();
        TextField CustPointsV = new TextField();
        CustPointsV.setEditable(false);
          TextField CustPasswordV = new TextField();
        
         CustNameV.setText(Name);
         CustAddressV.setText(add);
         CustPhoneNumberV.setText(pn);
         CustEmailIDV.setText(ma);
   CustPointsV.setText(points);
   CustPasswordV.setText(pass);
        
        
        root1.add(CustName, 0,0);
        root1.add(CustAddress, 0,2);
        root1.add(CustPhoneNumber, 0,3);
        root1.add(CustEmailID,0,4);
        root1.add(CustPoints,0,5);
        root1.add(CustPassword,0,6);
        root1.add(CustNameV, 1,0);
        root1.add(CustAddressV, 1,2);
        root1.add(CustPhoneNumberV, 1,3); 
        root1.add(CustEmailIDV, 1,4);
          root1.add(CustPointsV,1,5);
        root1.add(CustPasswordV,1,6);
        root1.add(Done, 3,10);
        
        
        String gen = customer.getGENDER();
        String dob = customer.getDATEOFBIRTH();
        String occ = customer.getOCCUPATION();
        
        Label CustGender = new Label("GENDER");
        Label CustDOB=new Label("DATE OF BIRTH");
        Label CustOccupation=new Label("OCCUPATION");
        
        TextField CustGenderV = new TextField();
        CustGenderV.setText(gen);
        TextField CustDOBV=new TextField();
        CustDOBV.setText(dob);
        TextField CustOccupationV=new TextField();
        CustOccupationV.setText(occ);
        
         root1.add(CustGender,0,7);
        root1.add(CustDOB,0,8);
        root1.add(CustOccupation,0,9);
    
           root1.add(CustGenderV,1,7);
        root1.add(CustDOBV,1,8);
        root1.add(CustOccupationV,1,9);
        
           
        Done.setOnAction(e->{
            try {

                System.out.println("done clicked");
            Query.updateCustInfo(id,CustNameV.getText(), CustAddressV.getText(),CustPhoneNumberV.getText(), CustEmailIDV.getText(),CustPasswordV.getText());
                System.out.println("done done");


            

            } catch (SQLException ex) {
          //      Logger.getLogger(SuperShop.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
        });
        Scene epscene=new Scene(root1,800,800);     
        epscene.getStylesheets().add("startPageDesign.css");
   //     root1.getStyleClass().add("my-root1");  
        return root1;
//        epstage.setScene(epscene);        
//        epstage.setTitle("EDIT PROFILE");        
//        epstage.show();
//        
        
        
    }
}

    
