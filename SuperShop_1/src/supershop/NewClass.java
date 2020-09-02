/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Zahin
 */
public class NewClass {
    public static void main(String[] args) {
         GridPane branchRoot=new GridPane();
        branchRoot.setAlignment(Pos.CENTER);
        branchRoot.setHgap(10);
        branchRoot.setVgap(10);
        Label BranchID=new Label("BRANCH ID");
        Label BranchName=new Label("LOCATION");
        
        TextField BranchIDV=new TextField();
        TextField BranchNameV=new TextField();
        
        branchRoot.add(BranchID,0,0);
        branchRoot.add(BranchName,0,1);
        
        branchRoot.add(BranchIDV,1,0);
        branchRoot.add(BranchNameV,1,1);
    }
}
