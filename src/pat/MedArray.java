/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob Sacks
 */
public class MedArray {
    
    private ArrayList<Medical> MedicalList = new ArrayList<>();//creates an new array list

        public MedArray(){//constructer methood for the class
            connectDB db = new connectDB();//creates an object for the Connect DB cass
            ResultSet r = db.getResults("SELECT * FROM tblMed;");//creates a new result set and sets it to the SQL statement
            try {
                while (r.next()) {//as long as the r resultSet has a next component then,
                    Medical s = new Medical(r.getInt("MedAidNo"), r.getString("MedAid"), r.getString("medEmail"));//a new medical object is created and given the vaues of r
                    MedicalList.add(s);// object is added to the array list

                }
                r.close();//the result set is closed
            } catch (SQLException ex) {//the SQL statemnt is caught
                JOptionPane.showMessageDialog(null,
                        "Data base error please contact system Administrtor on 063 318 1939");//Displays a suitable error message
            }
        }

    public ArrayList<Medical> getMedicalList() {//creates a getter fot the array list
        return MedicalList;//returns the array list
    }
        
        
        public String getMedicalAid(int medNo){//creates a methood to get the medical aid name
            String temp = "";//creates a String Varabe
        for(int i = 0; i < MedicalList.size(); i ++){//loops through the array list
            if(MedicalList.get(i).getMedNo() == medNo){//if the medical aid number at posiition i of the loop is eqaul to the parsed in number, then,
                temp = MedicalList.get(i).getMedAid();// the temp varable is eqaul to the  medica aid number
            }
        }
        return temp;
}
  public String getMedicalAidEmail(String MedName){//creates a methood to get the medical aid email
            String temp = "";//creates a String Varabe
        for(int i = 0; i < MedicalList.size(); i ++){//loops through the array list
            if(MedicalList.get(i).getMedAid().equals(MedName)){//if the medical aid name at posiition i of the loop is eqaul to the parsed in name, then,
                temp = MedicalList.get(i).getMedMail();// the temp varable is eqaul to the  medica aid email
            }
        }
        if(temp.equals("")){//checks if a email was found
            temp = JOptionPane.showInputDialog("Please enter the Medical Aids Email");//if was not then, askes the user to input a email adress
        }
        return temp;//returns the varable
}       
    
}

