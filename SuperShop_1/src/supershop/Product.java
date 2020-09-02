/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supershop;
import java.util.*;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Zahin
 */
public class Product {
 
        private final SimpleStringProperty ProductID; 
        private final SimpleStringProperty Name;
        private final SimpleStringProperty Quantity;
        private final SimpleStringProperty Discount;
        private final SimpleStringProperty Price;
        private final SimpleStringProperty Total;
       
 
        public Product(String ProductID, String Name, String Quantity,String 
                Discount,String Price,String Total ) {
            this.ProductID = new SimpleStringProperty(ProductID);
            this.Name = new SimpleStringProperty(Name);
            this.Quantity = new SimpleStringProperty(Quantity);
            this.Discount = new SimpleStringProperty(Discount);
            this.Price = new SimpleStringProperty(Price); 
            this.Total = new SimpleStringProperty(Total);
              
              
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
 