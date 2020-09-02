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
public class Customer {
     private String REG_CUS_ID;
    private String NAME;
    private String ADDRESS;
    private String PHONE_NUMBER;
    private String EMAIL_ID;
    private String POINTS;
    private String PASSWORD;
    private String GENDER;
    private String DATEOFBIRTH;
    private String OCCUPATION;

    public Customer(String REG_CUS_ID, String NAME, String ADDRESS, String PHONE_NUMBER, String EMAIL_ID, String POINTS, String PASSWORD, String GENDER, String DATEOFBIRTH, String OCCUPATION) {
        this.REG_CUS_ID = REG_CUS_ID;
        this.NAME = NAME;
        this.ADDRESS = ADDRESS;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.EMAIL_ID = EMAIL_ID;
        this.POINTS = POINTS;
        this.PASSWORD = PASSWORD;
        this.GENDER = GENDER;
        this.DATEOFBIRTH = DATEOFBIRTH;
        this.OCCUPATION = OCCUPATION;
    }

    public void setREG_CUS_ID(String REG_CUS_ID) {
        this.REG_CUS_ID = REG_CUS_ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public void setPHONE_NUMBER(String PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public void setEMAIL_ID(String EMAIL_ID) {
        this.EMAIL_ID = EMAIL_ID;
    }

    public void setPOINTS(String POINTS) {
        this.POINTS = POINTS;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public void setDATEOFBIRTH(String DATEOFBIRTH) {
        this.DATEOFBIRTH = DATEOFBIRTH;
    }

    public void setOCCUPATION(String OCCUPATION) {
        this.OCCUPATION = OCCUPATION;
    }

    public String getREG_CUS_ID() {
        return REG_CUS_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public String getEMAIL_ID() {
        return EMAIL_ID;
    }

    public String getPOINTS() {
        return POINTS;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getGENDER() {
        return GENDER;
    }

    public String getDATEOFBIRTH() {
        return DATEOFBIRTH;
    }

    public String getOCCUPATION() {
        return OCCUPATION;
    }
    
    
}
