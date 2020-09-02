/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Zahin
 */
public class EmployeeUnderManagerPage {
    public static Parent   EmployeesUnderManager() throws SQLException{
         System.out.println("inside stage");
        Stage empum = new Stage();
        GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        
        TableView<Employee> table = new TableView<Employee>();
        table.setEditable(true);
        TableColumn empCol = new TableColumn("EMPLOYEE ID");
        empCol.setMinWidth(100);
        empCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("EMPLOYEE_ID"));
 
        TableColumn NameCol = new TableColumn("NAME");
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("NAME"));
 
        TableColumn dobCol = new TableColumn("DATE OF BIRTH");
        dobCol.setMinWidth(100);
        dobCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("DATE_OF_BIRTH"));
        
         TableColumn addCol = new TableColumn("ADDRESS");
        addCol.setMinWidth(50);
        addCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("ADDRESS"));
        
        TableColumn pnCol = new TableColumn("PHONE NUMBER");
        pnCol.setMinWidth(100);
        pnCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("PHONE_NUMBER"));
        TableColumn mailCol = new TableColumn("EMAIL ID");
        mailCol.setMinWidth(100);
        mailCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("EMAIL_ID"));
         TableColumn hdCol = new TableColumn("HIRE DATE");
        hdCol.setMinWidth(100);
        hdCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("HIRE_DATE"));
              TableColumn sscCol = new TableColumn("SSC");
        sscCol.setMinWidth(100);
        sscCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("SSC"));
                TableColumn hscCol = new TableColumn("HSC");
        hscCol.setMinWidth(100);
        hscCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("HSC"));
                TableColumn ugCol = new TableColumn("HONORS");
        ugCol.setMinWidth(100);
        ugCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("HONORS"));
               TableColumn gCol = new TableColumn("MASTERS");
        gCol.setMinWidth(100);
        gCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("MASTERS"));
         table.setEditable(true);
 table.getColumns().addAll(empCol,NameCol,dobCol,addCol, pnCol,hdCol,sscCol,hscCol,ugCol,gCol);
          
             table.setItems(Query.dataUnderManager);
            
            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setMaxSize(800, 800);
            vbox.setPadding(new Insets(5, 0, 0, 5));
            vbox.getChildren().addAll( table);
            return vbox;
         //   Scene epscene=new Scene(vbox,800,800); 
               //    epscene.getStylesheets().add("startPageDesign.css");
    //   vbox.getStyleClass().add("my-root1"); 
//        empum.setScene(epscene);
//        empum.setTitle("EDIT PROFILE");
//        empum.show();
            
           


     }
}
  
    
    

