/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class PrepareBillPage {
    static int quanStock;
     static double finalTotalPrice = 0;
     public Calculator createContent() {
        final Calculator calculator = new Calculator();
        return calculator;
    }
    public static void PrepareBill(String id,Stage prepBill) throws SQLException, FileNotFoundException, IOException, ParseException{
   
        GridPane root1=new GridPane();
        root1.setAlignment(Pos.CENTER);
        root1.setHgap(10);
        root1.setVgap(10);
        
        GridPane billRoot=new GridPane();
        billRoot.setAlignment(Pos.TOP_LEFT);
        billRoot.setHgap(10);
        billRoot.setVgap(10);
        Label BillID = new Label("BILL ID");
        Label todaysDate = new Label("DATE AND TIME");
        
        TextField BillIDV = new TextField();
        TextField todaysDateV = new TextField();
        BillIDV.setText(Query.getBillID());
        BillIDV.setEditable(false);
        
        String todayD = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        todaysDateV.setText(todayD);
        billRoot.add(BillID, 0, 1);
        billRoot.add(todaysDate, 0, 2);
        billRoot.add(BillIDV, 1, 1);
        billRoot.add(todaysDateV, 1, 2); 
        
        GridPane custRoot=new GridPane();
        custRoot.setAlignment(Pos.CENTER);
        custRoot.setHgap(10);
        custRoot.setVgap(10);
        Label CustomerID=new Label("CUSTOMER ID");
        Label CustomerName=new Label("NAME");
        Label CustomerPoints=new Label("POINTS");
        
        TextField CustomerIDV=new TextField();
        TextField CustomerNameV=new TextField();
        TextField CustomerPointsV=new TextField();
        
        custRoot.add(CustomerID,0,0);
        custRoot.add(CustomerName,0,1);
        custRoot.add(CustomerPoints,0,2);
        
        custRoot.add(CustomerIDV,1,0);
        custRoot.add(CustomerNameV,1,1);
        custRoot.add(CustomerPointsV,1,2);
        
         GridPane branchRoot=new GridPane();
        branchRoot.setAlignment(Pos.CENTER);
        branchRoot.setHgap(10);
        branchRoot.setVgap(10);
        Label BranchID=new Label("BRANCH ID");
        Label BranchName=new Label("LOCATION");
        
        TextField BranchIDV=new TextField();
        BranchIDV.setText(Query.getBranch(id));
        TextField BranchNameV=new TextField();
        BranchNameV.setText(Query.getBranchLocation(BranchIDV.getText()));
        branchRoot.add(BranchID,0,0);
        branchRoot.add(BranchName,0,1);
        
        branchRoot.add(BranchIDV,1,0);
        branchRoot.add(BranchNameV,1,1);
        
        GridPane cashierRoot=new GridPane();
        cashierRoot.setAlignment(Pos.CENTER);
        cashierRoot.setHgap(10);
        cashierRoot.setVgap(10);
        Label CashierID=new Label("CASHIER ID");
        Label CashierName=new Label("NAME");
        
        TextField CashierIDV=new TextField();
        CashierIDV.setText(id);
        
        TextField CashierNameV=new TextField();
        Employee emp = Query.getInfo(CashierIDV.getText());
        CashierNameV.setText(emp.getNAME());
        
        cashierRoot.add(CashierID,0,0);
        cashierRoot.add(CashierName,0,1);
        
        cashierRoot.add(CashierIDV,1,0);
        cashierRoot.add(CashierNameV,1,1);
        
        Label ProductID=new Label("PRODUCT ID");
        Label Name=new Label("NAME");
        Label Price=new Label("PRICE");
        Label Quantity=new Label("QUANTITY");
        Label Discount = new Label("DISCOUNT");
        
        
        TextField ProductIDV=new TextField();
        TextField NameV=new TextField();
        TextField PriceV=new TextField();
        TextField QuantityV=new TextField();
        TextField DiscountV=new TextField();
        Button ADD=new Button("ADD");
        Button RESET=new Button("RESET");
        HBox loginContainer=new HBox();
        loginContainer.getChildren().addAll(ADD,RESET);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        root1.add(ProductID, 0,0);
        root1.add(Name, 0,1);
        root1.add(Price, 0,2);
        root1.add(Quantity, 0,3);
        root1.add(Discount, 0,4);
        root1.add(ProductIDV, 1,0);
        root1.add(NameV, 1,1);
        root1.add(PriceV, 1,2);
        root1.add(QuantityV, 1,3);  
        root1.add(DiscountV, 1,4);        
        
        root1.add(loginContainer,1,5);
        
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
 
        TableColumn quaCol = new TableColumn("Quantity");
        quaCol.setMinWidth(100);
        quaCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Quantity"));
        
         TableColumn disCol = new TableColumn("Discount");
        disCol.setMinWidth(50);
        disCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Discount"));
        
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Price"));
        TableColumn totalCol = new TableColumn("Total");
        totalCol.setMinWidth(100);
        totalCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("Total"));
        
 
          Label Total = new Label("TOTAL");
          TextField TotalV = new TextField();
          Label Vat = new Label("VAT");
          TextField VatV = new TextField();
          Label NetTotal = new Label("NET AMOUNT");
          TextField NetTotalV = new TextField();
          GridPane gp1 = new GridPane();
          gp1.setAlignment(Pos.BASELINE_LEFT);
          gp1.setHgap(10);
          gp1.setVgap(10);
          gp1.add(Total,0,1);
          gp1.add(Vat,0,2);
          gp1.add(NetTotal,0,3);
          gp1.add(TotalV,1,1);
          gp1.add(VatV,1,2);
          gp1.add(NetTotalV,1,3);
          Label CashPaid = new Label("CASH PAID");
          TextField CashPaidV = new TextField();
          Label ChangeAmount = new Label("CHANGE AMOUNT");
          TextField ChangeAmountV = new TextField();
       
            gp1.add(CashPaid,2,1);
            gp1.add(CashPaidV,3,1);
            gp1.add(ChangeAmountV,3,2);
                     
        Button back = new Button ("BACK");
        back.setOnAction(e->{
            try {
                CashierPage.Cashier(id, prepBill);
            } catch (SQLException ex) {
                Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
            table.getColumns().addAll(prodCol,NameCol,quaCol,disCol, priceCol, totalCol);
            HBox hbox1 = new HBox(5);
            Button DELETE = new Button("DELETE");
            Button GETTOTAL = new Button("GET TOTAL");
            hbox1.getChildren().addAll(GETTOTAL,DELETE);
            hbox1.setAlignment(Pos.BOTTOM_RIGHT);
            Button FINAL_BILL = new Button ("PREPARE FINAL BILL");
            final VBox vbox = new VBox();
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(5, 0, 0, 5));
            vbox.getChildren().addAll( table,hbox1,gp1,FINAL_BILL);
            final VBox vboxleft = new VBox();
            vboxleft.setSpacing(20);
            vboxleft.setPadding(new Insets(5, 0, 0, 5));
            vboxleft.getChildren().addAll(branchRoot, billRoot,cashierRoot,custRoot,root1);
       
            HBox hbox = new HBox(20); // spacing = 8
           
             Group grp = new Group();
        Calculator calculator1 = new Calculator();
        grp.getChildren().add(calculator1);
        hbox.getChildren().addAll(vboxleft,vbox,grp);
            CustomerIDV.setOnAction((ActionEvent event) -> { 
            try {
                int x = Integer.parseInt(CustomerIDV.getText());
                if(Query.checkValidIDCustomer(CustomerIDV.getText(), "CUSTOMER")>0){
                    System.out.println("TextField Action");
                    try {
                        String name = Query.getCustomerName(CustomerIDV.getText());
                        CustomerNameV.setText(name);
                        String point = Query.getCustomerPoints(CustomerIDV.getText());
                        CustomerPointsV.setText(point);
                    } catch (SQLException ex) {
                        Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }
                else {
                    ErrorPage.Error("Enter a valid ID");
                    CustomerIDV.clear();
                }
            } catch (Exception ex) {
                Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            });  
               BranchIDV.setOnAction((ActionEvent event) -> { 
            try {
                
                int x = Integer.parseInt(BranchIDV.getText());
                if(Query.checkValidID(BranchIDV.getText(), "BRANCH")>0){
                    System.out.println("TextField Action");
                    try {
                        String name = Query.getBranchLocation(BranchIDV.getText());
                        BranchNameV.setText(name);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }
                else {
                    ErrorPage.Error("Enter Valid ID");
                    BranchIDV.clear();
                }
            } catch (Exception ex) {
               ErrorPage.Error("Enter Valid ID");
                    BranchIDV.clear();
            }
               
            });  
            CashierIDV.setOnAction((ActionEvent event) -> { 
            try {
                int x = Integer.parseInt(CashierIDV.getText());
                if(Query.checkValidID(CashierIDV.getText(), "EMPLOYEE")>0){
                    
                    try {
                        Employee emp1 = Query.getInfo(CashierIDV.getText());
                        CashierNameV.setText(emp1.getNAME());
                    } catch (SQLException ex) {
                        Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
                else {
                    ErrorPage.Error("Enter Valid ID");
                    CashierIDV.clear();
                }
            } catch (Exception ex) {
                 ErrorPage.Error("Enter Valid ID");
                    CashierIDV.clear();
            }
            
               
});
            

           
            ProductIDV.setOnAction((ActionEvent event) -> { 
                
            try {
                 int x = Integer.parseInt(ProductIDV.getText());
                if(Query.checkValidID(ProductIDV.getText(), "PRODUCT")>0 && Query.checkIfprodInBranch(ProductIDV.getText(), BranchIDV.getText())==true){
                    System.out.println("TextField Action");
                    try {
                        
                        Product prod =  Query.getProductInfo(ProductIDV.getText());
                        int prodType = Integer.parseInt(ProductIDV.getText().substring(0,1));
                        System.out.println(ProductIDV.getText());
                        final String quantityInStock = prod.getQuantity();
                        quanStock = Integer.parseInt(quantityInStock);
                        if(quanStock<=0) ErrorPage.Error("OUT OF STOCK");
                        if(quanStock>0) {
                            PriceV.setText(prod.getPrice());
                            String name=null;
                            
                            if(prodType==1) name = Query.getClothingName(ProductIDV.getText());
                            else if(prodType==2) name = Query.getCosmeticsName(ProductIDV.getText());
                            else if(prodType==3) name = Query.getCrockeriesName(ProductIDV.getText());
                            else if(prodType==4) name = Query.getElectronicsName(ProductIDV.getText());
                            
                            else if(prodType==5) name = Query.getFreshProduceName(ProductIDV.getText());
                            else if(prodType==6) name = Query.getGroceriesName(ProductIDV.getText());
                            else if(prodType==7) name = Query.getToiletriesName(ProductIDV.getText());
                            
                            NameV.setText(name);
                            QuantityV.setText("1");
                            DiscountV.setText("0");
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                }
                else{
                    ErrorPage.Error("Enter a valid ID");
                    ProductIDV.clear();
                }
            } catch (SQLException ex) {
                ErrorPage.Error("Enter a valid ID");
                    ProductIDV.clear();
            }
               
});
       float totalPrice=0;

        ObservableList<Product> data=FXCollections.observableArrayList(
            new Product(null,null,null,null,null,null));
             table.setItems(data);

        ADD.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                double p = (Double.parseDouble( PriceV.getText()))*(Integer.parseInt(QuantityV.getText()));
                System.out.println(p);
                String quantitySold = QuantityV.getText();
                int quanSold = Integer.parseInt(quantitySold);
                if(quanSold>quanStock){
                    ErrorPage.Error("Please specify any value from "+1+" to "+quanStock);
                }
                else {
               
                double d = Double.parseDouble( DiscountV.getText());
                System.out.println(d);
                double t=0;
                    try {
                        t = Query.countPrice(d, p);
                    } catch (SQLException ex) {
                        Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
                
             data.add( new Product(ProductIDV.getText(),NameV.getText(),QuantityV.getText(),DiscountV.getText(), 
                    PriceV.getText(),Double.toString(t)));
             ProductIDV.clear();
                NameV.clear();
                PriceV.clear();
                QuantityV.clear(); 
                DiscountV.clear();
                }
            }
        });
               RESET.setOnAction(e1->{
                   
                ProductIDV.clear();
                NameV.clear();
                PriceV.clear();
                QuantityV.clear(); 
                DiscountV.clear();
               }
               );
        
   
       
                 DELETE.setOnAction(e -> {
                    Product selectedItem = table.getSelectionModel().getSelectedItem();
                    table.getItems().remove(selectedItem);
                 });

                 GETTOTAL.setOnAction(e2->{
                       table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    table.getSelectionModel().setCellSelectionEnabled(true);
                      for (Product prod : table.getItems()) {
                      String total = prod.getTotal();
                      double a=0;
                    if(total!=null)   a  = Double.parseDouble(total);
                      finalTotalPrice = finalTotalPrice + a;
                      }
                                  TotalV.setText(Double.toString(finalTotalPrice));
                VatV.setText(Double.toString(.15*finalTotalPrice));
                NetTotalV.setText(Double.toString(finalTotalPrice+.15*finalTotalPrice));
                     System.out.println("total and vat done");
                          table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                    table.getSelectionModel().setCellSelectionEnabled(true);
//                    for (Product prod : table.getItems()) {
//                  if(prod.getProductID()!=null)   {   System.out.println(prod.getProductID()+"-----"+ prod.getQuantity());
//                       try {
//                    Query.updateQuantity(prod.getProductID(), prod.getQuantity());
//                } catch (SQLException ex) {
//                    Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                  }
//                      }
//                 
          
                 });
               SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
                java.util.Date t=ft.parse(todayD);
                ft.applyPattern("dd-MMM-YYYY");

            FINAL_BILL.setOnAction(e->{
            try {
                System.out.println("final_bill pressed");
            if(CustomerIDV.getText()!=null)  {
                System.out.println("not null---> insertion starts");
                Query.insertIntoBill(BillIDV.getText(), CustomerIDV.getText(), TotalV.getText(),ft.format(t),BranchIDV.getText());
               // Query.insertIntoCustomerBuysFromBranch(BranchIDV.getText(), CustomerIDV.getText(), BillIDV.getText(),ft.format(t));
            }
            else {
                System.out.println("null---> insertion starts");
                Query.insertIntoBill(BillIDV.getText(), null, TotalV.getText(),ft.format(t),BranchIDV.getText());
          //  Query.insertIntoCustomerBuysFromBranch(BranchIDV.getText(), CustomerIDV.getText(), BillIDV.getText(),ft.format(t));
           
            }
            } catch (SQLException ex) {
                Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
            }
                for (Product prod : table.getItems()) {
                  if(prod.getProductID()!=null)   {   
                      System.out.println(prod.getProductID()+"-----"+ prod.getQuantity());
                  String pricePerUnit = Double.toString(Double.parseDouble(prod.getTotal()) /Double.parseDouble( prod.getQuantity()));
                      System.out.println("price per unit--->"+pricePerUnit);
                  try {
                    Query.insertIntoBillContainsProduct(BillIDV.getText(),prod.getProductID(),pricePerUnit, prod.getQuantity());
                } catch (SQLException ex) {
                    Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                  }
                  }
         ErrorPage.Error("BILL PREPARED");
         prepBill.close();
            try {
                PrepareBill(id,prepBill);
            } catch (SQLException ex) {
                Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(PrepareBillPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            });
   
        
            Scene prepBillScene = new Scene(hbox,1000,1000) ;  
                  prepBillScene.getStylesheets().add("prepbillpgdesign.css");
      //  hbox.getStyleClass().add("my-root1"); 
       custRoot.getStyleClass().addAll("grid");
       branchRoot.getStyleClass().addAll("grid");
       cashierRoot.getStyleClass().addAll("grid");
       root1.getStyleClass().addAll("grid");
       billRoot.getStyleClass().addAll("grid");
       gp1.getStyleClass().addAll("grid");
            prepBill.setScene(prepBillScene);
            prepBill.setTitle("BILL");
            prepBill.show();
    
    }
    
}
