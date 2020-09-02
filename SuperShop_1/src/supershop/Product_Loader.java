/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Product_Loader  {
    public static   List<Product> addToCartList = new ArrayList<>();
    public static    TableView<Product> table1 = new TableView<>();
     static double finalTotalPrice = 0;
    public static   ObservableList<Product> data1=FXCollections.observableArrayList(
            new Product(null,null,null,null,null,null));
    
    public static void ProductShow(String id,Stage primaryStage) throws IOException, SQLException { 
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
    "COSMETICS", "CLOTHING", "CROCKERIES","ELECTRONICS","FRESH PRODUCE","GROCERIES","TOILETRIES"));
        Button back = new Button("BACK");
        System.out.println("here");
        
        Scene scene = null;
//= new Stage();
        AnchorPane pane = new AnchorPane();
        Button final_bill = new Button("PREPARE FINAL BILL");
         Label Total = new Label("TOTAL");
          TextField TotalV = new TextField();
          Label Vat = new Label("VAT");
          TextField VatV = new TextField();
          Label NetTotal = new Label("NET AMOUNT");
          TextField NetTotalV = new TextField();
          GridPane gp1 = new GridPane();
          gp1.setAlignment(Pos.BASELINE_LEFT);
          Button DELETE = new Button("DELETE");
          HBox hb = new HBox(10);
          hb.setAlignment(Pos.CENTER_LEFT);
          hb.getChildren().add(DELETE);
          gp1.setHgap(10);
          gp1.setVgap(10);
          gp1.add(Total,0,1);
          gp1.add(Vat,0,2);
          gp1.add(NetTotal,0,3);
          gp1.add(TotalV,1,1);
          gp1.add(VatV,1,2);
          gp1.add(NetTotalV,1,3);
          gp1.add(final_bill,2,3);
        TableView<Product_With_ChoiceBox> table = new TableView<>();
        table.setEditable(true);

        TableColumn prodCol = new TableColumn("Product ID");
        prodCol.setMinWidth(100);
        prodCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("ProductID"));

        TableColumn NameCol = new TableColumn("Name");
        NameCol.setMinWidth(200);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Name"));

        TableColumn quaCol = new TableColumn("Quantity");
        quaCol.setMinWidth(100);
        quaCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Quantity"));

        TableColumn disCol = new TableColumn("Discount");
        disCol.setMinWidth(50);
        disCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Discount"));

        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Price"));
        TableColumn totalCol = new TableColumn("Total");
        totalCol.setMinWidth(100);
        totalCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Total"));
        
        TableColumn choiceBoxCol = new TableColumn("ChoiceBox");
        choiceBoxCol.setMinWidth(100);
        choiceBoxCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("choiceBox"));
        
        TableColumn btnCol = new TableColumn("Add To Cart");
        btnCol.setMinWidth(100);
        btnCol.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("button"));
        
      
     
        table.getColumns().addAll(prodCol, NameCol, quaCol, disCol, priceCol, totalCol, choiceBoxCol, btnCol);
        table.setEditable(true);
   
         cb.setOnAction((event) -> {
               if(cb.getValue().equals("COSMETICS")==true){
               try {
                   
                 Query.list.clear();     Query.getCosmeticsList(); 
                   ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
                     
                    for ( int i = 0; i<table.getItems().size(); i++) {
                       table.getItems().clear();
                   }
                 //  ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
  table.setItems(data);
               } catch (SQLException ex) {
                   Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
               }
             
           }
        else if(cb.getValue().equals("CLOTHING")==true){
               try {
                   
              
                   Query.list.clear();     Query.getClothingList(); 
                   ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
                     
                    for ( int i = 0; i<table.getItems().size(); i++) {
                       table.getItems().clear();
                   }
                   table.setItems(data);
                 } catch (SQLException ex) {
                     Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
                 }
           
           }
         else if(cb.getValue().equals("CROCKERIES")==true){
               try {
                   
              
                   Query.list.clear();     Query.getCrockeriesList(); 
                   ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
                     
                    for ( int i = 0; i<table.getItems().size(); i++) {
                       table.getItems().clear();
                   }
                   table.setItems(data);
                 } catch (SQLException ex) {
                     Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
                 }
           
           }
          else if(cb.getValue().equals("FRESH PRODUCE")==true){
               try {
                   
              
                   Query.list.clear();     Query.getFreshProduceList(); 
                   ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
                     
                    for ( int i = 0; i<table.getItems().size(); i++) {
                       table.getItems().clear();
                   }
                   table.setItems(data);
                 } catch (SQLException ex) {
                     Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
                 }
           
           }
           else if(cb.getValue().equals("ELECTRONICS")==true){
               try {
                   
              
                   Query.list.clear();     Query.getElectronicsList(); 
                   ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
                     
                    for ( int i = 0; i<table.getItems().size(); i++) {
                       table.getItems().clear();
                   }
                   table.setItems(data);
                 } catch (SQLException ex) {
                     Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
                 }
           
           }
            else if(cb.getValue().equals("GROCERIES")==true){
               try {
                   
              
                   Query.list.clear();     Query.getGroceriesList(); 
                   ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
                     
                    for ( int i = 0; i<table.getItems().size(); i++) {
                       table.getItems().clear();
                   }
                   table.setItems(data);
                 } catch (SQLException ex) {
                     Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
                 }
           
           }
          else if(cb.getValue().equals("TOILETRIES")==true){
               try {
                   
              
                   Query.list.clear();     Query.getToiletriesList(); 
                   ObservableList<Product_With_ChoiceBox> data = FXCollections.observableArrayList(Query.list);
                     
 for ( int i = 0; i<table.getItems().size(); i++) {
    table.getItems().clear();
}
              table.setItems(data);
               } catch (SQLException ex) {
                   Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
               }
           
           }
           
        });
        
     
        table1.setEditable(true);

        TableColumn prodCol1 = new TableColumn("Product ID");
        prodCol1.setMinWidth(100);
        prodCol1.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("ProductID"));

        TableColumn NameCol1 = new TableColumn("Name");
        NameCol1.setMinWidth(200);
        NameCol1.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Name"));

        TableColumn quaCol1 = new TableColumn("Quantity");
        quaCol1.setMinWidth(100);
        quaCol1.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Quantity"));

        TableColumn disCol1 = new TableColumn("Discount");
        disCol1.setMinWidth(50);
        disCol1.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Discount"));

        TableColumn priceCol1 = new TableColumn("Price");
        priceCol1.setMinWidth(100);
        priceCol1.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Price"));
        TableColumn totalCol1 = new TableColumn("Total");
        totalCol1.setMinWidth(100);
        totalCol1.setCellValueFactory(
                new PropertyValueFactory<Product_With_ChoiceBox, String>("Total"));
        
     
    //    ObservableList<Product> data1 = FXCollections.observableArrayList();
    //    data1= FXCollections.observableArrayList(addToCartList);

        table1.getColumns().addAll(prodCol1, NameCol1, quaCol1, disCol1, priceCol1, totalCol1);
        table1.setEditable(true);
      //  table1.setItems(data1);
           final_bill.setOnAction(e2->{
                       table1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    table1.getSelectionModel().setCellSelectionEnabled(true);
                      for (Product prod : table1.getItems()) {
                      String total = prod.getTotal();
                      double a=0;
                    if(total!=null)   a  = Double.parseDouble(total);
                      finalTotalPrice = finalTotalPrice + a;
                      }
                                  TotalV.setText(Double.toString(finalTotalPrice));
                VatV.setText(Double.toString(.15*finalTotalPrice));
                NetTotalV.setText(Double.toString(finalTotalPrice+.15*finalTotalPrice));
                     System.out.println("total and vat done");
                          table1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    table1.getSelectionModel().setCellSelectionEnabled(true);
//                    for (Product prod : table1.getItems()) {
//                  if(prod.getProductID()!=null)   {  
//                      System.out.println(prod.getProductID()+"-----"+ prod.getQuantity());
//                       try {
//                    Query.updateQuantity(prod.getProductID(), prod.getQuantity());
//                } catch (SQLException ex) {
//                }
//                  }
//                 }
                    
                    
                    
                    
                    /////////////////////////
                   String todayD = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
          SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
                java.util.Date t=null;
            try {
                t = ft.parse(todayD);
            } catch (ParseException ex) {
                Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
            }
                ft.applyPattern("dd-MMM-YYYY");

                System.out.println("not null---> insertion starts");
            try {
                Query.insertIntoPendingBill(null,id, TotalV.getText(),ft.format(t),"1");
                // Query.insertIntoCustomerBuysFromBranch(BranchIDV.getText(), CustomerIDV.getText(), BillIDV.getText(),ft.format(t));
            } catch (SQLException ex) {
                Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            
                for (Product prod : table1.getItems()) {
                  if(prod.getProductID()!=null)   {   
                      System.out.println(prod.getProductID()+"-----"+ prod.getQuantity());
                  String pricePerUnit = Double.toString(Double.parseDouble(prod.getTotal()) /Double.parseDouble( prod.getQuantity()));
                      System.out.println("price per unit--->"+pricePerUnit);
                  try {
                    Query.insertIntoPendingBillContainsProduct(null,prod.getProductID(),pricePerUnit, prod.getQuantity());
                } catch (SQLException ex) {
                    Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                  }
                  }
                 
          
                 });
           
            DELETE.setOnAction(e -> {
                    Product selectedItem = table1.getSelectionModel().getSelectedItem();
                    table1.getItems().remove(selectedItem);
                 });
            back.setOnAction(e->{
                System.out.println("back clicked");
            try {
                CustomerPage.Customer(id,primaryStage);
            } catch (SQLException ex) {
                System.out.println("in catch");
                Logger.getLogger(Product_Loader.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            );
        System.out.println("here2");
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(back,cb,table,table1,hb,gp1);
        vbox.setMaxSize(800, 800);
        scene = new Scene(vbox,1000,1000);
              scene.getStylesheets().add("prepbillpgdesign.css");
        hb.getStyleClass().add("my-root1"); 
       gp1.getStyleClass().addAll("grid");
      // return vbox;
    primaryStage.setScene(scene);
      primaryStage.show();
    }

   
   
}
