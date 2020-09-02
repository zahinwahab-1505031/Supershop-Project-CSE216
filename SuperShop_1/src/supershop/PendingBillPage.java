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
public class PendingBillPage {
          public static Parent pendingBill() throws SQLException{
        Stage pendingEmp = new Stage();
        GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        Button ACCEPT = new Button("ACCEPT");
        Button REJECT = new Button("REJECT");
        TableView<Bill> table = new TableView<Bill>();
        table.setEditable(true);
        TableColumn empCol = new TableColumn("PENDING ID");
        empCol.setMinWidth(100);
        empCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("BILL_ID"));
 
        TableColumn NameCol = new TableColumn("CUSTOMER_ID");
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("CUSTOMER_ID"));
 
        TableColumn dobCol = new TableColumn("BILL DATE");
        dobCol.setMinWidth(100);
        dobCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("BILL_DATE"));
        
        TableColumn priceCol = new TableColumn("TOTAL PRICE");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("TOTAL_PRICE"));
        
         table.setEditable(true);
 table.getColumns().addAll(empCol,NameCol,priceCol,dobCol);
          
      Query.getPendingBill();
      ObservableList<TablePosition> selectedCells = FXCollections.observableArrayList();

             table.setItems(Query.dataPendingBill);
     
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
        Bill selectedBill = table.getSelectionModel().getSelectedItem();
                     System.out.println(selectedBill.getBILL_ID());
                     try {
                         Query.updatePendingBill(selectedBill.getBILL_ID(), "ACCEPT");
                     } catch (SQLException ex) {
                         }
                     try {
                         System.out.println(selectedBill.getBILL_ID());
                        Query.deleteFromPendingBill(selectedBill.getBILL_ID());
                          table.getItems().remove(selectedBill);
                    } catch (SQLException ex) {
                        }
       
    }
                 
             });
             
              REJECT.setOnAction(e -> {
                   Employee selectedEmployee=null;
                               if (table.getSelectionModel().getSelectedItem() != null) {
                    Bill selectedBill = table.getSelectionModel().getSelectedItem();
                     System.out.println(selectedBill.getBILL_ID());
                     try {
                         Query.updatePendingBill(selectedBill.getBILL_ID(), "REJECT");
                     } catch (SQLException ex) {
                         }
                     try {
                         System.out.println(selectedBill.getBILL_ID());
                        Query.deleteFromPendingBill(selectedBill.getBILL_ID());
                        table.getItems().remove(selectedBill);
                    } catch (SQLException ex) {
                        }   
       
    }
                  
            
                   
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
            
           


     }
}
