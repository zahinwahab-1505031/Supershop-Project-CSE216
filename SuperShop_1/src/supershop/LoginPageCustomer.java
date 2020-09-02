/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Zahin
 */
public class LoginPageCustomer {
        public static void LoginCustomer(Stage stage) throws SQLException{
            boolean test;
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        //root.setGridLinesVisible(true);
        
        Label userLabel=new Label("CUSTOMER_ID");
        Label passLabel=new Label("PASSWORD");
        
        TextField userValue=new TextField();
        PasswordField passValue=new PasswordField();
        
        Button login=new Button("LOGIN");
        Button back=new Button("BACK");
        HBox loginContainer=new HBox();
        loginContainer.setSpacing(10);
        loginContainer.getChildren().addAll(back,login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
        Label warning=new Label();
        
        
        root.add(userLabel, 0,0);
        root.add(passLabel, 0,1);
        
        root.add(userValue, 1,0);
        root.add(passValue, 1,1);               
        
        root.add(loginContainer, 1,2);
        
        root.add(warning,1,3);
        
        login.setOnMouseClicked(new EventHandler<MouseEvent>(){
        

            @Override
            public void handle(MouseEvent t) {
                try{
                // conn=JavaConnectDb.ConnectDb();
                
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(e);
                }
                String username=userValue.getText();
                String password=passValue.getText();
                
                try {
int x = Integer.parseInt(username);
if(Query.passwordMatchCustomer(username, password)==true){
   CustomerPage.Customer(username,stage);
                    }

else {
    ErrorPage.Error("USER ID AND PASSWORD DON'T MATCH");
    userValue.clear();
    passValue.clear();
}
                } catch (SQLException ex) {
                //    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }});
     
      
        back.setOnAction(e1->{
            OptionPage.Option(stage);
        });
        Scene scene=new Scene(root,400,400); 
        scene.getStylesheets().add("startPageDesign.css");

root.getStyleClass().add("my-root1");     
        stage.setScene(scene);        
        stage.setTitle("Login");        
        stage.show();
    }
}
