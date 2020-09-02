/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Zahin
 */
public class JavaConnectDb {
    public static Connection ConnectDb(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","zahinProject","3133");

            return con;
        }catch(Exception e){
            System.err.println("caught");
            return null;
            
        }
    }
}
