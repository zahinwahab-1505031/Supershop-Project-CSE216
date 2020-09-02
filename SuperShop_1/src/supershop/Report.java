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
public class Report {
   
     private String PRODUCT_ID;
    private String QUAN_BOUGHT;
    private String QUAN_SOLD;
    private String TOTAL_COST_PRICE;
    private String TOTAL_SELLING_PRICE;
    private String PROFIT;
    private String LOSS;

    public Report(String PRODUCT_ID, String QUAN_BOUGHT, String QUAN_SOLD, String TOTAL_COST_PRICE, String TOTAL_SELLING_PRICE, String PROFIT, String LOSS) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.QUAN_BOUGHT = QUAN_BOUGHT;
        this.QUAN_SOLD = QUAN_SOLD;
        this.TOTAL_COST_PRICE = TOTAL_COST_PRICE;
        this.TOTAL_SELLING_PRICE = TOTAL_SELLING_PRICE;
        this.PROFIT = PROFIT;
        this.LOSS = LOSS;
    }

    public String getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public String getQUAN_BOUGHT() {
        return QUAN_BOUGHT;
    }

    public String getQUAN_SOLD() {
        return QUAN_SOLD;
    }

    public String getTOTAL_COST_PRICE() {
        return TOTAL_COST_PRICE;
    }

    public String getTOTAL_SELLING_PRICE() {
        return TOTAL_SELLING_PRICE;
    }

    public String getPROFIT() {
        return PROFIT;
    }

    public String getLOSS() {
        return LOSS;
    }

    public void setPRODUCT_ID(String PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public void setQUAN_BOUGHT(String QUAN_BOUGHT) {
        this.QUAN_BOUGHT = QUAN_BOUGHT;
    }

    public void setQUAN_SOLD(String QUAN_SOLD) {
        this.QUAN_SOLD = QUAN_SOLD;
    }

    public void setTOTAL_COST_PRICE(String TOTAL_COST_PRICE) {
        this.TOTAL_COST_PRICE = TOTAL_COST_PRICE;
    }

    public void setTOTAL_SELLING_PRICE(String TOTAL_SELLING_PRICE) {
        this.TOTAL_SELLING_PRICE = TOTAL_SELLING_PRICE;
    }

    public void setPROFIT(String PROFIT) {
        this.PROFIT = PROFIT;
    }

    public void setLOSS(String LOSS) {
        this.LOSS = LOSS;
    }
    
}
