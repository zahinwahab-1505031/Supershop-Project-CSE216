/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import static supershop.Product_Loader.addToCartList;

public class Product_With_ChoiceBox {
   
    private final SimpleStringProperty ProductID;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Quantity;
    private final SimpleStringProperty Discount;
    private final SimpleStringProperty Price;
    private final SimpleStringProperty Total;
    public static String str;
    private ChoiceBox choiceBox;
    private Button button;

    private String no_of_items; 
      
        
    
    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
    
    
    public ChoiceBox getChoiceBox() {
        return choiceBox;
    }

    public void setChoiceBox(ChoiceBox choiceBox) {
        this.choiceBox = choiceBox;
    }

    public Product_With_ChoiceBox(String ProductID, String Name, String Quantity, String Discount, String Price, String Total, String quantity
             ) {
        

        
        this.ProductID = new SimpleStringProperty(ProductID);
        this.Name = new SimpleStringProperty(Name);
        this.Quantity = new SimpleStringProperty(Quantity);
        this.Discount = new SimpleStringProperty(Discount);
        this.Price = new SimpleStringProperty(Price);
        this.choiceBox = new ChoiceBox();
        //DEFAULT
        no_of_items = "1";
        List<String> list = new ArrayList<>();
        for(int i=1; i<=Integer.parseInt(quantity); i++){
            list.add(String.valueOf(i));
        }
        choiceBox.setItems(FXCollections.observableArrayList(
                list));
        choiceBox.setValue("1");
        choiceBox.setOnAction((event) -> {
            System.out.println("=-->>> PRODUCT ID = " + ProductID + " , is selected and choiceBox value = " + (String)choiceBox.getValue());
            no_of_items = (String)choiceBox.getValue();
        
        });
        this.button = new Button("ADD TO CART");
        this.button.setOnAction((event) -> {    Double t = Double.parseDouble(Price)*Double.parseDouble(no_of_items);
            System.out.println(t);
         str =Double.toString(t);
            System.out.println("=-->>RUN QUERY FOR PRODUCT ID = " + ProductID + " and no of items = " + no_of_items);
       Product_Loader.data1.add(new Product(ProductID,Name,no_of_items,null,Price,str));
       Product_Loader.table1.setItems(Product_Loader.data1);
        });
        this.Total = new SimpleStringProperty(str);
        
    }

    public String getProductID() {
        return ProductID.get();
    }

    public String getName() {
        return Name.get();
    }

    public String getQuantity() {
        return Quantity.get();
    }

    public String getDiscount() {
        return Discount.get();
    }

    public String getPrice() {
        return Price.get();
    }

    public String getTotal() {
        return Total.get();
    }

    public void setProductID(String p) {
        ProductID.set(p);
    }

    public void setName(String n) {
        Name.set(n);
    }

    public void setQuantity(String q) {
        Quantity.set(q);
    }

    public void setDiscount(String d) {
        Discount.set(d);
    }

    public void setPrice(String p) {
        Price.set(p);
    }
    
    public void setTotal(String t) {
        Total.set(t);
    }

}
