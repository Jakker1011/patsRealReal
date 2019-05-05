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
public class patient {
    private int ID;//creates an integer varable
    private String fName;//creates a string varable
    private String sName;//creates a string varable
    private int medAidNo;//creates an integer varable
    private String dateOfBirth;//creates a string varable
    private String email;//creates a string varable

    public patient(int ID, String fName, String sName, int medAidNo, String dateOfBirth, String email) {//craetes a constructer methood for this class
        this.ID = ID;//initiates the variable
        this.fName = fName;//initiates the variable
        this.sName = sName;//initiates the variable
        this.medAidNo = medAidNo;//initiates the variable
        this.dateOfBirth = dateOfBirth;//initiates the variable
        this.email = email;//initiates the variable
    }

    

    public int getID() {//creates a getter methood
        return ID;//returns variable 
    }

    public void setID(int ID) {//creates a setter methood
        this.ID = ID;//sets the variable
    }

    public String getfName() {//creates a getter methood
        return fName;//returns variable 
    }

    public void setfName(String fName) {//creates a setter methood
        this.fName = fName;//sets the variable
    }

    public String getsName() {//creates a getter methood
        return sName;//returns variable 
    }

    public void setsName(String sName) {//creates a setter methood
        this.sName = sName;//sets the variable
    }

   

    public int getMedAidNo() {//creates a getter methood
        return medAidNo;//returns variable 
    }

    public void setMedAidNo(int medAidNo) {//creates a setter methood
        this.medAidNo = medAidNo;//sets the variable
    }

    public String getEmail() {//creates a getter methood
        return email;//returns variable 
    }

    public void setEmail(String email) {//creates a setter methood
        this.email = email;//sets the variable
    }

    public String getDateOfBirth() {//creates a getter methood
        return dateOfBirth;//returns variable 
    }

    public void setDateOfBirth(String dateOfBirth) {//creates a setter methood
        this.dateOfBirth = dateOfBirth;//sets the variable
    }
    
    
}
