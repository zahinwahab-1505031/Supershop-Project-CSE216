/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Zahin
 */
public class Query {

    public static Connection conn = JavaConnectDb.ConnectDb();
    public static ResultSet rs;
    public static Employee emp = null;
    public static ObservableList<Employee> dataUnderManager = FXCollections.observableArrayList(
            new Employee(null, null, null, null, null, null, null, null, null, null, null, null, null, null));
    public static ObservableList<Employee> dataPendingEmp = FXCollections.observableArrayList(
            new Employee(null, null, null, null, null, null, null, null, null, null, null, null, null, null));
    public static ObservableList<Product> dataListOfOutofStock = FXCollections.observableArrayList(
            new Product(null, null, null, null, null, null));
    public static ObservableList<Report> dataReport = FXCollections.observableArrayList(
            new Report(null, null, null, null, null, null, null));

    public static ObservableList<Report> dataReportEmpHire = FXCollections.observableArrayList(
            new Report(null, null, null, null, null, null, null));
    public static ObservableList<Bill> dataPendingBill = FXCollections.observableArrayList(
            new Bill(null, null, null, null));
    public static List<Product_With_ChoiceBox> list = new ArrayList<>();

    public static boolean passwordMatch(String userID, String password) throws SQLException {
        String sq = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID='" + userID + "'" + "and PASSWORD='" + password + "'";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("QUERYY IS " + sq);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean passwordMatchCustomer(String userID, String password) throws SQLException {
        String sq = "SELECT * FROM CUSTOMER WHERE REG_CUS_ID='" + userID + "'" + "and PASSWORD='" + password + "'";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("QUERYY IS " + sq);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static Employee getInfo(String userID) throws SQLException {

        String sq1 = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID='" + userID + "'";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq1);
        System.out.println("QUERYY IS " + sq1);

        if (rs.next()) {

            emp = new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    rs.getString(8), rs.getString(11), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getString(6),
                    rs.getString(18), rs.getString(7));
            System.out.println("query executed");
            return emp;
        }
        return emp;

    }

