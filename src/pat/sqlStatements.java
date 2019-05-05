/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pat.viewSession.currentPat;

/**
 *
 * @author Jacob Sacks
 */
public class sqlStatements {

    connectDB db = new connectDB();//creates an object for the class: connectDB
    patArray ptn = new patArray();//creates an object for the class:patArray
    sessionArray ssn = new sessionArray();//creates an object for the class: sessionArray
    private String currentPat = "";//creates a string varable called currentPat
    MedArray med = new MedArray();//creates an object for the class: MedArray

    public String getEmailAD(int id) {//method to return a sql Statement using the parsed in varable
        String sql = "SELECT medEmail FROM tblMed INNER JOIN tblPat ON tblMed.medAidNo = tblPat.medAidNo "//storeing the sql Staement in the String varable sql
                + "WHERE patID = " + id + ";";
        return sql;//returns sql Statement
    }

    public String delete(int SessionID) {//method to return a sql Statement using the parsed in varable
        String sql = "DELETE * FROM tblSession WHERE SessionID = '" + SessionID + "'";//storeing the sql Staement in the String varable sql
        return sql;//returns sql Statement
    }

    public String deletePAT(int PatientID) {//method to return a sql Statement using the parsed in varable
        String sql = "DELETE * FROM tblPat WHERE patID = '" + PatientID + "'";//storeing the sql Staement in the String varable sql
        return sql;//returns sql Statement
    }

    public String populateCMB(String medAid) {//method to return a sql Statement using the parsed in varable
        String sqlS = "SELECT patID, patFName, patSName, tblPat.medAidNo, dateOfBirth, patEmail\n"//storeing the sql Staement in the String varable sql
                + "FROM tblMed INNER JOIN tblPat ON tblMed.medAidNo = tblPat.medAidNo\n"//storeing the sql Staement in the String varable sql
                + "WHERE medAid =  '" + medAid + "';";//storeing the sql Staement in the String varable sql

        return sqlS;//returns sql Statement
    }

    public String updatePatients(String Tpatient) {//method to return a sql Statement using the parsed in varable
        int val = Tpatient.indexOf(' ');//get pos of space
        String PatientFname = Tpatient.substring(0, val);//gets first name
        String PateintSname = Tpatient.substring((val + 1), Tpatient.length());//gets sur name
        String sql = "SELECT SessionID , patID , dateOfSession ,ICD10, amount, code, time, paid"//storeing the sql Staement in the String varable sql
                + "  FROM tblPat INNER JOIN tblSession ON tblPat.patID = tblSession.patID"//storeing the sql Staement in the String varable sql
                + " WHERE patFName = '" + PatientFname + "' AND patSName ='" + PateintSname + "';";//storeing the sql Staement in the String varable sql
        return sql;//returns sql Statement
    }

    public String MakePaid(String ID) {//method to return a sql Statement using the parsed in varable
        String sql = "UPDATE tblSession SET Paid = TRUE WHERE SessionID = " + ID + ";";//storeing the sql Staement in the String varable sql
        return sql;//returns sql Statement
    }

    public String UpdatePatient(String txtFname, String txtSname, String txtMedicalNumber, String datewithasmallD, String txtEmail, int ID) {//method to return a sql Statement using the parsed in varable
        String sqlS = "";//creates a string varible called sql
       if (Login.nUser == true) {//checks if the static vabiable nUser is set to be true
           txtEmail = UserArray.currentEmail;//sets txtEmail to the static varable currentEmail
       }
       sqlS = "UPDATE tblPat SET patFName = '" + txtFname + "' , patSName '" + txtSname + "',"//storeing the sql Staement in the String varable sql
                    + " medAidNo = '" + txtMedicalNumber + "',  dateOfBirth '" + datewithasmallD + "', "//storeing the sql Staement in the String varable sql
                    + "patEmail '" + txtEmail + "'  WHERE patID = "+ID+";";//storeing the sql Staement in the String varable sql
            return sqlS;//returns sql Statement
    }
    
