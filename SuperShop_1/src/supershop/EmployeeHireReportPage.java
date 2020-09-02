/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
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
public class EmployeeHireReportPage {
    public static Parent EmployeeHireReport() throws SQLException{
        VBox vb = new VBox();
        vb.setSpacing(10);
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);
        Label d1 = new Label("START DATE");
        Label d2 = new Label("END DATE");
          final DatePicker d1V = new DatePicker(); 
          final DatePicker  d2V= new DatePicker();
        Button enter = new Button("ENTER");
        
        gp.add(d1,0,0);
        gp.add(d2,2,0);
        
        gp.add(d1V,1,0);
        gp.add(d2V,3,0);
        gp.add(enter,4,1);
                TableView<Report> table = new TableView<Report>();
        table.setEditable(true);
 
       
        TableColumn prodCol = new TableColumn("EMPLOYEE_ID"); 
        prodCol.setMinWidth(100) ;
        prodCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("PRODUCT_ID")) ;
 
        TableColumn quaCol = new TableColumn("NAME") ;
        quaCol.setMinWidth(200) ;
        quaCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("QUAN_BOUGHT")); 
 
        TableColumn qua2Col = new TableColumn("HIRE DATE") ;
        qua2Col.setMinWidth(100) ;
        qua2Col.setCellValueFactory(
                new PropertyValueFactory<Report, String>("QUAN_SOLD")); 
        
         TableColumn cpCol = new TableColumn("CURRENT BRANCH") ;
        cpCol.setMinWidth(50) ;
        cpCol.setCellValueFactory(
                new PropertyValueFactory<Report, String>("TOTAL COST PRICE")) ;
        
     
        
        table.getColumns().addAll(prodCol,quaCol,qua2Col,cpCol);
      
      
        enter.setOnAction(e->{
            try {
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.US);
String formattedValue = (d1V.getValue()).format(formatter);
String formattedValue1 = (d2V.getValue()).format(formatter);
                Query.generateEmployeeHireReport(formattedValue, formattedValue1);
            } catch (SQLException ex) {
                Logger.getLogger(ReportPage.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });  table.setItems(Query.dataReportEmpHire);
       
        vb.getChildren().addAll(gp,table);
        
        return vb;
        
        
    }
}
