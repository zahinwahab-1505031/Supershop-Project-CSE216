/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
public class SignUpPage {
    
    

    public static void SignUp(Stage stage) throws SQLException{
  
        
        Stage newEmp = new Stage();
        GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        ObservableList<String> options = 
    FXCollections.observableArrayList(
        "MANAGER", "SALESMAN", "CASHIER","SWEEPER","SECURITY GUARD"
    );
final ComboBox comboBox = new ComboBox(options);
comboBox.setPromptText("JOB TYPE");
        Label EmpName=new Label("NAME");
        Label EmpDOB=new Label("DATE OF BIRTH");
        Label EmpAddress=new Label("ADDRESS");
        Label EmpPhoneNumber=new Label("PHONE NUMBER");
        Label EmpEmailID=new Label("EMAIL ID");
        Label EmpSSC=new Label("SSC SCORE");
        Label EmpHSC=new Label("HSC SCORE");
        Label EmpUG=new Label("HONORS RESULT");
        Label EmpMasters=new Label("MASTERS RESULT");
        Label EmpPassword = new Label("PASSWORD");
        Label EmpConfirmPassword = new Label("CONFIRM PASSWORD");
        
        TextField EmpNameV=new TextField();
          final DatePicker EmpDOBV = new DatePicker();
        TextField EmpAddressV=new TextField();
        TextField EmpPhoneNumberV=new TextField();
        TextField EmpEmailIDV=new TextField();
        TextField EmpSSCV=new TextField();;
        TextField EmpHSCV=new TextField();;
        TextField EmpUGV=new TextField();;
        TextField EmpMastersV=new TextField();
        PasswordField EmpPasswordV = new PasswordField();
        PasswordField EmpConfirmPasswordV = new PasswordField();
        
        Button login=new Button("SIGN UP");
        Button back = new Button("BACK");
        HBox loginContainer=new HBox();
        loginContainer.setSpacing(10);
        loginContainer.getChildren().addAll(back,login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
      //  Label warning=new Label();
        
        
        root1.add(EmpName, 0,0);
        root1.add(EmpDOB, 0,1);
        root1.add(EmpAddress, 0,2);
        root1.add(EmpPhoneNumber, 0,3);
        root1.add(EmpEmailID,0,4);
        root1.add(EmpSSC, 0,5);
        root1.add(EmpHSC, 0,6);
        root1.add(EmpMasters, 0,8);
        root1.add(EmpUG,0,7);
        root1.add(EmpPassword, 0,9);
        root1.add(EmpConfirmPassword,0,10);
        root1.add(comboBox,1,11); 
        
        root1.add(EmpNameV, 1,0);
        root1.add(EmpDOBV, 1,1);
        root1.add(EmpAddressV, 1,2);
        root1.add(EmpPhoneNumberV, 1,3); 
        root1.add(EmpEmailIDV, 1,4);
        root1.add(EmpSSCV, 1,5);
        root1.add(EmpHSCV, 1,6);
        root1.add(EmpMastersV, 1,8);
        root1.add(EmpUGV,1,7);
        root1.add(EmpPasswordV, 1,9);
        root1.add(EmpConfirmPasswordV,1,10);
        root1.add(loginContainer, 3,12);
        login.setOnAction(e1->{
            try{ 
                if(EmpPasswordV.getText().equals(EmpConfirmPasswordV.getText())==false){
                    ErrorPage.Error("Passwords don't match");
                    EmpPasswordV.clear();
                    EmpConfirmPasswordV.clear();
                }
                else if(comboBox.getValue()==null){
                    ErrorPage.Error("Please specify a job type"); 
                }
                else{
              String jobtype = (String) comboBox.getValue();
                System.out.println(jobtype);
              String jobID=null;
              if(jobtype.equals("MANAGER")==true) {
                  jobID = "100";
                  }
              else if(jobtype.equals("SALESMAN")==true){
                  jobID = "200";
                  }
              else if(jobtype.equals("CASHIER")==true){
                   jobID = "300";
                  }
              else if(jobtype.equals("SWEEPER")==true){
                 jobID = "400";
                   }
              else if(jobtype.equals("SECURITY GUARD")==true){
                jobID = "500";
                 
              }
                  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.US);
String formattedValue = (EmpDOBV.getValue()).format(formatter);
        int k =   Query.signUp( jobID ,    EmpNameV.getText()   ,   formattedValue  ,   EmpAddressV.getText()  ,   EmpPhoneNumberV.getText()   ,   EmpEmailIDV.getText()   ,   EmpSSCV.getText()   ,    EmpHSCV.getText()  ,    EmpUGV.getText()  ,   EmpMastersV.getText() ,EmpPasswordV.getText()  );
      if(k>0)    newEmp.close();
                }
            }catch(Exception e2){
                
            }
   
        }
        );
        back.setOnAction(e->{
            newEmp.close();
            OptionPage.Option(stage);
        });
            Scene newEmpScene = new Scene(root1,500,500) ; 
            newEmpScene.getStylesheets().add("startPageDesign.css");
            root1.getStyleClass().add("my-root1"); 
            newEmp.setScene(newEmpScene);
            newEmp.setTitle("SIGN UP");
            newEmp.show();
         }
}


