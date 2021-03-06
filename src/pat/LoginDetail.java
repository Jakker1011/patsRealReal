/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Jacob Sacks
 */
public class LoginDetail extends javax.swing.JFrame {

    Validate val = new Validate();//creates an object for the class: Validate
    sessionArray ssn = new sessionArray();//creates an object for the class: sessionArray
    Date DATE = new Date();//creates an object for the class: Date
    patArray ptn = new patArray();//creates an object for the class: patArray
    sqlStatements sql = new sqlStatements();//creates an object for the class: sqlStatements
    MedArray med = new MedArray();//creates an object for the class: MedArray
    populateCombo pop = new populateCombo();//creates an object for the class: populateCombo

    /**
     * Creates new form LoginDetail
     */
    public LoginDetail() {//constructor methood for loginDetails Class
        initComponents();//initiates all the components for the screen
        java.util.Date date1 = null;//creates a new Date varable and sets it to null
        DefaultComboBoxModel MED = new DefaultComboBoxModel(pop.populateMED());// creates a new Default ComboBoxModel and populates from the populate comboCombobox class
        this.cmbMedAid.setModel(MED);//sets cmbMedAid to the combobox model
        this.cmbMedAid.addItem("Med Aid Not on List");//adds an item to the comboBox
        if (Login.nUser == true) {//checks if the static varable nUser is set to true
            this.btnBack.setVisible(false);//makes inisible the componenet: btnBack
            this.lblEmail.setVisible(false);//makes inisible the componenet: lblEmail
            this.txtEmail.setVisible(false);//makes inisible the componenet: txtEmail
            JOptionPane.showMessageDialog(null, "Welcome new User\nPlease fullin some personal information");// welcomes the new user
        }

        if (viewSession.update == true) {//checks if the static varable update is set to true, if it is then,
            this.lblHead.setText("Update Patient Details");//Sets the lables text to:
            this.btnAdd.setText("Update Patent");//Sets the lables text to:
            patient p = ptn.getFULLPatientID(viewSession.currentID);//a new patient varable is created useing the patientArrays methood
            this.txtFname.setText(p.getfName());//sets text field to allocated component of the patient 
            this.txtSname.setText(p.getsName());//sets text field to allocated component of the patient 
            this.txtMedicalNumber.setText(p.getMedAidNo() + "");//sets text field to allocated component of the patient 
            this.cmbMedAid.setSelectedItem(med.getMedicalAid(p.getMedAidNo()));//sets text field to allocated component of the patient using the medArray methood to get the details
            this.calDOB.setDateFormatString(p.getDateOfBirth());//sets text field to allocated component of the patient 
            this.txtEmail.setText(p.getEmail());//sets text field to allocated component of the patient 
            String sDate1 = p.getDateOfBirth();//sets the string varable sDate1 to allocated component of the patient 
            try {
                date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);//chaings the string into a date format
            } catch (ParseException ex) {//catches the chane of format
                Logger.getLogger(NewSession.class.getName()).log(Level.SEVERE, null, ex);//gives the error message
            }
            this.calDOB.setDate(date1);///sets text field to date format date
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        lblHead = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblFName1 = new javax.swing.JLabel();
        lblFName2 = new javax.swing.JLabel();
        lblFName3 = new javax.swing.JLabel();
        lblFName4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtFname = new javax.swing.JTextField();
        txtSname = new javax.swing.JTextField();
        calDOB = new com.toedter.calendar.JDateChooser();
        txtMedicalNumber = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cmbMedAid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHead.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHead.setText("Enter Patient Details");

        lblFName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFName.setText("First Name");

        lblFName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFName1.setText("Surname");

        lblFName2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFName2.setText("Date Of Birth");

        lblFName3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFName3.setText("Medical Aid Number");

        lblFName4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFName4.setText("Medical Aid Name");

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setText("Add Patient");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        cmbMedAid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Med Aid Not on List" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblHead, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFName1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFName2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFName3)
                                    .addComponent(lblFName4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFname)
                                    .addComponent(txtSname)
                                    .addComponent(calDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(txtMedicalNumber)
                                    .addComponent(txtEmail)
                                    .addComponent(cmbMedAid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblHead, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFName2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedicalNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMedAid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnBack))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //Validate.message = "";
        if (val.isName(this.txtFname.getText(), true) && val.isName(this.txtSname.getText(), true) && val.isNumber(this.txtMedicalNumber.getText(), true)//does the validation of all the enterd fields using methoods from the validate class
                && val.wasentered(this.txtFname.getText()) && val.wasentered(this.txtSname.getText())//does the validation of all the enterd fields using methoods from the validate class
                && val.wasentered(this.txtMedicalNumber.getText()) && val.wasentered(this.txtEmail.getText())//does the validation of all the enterd fields using methoods from the validate class
                && val.isemail(this.txtEmail.getText())) {//does the validation of all the enterd fields using methoods from the validate class
            String Date = this.calDOB.getDate().toString();//gets the selected item from the combo box
            String datewithasmallD = DATE.formatDate(Date);//formats the date that was gotten
            String medAidFinal = "";// createsa varable that will store the medical aid email
            if (this.cmbMedAid.getSelectedItem().equals("Med Aid Not on List")) {//checks that the selected item is not the instruction
                String temp = JOptionPane.showInputDialog("Please Enter The Name Of the Medical Aid");//asks the user to enter the name of thier medical aid
                if (temp.isEmpty() == false) {//makes sure that the anser was not empty
                    medAidFinal = temp;//sets the name of the email adress
                }
            } else {
                medAidFinal = this.cmbMedAid.getSelectedItem() + "";//get the selected item frm the comobox
            }
            if (viewSession.update == true) {//if the static varible update is true
                int patientID = ptn.getFULLPatientID(viewSession.currentID).getID();//the patient id is set uding the static varable currentID
                int originalNo = ptn.getFULLPatientID(viewSession.currentID).getMedAidNo();//the patient medical aid number is set uding the static varable currentID
                connectDB db = new connectDB();//calls the class connect DB
                String sqlS = sql.UpdatePatient(this.txtFname.getText(), this.txtSname.getText(), this.txtMedicalNumber.getText(), datewithasmallD, this.txtEmail.getText(), patientID);//parses in varables to the sqlStamet class to do the methood
                String sqlS2 = sql.UpdatePatientMed(this.txtMedicalNumber.getText(), medAidFinal, originalNo);//parses in varables to the sqlStamet class to do the methood
                try {
                    db.UpdateDatabase(sqlS);//updates the data baase whith the returned sql Statemnt 
                    db.UpdateDatabase(sqlS2);//updates the data baase whith the returned sql Statemnt 
                    viewSession.update = false;//setsb the static varible update to false
                    JOptionPane.showMessageDialog(null, "Update Patient Sucsessfull");//alerts the user the update was sucsessfull
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error in SQl Satamet, please contact the ADMIN");//alerts the user the update was not sucsessfull
                }
            } else {
                connectDB db = new connectDB();//calls the class connect DB
                String sqlS = sql.InsertPatient(this.txtFname.getText(), this.txtSname.getText(), this.txtMedicalNumber.getText(), datewithasmallD, this.txtEmail.getText());//parses in varables to the sqlStamet class to call the methood
                String sqlS2 = sql.InsertPatientMed(this.txtMedicalNumber.getText(), medAidFinal);//parses in varables to the sqlStamet class to call and run the methood
                try {
                    db.UpdateDatabase(sqlS);//updates the data baase whith the returned sql Statemnt 
                    db.UpdateDatabase(sqlS2);//updates the data baase whith the returned sql Statemnt 
                    JOptionPane.showMessageDialog(null, "Insert of Patient Sucsessfull");//alerts the user the update was sucsessfull

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error in SQl Satamet, please contact the ADMIN");//alerts the user the update was not sucsessfull
                }
            }
            if (Login.nUser == true) {//checks if the static varable nuser is true
                new viewClient().setVisible(true);//opens the screen viewClient
                this.hide();// closes this screen
            } else {
                new viewSession().setVisible(true);//opens the screen viewSession
                this.hide();//hides this screen
            }

        } else {
            JOptionPane.showMessageDialog(null, Validate.message);//displays the eroor message from the validate class
            Validate.message = "";//resets the error messsage
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.hide();//hides this screen
        new viewSession().setVisible(true);//sets the viewSession screen to be visibble
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private com.toedter.calendar.JDateChooser calDOB;
    private javax.swing.JComboBox<String> cmbMedAid;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblFName1;
    private javax.swing.JLabel lblFName2;
    private javax.swing.JLabel lblFName3;
    private javax.swing.JLabel lblFName4;
    private javax.swing.JLabel lblHead;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtMedicalNumber;
    private javax.swing.JTextField txtSname;
    // End of variables declaration//GEN-END:variables
}
