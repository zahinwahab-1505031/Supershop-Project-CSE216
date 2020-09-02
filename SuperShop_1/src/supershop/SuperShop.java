
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.swing.text.html.HTML.Tag.SELECT;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import supershop.AssignBranchPage;
import supershop.Employee;
import supershop.ErrorPage;
import supershop.JavaConnectDb;
import supershop.Product;
import supershop.LoginPage;
import supershop.NewBranchPage;
import supershop.NewCustomerPage;
import supershop.NewProductPage;
import supershop.NewSupplierPage;
import supershop.OptionPage;
import supershop.OptionPage2;
import supershop.PendingEmployeesPage;
import supershop.PrepareBillPage;
import supershop.SignUpPage;
import supershop.WelcomePage;

/**
 *
 * @author user
 */
public class SuperShop extends Application{
    public static Connection conn = null;
    public static OraclePreparedStatement pst = null;
    public static OracleResultSet rs = null;
    ResultSet rsnew = null;
              
                  public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
//        GridPane root=new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setHgap(10);
//        root.setVgap(10);
//        Button Login = new Button("LOGIN");
//        Button SignUp = new Button("SIGN UP");
//        root.add(Login,0,1);
//        root.add(SignUp,1,1);
//        Login.setOnAction(e -> {   
//            try {
//        //    PrepareBillPage.PrepareBill();
//    //  NewProductPage.NewProduct();
//       //   PendingEmployeesPage.pendingEmployees();
//       LoginPage.Login(stage);
//    //   NewCustomerPage.NewCustomer();
//            } catch (Exception ex) {
//                Logger.getLogger(SuperShop.class.getName()).log(Level.SEVERE, null, ex);
//            } 
//        
//         }
//            ); 
//             SignUp.setOnAction(e -> {
//            conn=JavaConnectDb.ConnectDb();
//            try {
//              SignUpPage.SignUp();
//            } catch (SQLException ex) {
//                Logger.getLogger(SuperShop.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//         }
//            ); 
//             Text scenetitle = new Text("Welcome");
//root.add(scenetitle, 0, 0, 2, 1);
//             Scene scene=new Scene(root,400,400); 
//        
//scene.getStylesheets().add("startPageDesign.css");
//
//root.getStyleClass().add("my-root"); 
//Login.getStyleClass().add("button"); 
//scenetitle.setId("welcome-text"); 
//SignUp.getStyleClass().add("button");
//
//        stage.setScene(scene);        
//        stage.setTitle("WELCOME AS AN EMPLOYEE");        
//        stage.show();
// 
//Stage stage1 = new Stage();
//OptionPage.Option(stage);
WelcomePage.newWelcome(stage);
//AssignBranchPage.AssignBranch();
//NewBranchPage.NewBranch();
//OptionPage2.Option2(stage1);
//NewProductPage.NewProduct("100001",stage);
    }  

}
     
    
    
          




