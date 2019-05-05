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

    connectDB db = new connectDB();
    patArray ptn = new patArray();
    sessionArray ssn = new sessionArray();
    private String currentPat = "";
    MedArray med = new MedArray();

    public String getEmailAD(int id) {
        String sql = "SELECT medEmail FROM tblMed INNER JOIN tblPat ON tblMed.medAidNo = tblPat.medAidNo "
                + "WHERE patID = " + id + ";";
        return sql;
    }

    public String delete(int SessionID) {
        String sql = "DELETE * FROM tblSession WHERE SessionID = '" + SessionID + "'";
        return sql;
    }

    public String deletePAT(int PatientID) {
        String sql = "DELETE * FROM tblPat WHERE patID = '" + PatientID + "'";
        return sql;
    }

    public String populateCMB(String medAid) {
        String sqlS = "SELECT patID, patFName, patSName, tblPat.medAidNo, dateOfBirth, patEmail\n"
                + "FROM tblMed INNER JOIN tblPat ON tblMed.medAidNo = tblPat.medAidNo\n"
                + "WHERE medAid =  '" + medAid + "';";

        return sqlS;
    }

    public String updatePatients(String Tpatient) {
        int val = Tpatient.indexOf(' ');//get pos of space
        String PatientFname = Tpatient.substring(0, val);//gets first name
        String PateintSname = Tpatient.substring((val + 1), Tpatient.length());//gets sur name
        String sql = "SELECT SessionID , patID , dateOfSession ,ICD10, amount, code, time, paid"
                + "  FROM tblPat INNER JOIN tblSession ON tblPat.patID = tblSession.patID"
                + " WHERE patFName = '" + PatientFname + "' AND patSName ='" + PateintSname + "';";
        return sql;
    }

    public String MakePaid(String ID) {
        String sql = "UPDATE tblSession SET Paid = TRUE WHERE SessionID = " + ID + ";";
        return sql;
    }

    public String UpdatePatient(String txtFname, String txtSname, String txtMedicalNumber, String datewithasmallD, String txtEmail, int ID) {
        String sqlS = "";
       if (Login.nUser == true) {
           txtEmail = UserArray.currentEmail;
       }
       sqlS = "UPDATE tblPat SET patFName = '" + txtFname + "' , patSName '" + txtSname + "',"
                    + " medAidNo = '" + txtMedicalNumber + "',  dateOfBirth '" + datewithasmallD + "', "
                    + "patEmail '" + txtEmail + "'  WHERE patID = "+ID+";";
            return sqlS;
    }
    
     public String InsertPatient(String txtFname, String txtSname, String txtMedicalNumber, String datewithasmallD, String txtEmail) {
        String sqlS = "";
       if (Login.nUser == true) {
           txtEmail = UserArray.currentEmail;
       }
       sqlS = "INSERT INTO tblPat(patFName, patSName, medAidNo, dateOfBirth, patEmail)"
                    + "VALUES ('" + txtFname + "', '" + txtSname + "', '" + txtMedicalNumber
                    + "','" + datewithasmallD + "','" + txtEmail + "' );";
        return sqlS;
    }

    public String UpdatePatientMed(String MedicalNumber, String medName, int orgNum) {
        String sqlS = "";
        
            sqlS = "UPDATE tblMed SET medAidNo = " + MedicalNumber + " , medAid ='" + medName + "',"
                    + " medEmail = '" + med.getMedicalAidEmail(medName) + "' WHERE medAidNo = "+ orgNum +" ;";
        
        return sqlS;
    }
    
     public String InsertPatientMed(String MedicalNumber, String medName) {
        String sqlS = "";
            sqlS = "INSERT INTO tblMed(medAidNo, medAid, medEmail)"
                    + "VALUES (" + MedicalNumber + ", '" + medName + "', '" + med.getMedicalAidEmail(medName) + "' );";
        return sqlS;
    }

    public String InsertSession(int patID, String datewithasmallD, String txtIDC, String txtCost, String txtCode, String cmbMin) {
        String insert = "INSERT INTO tblSession (patID, dateOfSession, ICD10, amount, code, time, Paid)"
                + "VAlUES(" + patID + ", '" + datewithasmallD + "', '" + txtIDC + "', " + txtCost + ", '" + txtCode + "', '"
                + cmbMin + "',False);";
        return insert;
    }

    public String UpdateSession(int patID, String datewithasmallD, String txtIDC, String txtCost, String txtCode, String cmbMin) {
        String update = "UPDATE tblSession SET patID = " + patID + " dateOfSession = '" + datewithasmallD + "', ICD10 = '" + txtIDC
                + "' , amount = " + txtCost + ", code = '" + txtCode + "', time = #" + cmbMin
                + "# WHERE SessionID = " + viewSession.currentID + ";";
        return update;
    }

    public String populateHeaddings(){
        String temp= "";
        Formatter formatter = new Formatter();
        temp += formatter.format("%20s %20s %20s %20s %20s %20s %20s", "Date", "First Name", "SurName", "Code", "IDC 10", "Session Cost", "Toatal") + "\n";
        return temp;
    }
    
    public String populateInvoice(String date, String PatientFname, String PatientSname, String code, String IDC10, int Amount, int toatal) {
        String temp = "";
        Formatter formatter = new Formatter();
        formatter = new Formatter();
        temp += formatter.format("%20s %20s %20s %20s %20s %20s %20s", date, PatientFname, PatientSname, code, IDC10, Amount, toatal) + "\n";
        return temp;
    }
}
