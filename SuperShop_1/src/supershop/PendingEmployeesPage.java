/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Zahin
 */
public class PendingEmployeesPage {
       public static ObservableList<Employee> dataListOfpendingEmployees=FXCollections.observableArrayList(
            new Employee(null,null,null,null,null,null,null,null,null,null,null,null,null,null));
  
         public static Parent pendingEmployees() throws SQLException{
        Stage pendingEmp = new Stage();
        GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        Button ACCEPTALL = new Button("ACCEPT ALL");
        Button ACCEPT = new Button("ACCEPT");
        Button REJECT = new Button("REJECT");
        TableView<Employee> table = new TableView<Employee>();
        table.setEditable(true);
        TableColumn empCol = new TableColumn("PENDING ID");
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
           TableColumn mCol = new TableColumn("MANAGER_ID");
        mCol.setMinWidth(100);
        mCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("MANAGER_ID"));
                TableColumn sCol = new TableColumn("SALARY");
        sCol.setMinWidth(100);
        sCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("SALARY"));
         table.setEditable(true);
 table.getColumns().addAll(empCol,NameCol,dobCol,addCol, pnCol,hdCol,sscCol,hscCol,ugCol,gCol,mailCol,mCol,sCol);
          
      Query.getPendingEmployees();
      ObservableList<TablePosition> selectedCells = FXCollections.observableArrayList();

             table.setItems(Query.dataPendingEmp);
     
//             ACCEPTALL.setOnAction(e->{    
//                 table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        table.getSelectionModel().setCellSelectionEnabled(true);
//        for (Employee emp : table.getItems()) {
//        // owner column data:
//        String name = emp.getNAME();
//            System.out.println("le");
//            System.out.println(name);
//        // ...
//        }
//
//   
//             });
             
             ACCEPT.setOnAction(e->{
                 
                 if (table.getSelectionModel().getSelectedItem() != null) {
        Employee selectedEmployee = table.getSelectionModel().getSelectedItem();
                     System.out.println(selectedEmployee.getEMPLOYEE_ID());
                     try {
                         Query.updatePendingEmployee(selectedEmployee.getEMPLOYEE_ID(), "ACCEPT");
                     } catch (SQLException ex) {
                         Logger.getLogger(PendingEmployeesPage.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     try {
                         System.out.println(selectedEmployee.getEMPLOYEE_ID());
                Query.deleteFromPending(selectedEmployee.getEMPLOYEE_ID());
            } catch (SQLException ex) {
                Logger.getLogger(PendingEmployeesPage.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
                 
             });
             
              REJECT.setOnAction(e -> {
                   Employee selectedEmployee=null;
                               if (table.getSelectionModel().getSelectedItem() != null) {
                selectedEmployee = table.getSelectionModel().getSelectedItem();
                     System.out.println(selectedEmployee.getEMPLOYEE_ID());
                     try {
                         Query.updatePendingEmployee(selectedEmployee.getEMPLOYEE_ID(), "REJECT");
                     } catch (SQLException ex) {
                         Logger.getLogger(PendingEmployeesPage.class.getName()).log(Level.SEVERE, null, ex);
                     }
       
    }
                  
            try {
                Query.deleteFromPending(selectedEmployee.getEMPLOYEE_ID());
            } catch (SQLException ex) {
                Logger.getLogger(PendingEmployeesPage.class.getName()).log(Level.SEVERE, null, ex);
            }
                      table.getItems().remove(selectedEmployee);
                 });
            
               final VBox vbox = new VBox();
               HBox btncontainer = new HBox();
               btncontainer.setSpacing(10);
               btncontainer.getChildren().addAll(ACCEPT,REJECT);
               btncontainer.setAlignment(Pos.CENTER_RIGHT);
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(5, 0, 0, 5));
            vbox.setMaxSize(800, 800);
            vbox.getChildren().addAll( table,btncontainer);
        return vbox;
            
           


     }}