    public static Customer getCustomerInfo(String userID) throws SQLException {

        String sq1 = "SELECT * FROM CUSTOMER WHERE REG_CUS_ID='" + userID + "'";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq1);
        System.out.println("QUERYY IS " + sq1);
        Customer customer = null;
        if (rs.next()) {

            customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    rs.getString(6), rs.getString(7),rs.getString(8),
                    rs.getString(9), rs.getString(10));
            System.out.println("query executed");
            return customer;
        }
        return customer;

    }

    public static Product getProductInfo(String id) throws SQLException {
        Product prod = null;
        String sq1 = "SELECT * FROM PRODUCT WHERE PRODUCT_ID='" + id + "'";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq1);
        System.out.println("QUERYY IS " + sq1);
        if (rs.next()) {

            prod = new Product(rs.getString(1), null, rs.getString(7), null, rs.getString(5), null);
            System.out.println("query executed");
            return prod;
        }
        return prod;

    }

    public static String getCustomerName(String id) throws SQLException {
        String name = null;
        String sq1 = "SELECT NAME FROM CUSTOMER WHERE REG_CUS_ID='" + id + "'";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq1);
        System.out.println("QUERYY IS " + sq1);
        if (rs.next()) {

            name = rs.getString(1);
        }
        return name;

    }

    public static String getBillID() throws SQLException {
        int count = 0;
        String result;
        String sq1 = "SELECT * FROM BILL";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq1);
        System.out.println("QUERYY IS " + sq1);
        while (rs.next()) {

            count++;
        }
        result = Integer.toString(count + 1);
        return result;
    }

    public static String getCustomerPoints(String id) throws SQLException {
        String name = null;
        String sq1 = "SELECT POINTS FROM CUSTOMER WHERE REG_CUS_ID='" + id + "'";
        Statement statement = conn.createStatement();
        rs = statement.executeQuery(sq1);
        System.out.println("QUERYY IS " + sq1);
        if (rs.next()) {

            name = rs.getString(1);
        }
        return name;

    }

    public static void updateInfo(String empID, String name, String add, String pn, String ma) throws SQLException {
        String sq = "UPDATE EMPLOYEE SET NAME= '" + name + "',  ADDRESS='" + add + "', PHONE_NUMBER ='" + pn + "', EMAIL_ID='" + ma + "' WHERE EMPLOYEE_ID = '" + empID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);

    }

    public static void updateCustInfo(String empID, String name, String add, String pn, String ma, String pass) throws SQLException {
        String sq = "UPDATE CUSTOMER SET NAME= '" + name + "',  ADDRESS='" + add + "', PHONE_NUMBER ='" + pn + "', EMAIL_ID='" + ma + "', PASSWORD='" + pass + "' WHERE REG_CUS_ID = '" + empID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);

    }

    public static void updateQuantity(String ID, String quantitySold) throws SQLException {
        String sq = "SELECT QUANTITY FROM PRODUCT WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        String prevQuan = null;
        if (rs.next()) {
            prevQuan = rs.getString(1);
            System.out.println("previous quantity-->" + prevQuan);

        }
        int diff = Integer.parseInt(prevQuan) - Integer.parseInt(quantitySold);
        String remaining = Integer.toString(diff);
        System.out.println("remaining-->" + remaining);
        sq = "UPDATE PRODUCT SET QUANTITY= '" + remaining + "'WHERE PRODUCT_ID = '" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("u pdate done successfully");

    }

    public static double countPrice(double discount, double price) throws SQLException {
        System.out.println("in countPrice");
        System.out.println(discount + " " + price);
        CallableStatement stmt = conn.prepareCall("{?= call countTotalPrice(?,?)}");
        stmt.setDouble(2, discount);
        stmt.setDouble(3, price);
        stmt.registerOutParameter(1, Types.DOUBLE);
        stmt.execute();
        System.out.println(stmt.getDouble(1));
        return stmt.getDouble(1);

    }

    public static int checkValidID(String ID, String table) throws SQLException {

        CallableStatement stmt = conn.prepareCall("{?= call CHECKVALIDITY(?,?)}");
        stmt.setString(2, ID);
        stmt.setString(3, table);
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        System.out.println(stmt.getInt(1));
        return stmt.getInt(1);
    }

    public static int checkValidIDCustomer(String ID, String table) throws SQLException {

        CallableStatement stmt = conn.prepareCall("{?= call CHECKVALIDITY1(?,?)}");
        stmt.setString(2, ID);
        stmt.setString(3, table);
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        System.out.println(stmt.getInt(1));
        return stmt.getInt(1);
    }

    public static String getClothingName(String ID) throws SQLException {
        String sq = "SELECT * FROM CLOTHING WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        String name = null;
        if (rs.next()) {
            name = rs.getString(1) + "_" + rs.getString(3) + "_" + rs.getString(4) + "_" + rs.getString(7) + "_" + rs.getString(8);
        }
        return name;
    }

    public static String getCosmeticsName(String ID) throws SQLException {
        String sq = "SELECT * FROM COSMETICS WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        String name = null;
        if (rs.next()) {
            name = rs.getString(1) + "_" + rs.getString(3) + "_" + rs.getString(4);
        }
        return name;
    }

    public static String getCrockeriesName(String ID) throws SQLException {
        String sq = "SELECT * FROM CROCKERIES WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        String name = null;
        if (rs.next()) {
            name = rs.getString(1) + "_" + rs.getString(3) + "_" + rs.getString(4);
        }
        return name;
    }

    public static String getElectronicsName(String ID) throws SQLException {
        System.out.println("HERE -_- ");
        String sq = "SELECT * FROM ELECTRONICS WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        String name = null;
        if (rs.next()) {
            name = rs.getString(1) + "_" + rs.getString(3) + "_" + rs.getString(4);
        }
        return name;
    }

    public static String getFreshProduceName(String ID) throws SQLException {
        String sq = "SELECT * FROM FRESH_PRODUCE WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        String name = null;
        if (rs.next()) {
            name = rs.getString(1) + "_" + rs.getString(3);
        }
        return name;
    }

    public static String getGroceriesName(String ID) throws SQLException {
        String sq = "SELECT * FROM GROCERIES WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        String name = null;
        if (rs.next()) {
            name = rs.getString(1) + "_" + rs.getString(3) + "_" + rs.getString(4);
        }
        return name;
    }

    public static String getToiletriesName(String ID) throws SQLException {
        String sq = "SELECT * FROM TOILETRIES WHERE PRODUCT_ID ='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery(sq);
        String name = null;
        System.out.println("query donee");
        if (rs.next()) {
            System.out.println("before name");
            name = rs.getString(1) + "_" + rs.getString(3) + "_" + rs.getString(4);
            System.out.println("name:-->" + name);
        }

        return name;
    }

    public static void addClothing(String cos_cpV, String cos_spV, String cos_quaV, String cos_nameV, String cos_colorV, String cos_sizeV, String cos_dateV, String cos_genderV, String cos_fabricV, String supp, String br) throws SQLException {
        String sq = "SELECT * FROM CLOTHING";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        int id = 100000 + count + 1;
        sq = "INSERT INTO PRODUCT (PRODUCT_ID,COST_PRICE,SELLING_PRICE,PRODUCT_TYPE,QUANTITY,BRANCH_ID,INITIAL_QUANTITY) VALUES( '" + id + "','" + cos_cpV + "','" + cos_spV + "','" + "100" + "','" + cos_quaV + "','" + br + "','" + cos_quaV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into prod");
        sq = "INSERT INTO CLOTHING(PRODUCT_NAME,PRODUCT_ID,COLOR,CLO_SIZE,DELIVARY_DATE,GENDER,FABRIC) VALUES ('" + cos_nameV + "','" + id + "','" + cos_colorV + "','" + cos_sizeV + "','" + cos_dateV + "','" + cos_genderV + "','" + cos_fabricV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cos");

        sq = "INSERT INTO SUPPLIER_DELIVERS_PRODUCTS VALUES ('" + id + "','" + supp + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cl");
    }

    public static void addCosmetics(String cos_cpV, String cos_spV, String cos_quaV, String cos_nameV, String cos_sizeV, String cos_dateV, String cos_date2V, String cos_brandV, String supp, String br) throws SQLException {
        String sq = "SELECT * FROM COSMETICS";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        int id = 200000 + count + 1;
        sq = "INSERT INTO PRODUCT (PRODUCT_ID,COST_PRICE,SELLING_PRICE,PRODUCT_TYPE,QUANTITY,BRANCH_ID,INITIAL_QUANTITY) VALUES('" + id + "','" + cos_cpV + "','" + cos_spV + "','" + "200" + "','" + cos_quaV + "','" + br + "','" + cos_quaV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        statement.executeQuery(sq);
        System.out.println("inserted into prod");
        sq = "INSERT INTO COSMETICS(PRODUCT_NAME,PRODUCT_ID,COS_SIZE,BRAND,MANUFACTURING_DATE,EXPIRY_DATE,INITIAL_QUANTITY) VALUES ('" + cos_nameV + "','" + id + "','" + cos_sizeV + "','" + cos_brandV + "','" + cos_dateV + "','" + cos_date2V + "')";

        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        int a = statement.executeUpdate(sq);
        System.out.println("inserted into cos");

        sq = "INSERT INTO SUPPLIER_DELIVERS_PRODUCTS VALUES ('" + id + "','" + supp + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cl");
    }

    public static void addCrockeries(String cro_cpV, String cro_spV, String cro_quaV, String cro_nameV, String cro_sizeV, String cro_dateV, String cro_materialV, String supp, String br) throws SQLException {
        String sq = "SELECT * FROM CROCKERIES";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        int id = 300000 + count + 1;
        sq = "INSERT INTO PRODUCT (PRODUCT_ID,COST_PRICE,SELLING_PRICE,PRODUCT_TYPE,QUANTITY,BRANCH_ID,INITIAL_QUANTITY) VALUES('" + id + "','" + cro_cpV + "','" + cro_spV + "','" + "300" + "','" + cro_quaV + "','" + br + "','" + cro_quaV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        statement.executeQuery(sq);
        System.out.println("inserted into prod");
        sq = "INSERT INTO CROCKERIES(PRODUCT_NAME,PRODUCT_ID,CRO_SIZE,MATERIAL,DELIVARY_DATE) VALUES ('" + cro_nameV + "','" + id + "','" + cro_sizeV + "','" + cro_materialV + "','" + cro_dateV + "')";

        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        int a = statement.executeUpdate(sq);
        System.out.println("inserted into cro");
        sq = "INSERT INTO SUPPLIER_DELIVERS_PRODUCTS VALUES ('" + id + "','" + supp + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cl");
    }

    public static void addElectronics(String ele_cpV, String ele_spV, String ele_quaV, String ele_nameV, String ele_sizeV, String ele_dateV, String ele_date2V, String ele_brandV, String supp, String br) throws SQLException {
        String sq = "SELECT * FROM ELECTRONICS";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        int id = 400000 + count + 1;
        sq = "INSERT INTO PRODUCT (PRODUCT_ID,COST_PRICE,SELLING_PRICE,PRODUCT_TYPE,QUANTITY,BRANCH_ID,INITIAL_QUANTITY) VALUES('" + id + "','" + ele_cpV + "','" + ele_spV + "','" + "200" + "','" + ele_quaV + "','" + br + "','" + ele_quaV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        statement.executeQuery(sq);
        System.out.println("inserted into prod");

        sq = "INSERT INTO ELECTRONICS(PRODUCT_NAME,PRODUCT_ID,ELE_SIZE,BRAND,DELIVARY_DATE,TRENDING_DATE) VALUES ('" + ele_nameV + "','" + id + "','" + ele_sizeV + "','" + ele_brandV + "','" + ele_dateV + "','" + ele_date2V + "')";

        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        int a = statement.executeUpdate(sq);

        System.out.println("inserted into ELECTRONICS");

        sq = "INSERT INTO SUPPLIER_DELIVERS_PRODUCTS VALUES ('" + id + "','" + supp + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cl");
    }

    public static void addFreshProduce(String fre_cpV, String fre_spV, String fre_quaV, String fre_nameV, String fre_dateV, String fre_date2V, String supp, String br) throws SQLException {
        String sq = "SELECT * FROM FRESH_PRODUCE";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        int id = 500000 + count + 1;
        sq = "INSERT INTO PRODUCT (PRODUCT_ID,COST_PRICE,SELLING_PRICE,PRODUCT_TYPE,QUANTITY,BRANCH_ID,INITIAL_QUANTITY) VALUES('" + id + "','" + fre_cpV + "','" + fre_spV + "','" + "500" + "','" + fre_quaV + "','" + br + "','" + fre_quaV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        //   statement.executeQuery(sq);
        System.out.println("inserted into prod");
        sq = "INSERT INTO FRESH_PRODUCE(PRODUCT_NAME,PRODUCT_ID,MANUFACTURING_DATE,EXPIRY_DATE) VALUES ('" + fre_nameV + "','" + id + "','" + fre_dateV + "','" + fre_date2V + "')";

        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        int a = statement.executeUpdate(sq);
        System.out.println("inserted into fre");
        sq = "INSERT INTO SUPPLIER_DELIVERS_PRODUCTS VALUES ('" + id + "','" + supp + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cl");
    }

    public static void addGroceries(String gro_cpV, String gro_spV, String gro_quaV, String gro_nameV, String gro_sizeV, String gro_dateV, String gro_date2V, String gro_brandV, String supp, String br) throws SQLException {
        String sq = "SELECT * FROM GROCERIES";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        int id = 600000 + count + 1;
        sq = "INSERT INTO PRODUCT (PRODUCT_ID,COST_PRICE,SELLING_PRICE,PRODUCT_TYPE,QUANTITY,BRANCH_ID,INITIAL_QUANTITY) VALUES('" + id + "','" + gro_cpV + "','" + gro_spV + "','" + "600" + "','" + gro_quaV + "','" + br + "','" + gro_quaV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        statement.executeQuery(sq);
        System.out.println("inserted into prod");
        sq = "INSERT INTO GROCERIES(PRODUCT_NAME,PRODUCT_ID,GRO_SIZE,BRAND,MANUFACTURING_DATE,EXPIRY_DATE) VALUES ('" + gro_nameV + "','" + id + "','" + gro_sizeV + "','" + gro_brandV + "','" + gro_dateV + "','" + gro_date2V + "')";

        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        int a = statement.executeUpdate(sq);
        System.out.println("inserted into gro");

        sq = "INSERT INTO SUPPLIER_DELIVERS_PRODUCTS VALUES ('" + id + "','" + supp + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cl");
    }

    public static void addToiletries(String toi_cpV, String toi_spV, String toi_quaV, String toi_nameV, String toi_sizeV, String toi_dateV, String toi_date2V, String toi_brandV, String supp, String br) throws SQLException {
        String sq = "SELECT * FROM TOILETRIES";
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        int id = 700000 + count + 1;
        sq = "INSERT INTO PRODUCT (PRODUCT_ID,COST_PRICE,SELLING_PRICE,PRODUCT_TYPE,QUANTITY,BRANCH_ID,INITIAL_QUANTITY) VALUES('" + id + "','" + toi_cpV + "','" + toi_spV + "','" + "700" + "','" + toi_quaV + "','" + br + "','" + toi_quaV + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        statement.executeQuery(sq);
        System.out.println("inserted into prod");
        sq = "INSERT INTO TOILETRIES(PRODUCT_NAME,PRODUCT_ID,TOI_SIZE,BRAND,MANUFACTURING_DATE,EXPIRY_DATE) VALUES ('" + toi_nameV + "','" + id + "','" + toi_sizeV + "','" + toi_brandV + "','" + toi_dateV + "','" + toi_date2V + "')";

        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        int a = statement.executeUpdate(sq);
        System.out.println("inserted into toi");

        sq = "INSERT INTO SUPPLIER_DELIVERS_PRODUCTS VALUES ('" + id + "','" + supp + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("inserted into cl");
    }

    public static void getPendingEmployees() throws SQLException {
        String sq = "SELECT * FROM EMPLOYEE_PENDING";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {

            dataPendingEmp.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    rs.getString(8), rs.getString(11), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getString(6),
                    rs.getString(18), rs.getString(7)));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getPendingBill() throws SQLException {
        String sq = "SELECT * FROM PENDING_BILL";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {

            dataPendingBill.add(new Bill(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4)));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getEmployeesUnderManager(String empID) throws SQLException {
        String sq = "SELECT * FROM EMPLOYEE E JOIN EMPLOYEE E1 ON (E.MANAGER_ID=E1.EMPLOYEE_ID) WHERE E1.EMPLOYEE_ID='" + empID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {

            dataUnderManager.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5),
                    rs.getString(8), rs.getString(11), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17),
                    rs.getString(6),
                    rs.getString(18), rs.getString(7)));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void insertIntoBill(String bill_id, String cus_id, String price, String date, String branchid) throws SQLException {
        CallableStatement stmt = conn.prepareCall("{call inserttobill(?,?,?,?,?)}");
        stmt.setString(1, bill_id);
        stmt.setString(2, cus_id);
        stmt.setString(3, price);
        stmt.setString(4, date);
        stmt.setString(5, branchid);
        stmt.execute();

        System.out.println("success");
    }

    public static void insertIntoPendingBill(String bill_id, String cus_id, String price, String date, String branchid) throws SQLException {
        String sq = "SELECT * FROM PENDING_BILL";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        Employee lastEmp = null;
        int count = 0;
        String id = null;
        while (rs.next()) {
            if (count < Integer.parseInt(rs.getString(1))) {
                count = Integer.parseInt(rs.getString(1));
            }
        }

        count++;
        System.out.println("pending bill id" + count);
        id = Integer.toString(count);
        sq = "INSERT INTO PENDING_BILL VALUES ('" + id + "','" + cus_id + "','" + price + "','" + date + "','" + branchid + "','" + "PENDING" + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("insert into pending bill done");
        System.out.println("success");
    }

    public static void updatePendingEmployee(String id, String status) throws SQLException {
        CallableStatement stmt = conn.prepareCall("{call UPDATEPENDING(?,?)}");
        stmt.setString(1, id);
        stmt.setString(2, status);
        stmt.execute();

        System.out.println("status of pending employee:-->" + id + " is-->" + status);
    }

    public static void updatePendingBill(String id, String status) throws SQLException {
        CallableStatement stmt = conn.prepareCall("{call UPDATEPENDINGBILL(?,?)}");
        stmt.setString(1, id);
        stmt.setString(2, status);
        stmt.execute();

        System.out.println("status of pending employee:-->" + id + " is-->" + status);
    }

    public static void addSupplier(
            String name, String phone, String address, String email) throws SQLException {
        int x = 0;
        CallableStatement stmt = conn.prepareCall("{?=call getid3(?)}");
        stmt.setString(2, "SUPPLIER");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        String id = Integer.toString(stmt.getInt(1) + 1);
        String sq = "INSERT INTO SUPPLIER VALUES('" + id + "','" + name + "','" + phone + "','" + address + "','" + email + "')";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("supplier added");

    }

    public static boolean ifEmployeeUnderManager(String eid, String mid) throws SQLException {
        String sq = "SELECT MANAGER_ID FROM EMPLOYEE WHERE EMPLOYEE_ID = '" + eid + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        if (rs.next()) {
            if (rs.getString("MANAGER_ID").equals(mid) == true) {
                return true;
            }
        }
        return false;

    }

    public static String getBranch(String eid) throws SQLException {
        
        String sq = "SELECT BRANCH_ID FROM EMPLOYEE_WORKS_IN_BRANCH WHERE EMPLOYEE_ID = '" + eid + "' AND END_DATE IS NULL";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        if (rs.next()) {
            return rs.getString("BRANCH_ID");
        }
        return null;

    }
    
    

    public static void generateEmployeeHireReport(String d1, String d2) throws SQLException {
        //    SELECT * FROM TABLE (GENERATE_EMPLOYEE_REPORT('21-DEC-2016','21-DEC-2017'));
        String sq = "SELECT * FROM TABLE(GENERATE_EMPLOYEE_REPORT('" + d1 + "','" + d2 + "'))";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            System.out.println("inside rs");

            dataReportEmpHire.add(new Report(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), null, null, null));

        }

    }

    public static void updateBranch(String eid, String prevB, String newB) throws SQLException, ParseException {
//                 String sq = "SELECT BRANCH_ID FROM EMPLOYEE_WORKS_IN_BRANCH WHERE EMPLOYEE_ID = '"+eid + "' AND END_DATE IS NULL";
//                System.out.println("QUERYY IS " + sq);
//        Statement statement = conn.createStatement();
//        ResultSet rs = statement.executeQuery(sq); 
//        return rs.getString("BRANCH_ID");
        String todayD = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
        java.util.Date t = null;
        t = ft.parse(todayD);
        ft.applyPattern("dd-MMM-YYYY");
        String todaysDate = ft.format(t);

        String sq = "UPDATE EMPLOYEE_WORKS_IN_BRANCH SET END_DATE = '" + todaysDate + "' WHERE EMPLOYEE_ID ='" + eid + "' AND BRANCH_ID='" + prevB + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);

        sq = "INSERT INTO EMPLOYEE_WORKS_IN_BRANCH (EMPLOYEE_ID,BRANCH_ID,START_DATE) VALUES( '" + eid + "','" + newB + "','" + todaysDate + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
    }
    
    
    
    public static void assignBranch(String eid,String newB) throws SQLException, ParseException {

        String todayD = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        SimpleDateFormat ft = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
        java.util.Date t = null;
        t = ft.parse(todayD);
        ft.applyPattern("dd-MMM-YYYY");
        String todaysDate = ft.format(t);

       String sq = "INSERT INTO EMPLOYEE_WORKS_IN_BRANCH (EMPLOYEE_ID,BRANCH_ID,START_DATE) VALUES( '" + eid + "','" + newB + "','" + todaysDate + "')";
        System.out.println("QUERYY IS " + sq);
       Statement statement = conn.createStatement();
       ResultSet rs = statement.executeQuery(sq);
    }

    public static void addCustomer(
            String name, String phone, String address, String email,String gen,String dob,String occ) throws SQLException {
        int x = 0;
        CallableStatement stmt = conn.prepareCall("{?=call getid3(?)}");
        stmt.setString(2, "CUSTOMER");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        String id = Integer.toString(stmt.getInt(1) + 1);
        String sq = "INSERT INTO CUSTOMER VALUES('" + id + "','" + name + "','" + address + "','" + phone + "','" + email + "','" + 0 + "','" + id +"','" + gen + "','" + dob + "','" + occ +"')";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("CUSTOMER added");

    }
    
     public static void addBranch(
             String phone, String address, String email) throws SQLException {
        int x = 0;
        CallableStatement stmt = conn.prepareCall("{?=call getid3(?)}");
        stmt.setString(2, "BRANCH");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        String id = Integer.toString(stmt.getInt(1) + 1);
        String sq = "INSERT INTO BRANCH VALUES('" + id + "','" + address + "','" + phone + "','" + email + "')";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("CUSTOMER added");

    }

    public static void insertIntoBillContainsProduct(String billid, String prodid, String price, String quan) throws SQLException {
        System.out.println("insert into bill contains prod");

        String sq = "INSERT INTO BILL_CONTAINS_PRODUCT VALUES('" + billid + "','" + prodid + "','" + price + "','" + quan + "')";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("insert into bill contains prod done");
    }

    public static void insertIntoPendingBillContainsProduct(String billid, String prodid, String price, String quan) throws SQLException {
        System.out.println("insert into bill contains prod");

        String sq = "SELECT * FROM PENDING_BILL";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        int count = 0;
        String id = null;
        while (rs.next()) {
            if (count < Integer.parseInt(rs.getString(1))) {
                count = Integer.parseInt(rs.getString(1));
            }
        }

        System.out.println("pending bill id" + count);
        id = Integer.toString(count);

        sq = "INSERT INTO PENDING_BILL_CONTAINS_PRODUCT VALUES('" + id + "','" + prodid + "','" + price + "','" + quan + "','" + "PENDING" + "')";
        System.out.println("QUERYY IS " + sq);
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        System.out.println("insert into bill contains prod done");
    }
