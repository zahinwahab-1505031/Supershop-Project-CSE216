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
public class EditProfilePage {
     public static Parent EditProfile(Employee employee) throws SQLException{
     
        String id = employee.getEMPLOYEE_ID();
        String Name = employee.getNAME();
        String dob = employee.getDATE_OF_BIRTH();
        String add = employee.getADDRESS();
        String hd =employee.getHIRE_DATE();
       String sal = employee.getSALARY();
      String ssc = employee.getSSC();
      String hsc = employee.getHSC();
      String ug = employee.getHONORS();
      String grad = employee.getMASTERS();
      String pn = employee.getPHONE_NUMBER();
      String ma = employee.getEMAIL_ID();
      
        Stage epstage = new Stage();
        Button Done = new Button("DONE");
        GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
    
        Label EmpName=new Label("NAME");
        Label EmpDOB=new Label("DATE OF BIRTH");
        Label EmpAddress=new Label("ADDRESS");
        Label EmpPhoneNumber=new Label("PHONE NUMBER");
        Label EmpEmailID=new Label("EMAIL ID");
        Label EmpSSC=new Label("SSC SCORE");
        Label EmpHSC=new Label("HSC SCORE");
        Label EmpUG=new Label("HONORS RESULT");
        Label EmpMasters=new Label("MASTERS RESULT");
        
        
        TextField EmpNameV=new TextField();
        TextField EmpDOBV=new TextField();
        EmpDOBV.setEditable(false);
        TextField EmpAddressV=new TextField();
        TextField EmpPhoneNumberV=new TextField();
        TextField EmpEmailIDV=new TextField();
        TextField EmpSSCV=new TextField();
        EmpSSCV.setEditable(false);
        
        TextField EmpHSCV=new TextField();
        EmpHSCV.setEditable(false);
        TextField EmpUGV=new TextField();
        EmpUGV.setEditable(false);
        TextField EmpMastersV=new TextField();
        EmpMastersV.setEditable(false);
        
         EmpNameV.setText(Name);
         EmpDOBV.setText(dob);
         EmpAddressV.setText(add);
         EmpPhoneNumberV.setText(pn);
         EmpEmailIDV.setText(ma);
         EmpSSCV.setText(ssc);
         EmpHSCV.setText(hsc);
         EmpUGV.setText(ug);
         EmpMastersV.setText(grad);
//     
        
        
        root1.add(EmpName, 0,0);
        root1.add(EmpDOB, 0,1);
        root1.add(EmpAddress, 0,2);
        root1.add(EmpPhoneNumber, 0,3);
        root1.add(EmpEmailID,0,4);
        root1.add(EmpSSC, 0,5);
        root1.add(EmpHSC, 0,6);
        root1.add(EmpMasters, 0,8);
        root1.add(EmpUG,0,7);
        
        root1.add(EmpNameV, 1,0);
        root1.add(EmpDOBV, 1,1);
        root1.add(EmpAddressV, 1,2);
        root1.add(EmpPhoneNumberV, 1,3); 
        root1.add(EmpEmailIDV, 1,4);
        root1.add(EmpSSCV, 1,5);
        root1.add(EmpHSCV, 1,6);
        root1.add(EmpMastersV, 1,8);
        root1.add(EmpUGV,1,7);
        root1.add(Done, 3,10);
    
           
        Done.setOnAction(e->{
            try {

                System.out.println("done clicked");
            Query.updateInfo(id,EmpNameV.getText(), EmpAddressV.getText(),EmpPhoneNumberV.getText(), EmpEmailIDV.getText());
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
