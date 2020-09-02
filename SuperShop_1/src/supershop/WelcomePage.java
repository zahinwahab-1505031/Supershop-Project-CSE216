/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Zahin
 */
public class WelcomePage {

    public static void Welcome(Stage stage) {

        AnchorPane st = new AnchorPane();
        AnchorPane st1 = new AnchorPane();
        ImageView dp = new ImageView();
        Image im = new Image("bank.jpg");

        dp.setImage(im);
        dp.setFitWidth(200);
        dp.setFitHeight(200);

        ImageView dp1 = new ImageView();
        Image im1 = new Image("emp.jpg");

        dp1.setImage(im1);
        dp1.setFitWidth(200);
        dp1.setFitHeight(200);
        AnchorPane root1 = new AnchorPane();
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
//        root.setHgap(10);
//        root.setVgap(10);
        Button cus = new Button("CUSTOMER");
        Button emp = new Button("EMPLOYEE");
//    
//        root.add(cus, 0, 0);
//        root.add(emp, 0, 1);
        //      st.getChildren().add(dp);
//        st1.getChildren().add(dp1);
        cus.setPrefSize(200, 200);
        emp.setPrefSize(200, 200);

        cus.setLayoutX(10);
        cus.setLayoutY(10);

        dp.setLayoutX(10);
        dp.setLayoutY(10);
        root1.getChildren().add(cus);
        root1.getChildren().add(dp);
//           root.add(dp, 1, 0);
//        root.add(dp1, 1, 1);   

        //    root.add(st,1,1);
        emp.setOnMouseClicked(e -> {
            try {
                System.out.println("dp clicked");
                Stage stage1 = new Stage();
                OptionPage.Option(stage1);

            } catch (Exception ex) {
            }

        }
        );

        dp.setOnMouseClicked(e -> {
            try {
                System.out.println("dp clicked");
                Stage stage2 = new Stage();
                OptionPage.Option(stage2);

            } catch (Exception ex) {
            }

        }
        );

        Text scenetitle = new Text("Welcome");
//root.add(scenetitle, 0, 0, 2, 1);
        Scene scene = new Scene(root1, 600, 600);

        scene.getStylesheets().add("random.css");
        dp.getStyleClass().add("imageview");
        stage.setScene(scene);
        stage.show();
    }

    public static void newWelcome(Stage stage) {
//        Stage stage = new Stage();
        Scene scene = null;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();
//        String fxmlName = "/javafxapplication10/welcomePage.fxml";
        String fxmlName = "/supershop/welcomePage.fxml";
        WelcomePageController controller = null;
        System.out.println("===>>  Trying to Load  " + fxmlName);
        try {
            loader.setLocation(new WelcomePage().getClass().getResource(fxmlName));
            root = loader.load();
            controller = loader.getController();
        } catch (Exception ex2) {
            ex2.printStackTrace();
        }
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
