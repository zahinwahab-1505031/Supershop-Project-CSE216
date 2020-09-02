/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supershop;

import java.util.*;

/**
 *
 * @author Zahin
 */
public class Employee {

    private String EMPLOYEE_ID;
    private String NAME;
    private String DATE_OF_BIRTH;
    private String ADDRESS;
    private String PHONE_NUMBER;
    private String EMAIL_ID;
    private String HIRE_DATE;
    private String JOB_TYPE;
    private String SALARY;
    private String SSC;
    private String HSC;
    private String HONORS;
    private String MASTERS;
    private String MANAGER_ID;
    public void setEMPLOYEE_ID(String EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public String getSALARY() {
        return SALARY;
    }

    public void setSALARY(String SALARY) {
        this.SALARY = SALARY;
    }

   
    public String getMANAGER_ID() {
        return MANAGER_ID;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public void setDATE_OF_BIRTH(String DATE_OF_BIRTH) {
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
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

    public String getEMAIL_ID() {
        return EMAIL_ID;
    }
   
    

    public void setHIRE_DATE(String HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

    public void setJOB_TYPE(String JOB_TYPE) {
        this.JOB_TYPE = JOB_TYPE;
    }

    public void setSSC(String SSC) {
        this.SSC = SSC;
    }

    public void setHSC(String HSC) {
        this.HSC = HSC;
    }

    public void setHONORS(String HONORS) {
        this.HONORS = HONORS;
    }

    public void setMASTERS(String MASTERS) {
        this.MASTERS = MASTERS;
    }
  

    public Employee(String EMPLOYEE_ID, String NAME, String DATE_OF_BIRTH, String ADDRESS, String PHONE_NUMBER, String HIRE_DATE, String JOB_TYPE, String SSC, String HSC, String HONORS, String MASTERS, String EMAIL_ID, String MANAGER_ID,String SALARY) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
        this.NAME = NAME;
        this.DATE_OF_BIRTH = DATE_OF_BIRTH;
        this.ADDRESS = ADDRESS;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.HIRE_DATE = HIRE_DATE;
        this.JOB_TYPE = JOB_TYPE;
        
        this.SSC = SSC;
        this.HSC = HSC;
        this.HONORS = HONORS;
        this.MASTERS = MASTERS;
      
        this.EMAIL_ID = EMAIL_ID;
        this.MANAGER_ID = MANAGER_ID;
        this.SALARY = SALARY;
    

    }

    public String getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getDATE_OF_BIRTH() {
        return DATE_OF_BIRTH;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public String getHIRE_DATE() {
        return HIRE_DATE;
    }

    public String getJOB_TYPE() {
        return JOB_TYPE;
    }

    public String getSSC() {
        return SSC;
    }

    public String getHSC() {
        return HSC;
    }

    public String getHONORS() {
        return HONORS;
    }

    public String getMASTERS() {
        return MASTERS;
    }

}
