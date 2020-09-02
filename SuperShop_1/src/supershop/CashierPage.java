/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
public class CashierPage {

    public static void Cashier(String empID,Stage stage) throws SQLException {
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
        Button btn01 = new Button("ADD NEW CUSTOMER");
        Button btn1 = new Button("PREPARE BILL");
         Button btn11 = new Button("SEE PENDING BILLS");
        Button btn2 = new Button("LOG OUT");
        btn.setPrefSize(200,50);
        btn01.setPrefSize(200,50);
        btn1.setPrefSize(200,50);
        btn11.setPrefSize(200,50);
        btn2.setPrefSize(200,50);
        root.add(btn, 0, 1);
        root.add(btn01, 0, 2);
         root.add(btn1, 0, 3);
          root.add(btn11, 0, 4);
        root.add(btn2, 0, 5);
        
        profileRoot.add(dp,0,0);
        VBox grp1 = new VBox();
        grp1.setPadding(new Insets(100,100,100,50));
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
                   NewCustomerPage.NewCustomer();
               } catch (SQLException ex) {
                   Logger.getLogger(CashierPage.class.getName()).log(Level.SEVERE, null, ex);
               }
        });
        btn1.setOnAction(e->{
               try {
                   Stage stage1 = new Stage ();
                   PrepareBillPage.PrepareBill(empID,stage1);
               } catch (SQLException ex) {
                   Logger.getLogger(CashierPage.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(CashierPage.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ParseException ex) {
                   Logger.getLogger(CashierPage.class.getName()).log(Level.SEVERE, null, ex);
               }
        });
        btn11.setOnAction(e -> {
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
               try {
                 grp6.getChildren().add(PendingBillPage.pendingBill());
                 finalroot.getChildren().add(grp6);
               } catch (SQLException ex) {
                   Logger.getLogger(SalesmanPage.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        );
        btn2.setOnAction(e -> {
               try {
                   LoginPage.Login(stage);
               } catch (SQLException ex) {
                   Logger.getLogger(SalesmanPage.class.getName()).log(Level.SEVERE, null, ex);
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
