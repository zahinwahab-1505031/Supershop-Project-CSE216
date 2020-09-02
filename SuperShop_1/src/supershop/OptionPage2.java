/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Zahin
 */
public class OptionPage2 {
    public static void Option2(Stage stage){
        ImageView logo;
           Image coll = new Image("file:logo");
        logo = new ImageView();
        logo.setImage(coll);
         GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        Button Login = new Button("LOGIN");
        Button SignUp = new Button("SIGN UP");
        root.add(Login,0,1);
        root.add(SignUp,1,1);
        Login.setOnAction(e -> {   
            try {
//PrepareBillPage.PrepareBill();
 //  NewProductPage.NewProduct();
       //   PendingEmployeesPage.pendingEmployees();
 // LoginPage.Login(stage);
 //Product_Loader.ProductShow();
    //  
    LoginPageCustomer.LoginCustomer(stage);
            } catch (Exception ex) {
            } 
        
         }
            ); 
             SignUp.setOnAction(e -> {
            try { NewCustomerPage.NewCustomer();
           //   SignUpPage.SignUp(stage);
            } catch (SQLException ex) {
            }
        
         }
            ); 
             Text scenetitle = new Text("Welcome");
root.add(scenetitle, 0, 0, 2, 1);
             Scene scene=new Scene(root,400,400); 
        
scene.getStylesheets().add("startPageDesign.css");

root.getStyleClass().add("my-root"); 
Login.getStyleClass().add("button"); 
scenetitle.setId("welcome-text"); 
SignUp.getStyleClass().add("button");

        stage.setScene(scene);        
        stage.setTitle("WELCOME AS A CUSTOMER");        
        stage.show();
    }
}
