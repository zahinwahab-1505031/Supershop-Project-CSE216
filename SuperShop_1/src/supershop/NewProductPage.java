/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.awt.Color;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Zahin
 */
public class NewProductPage {

    public static void NewProduct(String id, Stage primaryStage) throws SQLException {

        //    primaryStage.setTitle("TEST");
        VBox root = new VBox();
        // root.setSpacing(20);
        Scene scene = new Scene(root, 800, 800);

        TabPane tabPane = new TabPane();
        BorderPane mainPane = new BorderPane();
        Button btn_clo = new Button("ADD");
        Button btn_cos = new Button("ADD");
        Button btn_cro = new Button("ADD");
        Button btn_ele = new Button("ADD");
        Button btn_fre = new Button("ADD");
        Button btn_gro = new Button("ADD");
        Button btn_toi = new Button("ADD");

        GridPane clo = new GridPane();
        clo.setAlignment(Pos.CENTER);
        clo.setHgap(10);
        clo.setVgap(10);
        Label clo_br = new Label("BRANCH ID");
        Label cos_br = new Label("BRANCH ID");
        Label cro_br = new Label("BRANCH ID");
        Label ele_br = new Label("BRANCH ID");
        Label fre_br = new Label("BRANCH ID");
        Label gro_br = new Label("BRANCH ID");
        Label toi_br = new Label("BRANCH ID");

        TextField clo_brV = new TextField();
        TextField cos_brV = new TextField();
        TextField cro_brV = new TextField();
        TextField ele_brV = new TextField();
        TextField fre_brV = new TextField();
        TextField gro_brV = new TextField();
        TextField toi_brV = new TextField();
        
        
        clo_brV.setText(Query.getBranch(id));
        cos_brV.setText(Query.getBranch(id));
        cro_brV.setText(Query.getBranch(id));
        ele_brV.setText(Query.getBranch(id));
        fre_brV.setText(Query.getBranch(id));
        gro_brV.setText(Query.getBranch(id));
        toi_brV.setText(Query.getBranch(id));
        
        
        
        
        

        Label clo_name = new Label("NAME");
        Label clo_color = new Label("COLOR");
        Label clo_size = new Label("SIZE");
        Label clo_date = new Label("DELIVARY DATE");
        Label clo_gender = new Label("GENDER");
        Label clo_fabric = new Label("FABRIC");

        TextField clo_nameV = new TextField();
        TextField clo_colorV = new TextField();
        TextField clo_sizeV = new TextField();
        final DatePicker clo_dateV = new DatePicker();
        TextField clo_genderV = new TextField();
        TextField clo_fabricV = new TextField();

        clo.add(clo_name, 0, 1);
        clo.add(clo_color, 0, 2);
        clo.add(clo_size, 0, 3);
        clo.add(clo_date, 0, 4);
        clo.add(clo_gender, 0, 5);
        clo.add(clo_fabric, 0, 6);

        clo.add(clo_nameV, 1, 1);
        clo.add(clo_colorV, 1, 2);
        clo.add(clo_sizeV, 1, 3);
        clo.add(clo_dateV, 1, 4);
        clo.add(clo_genderV, 1, 5);
        clo.add(clo_fabricV, 1, 6);

        Label clo_cp = new Label("COST PRICE");
        Label clo_sp = new Label("SELLING PRICE");
        Label clo_qua = new Label("QUANTITY");

        TextField clo_cpV = new TextField();
        TextField clo_spV = new TextField();
        TextField clo_quaV = new TextField();
        clo.add(clo_cp, 0, 7);
        clo.add(clo_sp, 0, 8);
        clo.add(clo_qua, 0, 9);
        clo.add(clo_cpV, 1, 7);
        clo.add(clo_spV, 1, 8);
        clo.add(clo_quaV, 1, 9);
        clo.add(clo_br, 0, 10);
        clo.add(clo_brV, 1, 10);
        clo.add(btn_clo, 2, 11);

        GridPane cos = new GridPane();
        cos.setAlignment(Pos.CENTER);
        cos.setHgap(10);
        cos.setVgap(10);
        Label cos_name = new Label("NAME");
        Label cos_size = new Label("SIZE");
        Label cos_date = new Label("MANUFACTURING DATE");
        Label cos_date2 = new Label("EXPIRY DATE");
        Label cos_brand = new Label("BRAND");

        TextField cos_nameV = new TextField();
        TextField cos_sizeV = new TextField();
        final DatePicker cos_dateV = new DatePicker();

        final DatePicker cos_date2V = new DatePicker();
        TextField cos_brandV = new TextField();

        cos.add(cos_name, 0, 2);
        cos.add(cos_size, 0, 3);
        cos.add(cos_date, 0, 4);
        cos.add(cos_brand, 0, 5);
        cos.add(cos_date2, 0, 6);
        cos.add(cos_nameV, 1, 2);
        cos.add(cos_sizeV, 1, 3);
        cos.add(cos_dateV, 1, 4);
        cos.add(cos_brandV, 1, 5);
        cos.add(cos_date2V, 1, 6);
        Label cos_cp = new Label("COST PRICE");
        Label cos_sp = new Label("SELLING PRICE");
        Label cos_qua = new Label("QUANTITY");

        TextField cos_cpV = new TextField();
        TextField cos_spV = new TextField();
        TextField cos_quaV = new TextField();
        cos.add(cos_cp, 0, 7);
        cos.add(cos_sp, 0, 8);
        cos.add(cos_qua, 0, 9);
        cos.add(cos_cpV, 1, 7);
        cos.add(cos_spV, 1, 8);
        cos.add(cos_quaV, 1, 9);
        cos.add(cos_br, 0, 10);
        cos.add(cos_brV, 1, 10);
        cos.add(btn_cos, 2, 11);
        GridPane cro = new GridPane();
        cro.setAlignment(Pos.CENTER);
        cro.setHgap(10);
        cro.setVgap(10);
        Label cro_name = new Label("NAME");
        Label cro_size = new Label("SIZE");
        Label cro_date = new Label("DELIVARY DATE");
        Label cro_material = new Label("MATERIAL");

        TextField cro_nameV = new TextField();
        TextField cro_sizeV = new TextField();
        final DatePicker cro_dateV = new DatePicker();
        TextField cro_materialV = new TextField();

        cro.add(cro_name, 0, 2);
        cro.add(cro_size, 0, 3);
        cro.add(cro_date, 0, 4);
        cro.add(cro_material, 0, 5);

        cro.add(cro_nameV, 1, 2);
        cro.add(cro_sizeV, 1, 3);
        cro.add(cro_dateV, 1, 4);
        cro.add(cro_materialV, 1, 5);

        Label cro_cp = new Label("COST PRICE");
        Label cro_sp = new Label("SELLING PRICE");
        Label cro_qua = new Label("QUANTITY");

        TextField cro_cpV = new TextField();
        TextField cro_spV = new TextField();
        TextField cro_quaV = new TextField();
        cro.add(cro_cp, 0, 7);
        cro.add(cro_sp, 0, 8);
        cro.add(cro_qua, 0, 9);
        cro.add(cro_cpV, 1, 7);
        cro.add(cro_spV, 1, 8);
        cro.add(cro_quaV, 1, 9);
        cro.add(cro_br, 0, 10);
        cro.add(cro_brV, 1, 10);
        cro.add(btn_cro, 2, 11);
        GridPane ele = new GridPane();
        ele.setAlignment(Pos.CENTER);
        ele.setHgap(10);
        ele.setVgap(10);
        Label ele_name = new Label("NAME");
        Label ele_size = new Label("SIZE");
        Label ele_date = new Label("DELIVARY DATE");
        Label ele_date2 = new Label("TRENDING DATE");
        Label ele_brand = new Label("BRAND");

        TextField ele_nameV = new TextField();
        TextField ele_sizeV = new TextField();
        final DatePicker ele_dateV = new DatePicker();
        final DatePicker ele_date2V = new DatePicker();
        TextField ele_brandV = new TextField();

        ele.add(ele_name, 0, 2);
        ele.add(ele_size, 0, 3);
        ele.add(ele_date, 0, 4);
        ele.add(ele_brand, 0, 5);
        ele.add(ele_date2, 0, 6);
        ele.add(ele_nameV, 1, 2);
        ele.add(ele_sizeV, 1, 3);
        ele.add(ele_dateV, 1, 4);
        ele.add(ele_brandV, 1, 5);
        ele.add(ele_date2V, 1, 6);
        Label ele_cp = new Label("COST PRICE");
        Label ele_sp = new Label("SELLING PRICE");
        Label ele_qua = new Label("QUANTITY");

        TextField ele_cpV = new TextField();
        TextField ele_spV = new TextField();
        TextField ele_quaV = new TextField();
        ele.add(ele_cp, 0, 7);
        ele.add(ele_sp, 0, 8);
        ele.add(ele_qua, 0, 9);
        ele.add(ele_cpV, 1, 7);
        ele.add(ele_spV, 1, 8);
        ele.add(ele_quaV, 1, 9);
        ele.add(ele_br, 0, 10);
        ele.add(ele_brV, 1, 10);
        ele.add(btn_ele, 2, 11);
        GridPane fre = new GridPane();
        fre.setAlignment(Pos.CENTER);
        fre.setHgap(10);
        fre.setVgap(10);
        Label fre_name = new Label("NAME");
        Label fre_date = new Label("MANUFACTURING DATE");
        Label fre_date2 = new Label("EXPIRY DATE");
        TextField fre_nameV = new TextField();
        final DatePicker fre_dateV = new DatePicker();
        final DatePicker fre_date2V = new DatePicker();
        fre.add(fre_name, 0, 2);
        fre.add(fre_date, 0, 3);
        fre.add(fre_date2, 0, 4);

        fre.add(fre_nameV, 1, 2);
        fre.add(fre_dateV, 1, 3);
        fre.add(fre_date2V, 1, 4);
        Label fre_cp = new Label("COST PRICE");
        Label fre_sp = new Label("SELLING PRICE");
        Label fre_qua = new Label("QUANTITY");

        TextField fre_cpV = new TextField();
        TextField fre_spV = new TextField();
        TextField fre_quaV = new TextField();
        fre.add(fre_cp, 0, 7);
        fre.add(fre_sp, 0, 8);
        fre.add(fre_qua, 0, 9);
        fre.add(fre_cpV, 1, 7);
        fre.add(fre_spV, 1, 8);
        fre.add(fre_quaV, 1, 9);

        fre.add(fre_br, 0, 10);
        fre.add(fre_brV, 1, 10);
        fre.add(btn_fre, 2, 11);
        GridPane gro = new GridPane();
        gro.setAlignment(Pos.CENTER);
        gro.setHgap(10);
        gro.setVgap(10);
        Label gro_name = new Label("NAME");
        Label gro_size = new Label("SIZE");
        Label gro_date = new Label("MANUFACTURING DATE");
        Label gro_date2 = new Label("EXPIRY DATE");
        Label gro_brand = new Label("BRAND");

        TextField gro_nameV = new TextField();
        TextField gro_sizeV = new TextField();
        final DatePicker gro_dateV = new DatePicker();
        final DatePicker gro_date2V = new DatePicker();
        TextField gro_brandV = new TextField();

        gro.add(gro_name, 0, 2);
        gro.add(gro_size, 0, 3);
        gro.add(gro_date, 0, 4);
        gro.add(gro_date2, 0, 5);
        gro.add(gro_brand, 0, 6);

        gro.add(gro_nameV, 1, 2);
        gro.add(gro_sizeV, 1, 3);
        gro.add(gro_dateV, 1, 4);
        gro.add(gro_date2V, 1, 5);
        gro.add(gro_brandV, 1, 6);
        Label gro_cp = new Label("COST PRICE");
        Label gro_sp = new Label("SELLING PRICE");
        Label gro_qua = new Label("QUANTITY");

        TextField gro_cpV = new TextField();
        TextField gro_spV = new TextField();
        TextField gro_quaV = new TextField();
        gro.add(gro_cp, 0, 7);
        gro.add(gro_sp, 0, 8);
        gro.add(gro_qua, 0, 9);
        gro.add(gro_cpV, 1, 7);
        gro.add(gro_spV, 1, 8);
        gro.add(gro_quaV, 1, 9);
        gro.add(gro_br, 0, 10);
        gro.add(gro_brV, 1, 10);
        gro.add(btn_gro, 2, 11);

        GridPane toi = new GridPane();
        toi.setAlignment(Pos.CENTER);
        toi.setHgap(10);
        toi.setVgap(10);
        Label toi_name = new Label("NAME");
        Label toi_size = new Label("SIZE");
        Label toi_date = new Label("MANUFACTURING DATE");
        Label toi_date2 = new Label("EXPIRY DATE");
        Label toi_brand = new Label("BRAND");

        TextField toi_nameV = new TextField();
        TextField toi_sizeV = new TextField();
        final DatePicker toi_dateV = new DatePicker();
        final DatePicker toi_date2V = new DatePicker();
        TextField toi_brandV = new TextField();

        toi.add(toi_name, 0, 2);
        toi.add(toi_size, 0, 3);
        toi.add(toi_date, 0, 4);
        toi.add(toi_date2, 0, 5);
        toi.add(toi_brand, 0, 6);

        toi.add(toi_nameV, 1, 2);
        toi.add(toi_sizeV, 1, 3);
        toi.add(toi_dateV, 1, 4);
        toi.add(toi_date2V, 1, 5);
        toi.add(toi_brandV, 1, 6);
        Label toi_cp = new Label("COST PRICE");
        Label toi_sp = new Label("SELLING PRICE");
        Label toi_qua = new Label("QUANTITY");

        TextField toi_cpV = new TextField();
        TextField toi_spV = new TextField();
        TextField toi_quaV = new TextField();
        toi.add(toi_cp, 0, 7);
        toi.add(toi_sp, 0, 8);
        toi.add(toi_qua, 0, 9);
        toi.add(toi_cpV, 1, 7);
        toi.add(toi_spV, 1, 8);
        toi.add(toi_quaV, 1, 9);
        toi.add(toi_br, 0, 10);
        toi.add(toi_brV, 1, 10);
        toi.add(btn_toi, 2, 11);
        Label clo_supplier = new Label("SUPPLIER ID");
        TextField clo_supplierV = new TextField();
        clo.add(clo_supplier, 0, 0);
        clo.add(clo_supplierV, 1, 0);

        Label cos_supplier = new Label("SUPPLIER ID");
        TextField cos_supplierV = new TextField();
        cos.add(cos_supplier, 0, 0);
        cos.add(cos_supplierV, 1, 0);

        Label cro_supplier = new Label("SUPPLIER ID");
        TextField cro_supplierV = new TextField();
        cro.add(cro_supplier, 0, 0);
        cro.add(cro_supplierV, 1, 0);

        Label ele_supplier = new Label("SUPPLIER ID");
        TextField ele_supplierV = new TextField();
        ele.add(ele_supplier, 0, 0);
        ele.add(ele_supplierV, 1, 0);

        Label fre_supplier = new Label("SUPPLIER ID");
        TextField fre_supplierV = new TextField();
        fre.add(fre_supplier, 0, 0);
        fre.add(fre_supplierV, 1, 0);

        Label gro_supplier = new Label("SUPPLIER ID");
        TextField gro_supplierV = new TextField();
        gro.add(gro_supplier, 0, 0);
        gro.add(gro_supplierV, 1, 0);

        Label toi_supplier = new Label("SUPPLIER ID");
        TextField toi_supplierV = new TextField();
        toi.add(toi_supplier, 0, 0);
        toi.add(toi_supplierV, 1, 0);

        Tab tabClo = new Tab();
        tabClo.setText("CLOTHING");
        tabClo.setContent(clo);
        tabPane.getTabs().add(tabClo);

        Tab tabCos = new Tab();
        tabCos.setText("COSMETICS");
        tabCos.setContent(cos);
        tabPane.getTabs().add(tabCos);

        Tab tabCro = new Tab();
        tabCro.setText("CROCKERIES");
        tabCro.setContent(cro);
        tabPane.getTabs().add(tabCro);

        Tab tabEle = new Tab();
        tabEle.setText("ELECTRONICS");
        tabEle.setContent(ele);
        tabPane.getTabs().add(tabEle);

        Tab tabFre = new Tab();
        tabFre.setText("FRESH PRODUCE");
        tabFre.setContent(fre);
        tabPane.getTabs().add(tabFre);

        Tab tabGro = new Tab();
        tabGro.setText("GROCERIES");
        tabGro.setContent(gro);
        tabPane.getTabs().add(tabGro);

        Tab tabToi = new Tab();
        tabToi.setText("TOILETRIES");
        tabToi.setContent(toi);
        tabPane.getTabs().add(tabToi);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.US);