     public String InsertPatient(String txtFname, String txtSname, String txtMedicalNumber, String datewithasmallD, String txtEmail) {//method to return a sql Statement using the parsed in varable
        String sqlS = "";//creates a string varible called sql
       if (Login.nUser == true) {//checks if the static vabiable nUser is set to be true
           txtEmail = UserArray.currentEmail;//sets txtEmail to the static varable currentEmail
       }
       sqlS = "INSERT INTO tblPat(patFName, patSName, medAidNo, dateOfBirth, patEmail)"//storeing the sql Staement in the String varable sql
                    + "VALUES ('" + txtFname + "', '" + txtSname + "', '" + txtMedicalNumber//storeing the sql Staement in the String varable sql
                    + "','" + datewithasmallD + "','" + txtEmail + "' );";//storeing the sql Staement in the String varable sql
        return sqlS;//returns sql Statement
    }

    public String UpdatePatientMed(String MedicalNumber, String medName, int orgNum) {//method to return a sql Statement using the parsed in varable
        String sqlS = "";//creates a string varible called sql
        sqlS = "UPDATE tblMed SET medAidNo = " + MedicalNumber + " , medAid ='" + medName + "',"//storeing the sql Staement in the String varable sql
                    + " medEmail = '" + med.getMedicalAidEmail(medName) + "' WHERE medAidNo = "+ orgNum +" ;";//storeing the sql Staement in the String varable sql
        
        return sqlS;//returns sql Statement
    }
    
     public String InsertPatientMed(String MedicalNumber, String medName) {//method to return a sql Statement using the parsed in varable
        String sqlS = "";//creates a string varible called sql
            sqlS = "INSERT INTO tblMed(medAidNo, medAid, medEmail)"//storeing the sql Staement in the String varable sql
                    + "VALUES (" + MedicalNumber + ", '" + medName + "', '" + med.getMedicalAidEmail(medName) + "' );";//storeing the sql Staement in the String varable sql
        return sqlS;//returns sql Statement
    }

    public String InsertSession(int patID, String datewithasmallD, String txtIDC, String txtCost, String txtCode, String cmbMin) {//method to return a sql Statement using the parsed in varable
        String insert = "INSERT INTO tblSession (patID, dateOfSession, ICD10, amount, code, time, Paid)"//storeing the sql Staement in the String varable sql
                + "VAlUES(" + patID + ", '" + datewithasmallD + "', '" + txtIDC + "', " + txtCost + ", '" + txtCode + "', '"//storeing the sql Staement in the String varable sql
                + cmbMin + "',False);";//storeing the sql Staement in the String varable sql
        return insert;//return the insert Statement
    }

    public String UpdateSession(int patID, String datewithasmallD, String txtIDC, String txtCost, String txtCode, String cmbMin) {//method to return a sql Statement using the parsed in varable
        String update = "UPDATE tblSession SET patID = " + patID + " dateOfSession = '" + datewithasmallD + "', ICD10 = '" + txtIDC//storeing the sql Staement in the String varable sql
                + "' , amount = " + txtCost + ", code = '" + txtCode + "', time = #" + cmbMin//storeing the sql Staement in the String varable sql
                + "# WHERE SessionID = " + viewSession.currentID + ";";//storeing the sql Staement in the String varable sql
        return update;//return the insert Statement
    }

    public String populateHeaddings(){//method to return a sql Statement using the parsed in varable
        String temp= "";//creates a string varible called sql
        Formatter formatter = new Formatter();//creates a new String formatter 
        temp += formatter.format("%20s %20s %20s %20s %20s %20s %20s", "Date", "First Name", "SurName", "Code", "IDC 10", "Session Cost", "Toatal") + "\n";//formats the date for the invoice
        return temp;//return the temp varable
    }
    
    public String populateInvoice(String date, String PatientFname, String PatientSname, String code, String IDC10, int Amount, int toatal) {//method to return a sql Statement using the parsed in varable
        String temp = "";//creates a string varible called sql
        Formatter formatter = new Formatter();//creates a new String formatter 
        temp += formatter.format("%20s %20s %20s %20s %20s %20s %20s", date, PatientFname, PatientSname, code, IDC10, Amount, toatal) + "\n";//formats the date for the invoice
        return temp;//return the temp varable
    }
}
