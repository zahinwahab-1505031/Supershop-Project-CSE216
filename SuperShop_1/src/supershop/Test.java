/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Zahin
 */
public class Test {
    public static void main(String[] args) throws SQLException, ParseException {
      //  System.out.println("hello world");
//      System.out.println(Query.passwordMatch("100001", "1"));
//      System.out.println(Query.passwordMatch("100001", "real"));
//    Employee emp = Query.getInfo("100001");
// System.out.println(emp.getNAME());
// Product p = Query.getProductInfo("100001");
//   System.out.println(p.getQuantity());
////     Query.updateQuantity("100001", "1");
System.out.println(Query.getElectronicsName("400001"));
//System.out.println(Query.getCustomerPoints("1"));
     //   System.out.println(Query.getBillID());
  // Query.addClothing("100" , "120", "5" , "hello" , "ble" , "l" ,"12-DEC-2010" ,"FEMAKE" , "SILKYYERE");
//   try{
//        Query.addCosmetics("100" , "120", "5" , "lipstick" ,  "0" ,"12-DEC-2010" ,"12-DEC-2017" , "MAC");
//   }catch (SQLException e){
//        System.out.println(e);
//    }
   // String todayD = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
   // 
//Query.insertIntoBill("1039", null,"8000", "28-Dec-2017");
//SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
//java.util.Date t=ft.parse(todayD);
//ft.applyPattern("dd-MMM-YYYY");
//System.out.println(ft.format(t));
//Query.getToiletriesList();
//Query.insertIntoPendingBill("1", "1", "100", "12-jan-2017", "1");
//Query.ifEmployeeUnderManager("200001", "100001");

//Query.updateBranch ("200001",Query.getBranch("200001"),"4") ;
//Query.generateReport("12-DEC-2017", "12-JAN-2018");
Query.getCosmeticsList();
  }
    
}
