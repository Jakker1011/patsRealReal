/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jacob Sacks
 */
public class patArray {

    private ArrayList<patient> patientArray = new ArrayList<>();//creates an new array list

    public patArray() {//constructer methood for the class
        connectDB db = new connectDB();//creates an object for the Connect DB cass
        ResultSet r = db.getResults("SELECT * FROM tblPat;");//creates a new result set and sets it to the SQL statement
        try {
            while (r.next()) {//as long as the r resultSet has a next component then,

                patient p = new patient(r.getInt("patID"), r.getString("patFName"),
                        r.getString("patSName"), r.getInt("medAidNo"), r.getString("dateOfBirth"), r.getString("patEmail"));//a new patient object is created and given the vaues of r
                patientArray.add(p);// object is added to the array list
            }
            r.close();//the result set is closed
        } catch (SQLException ex) {//the SQL statemnt is caught
JOptionPane.showMessageDialog(null,
                    "Data base error please contact system Administrtor on 063 318 1939");//Displays a suitable error message
        }
    }

    public ArrayList<patient> getPatientArray() {//creates a getter fot the array list
        return patientArray;//returns the array list
    }

    public void setPatientArray(ArrayList<patient> patientArray) {//creates a setter methood for the array list
        this.patientArray = patientArray;//sets the arry list to the parsed in value
    }

    public patient getPatientID(String patFName, String patSName) { //method that searches for a patients ID and if it finds the patients’s ID it returns all the details for that particular student
        patient p = null;//creates a new patient object and sets it to null
        for (int k = 0; k < patientArray.size(); k++) { // loops through the number of students
            if (patientArray.get(k).getfName().equals(patFName)) {// if a student in the array eguals has the same ID that was in the parameter it will return that student
                p = patientArray.get(k);// the patient is eqaul to the array list at position i
                break;//breaks the loop
            }
        }
        return p; // or else return null

    }

    public int getID(String PatientFname, String PateintSname) {//that gtes a patients ID whith its first name and sur name parsed in
        int id = 0;//creates an integer varable
        for (int i = 0; i < patientArray.size(); i++) {//loops through the array lsit
            if (patientArray.get(i).getfName().equals(PatientFname) && patientArray.get(i).getsName().equals(PateintSname)) {//checks if the array lsit at i is eaqaul to the parsed in varabe
                id = patientArray.get(i).getID();//sets the id to the array lsit at i
            }
        }
        return id;//returns the ID
    }

    public patient getCurrentPatient(String email) {//gets the patient with just the email
        for (int i = 0; i < patientArray.size(); i++) {//loops throght the whole array list
            if (patientArray.get(i).getEmail().equals(email)) {//checks if the array at position i is eqaul to the given email
                return patientArray.get(i);//returns the patient object at i

            }
        }
        return null;// if doent return a patient will return null
    }

    public String serachPatient(String serachBy, String Serach) {//createsa a mathood that scearches for a patient
        String sqlS = "";//creates a string varable 
        switch (serachBy) {//switches the serachBy Varable 
            case "First Name"://if serachBy is eqaul to the case 
                sqlS = "SELECT * FROM tblPat WHERE patFName LIKE'" + Serach + "*';";//Sets the sql Statement
                break;//breaks the case
            case "Last Name"://if serachBy is eqaul to the case 
                sqlS = "SELECT * FROM tblPat WHERE patSName LIKE '" + Serach + "*';";//Sets the sql Statement
                break;//breaks the case
            case "Medical Aid Number"://if serachBy is eqaul to the case 
                sqlS = "SELECT * FROM tblPat WHERE medAidNo LIKE '" + Serach + "*';";//Sets the sql Statement
                break;//breaks the case
            case "Email"://if serachBy is eqaul to the case 
                sqlS = "SELECT * FROM tblPat WHERE patEmail LIKE '" + Serach + "*';";//Sets the sql Statement
                break;//breaks the case

        }
        return sqlS;//Returns the Spl Statement
    }

    public patient getFULLPatientID(int ID) { //method that searches for a patients ID and if it finds the patients’s ID it returns all the details for that particular student
        patient p = null;//creates a patient object
        for (int k = 0; k < patientArray.size(); k++) { // loops through the number of students
            if (patientArray.get(k).getID() == ID) {// if a student in the array eguals has the same ID that was in the parameter it will return that student
                p = patientArray.get(k);//stores array at i, in the p varable
                break;//breaks the loop
            }
        }
        return p; // or else return null

    }

    public String[] getPossibleSurnames(String Fname) {//creats a methood that returns a string array of names 
        ArrayList<String> names = new ArrayList<String>();//creats an array list
        for (int k = 0; k < patientArray.size(); k++) { // loops through the number of students
            if (patientArray.get(k).getfName().equals(Fname)) {// if a student in the array eguals has the same ID that was in the parameter it will return that student
                names.add(patientArray.get(k).getsName());//adds the name of patientArray to the array lsit
            }
        }
        String[] array = names.toArray(new String[names.size()]);//converts the array list into a String Array
        return array;//returns the String Array
    }
    
     public String[] getPossibleFirstnames(String Sname) {//creats a methood that returns a string array of names 
        ArrayList<String> names = new ArrayList<String>();//creats an array list
        for (int k = 0; k < patientArray.size(); k++) { // loops through the number of students
            if (patientArray.get(k).getsName().equals(Sname)) {// if a student in the array eguals has the same ID that was in the parameter it will return that student
                names.add(patientArray.get(k).getfName());//adds the name of patientArray to the array lsit
            }
        }
        String[] array = names.toArray(new String[names.size()]);//converts the array list into a String Array
        return array;//returns the String Array
    }

    public void DeletePaient(int ID) {//creates a methood to delete a patient
        connectDB db = new connectDB();//creates an object for the class connectDB
        for (int i = 0; i < patientArray.size(); i++) {//loops through patientArray
            if (patientArray.get(i).getID() == ID) {// if the ID of the patient at i is eqal to the parsed in ID
                patientArray.remove(i);//thst element is removed from the array
                try {
                    // student is removed from Data base
                    db.UpdateDatabase("DELETE * FROM tblPat WHERE patID = " + ID + ";");// SQL cammand to delete a student
                } catch (SQLException ex) {
                    Logger.getLogger(sessionArray.class.getName()).log(Level.SEVERE, null, ex);//gives the execption to the catch methood
                }
            }

        }
    }
}
