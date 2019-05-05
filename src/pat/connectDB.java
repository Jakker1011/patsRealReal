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
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Problem Connecting to database " + e);
        }
    }

    public ResultSet getResults(String Query) {
        try {
            rs = stmt.executeQuery(Query);//The query that has been sent in via the String query is executed              
        } catch (Exception e) {
            System.out.println("Error occured: " + e);
        }
        return rs;//returns the resultset to the user to be used
    }
    
    public void UpdateDatabase(String G) throws SQLException{
        stmt.executeUpdate(G);
    }
    
    
    
    public DefaultTableModel getSession(String sqlS) {
        DefaultTableModel model = null;
        ResultSet r = this.getResults(sqlS);
        
        Object columnNames[] = {"SessionID","patID", "dateOfSession","ICD10","amount", "code", "time", "paid"};
        model = new DefaultTableModel(columnNames, 0);
        try {
            while(r.next()) {
                int SessionID = r.getInt("SessionID");
                int PatID = r.getInt("patID");
                String dateOfSession = r.getString("dateOfSession");
                String ICD10 = r.getString("ICD10");
                int amounts = r.getInt("amount");
                String code = r.getString("code");
                String time = r.getString("time");
                boolean paid = r.getBoolean("paid");
                        
                model.addRow(new Object[] {SessionID ,PatID, dateOfSession, ICD10, amounts, code, time, paid});
            }
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
     public DefaultTableModel getUser(String sqlS) {
        DefaultTableModel model = null;
        ResultSet r = this.getResults(sqlS);
        
        Object columnNames[] = {"UName","PWord", "Admin"};
        model = new DefaultTableModel(columnNames, 0);
        try {
            while(r.next()) {
                
                String UName = r.getString("UName");
                String PWord = r.getString("PWord");
                boolean Admin = r.getBoolean("Admin");
                
                        
                model.addRow(new Object[] {UName,PWord,Admin});
            }
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
     
      public DefaultTableModel getPatient(String sqlS) {
        DefaultTableModel model = null;
        ResultSet r = this.getResults(sqlS);
        Object columnNames[] = {"patID", "patFName","patSName" ,"dateOfBirth", "medAidNo" , "patEmail"};
        model = new DefaultTableModel(columnNames, 0);
        try {
            while(r.next()) {
                int PatID = r.getInt("patID");
                String patFName = r.getString("patFName");
                String patSName = r.getString("patSName");
                String dateOfBirth = r.getString("dateOfBirth");
                int medAidNo = r.getInt("medAidNo");
                String patEmail = r.getString("patEmail");
                
                        
                model.addRow(new Object[] {PatID, patFName ,patSName ,dateOfBirth , medAidNo , patEmail});
            }
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
      
       public DefaultTableModel getMed(String sqlS) {
        DefaultTableModel model = null;
        ResultSet r = this.getResults(sqlS);
        
        Object columnNames[] = {"MedAidNo","MedAid", "medEmail"};
        model = new DefaultTableModel(columnNames, 0);
        try {
            while(r.next()) {
                int MedAidNo = r.getInt("medAidNo");
                String MedAid = r.getString("MedAid");
                String MedEmail = r.getString("medEmail");
                
                        
                model.addRow(new Object[] {MedAidNo ,MedAid,  MedEmail});
            }
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
        public DefaultTableModel getCreditiors(String sqlS) {
        DefaultTableModel model = null;
        ResultSet r = this.getResults(sqlS);
        
        Object columnNames[] = { "patFName", "patSName", "dateOfSession" , "amount"};
        model = new DefaultTableModel(columnNames, 0);
        try {
            while(r.next()) {
                
                String patFName = r.getString("patFName");
                String patSName = r.getString("patSName");
                String dateOfSession = r.getString("dateOfSession");
                int amount = r.getInt("amount");
                        
                model.addRow(new Object[] { patFName, patSName, dateOfSession ,amount});
            }
            r.close();
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
       
}
