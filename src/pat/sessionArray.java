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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jacob Sacks
 */
public class sessionArray {

    private ArrayList<session> sessionList = new ArrayList<>();//creates an new array list

    public sessionArray() {//constructer methood for the class
        connectDB db = new connectDB();//creates an object for the Connect DB cass
        ResultSet r = db.getResults("SELECT * FROM tblSession;");//creates a new result set and sets it to the SQL statement
        try {
            while (r.next()) {//as long as the r resultSet has a next component then,
                session s = new session(r.getInt("SessionID"), r.getInt("patID"), r.getString("dateOfSession"),
                        r.getString("ICD10"), r.getInt("amount"), r.getString("code"), r.getString("time"), r.getBoolean("paid"));//a new session object is created and given the vaues of r

                sessionList.add(s);// object is added to the array list

            }
            r.close();//the result set is closed
        } catch (SQLException ex) {//the SQL statemnt is caught
            JOptionPane.showMessageDialog(null,
                    "Data base error please contact system Administrtor on 063 318 1939");//Displays a suitable error message
        }

    }

    public ArrayList<session> getSessionArray() {//creates a getter fot the array list
        return sessionList;//returns the array lsit
    }

    public void set(ArrayList<session> sessionList) {//creates a setter methood for the array list
        this.sessionList = sessionList;//returns the new array lsit
    }

    public String composeInvoice() {//creates a methood to add the hearrder to a phycoclogysts emails
        String Email = "Shereen Abramowitz\n"
                + "Clinical Psychologist\n"
                + "BA, BA (Hons), H.Dip.Ed, MA (Clin. Psych)\n"
                + "\n"
                + "Consulting Rooms                                                                                               Postal Address\n"
                + "Life Roseacres Hospital                                                                                      PO Box 766\n"
                + "Cnr Castor and St Joseph St                                                                              Highlands North\n"
                + "Primrose                                                                                                               2037\n"
                + "\n"
                + "24 12TH Avenue                                                                                                    Tel: 082 856 2092\n"
                + "Linksfield West                                                                        Email:shereen@abramowitz.co.za\n"
                + "2192                                                    \n"
                + "                                                           PR No. 8628483\n"
                + "\n\n";

        return Email;//returns the email
    }

    public String getSessionEmail(String FName, String SName, int index) {//creates a methood tp get a sessions email with a name and a surname
        patArray ptn = new patArray();//calls the class patArray and makes an object 
        String date[] = new String[sessionList.size()];//creates a string array to the size of the sessionArray
        int patID = ptn.getID(FName, SName);//get the ID of current patient
        int count = 0;//creates an integer varablecalled count
        for (int i = 0; i < sessionList.size(); i++) {//loops through session array
            if (sessionList.get(i).getPatID() == patID) {//if the patients iD in the array at i = the currnet patients ID
                date[count] = sessionList.get(i).getDate();//Adds the date at i to the string array
                count++;//increaeses the count varable by one
            }
        }
        return date[index];//returns the date at the passed in position of the array
    }

    public session getSession(String FName, String SName, String date) {// ceates a methood that returns a session
        patArray ptn = new patArray();//calls the class patArray and makes an object 
        session temp = null;//creats a new session object and sets it to null
        int patID = ptn.getID(FName, SName);//uses the methood get ID to get the patients ID
        for (int i = 0; i < sessionList.size(); i++) {//Loops thriugh the sessionList
            if (sessionList.get(i).getPatID() == patID && sessionList.get(i).getDate().contains(date)) {//If sessionList's date = parsed in date and the ID is the same then,
                temp = sessionList.get(i);//the temp session is set to be the session at i
            }
        }
        return temp;//returns the session
    }

    public int totalDue(int id) {//a Methood that gets the toatal amout a patient owes
        int sum = 0;//creates an integer varable and sets it to 0
        for (int i = 0; i < sessionList.size(); i++) {//Loops through the sessionList
            if (sessionList.get(i).getPatID() == id) {//IF the parsed in ID is eqaul to getPatID
                sum = sum + sessionList.get(i).getAmount();//The cost of the sesiion fets added to the running toatal
            }
        }
        return sum;//retutns the toatal
    }

    public int getPatient(int ID) {//creates a methood that gets the Patient IDs of a Session
        int temp = 0;//creates an integer varable and sets it to 0
        for (int i = 0; i < sessionList.size(); i++) {//Loops through the sessionList
            if (sessionList.get(i).getPatID() == ID) {//IF the parsed in ID is eqaul to getPatID
                temp = sessionList.get(i).getPatID();//the ID is asigend to the temp varable
                break;//breaks the loop
            }
        }
        return temp;//returns the patients ID
    }

    public session getFullSession(int ID) {//creates a methood that gets the full Session from a session id that is parsed in
        session temp = null;//creats a new session object and sets it to null
        for (int i = 0; i < sessionList.size(); i++) {//Loops through the sessionList
            if (sessionList.get(i).getSessionID() == ID) {//IF the parsed in ID is eqaul to Session ID
                temp = sessionList.get(i);//the Session at i is asigend to the temp Session
            }
        }
        return temp;//returns the session
    }

    public void DeleteSession(int ID) {//creates a methood to delete a session
        connectDB db = new connectDB();//creates an object for the class connectDB
        for (int i = 0; i < sessionList.size(); i++) {//loops through sessionArray
            if (sessionList.get(i).getSessionID() == ID) {// if the ID of the Session at i is eqal to the parsed in ID
                sessionList.remove(i);//the element is removed from the array
                try {
                    // student is removed from Data base
                    db.UpdateDatabase("DELETE * FROM tblSession WHERE SessionID = " + ID + ";");// SQL cammand to delete a student
                } catch (SQLException ex) {
                    Logger.getLogger(sessionArray.class.getName()).log(Level.SEVERE, null, ex);//gives the execption to the catch methood
                }
            }
        }
    }

    public void DeleteManySession(int ID) {
        connectDB db = new connectDB();//creates an object for the class connectDB
        for (int i = 0; i < sessionList.size(); i++) {//loops through sessionArray
            if (sessionList.get(i).getPatID() == ID) {// if the ID of the Session at i is eqal to the parsed in ID
                sessionList.remove(i);//the element is removed from the array
                try {
                    // student is removed from Data base
                    db.UpdateDatabase("DELETE * FROM tblSession WHERE patID = " + ID + ";");// SQL cammand to delete a student
                } catch (SQLException ex) {
                    Logger.getLogger(sessionArray.class.getName()).log(Level.SEVERE, null, ex);//gives the execption to the catch methood
                }
            }
        }
    }

    public ArrayList<session> getManySessions(String [] days, String month, String year) {//creates a methoodn that returns an array list of dates
        ArrayList<session> sessTemp = new ArrayList<>();//creates an array list called sessTemp
        for(int j = 0; j < days.length; j ++){//loops thrught the parsed in array
        String fullDate =  month  + "/" +days[j]+ "/"+ year;//formats the date correctly 
        for (int i = 0; i < sessionList.size(); i++) {//loops the sessionList
            if (sessionList.get(i).getDate().contains(fullDate)) {//checks if the date at i from session list = that date from the parsed in aarray
                sessTemp.add(sessionList.get(i));//the session at i is added to the array list
            }
        }
        }
        return sessTemp;//returns the array list
    }
}
