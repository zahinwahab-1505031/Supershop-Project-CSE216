/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

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
public class ManagerPage {

    public static void Manager(Stage stage) throws SQLException {
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
        Button btn01 = new Button("EMPLOYEES");
        Button btn1 = new Button("PENDING EMPLOYEES");
        Button btn11 = new Button("OUT OF STOCK PRODUCTS");
        Button btn12 = new Button("PROFIT LOSS REPORT");
        Button btn2 = new Button("LOG OUT");
        Button btn3 = new Button("EDIT BRANCH");
        Button btn4 = new Button("EMPLOYEE HIRE INFORMATION REPORT");
        Button btn5 = new Button("ADD NEW BRANCH");
        Button btn6 = new Button("ASSIGN BRANCH");
         Button btn7 = new Button("ADD PRODUCTS");
        Button back = new Button ("BACK");
        btn.setPrefSize(200,50);
        btn01.setPrefSize(200,50);
        btn1.setPrefSize(200,50);
        btn11.setPrefSize(200,50);
        btn12.setPrefSize(200,50);
        btn2.setPrefSize(200,50);
        btn3.setPrefSize(200,50);
         btn4.setPrefSize(200,50);
           btn5.setPrefSize(200,50);
         btn6.setPrefSize(200,50);
           btn7.setPrefSize(200,50);
        root.add(btn, 0, 1);
        root.add(btn01, 0, 2);
        root.add(btn1, 0, 3);
        root.add(btn11, 0, 4);
        root.add(btn12, 0, 5);
        root.add(btn3, 0, 6);
        root.add(btn4, 0, 7);
        root.add(btn5, 0, 8);
        root.add(btn6, 0, 9);
        root.add(btn7, 0, 10);
        root.add(btn2, 0, 11);
        
        profileRoot.add(dp,0,0);
        VBox grp1 = new VBox();
        grp1.setPadding(new Insets(100,100,100,50));
        String empID = Query.rs.getString("EMPLOYEE_ID");
        String name = Query.rs.getString("NAME");
        
        Button ID = new Button(empID);
        ID.setPrefSize(200, 30);
        profileRoot.add(ID, 0, 1);
        VBox grp2 = new VBox();
        VBox grp3 = new VBox(); 
        VBox grp4 = new VBox(); 
        VBox grp5 = new VBox(); 
        VBox grp6 = new VBox(); 
        VBox grp7 = new VBox(); 
        grp2.setPadding(new Insets(100,100,100,50));
        grp3.setPadding(new Insets(100,100,100,10));
        grp4.setPadding(new Insets(100,100,100,10));
        grp5.setPadding(new Insets(100,100,100,10));
        grp6.setPadding(new Insets(100,100,100,10));
        finalroot.setSpacing(10);
        finalroot.setPrefSize(1000,1000);
               Employee employee1 = Query.getInfo(empID);
                SeeProfilePage.SeeProfile(employee1);
      grp6.getChildren().add(SeeProfilePage.SeeProfile(employee1));
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

grp7.getChildren().clear();
finalroot.getChildren().remove(grp7); 
                          Employee employee = Query.getInfo(empID);
                EditProfilePage.EditProfile(employee);
      grp1.getChildren().add(EditProfilePage.EditProfile(employee));
        
         finalroot.getChildren().add(grp1);

            } catch (SQLException ex) {

            }
        }
        );
        btn01.setOnAction(e -> {
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
grp7.getChildren().clear();
finalroot.getChildren().remove(grp7); 
Query.dataUnderManager.clear();
                Query.getEmployeesUnderManager(empID);
               
                         grp2.getChildren().add(EmployeeUnderManagerPage.EmployeesUnderManager());
    
        
         finalroot.getChildren().add( grp2);
            } catch (SQLException ex) {
            }
        });
        btn1.setOnAction(e -> {
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
grp7.getChildren().clear();
finalroot.getChildren().remove(grp7); 
Query.dataPendingEmp.clear();
       grp3.getChildren().add(  PendingEmployeesPage.pendingEmployees());
         
 
    
        
         finalroot.getChildren().add( grp3);
            } catch (SQLException ex) {
            }
        }
        );
         btn11.setOnAction(e -> {
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
grp7.getChildren().clear();
finalroot.getChildren().remove(grp7); 
Query.dataListOfOutofStock.clear();
                  Query.getOutOfStock();
       grp4.getChildren().add(  OutOfStockPage.OutOfStock());
         
 
    
        
         finalroot.getChildren().add( grp4);
            } catch (SQLException ex) {
            }
        }
        );
               btn12.setOnAction(e -> {
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
grp7.getChildren().clear();
finalroot.getChildren().remove(grp7); 
Query.dataReport.clear();
         
       grp5.getChildren().add( ReportPage.Report());
         
 
    
        
         finalroot.getChildren().add(grp5);
            } catch (SQLException ex) {
            }
        }
        );
        btn2.setOnAction(e -> {
               try {
                   LoginPage.Login(stage);
               } catch (SQLException ex) {
                   Logger.getLogger(ManagerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        );
        
        btn7.setOnAction(e -> {
               try {
                   Stage stage1 = new Stage();
                   NewProductPage.NewProduct(empID,stage1);
               } catch (SQLException ex) {
                   Logger.getLogger(ManagerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        );
        
          btn3.setOnAction(e -> {
               try {
                  EditBranchPage.EditBranch(empID);
               } catch (SQLException ex) {
                   Logger.getLogger(ManagerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        );
          btn5.setOnAction(e->{
               try {
                   NewBranchPage.NewBranch();
               } catch (SQLException ex) {
                   Logger.getLogger(ManagerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
          );
            btn6.setOnAction(e->{
               try {
                   AssignBranchPage.AssignBranch();
               } catch (SQLException ex) {
                   Logger.getLogger(ManagerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
          );
   
              btn4.setOnAction(e -> {
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
grp7.getChildren().clear();
finalroot.getChildren().remove(grp7); 
Query.dataReportEmpHire.clear();
               try {
                     grp7.getChildren().add(EmployeeHireReportPage.EmployeeHireReport());
         
 
    
        
         finalroot.getChildren().add(grp7);
              
               } catch (SQLException ex) {
                   Logger.getLogger(ManagerPage.class.getName()).log(Level.SEVERE, null, ex);
               }
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
