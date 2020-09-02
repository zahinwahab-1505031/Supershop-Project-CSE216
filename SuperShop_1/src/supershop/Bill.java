/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

/**
 *
 * @author Zahin
 */
public class Bill {
    

     private String BILL_ID;
    private String CUSTOMER_ID;
    private String TOTAL_PRICE;
    private String BILL_DATE;

    public Bill(String BILL_ID, String CUSTOMER_ID, String TOTAL_PRICE, String BILL_DATE) {
        this.BILL_ID = BILL_ID;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.TOTAL_PRICE = TOTAL_PRICE;
        this.BILL_DATE = BILL_DATE;
    }

    public String getBILL_ID() {
        return BILL_ID;
    }

    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setBILL_ID(String BILL_ID) {
        this.BILL_ID = BILL_ID;
    }

    public void setCUSTOMER_ID(String CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public void setTOTAL_PRICE(String TOTAL_PRICE) {
        this.TOTAL_PRICE = TOTAL_PRICE;
    }

    public void setBILL_DATE(String BILL_DATE) {
        this.BILL_DATE = BILL_DATE;
    }

    public String getTOTAL_PRICE() {
        return TOTAL_PRICE;
    }

    public String getBILL_DATE() {
        return BILL_DATE;
    }
    
}
