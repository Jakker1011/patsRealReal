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
public class Medical {
    private int medNo;//creates an integer varable
    private String medAid;//creates a string varable
    private String medMail;//creates a string varable

    public Medical(int medNo, String medAid, String medMail) {//craetes a constructer methood for this class
        this.medNo = medNo;//initiates the variable
        this.medAid = medAid;//initiates the variable
        this.medMail = medMail;//initiates the variable
    }

    public int getMedNo() {//creates a getter methood
        return medNo;//returns variable 
    }

    public void setMedNo(int medNo) {//creates a setter methood
        this.medNo = medNo;//sets the variable
    }

    public String getMedAid() {//creates a getter methood
        return medAid;//returns variable 
    }

    public void setMedAid(String medAid) {//creates a setter methood
        this.medAid = medAid;//sets the variable
    }

  
    public String getMedMail() {//creates a getter methood
        return medMail;//returns variable 
    }

    public void setMedMail(String medMail) {//creates a setter methood
        this.medMail = medMail;//sets the variable
    }
    
    
}
