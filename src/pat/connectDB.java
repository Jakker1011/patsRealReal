/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class connectDB {

    private Connection conn; //connection type to connect to the database
    private Statement stmt;//statement to store different queries
    private ResultSet rs;//a set of results stored of the stmt

    public connectDB() {
        try {
            
            String url = "jdbc:ucanaccess://PATDB.mdb";//url at which the database is stored on the computer aswell as the driver to connect to the database
            conn = DriverManager.getConnection(url);//establishes the connection to the database
            stmt = conn.createStatement();//allows for data base communication thought the createtion of statements
        } catch (Exception e) { //catches the statemennt
            System.out.println("Problem Connecting to database " + e);//displays apropiate error message
        }
    }

    public ResultSet getResults(String Query) {//creates a methood that allows for a parsed in query to return a result set
        try {
            rs = stmt.executeQuery(Query);//The query that has been sent in via the String query is executed              
        } catch (Exception e) {//catches the Query
            System.out.println("Error occured: " + e);//displays apropiate error message
        }
        return rs;//returns the resultset to the user to be used
    }
    
    public void UpdateDatabase(String G) throws SQLException{//creates a methood to update the data base
        stmt.executeUpdate(G);//updates the date base with the parsed in string G
    }
    
    
    
    public DefaultTableModel getSession(String sqlS) {//sets the default table model for the sessions
        DefaultTableModel model = null;//creats a default table model
        ResultSet r = this.getResults(sqlS);//runs a resultset with the parsed in sql statemnt
        
        Object columnNames[] = {"SessionID","patID", "dateOfSession","ICD10","amount", "code", "time", "paid"};//sets the columnNames for the table
        model = new DefaultTableModel(columnNames, 0);//sets the default table model with the column names 
        try {
            while(r.next()) {//while the result set has a next component
                int SessionID = r.getInt("SessionID");//sets the next componet of the result set to the assigned varaible
                int PatID = r.getInt("patID");//sets the next componet of the result set to the assigned varaible
                String dateOfSession = r.getString("dateOfSession");//sets the next componet of the result set to the assigned varaible
                String ICD10 = r.getString("ICD10");//sets the next componet of the result set to the assigned varaible
                int amounts = r.getInt("amount");//sets the next componet of the result set to the assigned varaible
                String code = r.getString("code");//sets the next componet of the result set to the assigned varaible
                String time = r.getString("time");//sets the next componet of the result set to the assigned varaible
                boolean paid = r.getBoolean("paid");//sets the next componet of the result set to the assigned varaible
                        
                model.addRow(new Object[] {SessionID ,PatID, dateOfSession, ICD10, amounts, code, time, paid});//adds a row to the model
            }
            r.close();//closes the resultset
        } catch (SQLException ex) {//catches the resultset 
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);//displays an error message
        }
        return model;//returns the DefaultTableModel
    }
    public DefaultTableModel getUser(String sqlS) {//sets the default table model for the users
        DefaultTableModel model = null;//creats a default table model
        ResultSet r = this.getResults(sqlS);//runs a resultset with the parsed in sql statemnt
        
        Object columnNames[] = {"UName","PWord", "Admin"};//sets the columnNames for the table
        model = new DefaultTableModel(columnNames, 0);//sets the default table model with the column names
        try {
            while(r.next()) {//while the result set has a next component
                
                String UName = r.getString("UName");//sets the next componet of the result set to the assigned varaible
                String PWord = r.getString("PWord");//sets the next componet of the result set to the assigned varaible
                boolean Admin = r.getBoolean("Admin");//sets the next componet of the result set to the assigned varaible
                
                        
                model.addRow(new Object[] {UName,PWord,Admin});//adds a row to the model
            }
            r.close();//closes the resultset
        } catch (SQLException ex){ //catches the resultset
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);//displays an error message
        }
        return model;//returns the DefaultTableModel
    }
     
      public DefaultTableModel getPatient(String sqlS) {//sets the default table model for the patients
        DefaultTableModel model = null;//creats a default table model
        ResultSet r = this.getResults(sqlS);//runs a resultset with the parsed in sql statemnt
        Object columnNames[] = {"patID", "patFName","patSName" ,"dateOfBirth", "medAidNo" , "patEmail"};//sets the columnNames for the table
        model = new DefaultTableModel(columnNames, 0);//sets the default table model with the column names
        try {
            while(r.next()) { //while the result set has a next component
                int PatID = r.getInt("patID");//sets the next componet of the result set to the assigned varaible
                String patFName = r.getString("patFName");//sets the next componet of the result set to the assigned varaible
                String patSName = r.getString("patSName");//sets the next componet of the result set to the assigned varaible
                String dateOfBirth = r.getString("dateOfBirth");//sets the next componet of the result set to the assigned varaible
                int medAidNo = r.getInt("medAidNo");//sets the next componet of the result set to the assigned varaible
                String patEmail = r.getString("patEmail");//sets the next componet of the result set to the assigned varaible
                
                        
                model.addRow(new Object[] {PatID, patFName ,patSName ,dateOfBirth , medAidNo , patEmail});//adds a row to the model
            }
            r.close();//closes the resultset
        } catch (SQLException ex) {//catches the resultset
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);//displays an error message
        }
        return model;//returns the DefaultTableModel
    }
      
       public DefaultTableModel getMed(String sqlS) {//sets the default table model for the medical aid
        DefaultTableModel model = null;//creats a default table model
        ResultSet r = this.getResults(sqlS);//runs a resultset with the parsed in sql statemnt
        
        Object columnNames[] = {"MedAidNo","MedAid", "medEmail"};//sets the columnNames for the table
        model = new DefaultTableModel(columnNames, 0);//sets the default table model with the column names
        try {
            while(r.next()) {//while the result set has a next component
                int MedAidNo = r.getInt("medAidNo");//sets the next componet of the result set to the assigned varaible
                String MedAid = r.getString("MedAid");//sets the next componet of the result set to the assigned varaible
                String MedEmail = r.getString("medEmail");//sets the next componet of the result set to the assigned varaible
                
                        
                model.addRow(new Object[] {MedAidNo ,MedAid,  MedEmail});//adds a row to the model
            }
            r.close();//closes the resultset
        } catch (SQLException ex) {//catches the resultset
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);//displays an error message
        }
        return model;//returns the DefaultTableModel
    }
        public DefaultTableModel getCreditiors(String sqlS) {//sets the default table model for the creditiors
        DefaultTableModel model = null;//creats a default table model
        ResultSet r = this.getResults(sqlS);//runs a resultset with the parsed in sql statemnt
        
        Object columnNames[] = { "patFName", "patSName", "dateOfSession" , "amount"};//sets the columnNames for the table
        model = new DefaultTableModel(columnNames, 0);//sets the default table model with the column names
        try {
            while(r.next()) {//while the result set has a next component
                
                String patFName = r.getString("patFName");//sets the next componet of the result set to the assigned varaible
                String patSName = r.getString("patSName");//sets the next componet of the result set to the assigned varaible
                String dateOfSession = r.getString("dateOfSession");//sets the next componet of the result set to the assigned varaible
                int amount = r.getInt("amount");//sets the next componet of the result set to the assigned varaible
                        
                model.addRow(new Object[] { patFName, patSName, dateOfSession ,amount});//adds a row to the model
            }
            r.close();//closes the resultset
        } catch (SQLException ex) {//catches the resultset
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);//displays an error message
        }
        return model;//returns the DefaultTableModel
    }
       
}