//         public static void insertIntoCustomerBuysFromBranch(String branchid,String cusid,String billid,String date) throws SQLException{
//            System.out.println("insert intocustomer buy from branch");
//            
//            String sq = "INSERT INTO CUSTOMER_BUYS_FROM_BRANCH VALUES('"+branchid+"','"+cusid+"','"+date+"','"+billid+"')";
//         System.out.println("QUERYY IS " + sq);
//        Statement statement = conn.createStatement();
//        ResultSet rs = statement.executeQuery(sq);
//        System.out.println("insert into customer buy from branch done");
//                }

    public static String getBranchLocation(String ID) throws SQLException {

        String sq = "SELECT LOCATION FROM BRANCH WHERE BRANCH_ID='" + ID + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        if (rs.next()) {
            return rs.getString("LOCATION");
        } else {
            return null;
        }
    }

    public static void deleteFromPending(String id) throws SQLException {
        System.out.println("delete from pending");
        CallableStatement stmt = conn.prepareCall("{call DELETEFROMPENDING(?)}");
        stmt.setString(1, id);
        stmt.execute();

        System.out.println("employee no--->" + id + "<--is deleted from pending emp table");
    }

    public static void deleteFromPendingBill(String id) throws SQLException {
        System.out.println("delete from pending");
        CallableStatement stmt = conn.prepareCall("{call DELETEFROMPENDINGBILL(?)}");
        stmt.setString(1, id);
        stmt.execute();

        System.out.println("employee no--->" + id + "<--is deleted from pending emp table");
    }

    public static int signUp(String jobID, String EmpNameV, String EmpDOBV, String EmpAddressV, String EmpPhoneNumberV, String EmpEmailIDV, String EmpSSCV, String EmpHSCV, String EmpUGV, String EmpMastersV, String pass) throws SQLException {
        String sq = "SELECT * FROM EMPLOYEE_PENDING";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        Employee lastEmp = null;
      int count = 0;
        String id = null;
        while (rs.next()) {
            if (count < Integer.parseInt(rs.getString(1))) {
                count = Integer.parseInt(rs.getString(1));
            }
        }

        count++;
        System.out.println("pending emp id" + count);
        id = Integer.toString(count);
        sq = "SELECT * FROM JOB WHERE JOB_TYPE='" + jobID + "'";
        statement = conn.createStatement();
        rs = statement.executeQuery(sq);
        int sal = 0;
        if (rs.next()) {
            sal = rs.getInt("SALARY");
        }
        System.out.println("SALARY" + sal);
        OraclePreparedStatement pst = null;
        pst
                = (OraclePreparedStatement) conn.prepareStatement("INSERT INTO EMPLOYEE_PENDING(EMP_PENDING_ID,NAME,DATE_OF_BIRTH,ADDRESS,PHONE_NUMBER,EMAIL_ID,SALARY,HIRE_DATE,JOB_TYPE,SSC,HSC,HONORS,MASTERS,STATUS,PASSWORD) "
                        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        pst.setInt(1, count);
        pst.setString(2, EmpNameV);
        java.util.Date myDate = new java.util.Date(EmpDOBV);
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        String todayD = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        java.util.Date myDate1 = new java.util.Date(todayD);
        java.sql.Date today = new java.sql.Date(myDate1.getTime());
        pst.setDate(3, sqlDate);
        pst.setString(4, EmpAddressV);
        int pn = Integer.parseInt(EmpPhoneNumberV);
        pst.setInt(5, pn);
        pst.setString(6, EmpEmailIDV);
        pst.setInt(7, sal);
        pst.setDate(8, today);
        pst.setInt(9, Integer.parseInt(jobID));
        pst.setString(10, EmpSSCV);
        pst.setString(11, EmpHSCV);
        pst.setString(12, EmpUGV);
        pst.setString(13, EmpMastersV);
        pst.setString(14, "PENDING");
        pst.setString(15, pass);
        int a = pst.executeUpdate();
        if (a > 0) {
            ErrorPage.Error("You have registered as a new employee and your status is pending");
            System.out.println("row update");

        }
        return a;
    }

    public static void generateReport(String d1, String d2) throws SQLException {
        String sq = "SELECT * FROM TABLE(GENERATE_REPORT('" + d1 + "','" + d2 + "'))";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            System.out.println("inside rs");

            dataReport.add(new Report(rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));

        }
    }

    public static void getOutOfStock() throws SQLException {
        String sq = "SELECT * FROM OUT_OF_STOCK_PRODUCT";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            int prodType = Integer.parseInt(rs.getString(1).substring(0, 1));

            if (prodType == 1) {
                name = Query.getClothingName(rs.getString(1));
            } else if (prodType == 2) {
                name = Query.getCosmeticsName(rs.getString(1));
            } else if (prodType == 3) {
                name = Query.getCrockeriesName(rs.getString(1));
            } else if (prodType == 4) {
                name = Query.getElectronicsName(rs.getString(1));
            } else if (prodType == 5) {
                name = Query.getFreshProduceName(rs.getString(1));
            } else if (prodType == 6) {
                name = Query.getGroceriesName(rs.getString(1));
            } else if (prodType == 7) {
                name = Query.getToiletriesName(rs.getString(1));
            }
            Product prod = getProductInfo(rs.getString(1));
            String q = prod.getQuantity();
            dataListOfOutofStock.add(new Product(rs.getString(1), name, null, null, null, null));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getClothingList() throws SQLException {
         String sq = "SELECT  C.PRODUCT_NAME, C.PRODUCT_ID FROM CLOTHING C JOIN PRODUCT P ON C.PRODUCT_ID = P.PRODUCT_ID WHERE P.QUANTITY<>0";  System.out.println("QUERYY IS " + sq);
       
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            name = Query.getClothingName(rs.getString(2));
            Product prod = getProductInfo(rs.getString(2));
            String q = prod.getQuantity();
            String p = prod.getPrice();
            list.add(new Product_With_ChoiceBox(rs.getString(2), name, null, null, p, null, q));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getCosmeticsList() throws SQLException {
        String sq = "SELECT  C.PRODUCT_NAME, C.PRODUCT_ID FROM COSMETICS C JOIN PRODUCT P ON C.PRODUCT_ID = P.PRODUCT_ID WHERE P.QUANTITY<>0";  System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            name = Query.getCosmeticsName(rs.getString(2));
            Product prod = getProductInfo(rs.getString(2));
            String q = prod.getQuantity();
            String p = prod.getPrice();
            list.add(new Product_With_ChoiceBox(rs.getString(2), name, null, null, p, null, q));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getCrockeriesList() throws SQLException {
         String sq = "SELECT  C.PRODUCT_NAME, C.PRODUCT_ID FROM CROCKERIES C JOIN PRODUCT P ON C.PRODUCT_ID = P.PRODUCT_ID WHERE P.QUANTITY<>0";  System.out.println("QUERYY IS " + sq);
       
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            name = Query.getCrockeriesName(rs.getString(2));
            Product prod = getProductInfo(rs.getString(2));
            String q = prod.getQuantity();
            String p = prod.getPrice();
            list.add(new Product_With_ChoiceBox(rs.getString(2), name, null, null, p, null, q));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getElectronicsList() throws SQLException {
    String sq = "SELECT  C.PRODUCT_NAME, C.PRODUCT_ID FROM ELECTRONICS C JOIN PRODUCT P ON C.PRODUCT_ID = P.PRODUCT_ID WHERE P.QUANTITY<>0";  System.out.println("QUERYY IS " + sq);
       
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            name = Query.getElectronicsName(rs.getString(2));
            Product prod = getProductInfo(rs.getString(2));
            String q = prod.getQuantity();
            String p = prod.getPrice();
            list.add(new Product_With_ChoiceBox(rs.getString(2), name, null, null, p, null, q));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getFreshProduceList() throws SQLException {
      String sq = "SELECT  C.PRODUCT_NAME, C.PRODUCT_ID FROM FRESH_PRODUCE C JOIN PRODUCT P ON C.PRODUCT_ID = P.PRODUCT_ID WHERE P.QUANTITY<>0";  System.out.println("QUERYY IS " + sq);
       
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            name = Query.getFreshProduceName(rs.getString(2));
            Product prod = getProductInfo(rs.getString(2));
            String q = prod.getQuantity();
            String p = prod.getPrice();
            list.add(new Product_With_ChoiceBox(rs.getString(2), name, null, null, p, null, q));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getGroceriesList() throws SQLException {
       String sq = "SELECT  C.PRODUCT_NAME, C.PRODUCT_ID FROM GROCERIES C JOIN PRODUCT P ON C.PRODUCT_ID = P.PRODUCT_ID WHERE P.QUANTITY<>0";  System.out.println("QUERYY IS " + sq);
       
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            name = Query.getGroceriesName(rs.getString(2));
            Product prod = getProductInfo(rs.getString(2));
            String q = prod.getQuantity();
            String p = prod.getPrice();
            list.add(new Product_With_ChoiceBox(rs.getString(2), name, null, null, p, null, q));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static void getToiletriesList() throws SQLException {
         String sq = "SELECT  C.PRODUCT_NAME, C.PRODUCT_ID FROM TOILETRIES C JOIN PRODUCT P ON C.PRODUCT_ID = P.PRODUCT_ID WHERE P.QUANTITY<>0";  System.out.println("QUERYY IS " + sq);
       
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        System.out.println("query executed :3 ");
        while (rs.next()) {
            String name = null;
            name = Query.getToiletriesName(rs.getString(2));
            Product prod = getProductInfo(rs.getString(2));
            String q = prod.getQuantity();
            String p = prod.getPrice();
            list.add(new Product_With_ChoiceBox(rs.getString(2), name, null, null, p, null, q));
            System.out.println("from rs in pend after getting to data");
        }

    }

    public static boolean checkIfprodInBranch(String prod_id, String branch_id) throws SQLException {
        String sq = "SELECT BRANCH_ID FROM PRODUCT WHERE PRODUCT_ID='" + prod_id + "'";
        System.out.println("QUERYY IS " + sq);
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sq);
        if (rs.next()) {
            if (rs.getString(1).equals(branch_id) == true) {
                return true;
            }
        }
        return false;
    }
}



//SELECT * FROM TABLE(GENERATE_REPORT(TO_DATE('12-12-2017','DD-MM-YYYY'),TO_DATE('12-01-2018','DD-MM-YYYY')));
