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

    connectDB db = new connectDB();
    patArray ptn = new patArray();
    CalendarModel mod = new CalendarModel();
    sessionArray ssn = new sessionArray();
    GregorianCalendar cal = new GregorianCalendar(); //Create calendar
    Date DATE = new Date();
    int realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
    int realMonth = cal.get(GregorianCalendar.MONTH); //Get month
    int realYear = cal.get(GregorianCalendar.YEAR); //Get year
    int currentMonth = realMonth; //Match month and year
    int currentYear = realYear;

    //populates session table
    public DefaultTableModel populateSessionTable() {
        DefaultTableModel model = db.getSession("SELECT * FROM tblSession;");
        return model;
    }

    //populates session table
    public DefaultTableModel populatePatientTable() {
        DefaultTableModel model = db.getPatient("SELECT * FROM tblPat;");
        return model;
    }

    //populates session table
    public DefaultTableModel populateCalender(int year, int month) {
        DefaultTableModel model = new DefaultTableModel();
        mod.setMonth(year, month);
        model.setDataVector(mod.calendar, mod.days);
        return model;
    }

    public String[] sesionsInMonth(String Year, String Month) {
        ArrayList<String> day = new ArrayList<String>();
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {
            if (ssn.getSessionArray().get(i).getDate().substring(0, 4).contains(Month) && ssn.getSessionArray().get(i).getDate().substring(5, 10).contains(Year)) {
                day.add(ssn.getSessionArray().get(i).getDate().substring(3, 5));
            }

        }
        String[] array = day.toArray(new String[day.size()]);
        return array;
    }

    //populates schools combo boxes
    public String[] populateYear() {
        ArrayList<String> years = new ArrayList<String>();
        for (int i = realYear; i > 2015; i--) {
            years.add(i + "");
        }
        String[] array = years.toArray(new String[years.size()]);
        return array;
    }

    public String setMonth(int add) {
        String finalMonth = "";
        int month = realMonth + add;
        finalMonth = DATE.getFinalMonth(month);
        return finalMonth;
    }

    //populates session table
    public DefaultTableModel populateCreditTable() {
        DefaultTableModel model = db.getCreditiors("SELECT patFName, patSName, dateOfSession ,amount\n"
                + "FROM tblPat INNER JOIN tblSession ON tblPat.patID = tblSession.patID\n"
                + "WHERE Paid = False;");
        return model;
    }

    //populates schools combo boxes
    public String[] populatePatients() {
        String[] patients = new String[ptn.getPatientArray().size()];
        for (int i = 0; i < ptn.getPatientArray().size(); i++) {
            String fname = ptn.getPatientArray().get(i).getfName();
            String lname = ptn.getPatientArray().get(i).getsName();
            patients[i] = fname + " " + lname;
        }
        return patients;
    }

    //populates schools combo boxes
    public String[] populateMED() {
        ArrayList<String> MED = new ArrayList<String>();
        ResultSet r = db.getResults("SELECT DISTINCT medAid FROM tblMed;");
        try {
            while (r.next()) {
                MED.add(r.getString("medAid"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(populateCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = MED.toArray(new String[MED.size()]);
        return array;
    }

    public String[] populateSession(String temp) {
        ArrayList<String> client = new ArrayList<String>();
        viewSession.currentPat = temp;
        int val = temp.indexOf(' ');
        String PatientFname = temp.substring(0, val);
        String PateintSname = temp.substring((val + 1), temp.length());
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {
            String date = ssn.getSessionEmail(PatientFname, PateintSname, i);
            client.add(date);
        }

        String[] array = client.toArray(new String[client.size()]);
        return array;
    }

    public String populateCMB(String medAid) {
        String sqlS = "SELECT patID, patFName, patSName, tblPat.medAidNo, dateOfBirth, patEmail\n"
                + "FROM tblMed INNER JOIN tblPat ON tblMed.medAidNo = tblPat.medAidNo\n"
                + "WHERE medAid =  '" + medAid + "';";
        return sqlS;
    }

    public ListModel<String> populateClientList(int id) {
        DefaultListModel sess = new DefaultListModel();;
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {
            if (ssn.getSessionArray().get(i).getPatID() == id && ssn.getSessionArray().get(i).isPaid() == false) {
                sess.addElement(ssn.getSessionArray().get(i).getDate() + "       R" + ssn.getSessionArray().get(i).getAmount());
            }

        }
        return sess;
    }

    public String TodayMonth() {
        String month = DATE.getFinalMonth(currentMonth);
        return month;
    }

   
//stores all the dates that sessions occour in a list

    public String[] dates() {
        String[] dates = new String[ssn.getSessionArray().size()];
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {
            dates[i] = ssn.getSessionArray().get(i).getDate();
        }
        return dates;
    }

    public boolean checkIfSession(String date, String[] dates) {
        boolean temp = false;
        for (int i = 0; i < dates.length; i++) {
            if (dates[i].equals(date)) {
                temp = true;
            }
        }
        return temp;
    }

    public String [] getMin(String Hour) {
        String[] times = new String[4];
        int time = 15;
        times[0] = Hour + ":00";
        for (int i = 0; i < 3; i++) {
            times[i + 1] = Hour + ":" + time;
            time = time + 15;
        }
        return times;
    }
    
    public String[] populateName() {
       connectDB db = new connectDB();
         ArrayList<String> Names = new ArrayList<String>();
        ResultSet r = db.getResults("SELECT DISTINCT patFName FROM tblPat;");
        try {
            while (r.next()) {
                Names.add(r.getString("patFName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(populateCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = Names.toArray(new String[Names.size()]);
        return array;
    }
    
    public String[] populateSName() {
       connectDB db = new connectDB();
         ArrayList<String> Names = new ArrayList<String>();
        ResultSet r = db.getResults("SELECT DISTINCT patSName FROM tblPat;");
        try {
            while (r.next()) {
                Names.add(r.getString("patSName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(populateCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = Names.toArray(new String[Names.size()]);
        return array;
    }
    
}