        btn_clo.setOnAction(e -> {
            try {
                String formattedValue = (clo_dateV.getValue()).format(formatter);
                Query.addClothing(clo_cpV.getText(),
                        clo_spV.getText(), clo_quaV.getText(), clo_nameV.getText(),
                        clo_colorV.getText(), clo_sizeV.getText(), formattedValue, clo_genderV.getText(),
                        clo_fabricV.getText(), clo_supplierV.getText(), clo_brV.getText());
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btn_cos.setOnAction(e -> {
            try {
                String formattedValue = (cos_dateV.getValue()).format(formatter);
                String formattedValue1 = (cos_date2V.getValue()).format(formatter);
                Query.addCosmetics(cos_cpV.getText(),
                        cos_spV.getText(), cos_quaV.getText(), cos_nameV.getText(),
                        cos_sizeV.getText(), formattedValue, formattedValue1, cos_brandV.getText(), cos_supplierV.getText(), cos_brV.getText());
                cos_cpV.clear();
                cos_spV.clear();
                cos_quaV.clear();
                cos_nameV.clear();
                cos_sizeV.clear();
                cos_brandV.clear();
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_cro.setOnAction(e -> {
            try {
                //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",Locale.US);
                String formattedValue = (cro_dateV.getValue()).format(formatter);
                Query.addCrockeries(cro_cpV.getText(),
                        cro_spV.getText(), cro_quaV.getText(), cro_nameV.getText(),
                        cro_sizeV.getText(), formattedValue, cro_materialV.getText(), cro_supplierV.getText(), cro_brV.getText());
                cro_cpV.clear();
                cro_spV.clear();
                cro_quaV.clear();
                cro_nameV.clear();
                cro_sizeV.clear();;
                cro_materialV.clear();
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_ele.setOnAction(e -> {
            try {
                String formattedValue = (ele_dateV.getValue()).format(formatter);
                String formattedValue1 = (ele_date2V.getValue()).format(formatter);
                Query.addElectronics(ele_cpV.getText(),
                        ele_spV.getText(), ele_quaV.getText(), ele_nameV.getText(),
                        ele_sizeV.getText(), formattedValue, formattedValue1, ele_brandV.getText(), ele_supplierV.getText(), ele_brV.getText());
                ele_cpV.clear();
                ele_spV.clear();
                ele_quaV.clear();
                ele_nameV.clear();
                ele_sizeV.clear();
                ele_brandV.clear();
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        //addFreshProduce(String fre_cpV  , String 
        // fre_spV  , String fre_quaV, String fre_nameV , String fre_dateV  , String fre_date2V
        // )//
        btn_fre.setOnAction(e -> {
            try {
                String formattedValue = (fre_dateV.getValue()).format(formatter);
                String formattedValue1 = (fre_date2V.getValue()).format(formatter);
                Query.addFreshProduce(fre_cpV.getText(),
                        fre_spV.getText(), fre_quaV.getText(), fre_nameV.getText(), formattedValue,
                        formattedValue1, fre_supplierV.getText(), fre_brV.getText());
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn_gro.setOnAction(e -> {
            try {
                String formattedValue = (gro_dateV.getValue()).format(formatter);
                String formattedValue1 = (gro_date2V.getValue()).format(formatter);
                Query.addGroceries(gro_cpV.getText(),
                        gro_spV.getText(), gro_quaV.getText(), gro_nameV.getText(),
                        gro_sizeV.getText(), formattedValue, formattedValue1, gro_brandV.getText(), gro_supplierV.getText(), gro_brV.getText());
                gro_cpV.clear();
                gro_spV.clear();
                gro_quaV.clear();
                gro_nameV.clear();
                gro_sizeV.clear();
                gro_brandV.clear();
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        btn_toi.setOnAction(e -> {
            try {
                String formattedValue = (toi_dateV.getValue()).format(formatter);
                String formattedValue1 = (toi_date2V.getValue()).format(formatter);

                Query.addToiletries(toi_cpV.getText(),
                        toi_spV.getText(), toi_quaV.getText(), toi_nameV.getText(),
                        toi_sizeV.getText(), formattedValue, formattedValue1, toi_brandV.getText(), toi_supplierV.getText(), toi_brV.getText());
                toi_cpV.clear();
                toi_spV.clear();
                toi_quaV.clear();
                toi_nameV.clear();
                toi_sizeV.clear();
                toi_brandV.clear();
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button back = new Button("BACK");
        back.setOnAction((ActionEvent e) -> {
            try {
                SalesmanPage.Salesman(id, primaryStage);
            } catch (SQLException ex) {
                Logger.getLogger(NewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        mainPane.setCenter(tabPane);
        mainPane.prefHeightProperty().bind(scene.heightProperty());
        mainPane.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().addAll(back, mainPane);
        scene.getStylesheets().add("startPageDesign.css");

        clo.getStyleClass().add("my-root1");
        cos.getStyleClass().add("my-root1");
        cro.getStyleClass().add("my-root1");
        fre.getStyleClass().add("my-root1");
        ele.getStyleClass().add("my-root1");
        gro.getStyleClass().add("my-root1");
        toi.getStyleClass().add("my-root1");
// A.getStyleClass().add("main-text");
//return mainPane;
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
