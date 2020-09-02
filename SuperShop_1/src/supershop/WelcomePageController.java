/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author esfs
 */
public class WelcomePageController implements Initializable {

    @FXML
    private ImageView imageView_Bank;
    @FXML
    private ImageView imageView_cust;
    @FXML
    private Text text_CUST;
    @FXML
    private Text text_EMP;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        System.out.println("-->>>INSIDE CONTROLLER CLASS.. ");
//        text_EMP.setText("EMPLOYEE!!");
//        text_CUST.setText("CUSTOMER!!");
    }    

    @FXML
    private void imageCustomerClicked(ActionEvent event) {
        System.out.println("=-->> Inside WelcomePageController.imageCustomerClicked.. \nCustomer icon is clicked!!");
        Stage stage = new Stage();
        OptionPage.Option(stage);

    }

    @FXML
    private void imageBankClicked(ActionEvent event) {
        System.out.println("=-->> Inside WelcomePageController.imageBankClicked.. \nBANK IMAGE icon is clicked!!");    
        Stage stage = new Stage();
        OptionPage.Option(stage);
    
    }

    @FXML
    private void mouseEnteredFunction(MouseEvent event) {
//        System.out.println("=->>Mouse Entered Event");
        text_CUST.setText("CUSTOMER!!");
    }

    @FXML
    private void mouseEntered2(MouseEvent event) {
        text_EMP.setText("EMPLOYEE!");
    }

    @FXML
    private void releaseCustomer(MouseEvent event) {
//        System.out.println("=->>INSIDE RELEASE CUSTOMER!");
        text_CUST.setText("");
    }


    @FXML
    private void releaseEmp(MouseEvent event) {
//        System.out.println("=-->>INSIDE RELEASE EMP");
        text_EMP.setText("");
    }
    
}
