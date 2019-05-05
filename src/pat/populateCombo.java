/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jacob Sacks
 */
public class populateCombo {

    connectDB db = new connectDB();//creates an object for the class: connectDB
    patArray ptn = new patArray();//creates an object for the class: patArray
    CalendarModel mod = new CalendarModel();//creates an object for the class: CalendarModel
    sessionArray ssn = new sessionArray();//creates an object for the class: sessionArray
    GregorianCalendar cal = new GregorianCalendar(); //Create calendar model
    Date DATE = new Date();//creates an object for the class: Date
    int realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get current day
    int realMonth = cal.get(GregorianCalendar.MONTH); //Get current month
    int realYear = cal.get(GregorianCalendar.YEAR); //Get current year
    int currentMonth = realMonth; //Match month and year
    int currentYear = realYear;//creates a static varable to store the year

    //populates session table
    public DefaultTableModel populateSessionTable() {//creates a methood to popuate a JTable
        DefaultTableModel model = db.getSession("SELECT * FROM tblSession;");//sets the DefaultTableModel form the connect DB class
        return model;//returns the Default Table model
    }

    //populates patient table
    public DefaultTableModel populatePatientTable() {//creates a methood to popuate a JTable
        DefaultTableModel model = db.getPatient("SELECT * FROM tblPat;");//sets the DefaultTableModel form the connect DB class
        return model;//returns the Default Table model
    }

    //populates calender table
    public DefaultTableModel populateCalender(int year, int month) {//creates a methood to popuate a JTable
        DefaultTableModel model = new DefaultTableModel();//sets the DefaultTableModel form the connect DB class
        mod.setMonth(year, month);//sets the days in the calendar table
        model.setDataVector(mod.calendar, mod.days);//sets the model from the Model classes methood setDataVector
        return model;//returns the Default Table model
    }

    //populates credit table
    public DefaultTableModel populateCreditTable() {//creates a methood to popuate a JTable
        DefaultTableModel model = db.getCreditiors("SELECT patFName, patSName, dateOfSession ,amount\n"//sets the DefaultTableModel form the connect DB class
                + "FROM tblPat INNER JOIN tblSession ON tblPat.patID = tblSession.patID\n"
                + "WHERE Paid = False;");
        return model;//returns the Default Table model
    }
    
    //populates patients combo boxes
    public String[] populatePatients() {//creats a methood to return a string array to populate a default combo box model
        String[] patients = new String[ptn.getPatientArray().size()];//creates a string array to the size of PatientArray
        for (int i = 0; i < ptn.getPatientArray().size(); i++) {//loops through patients array
            String fname = ptn.getPatientArray().get(i).getfName();//gets the patients first name
            String lname = ptn.getPatientArray().get(i).getsName();//gets the patients sur name
            patients[i] = fname + " " + lname;//adds the first name and the surname to the array at position i
        }
        return patients;//returns the array
    }
    
    public String[] sesionsInMonth(String Year, String Month) {//creats a methood to return a string array to populate a default combo box model
        ArrayList<String> day = new ArrayList<String>();//creats a new array list called day
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {//loops through getSessionArray
            if (ssn.getSessionArray().get(i).getDate().substring(0, 4).contains(Month) && ssn.getSessionArray().get(i).getDate().substring(5, 10).contains(Year)) {//if the month and the day is equal
                day.add(ssn.getSessionArray().get(i).getDate().substring(3, 5));//the day part of the date is added to the array
            }

        }
        String[] array = day.toArray(new String[day.size()]);//the array list is converted into a string array
        return array;//the array is returned
    }

    //populates schools combo boxes
    public String[] populateYear() {//creats a methood to return a string array to populate a default combo box model
        ArrayList<String> years = new ArrayList<String>();//creats a new array list called years
        for (int i = realYear; i > 2015; i--) {//loops from the real year down to 2015
            years.add(i + "");//add the year from the loop to the array list
        }
        String[] array = years.toArray(new String[years.size()]);//the array list is converted into a string array
        return array;//the array is returned
    }

    public String setMonth(int add) {//methood to get the month inputed by the user into the calendar
        String finalMonth = "";//creates a string varable called finalMonth
        int month = realMonth + add;//adds the current year to the parsed in value
        finalMonth = DATE.getFinalMonth(month);//formats the final month
        return finalMonth;//returns the final month
    }

    //populates medical aid combo boxes
    public String[] populateMED() {//creats a methood to return a string array to populate a default combo box model
        ArrayList<String> MED = new ArrayList<String>();//creats a new array list called MED
        ResultSet r = db.getResults("SELECT DISTINCT medAid FROM tblMed;");//sets a result set to the resutls got from the sql Statemnt 
        try {
            while (r.next()) {//while the resultset varable has a next value
                MED.add(r.getString("medAid"));//gets the mediacl aid and adds it to the MED array
            }
        } catch (SQLException ex) {//catches the statement
            Logger.getLogger(populateCombo.class.getName()).log(Level.SEVERE, null, ex);//creates an execption
        }
        String[] array = MED.toArray(new String[MED.size()]);//the array list is converted into a string array
        return array;//returns the array
    }

