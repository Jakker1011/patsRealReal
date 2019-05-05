/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

/**
 *
 * @author Jacob Sacks
 */
public class session {
    private int SessionID;//creates an integer varable
    private int patID;//creates an integer varable
    private String date;//creates a string varable
    private String ICD10;//creates a string varable
    private int amount;//creates an integer varable
    private String code;//creates a string varable
    private String time;//creates a string varable
    private boolean paid;//creates a boolean variable
    

    public session(int SessionID, int patID, String date, String IDC10, int amount, String code, String time, boolean paid) {//craetes a constructer methood for this class
        this.SessionID = SessionID;
        this.patID = patID;
        this.date = date;
        this.ICD10 = IDC10;
        this.amount = amount;
        this.code = code;
        this.time = time;
        this.paid = paid;
    }

    public int getSessionID() {//creates a getter methood
        return SessionID;//returns variable 
    }

    public void setSessionID(int SessionID) {//creates a setter methood
        this.SessionID = SessionID;//sets the variable
    }

    public int getPatID() {//creates a getter methood
        return patID;//returns variable 
    }

    public void setPatID(int patID) {//creates a setter methood
        this.patID = patID;//sets the variable
    }

    public String getDate() {//creates a getter methood
        return date;//returns variable 
    }

    public void setDate(String date) {//creates a setter methood
        this.date = date;//sets the variable
    }

    public String getIDC10() {//creates a getter methood
        return ICD10;//returns variable 
    }

    public void setIDC10(String IDC10) {//creates a setter methood
        this.ICD10 = IDC10;//sets the variable
    }

    public int getAmount() {//creates a getter methood
        return amount;//returns variable 
    }

    public void setAmount(int amount) {//creates a setter methood
        this.amount = amount;//sets the variable
    }
     public String getcode() {//creates a getter methood
        return code;//returns variable 
    }

    public void setcode(String code) {//creates a setter methood
        this.code = code;//sets the variable
    }

    public String getTime() {//creates a getter methood
        return time;//returns variable 
    }

    public void setTime(String time) {//creates a setter methood
        this.time = time;//sets the variable
    }

    public boolean isPaid() {//creates a getter methood
        return paid;//returns variable 
    }

    public void setPaid(boolean paid){ //creates a setter methood
        this.paid = paid;//sets the variable
    }
    
    
    
}
