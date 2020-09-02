/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 *
 * @author Zahin
 */
public class OutOfStockPage {
         public static Parent OutOfStock() throws SQLException{
 TableView<Product> table = new TableView<Product>();
        table.setEditable(true);
 
        TableColumn prodCol = new TableColumn("Product ID");
        prodCol.setMinWidth(100);
        prodCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("ProductID"));
 
        TableColumn NameCol = new TableColumn("Name");
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Name"));
 
           TableColumn quaCol = new TableColumn("Quantity bought");
        quaCol.setMinWidth(100);
        quaCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Quantity bought"));
        
            TableColumn qua2Col = new TableColumn("Quantity Sold");
        quaCol.setMinWidth(100);
        quaCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Quantity Sold"));
        TableColumn priceCol = new TableColumn("Cost Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Cost Price"));
        
                TableColumn price2Col = new TableColumn("Selling Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Selling Price"));
       
            table.getColumns().addAll(prodCol,NameCol,quaCol);
            table.setItems(Query.dataListOfOutofStock);
               final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(5, 0, 0, 5));
            vbox.setMaxSize(800, 800);
            vbox.getChildren().addAll( table);
        return vbox;
            
           


     }
}