    public String[] populateSession(String temp) {//creats a methood to return a string array to populate a default combo box model
        ArrayList<String> client = new ArrayList<String>();//creats a new array list called client
        viewSession.currentPat = temp;//sets currentPat to the passes in varable
        int val = temp.indexOf(' ');//gets index of the space
        String PatientFname = temp.substring(0, val);//seperates into a firstname and surname
        String PateintSname = temp.substring((val + 1), temp.length());//seperates into a firstname and surname
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {//loops through the session Array
            String date = ssn.getSessionEmail(PatientFname, PateintSname, i);//gets the dtae of the sessions of the patient at i
            client.add(date);//adds the date of session to the array
        }

        String[] array = client.toArray(new String[client.size()]);//the array list is converted into a string array
        return array;//returns the array
    }

    public String populateCMB(String medAid) {//creats a methood to return a sql Statement to populate a default combo box model
        String sqlS = "SELECT patID, patFName, patSName, tblPat.medAidNo, dateOfBirth, patEmail\n"//Creates a sql statemnt to populate comboBox
                + "FROM tblMed INNER JOIN tblPat ON tblMed.medAidNo = tblPat.medAidNo\n"//Creates a sql statemnt to populate comboBox
                + "WHERE medAid =  '" + medAid + "';";//Creates a sql statemnt to populate comboBox
        return sqlS;//returns the sql Statemnt
    }

    public ListModel<String> populateClientList(int id) {//creates a methood to popuate a a List Model
        DefaultListModel sess = new DefaultListModel();//creates a default listbmodel called sess
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {//loops through the sessionArray
            if (ssn.getSessionArray().get(i).getPatID() == id && ssn.getSessionArray().get(i).isPaid() == false) {//checks if is the correct Patient and if the email is not paid
                sess.addElement(ssn.getSessionArray().get(i).getDate() + "       R" + ssn.getSessionArray().get(i).getAmount());//adds an elemt to the list
            }

        }
        return sess;////returns the list model
    }

    public String TodayMonth() {//methood to return current month
        String month = DATE.getFinalMonth(currentMonth);//formats current mounth
        return month;//returns current month
    }

   
//stores all the dates that sessions occour in a list

    public String[] dates() {//creats a methood to return a string array to populate a default combo box model
        String[] dates = new String[ssn.getSessionArray().size()];//creates a string array to the size of SessionArray
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {//lops throught session array
            dates[i] = ssn.getSessionArray().get(i).getDate();//adds to the dates array
        }
        return dates;//returns the dates array
    }

   /*public boolean checkIfSession(String date, String[] dates) {
        boolean temp = false;
        for (int i = 0; i < dates.length; i++) {
            if (dates[i].equals(date)) {
                temp = true;
            }
        }
        return temp;
    } */

    public String [] getMin(String Hour) {//creats a methood to return a string array to populate a default combo box model
        String[] times = new String[4];//creates a string array that stores 4 elements
        int time = 15;//sets time to 15
        times[0] = Hour + ":00";//formats the time
        for (int i = 0; i < 3; i++) {//runs a loop from 0 to 3
            times[i + 1] = Hour + ":" + time;//adds the time in a formateded form to the array
            time = time + 15;//increateses time by 15
        }
        return times;//returns the times array
    }
    
    public String[] populateName() {//creats a methood to return a string array to populate a default combo box model
       connectDB db = new connectDB();
         ArrayList<String> Names = new ArrayList<String>();//creats a new array list called MED
        ResultSet r = db.getResults("SELECT DISTINCT patFName FROM tblPat;");//sets a result set to the resutls got from the sql Statemnt 
        try {
            while (r.next()) {//while the resultset varable has a next value
                Names.add(r.getString("patFName"));//gets the patFName and adds it to the Names array
            }
        } catch (SQLException ex) {//catches the statement
            Logger.getLogger(populateCombo.class.getName()).log(Level.SEVERE, null, ex);//creates an execption for the catch
        }
        String[] array = Names.toArray(new String[Names.size()]);//the array list is converted into a string array
        return array;//returns the array
    }
    
    public String[] populateSName() {//creats a methood to return a string array to populate a default combo box model
       connectDB db = new connectDB();
         ArrayList<String> Names = new ArrayList<String>();//creats a new array list called names
        ResultSet r = db.getResults("SELECT DISTINCT patSName FROM tblPat;");//sets a result set to the resutls got from the sql Statemnt 
        try {
            while (r.next()) {//while the resultset varable has a next value
                Names.add(r.getString("patSName"));//gets the patSName and adds it to the names array
            }
        } catch (SQLException ex) {//catches the statement
            Logger.getLogger(populateCombo.class.getName()).log(Level.SEVERE, null, ex);//creates an execption for the catch
        }
        String[] array = Names.toArray(new String[Names.size()]);//the array list is converted into a string array
        return array;//returns the array
    }
    
}
