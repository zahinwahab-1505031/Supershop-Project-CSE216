/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Zahin
 */
public class ReportPage {
    public static Parent Report() throws SQLException{
           final DatePicker datePicker = new DatePicker();
              final DatePicker datePicker1 = new DatePicker();
        VBox vb = new VBox();
        vb.setSpacing(10);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);
        Label d1 = new Label("START DATE");
        Label d2 = new Label("END DATE");
        
        TextField d1V = new TextField();
        TextField d2V = new TextField();
        Button enter = new Button("ENTER");
        
        gp.add(d1,0,0);
        gp.add(d2,2,0);
        
        gp.add(datePicker,1,0);
        gp.add(datePicker1,3,0);
        gp.add(enter,4,1);
                TableView<Report> table = new TableView<Report>();
        table.setEditable(true);
 
       
        TableColumn prodCol = new TableColumn("PRODUCT_ID"); 
        prodCol.setMinWidth(100) ;
        prodCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("PRODUCT_ID")) ;
 
        TableColumn quaCol = new TableColumn("QUANTITY BOUGHT") ;
        quaCol.setMinWidth(200) ;
        quaCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("QUAN_BOUGHT")); 
 
        TableColumn qua2Col = new TableColumn("QUANTITY SOLD") ;
        qua2Col.setMinWidth(100) ;
        qua2Col.setCellValueFactory(
                new PropertyValueFactory<Report, String>("QUAN_SOLD")); 
        
         TableColumn cpCol = new TableColumn("TOTAL_COST_PRICE") ;
        cpCol.setMinWidth(50) ;
        cpCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("TOTAL COST PRICE")) ;
        
        TableColumn spCol = new TableColumn("TOTAL SELLING PRICE") ;
        spCol.setMinWidth(100) ;
        spCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("TOTAL_SELLING_PRICE")); 
				
				
	TableColumn profitCol = new TableColumn("PROFIT") ;
        profitCol.setMinWidth(100) ;
        profitCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("PROFIT"));
				
	TableColumn lossCol = new TableColumn("LOSS") ;
        lossCol.setMinWidth(100) ;
        lossCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("LOSS"));
        
        table.getColumns().addAll(prodCol,quaCol,qua2Col,cpCol,spCol,profitCol,lossCol);
        table.setItems(Query.dataReport);
        enter.setOnAction(e->{
            try {
                   LocalDate date = datePicker.getValue();

         System.err.println("Selected date: " + date);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.US);
String formattedValue = (datePicker.getValue()).format(formatter);
         System.out.println(formattedValue);
         
         
         String formattedValue1 = (datePicker1.getValue()).format(formatter);
      
                Query.generateReport(formattedValue, formattedValue1);
            } catch (SQLException ex) {
                Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
        table.setItems(Query.dataReport);
        vb.getChildren().addAll(gp,table);
        
        return vb;
        
        
    }
}
