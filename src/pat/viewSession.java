/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

/**
 *
 * @author Jacob Sacks
 */
public class viewSession extends javax.swing.JFrame {

    connectDB db = new connectDB();//creates an object for the class: connectDB
    patArray ptn = new patArray();//creates an object for the class: patArray
    sessionArray ssn = new sessionArray();//creates an object for the class: sessionArray
    public static String currentPat = "";//creates a static variable called: currentPat
    public static int currentID = 0;//creates a static variable called: currentID
    public static int currentSes = 0;//creates a static variable called: currentSes
    sqlStatements sqlStatement = new sqlStatements();//creates an object for the class: sqlStatement
    Date DATE = new Date();//creates an object for the class: Date
    UserArray usr = new UserArray();//creates an object for the class: UserArray
    populateCombo pop = new populateCombo();//creates an object for the class: populateCombo
    public int add = 0;//creates an integer variable called add
    CalendarModel model = new CalendarModel();//creates an object for the class: connectDB
    public static session s = null;//creates a static variable session called: s
    public static boolean update = false;//creates a static boolean variable called update and sets it to false
    Validate val = new Validate();//creates an object for the class: Validate
    public static ArrayList<session> tSess = null;//creates a static arraylist called tSess
    
    public viewSession() {//constructor methood for  Class
        initComponents();//initiates all the components for the screen
        this.btnDisplayAll.setBackground(Color.YELLOW);//sets the colour of btnDisplayAll to alter the user to click the botton
        this.lbldate.setText("Todays Date: " + DATE.getDate());//sets the label with todays date
        this.lblDate2.setText("Todays Date: " + DATE.getDate());//sets the label with todays date
        tblSessions.setModel(pop.populateSessionTable());//sets the model of the table tblSessions
        tblSessions.setAutoCreateRowSorter(true);//allows for the rows to be sorterd
        DefaultComboBoxModel Tpatient = new DefaultComboBoxModel(pop.populatePatients());//creates a new default table model using a methood from popuatePatients
        this.cmbPatient.setModel(Tpatient);//sets the model of cmbPatient
        DefaultComboBoxModel MED = new DefaultComboBoxModel(pop.populateMED());//creates a new default table model using a methood from popuatePatients
        this.cmbMedAid.setModel(MED);//sets the model of cmbMedAid
        this.tblCredit.setModel(pop.populateCreditTable());//creates a new default table model using a methood from popuatePatients
        tblCredit.setAutoCreateRowSorter(true);//allows for the rows to be sorterd
        this.cmbPatients.setModel(Tpatient);//sets the model of cmbPatients
        this.lblMonth.setText(pop.setMonth(add));//sets the text of lblMonth to todays date
        DefaultComboBoxModel year = new DefaultComboBoxModel(pop.populateYear());//creates a new default table model using a methood from popuatePatients
        this.cmbYear.setModel(year);//sets the model of cmbYear 
        this.tblCalendar.setModel(pop.populateCalender(Integer.parseInt(cmbYear.getSelectedItem().toString()), DATE.revMonth(lblMonth.getText())));//sets the model of the calendar in the table tblCalendar
        
        
    }
    DefaultListModel sessionAddedList = new DefaultListModel();//creates a new default list model
    /**
     * This method is called from within the constructor to the form. WARNING:
     * Do NOT modify this code. The content of this method is always regenerated
     * by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSession = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jMenuItem1 = new javax.swing.JMenuItem();
        Home = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPword = new javax.swing.JTextField();
        btnNewU = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUname = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCredit = new javax.swing.JTable();
        lbldate = new javax.swing.JLabel();
        btnPaid = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSessions = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnNewSession = new javax.swing.JButton();
        cmbPatients = new javax.swing.JComboBox<>();
        txtTotal = new javax.swing.JTextField();
        btnSelect = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtSearch = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPatients = new javax.swing.JTable();
        txtSerach = new javax.swing.JTextField();
        cmbMedAid = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnDeletePat = new javax.swing.JButton();
        btnNewPat = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDisplayAll = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnSearchPat = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        cmbFields = new javax.swing.JComboBox<>();
        btnUpdatePat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEmail = new javax.swing.JButton();
        cmbPatient = new javax.swing.JComboBox<>();
        cmbSessions = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        btnRemove = new javax.swing.JButton();
        btnRest = new javax.swing.JButton();
        lblInvoice = new javax.swing.JLabel();
        btnViewSes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSub = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblMonth = new javax.swing.JLabel();
        cmbYear = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCalendar = new javax.swing.JTable();
        lblMonth1 = new javax.swing.JLabel();
        btnDate = new javax.swing.JButton();
        lblDisplay = new javax.swing.JLabel();
        btnViewSesion = new javax.swing.JButton();
        lblDate2 = new javax.swing.JLabel();
        btnViewSesion1 = new javax.swing.JButton();
        btnViewAll = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuLogout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        tblSession.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tblSession);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jLabel4.setText("jLabel4");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setToolTipText("");

        jLabel15.setText("USER NAME");

        jLabel16.setText("PASSWORD");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel11.setText("WELCOME TO YOUR DESKTOP MANAGER");
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNewU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnNewU.setText("CREATE");
        btnNewU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Still Owe You Money");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Create New Admin");

        txtUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnameActionPerformed(evt);
            }
        });

        jLabel17.setText("Email Adress");

        tblCredit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblCredit);

        lbldate.setText("lblDate");

        btnPaid.setText("Paid");
        btnPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaidActionPerformed(evt);
            }
        });

        btnSend.setText("Send Invoices");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnNewU)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(63, 63, 63))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(77, 77, 77))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtPword, txtUname});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDate)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(62, 62, 62)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbldate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(txtEmail))
                                .addGap(37, 37, 37)))
                        .addComponent(btnNewU)))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnSend)
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnPaid)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        Home.addTab("Home", jPanel5);

        tblSessions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblSessions);

        btnDelete.setText("Delete Sesion");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnNewSession.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNewSession.setText("Add New Session");
        btnNewSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSessionActionPerformed(evt);
            }
        });

        cmbPatients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select A Patient" }));
        cmbPatients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPatientsActionPerformed(evt);
            }
        });

        txtTotal.setText("Total Due:");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnSelect.setText("View Patient Who Booked Session");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update Selected Session");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTotal)
                    .addComponent(cmbPatients, 0, 152, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(btnNewSession)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelect)
                            .addComponent(btnDelete))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate)
                            .addComponent(btnRefresh)))
                    .addComponent(btnNewSession, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Home.addTab("Sessions", jPanel1);

        tblPatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblPatients);

        cmbMedAid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT" }));
        cmbMedAid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedAidActionPerformed(evt);
            }
        });

        jLabel7.setText("Distint medical Aids");

        btnDeletePat.setText("Delete");
        btnDeletePat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePatActionPerformed(evt);
            }
        });

        btnNewPat.setText("Add");
        btnNewPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPatActionPerformed(evt);
            }
        });

        jLabel8.setText("Add New Patient");

        jLabel9.setText("Delete Selected Patient");

        btnDisplayAll.setText("Display All");
        btnDisplayAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayAllActionPerformed(evt);
            }
        });

        jLabel10.setText("Seach For Patient By:");

        btnSearchPat.setText("View Patient");
        btnSearchPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPatActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbFields.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Name", "Last Name", "Medical Aid Number", "Email" }));
        cmbFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFieldsActionPerformed(evt);
            }
        });

        btnUpdatePat.setText("Update");
        btnUpdatePat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePatActionPerformed(evt);
            }
        });

        jLabel3.setText("Update Selected Patient");

        javax.swing.GroupLayout txtSearchLayout = new javax.swing.GroupLayout(txtSearch);
        txtSearch.setLayout(txtSearchLayout);
        txtSearchLayout.setHorizontalGroup(
            txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
            .addGroup(txtSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearchPat, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(btnDisplayAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtSearchLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewPat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txtSearchLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(txtSearchLayout.createSequentialGroup()
                        .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbFields, 0, 150, Short.MAX_VALUE)
                            .addComponent(txtSerach))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdatePat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletePat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMedAid, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        txtSearchLayout.setVerticalGroup(
            txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtSearchLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtSearchLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(9, 9, 9)
                        .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(cmbFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11))
                    .addGroup(txtSearchLayout.createSequentialGroup()
                        .addComponent(btnDisplayAll, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtSearchLayout.createSequentialGroup()
                        .addComponent(txtSerach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch))
                    .addComponent(btnSearchPat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbMedAid, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, txtSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdatePat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNewPat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnDeletePat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        Home.addTab("Patients", txtSearch);

        btnEmail.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEmail.setText("SEND INVOICES");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        cmbPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPatientActionPerformed(evt);
            }
        });

        cmbSessions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sessions" }));
        cmbSessions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSessionsActionPerformed(evt);
            }
        });

        jLabel1.setText("Select sessions that will be sent:");

        jLabel2.setText("Select Patient about whos invoice will be sent:");

        list.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane4.setViewportView(list);

        btnRemove.setText("Remove Selected Session");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnRest.setText("Reset Session Selection");
        btnRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestActionPerformed(evt);
            }
        });

        lblInvoice.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblInvoice.setText("Send Invoices");
        lblInvoice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnViewSes.setText("View Selected Session");
        btnViewSes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbSessions, 0, 197, Short.MAX_VALUE)
                    .addComponent(cmbPatient, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewSes, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(btnRest, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 208, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(lblInvoice))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(198, 198, 198))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblInvoice)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSessions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRemove)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewSes)
                        .addGap(18, 18, 18)
                        .addComponent(btnRest)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        Home.addTab("Send Invoice ", jPanel2);

        btnSub.setText("<<");
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        btnAdd.setText(">>");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblMonth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMonth.setText("January");

        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year" }));
        cmbYear.setToolTipText("");
        cmbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearActionPerformed(evt);
            }
        });

        tblCalendar.setBackground(new java.awt.Color(240, 240, 240));
        tblCalendar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 3, true));
        tblCalendar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblCalendar.setForeground(new java.awt.Color(0, 0, 255));
        tblCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCalendar.setCellSelectionEnabled(true);
        tblCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCalendar.setGridColor(new java.awt.Color(255, 153, 153));
        tblCalendar.setRowMargin(4);
        tblCalendar.setSelectionForeground(new java.awt.Color(255, 102, 102));
        tblCalendar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(tblCalendar);
        tblCalendar.getAccessibleContext().setAccessibleDescription("");

        lblMonth1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMonth1.setText("YEAR:");

        btnDate.setText("Reset Date");
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        lblDisplay.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblDisplay.setText("Past Sessions Calendar");
        lblDisplay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnViewSesion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnViewSesion.setText("View Sessions For Selected Day");
        btnViewSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSesionActionPerformed(evt);
            }
        });

        lblDate2.setText("lblDate");

        btnViewSesion1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnViewSesion1.setText("View Sessions For Selected Day");
        btnViewSesion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewSesion1ActionPerformed(evt);
            }
        });

        btnViewAll.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnViewAll.setText("View Sessions For Selected Month");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSub)
                .addGap(12, 12, 12)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(lblMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(lblDisplay)
                        .addGap(121, 121, 121)
                        .addComponent(lblDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(btnViewSesion1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnViewSesion)
                        .addGap(60, 60, 60)
                        .addComponent(btnViewAll)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisplay)
                    .addComponent(lblDate2))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addComponent(lblMonth1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnDate))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSub)
                        .addComponent(btnAdd)
                        .addComponent(lblMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewSesion)
                    .addComponent(btnViewAll))
                .addGap(163, 163, 163)
                .addComponent(btnViewSesion1)
                .addGap(59, 59, 59))
        );

        Home.addTab("Calender", jPanel4);

        jMenu1.setText("File");

        menuLogout.setText("Logout");
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuLogout);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        UserArray.currentPatient = null;//sets the Static variable currentPatient to nul
        this.hide(); //makes view sessions frame hidden
        new Login().setVisible(true);//sets Login scrren to be visiable
    }//GEN-LAST:event_menuLogoutActionPerformed

    public void editSetup() {
        tblPatients.setCellSelectionEnabled(false); // prevents individual cell selection
        tblPatients.setColumnSelectionAllowed(false); // prevents column selection
        tblPatients.setRowSelectionAllowed(true); // allows row selection
        tblPatients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //restricts the row selection to a single row 
        tblSession.setCellSelectionEnabled(false); // prevents individual cell selection
        tblSession.setColumnSelectionAllowed(false); // prevents column selection
        tblSession.setRowSelectionAllowed(true); // allows row selection
        tblSession.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //restricts the row selection to a single row 
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    private void btnRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestActionPerformed
        this.sessionAddedList.clear();//clears the lsit in sessionAddedList
         DefaultComboBoxModel ses = new DefaultComboBoxModel(pop.populateSession(cmbPatient.getSelectedItem() + ""));//creates a new default table model using a methood from popuatePatients
        cmbSessions.setModel(ses);//sets the model of cmbSessions
    }//GEN-LAST:event_btnRestActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            this.sessionAddedList.remove(this.list.getSelectedIndex());//removes the selected element in sessionAddedList
            this.list.setModel(this.sessionAddedList);//resets the model of the list
        } catch (Exception e) {//catches the statemenet 
            JOptionPane.showMessageDialog(null, "Please select a session to remove");//displays the error message
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void cmbSessionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSessionsActionPerformed
        connectDB db = new connectDB();//creates an object for the class: connectDB
        String vali = "";//creates a string variable
        try{
            vali = cmbSessions.getSelectedItem().toString();//gets the selected item from cmbSessions
        }catch(Exception e){//cateches the statement above
            JOptionPane.showMessageDialog(null, "Please push reset to get the get other sessions");//alerts the user to push the rest button 
        }
        if (vali != "Sessions") {//make sure the selected item is not the hedding 
            sessionAddedList.addElement(vali);//adds the selected item to the lsit called sessionAddedList
            this.list.setModel(sessionAddedList);//resets the model of the lsit
            cmbSessions.removeItem(cmbSessions.getSelectedItem());//removes selected item from the lsit
        }
    }//GEN-LAST:event_cmbSessionsActionPerformed

    private void cmbPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPatientActionPerformed
        if (cmbPatient.getSelectedItem() != "Patients") {//make sure the selected item is not the hedding 
            DefaultComboBoxModel ses = new DefaultComboBoxModel(pop.populateSession(cmbPatient.getSelectedItem() + ""));//creates a new default table model using a methood from popuatePatients
            this.cmbSessions.setModel(ses);//sets the model of the combo box cmbSessions
            this.sessionAddedList.clear();//cleara the sessionAddedList
        }
    }//GEN-LAST:event_cmbPatientActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed

        int val = currentPat.indexOf(' ');//get pos of space
        String PatientFname = currentPat.substring(0, val);//gets first name
        String PateintSname = currentPat.substring((val + 1), currentPat.length());//gets sur name 
        String text = ssn.composeInvoice() + "\n" + sqlStatement.populateHeaddings() +"\n"; //calls up methood to compose invoice for every session
        int toatal = 0;//creates an integer variable 
        for (int i = 0; i < this.sessionAddedList.getSize(); i++) {//loops through the sessionAddedList list 
            session current = ssn.getSession(PatientFname, PateintSname, this.sessionAddedList.elementAt(i) + ""); //adds patient info to email
            toatal = current.getAmount() + toatal;//keeps a running total
            text += sqlStatement.populateInvoice(this.sessionAddedList.elementAt(i) + "", PatientFname, PateintSname, current.getcode(), current.getIDC10(),current.getAmount(), toatal );//creates the text of the email
        }
        String toAddress = "";//creates a string to store the toAddress
        int id = ptn.getID(PatientFname, PateintSname);//creates an integer variable that stores the patient ID
        String sql = sqlStatement.getEmailAD(id);//gets a sql statemnt to get the email
        ResultSet r = db.getResults(sql);//updates the data base useing the sql statement
        try {
            while (r.next()) {//while the result set has a next element
                toAddress = (r.getString("medEmail"));//to to adress to set to the email
            }
        } catch (SQLException ex) {//catches the result set
            Logger.getLogger(populateCombo.class.getName()).log(Level.SEVERE, null, ex);//gievs an exception to the catch statemtemnt
        }
        Emails email = new Emails(toAddress, text, "Invoice");// then the email gets sent as a parameter to the email class
         this.sessionAddedList.clear();//clears the list
         DefaultComboBoxModel ses = new DefaultComboBoxModel(pop.populateSession(cmbPatient.getSelectedItem() + ""));//repopulaes session combobox
        cmbSessions.setModel(ses);//sets the model of the comobox

    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnNewSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSessionActionPerformed
        this.hide();//closes view session screen 
        new NewSession().setVisible(true);//sets NewSession to be visiable
    }//GEN-LAST:event_btnNewSessionActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        tblSessions.setModel(pop.populateSessionTable());//populates tblSessions again to refresh it
        this.txtTotal.setText("");//the text is set to empty

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
         int row = tblSessions.getSelectedRow();// row becomes a row selected in the tblstudents
        if (row != -1) {//make sure a row was selected 
            ssn.DeleteSession(Integer.parseInt(tblSessions.getValueAt(row, 0).toString()));//calls a methood from sesson array to delete that row
            tblSessions.setModel(pop.populateSessionTable());//repopulates the table
            JOptionPane.showMessageDialog(null, "Session Deleted");//a message is shown to confirm that a session was delted
        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the user to select a row
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDisplayAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayAllActionPerformed
        tblPatients.setModel(pop.populatePatientTable());//sets the model of tblPatients
        tblPatients.setAutoCreateRowSorter(true);//allows for auto row sorting
        this.btnDisplayAll.setBackground(Color.WHITE);//sets the coulour of btnDisplayAll
        this.btnDisplayAll.setText("Refresh");//sets the text of btnDisplayAll to be refresh
        this.txtSerach.setText("");//set the text of txtSerach to be empty 
    }//GEN-LAST:event_btnDisplayAllActionPerformed

    private void btnNewPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPatActionPerformed

        new LoginDetail().setVisible(true);//sets the LoginDetail screen to be visiable
        this.hide();//sets this screen to not be visiable

    }//GEN-LAST:event_btnNewPatActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(val.wasentered(txtSerach.getText())){//make sure that txtSerach has text in it
        String sqlSt = ptn.serachPatient(this.cmbFields.getSelectedItem() + "", this.txtSerach.getText() + "");//creates a sql statemnt to search for a patient
        DefaultTableModel model3 = (DefaultTableModel) db.getPatient(sqlSt);//creates a default table model and sets it to use the sql statemnt
        tblPatients.setModel(model3);//sets the model of tblPatients
        }else 
        {
            JOptionPane.showMessageDialog(null, Validate.message);// displays  the error message 
            Validate.message = "";//restest the error message 
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeletePatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePatActionPerformed
    int row = tblPatients.getSelectedRow();// row becomes a row selected in the tblstudents
    int tempID = (Integer.parseInt(tblPatients.getValueAt(row, 0).toString()));//sets the ID of the selected row
        if (row != -1) {//makes sure a row was selected 
            ptn.DeletePaient(tempID);//uses a methood from patient array to delete the patient
            tblPatients.setModel(pop.populatePatientTable());//sets the model of the tblPatients
            JOptionPane.showMessageDialog(null, "Patient Deleted");//alrts the user that the patient was deleted 
           int ans =  JOptionPane.showConfirmDialog(null, "would You like to delete this patients sessions?");//askes the user if they would like to delte the patints sessions aswell
           if(ans ==2){//if answer is yes 
               ssn.DeleteManySession(tempID);//detletes the patients sessions
           }
        tblSessions.setModel(pop.populateSessionTable());//sets the model of tblSessions using populate comboboxes calss 
        DefaultComboBoxModel Tpatient = new DefaultComboBoxModel(pop.populatePatients());//creates a new default table model using a methood from popuatePatients
        this.cmbPatient.setModel(Tpatient);//sets the model of cmbPatient
        DefaultComboBoxModel MED = new DefaultComboBoxModel(pop.populateMED());//creates a new default table model using a methood from popuatePatients
        this.cmbMedAid.setModel(MED);//sets the model of cmbMedAid
        this.tblCredit.setModel(pop.populateCreditTable());//sets the model of tblCredit
        this.cmbPatients.setModel(Tpatient);//sets the model of cmbPatients
        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the userr to select a row from the table
        }
    }//GEN-LAST:event_btnDeletePatActionPerformed

    private void cmbMedAidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMedAidActionPerformed
        String medAid = "" + this.cmbMedAid.getSelectedItem();//gets the selected item from the combo box and stores it in th string variable
        String sql = pop.populateCMB(medAid);//creates a sql statemnt useing the methood populateCMB
        DefaultTableModel model = db.getPatient(sql);//creates a new default table model using a methood from popuatePatients
        tblPatients.setModel(model);//sets the model of tblPatients 
    }//GEN-LAST:event_cmbMedAidActionPerformed

    private void cmbFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFieldsActionPerformed

    }//GEN-LAST:event_cmbFieldsActionPerformed

    private void btnNewUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUActionPerformed
        if (val.wasentered(this.txtUname.getText()) && val.isLoginPass(this.txtPword.getText()) == true && val.wasentered(this.txtEmail.getText()) && val.isemail(this.txtEmail.getText())) {//makes sure that all the enterd values are valid using the validate class's diffrent methoods
            if (usr.CheckExist(this.txtUname.getText()) == false) {//checks if the user name already exits
                usr.CreateNewAdmin(this.txtUname.getText(), this.txtPword.getText(), this.txtEmail.getText());//creates a new admin using the methood CreateNewAdmin
                this.txtEmail.setText("");//sets the text to empty
                this.txtPword.setText("");//sets the text to empty
                this.txtUname.setText("");//sets the text to empty
                Validate.message = "";//rests the validtae message 
            } else {
                JOptionPane.showMessageDialog(null, "User Name Already taken");//alerts the user that the name is not availbe
                Validate.message = "";//rests the validtae message 
            }
        } else {
            JOptionPane.showMessageDialog(null, Validate.message);//displays the errors 
            Validate.message = "";//rests the validtae message 
        }

    }//GEN-LAST:event_btnNewUActionPerformed

    private void cmbPatientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPatientsActionPerformed
        String selPatient = this.cmbPatients.getSelectedItem() + "";//gets the selected item form cmbPatients
        int val = selPatient.indexOf(' ');//get pos of space
        String PatientFname = selPatient.substring(0, val);//gets first name
        String PateintSname = selPatient.substring((val + 1), selPatient.length());//gets sur name 
        String sqlS = sqlStatement.updatePatients(selPatient);//creates a sql statemnt useing the methood updatePatients
        connectDB db = new connectDB();//recreates the object for class connectDB
        DefaultTableModel model = db.getSession(sqlS);//creates a new defaut table model and gets the seioons to populate it
        this.tblSessions.setModel(model);//srts the model of tblSessions
        this.txtTotal.setText("Toatal Due is R" + ssn.totalDue(ptn.getID(PatientFname, PateintSname)) + "");//sets the text of txttoatal to display the toatal due

    }//GEN-LAST:event_cmbPatientsActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed

    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaidActionPerformed
        int row = tblCredit.getSelectedRow();// row becomes a row selected in the tblstudents
        if (row != -1) {//makes sure that a row as selected 
            session s = ssn.getSession(tblCredit.getValueAt(row, 0).toString(), tblCredit.getValueAt(row, 1).toString(), tblCredit.getValueAt(row, 2).toString());//creaes a sew sessiona and calles it s
            String sql = sqlStatement.MakePaid(s.getSessionID() + "");//creates a sql statemnt to make the selcted seion paid
            try {
                db.UpdateDatabase(sql);//updates the data base useing the sql statemnt to MakePaid
            } catch (SQLException ex) {//cateches th update of the DB
                Logger.getLogger(viewSession.class.getName()).log(Level.SEVERE, null, ex);//displays the error message 
            }

            this.tblCredit.setModel(pop.populateCreditTable());//sets the model of tblCredit
        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the user to select a row
        }
    }//GEN-LAST:event_btnPaidActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        int row = tblCredit.getSelectedRow();//gets the int value of the selected row
        if (row != -1) {//make sure that a row was selected
            session s = ssn.getSession(tblCredit.getValueAt(row, 0).toString(), tblCredit.getValueAt(row, 1).toString(), tblCredit.getValueAt(row, 2).toString());//creaes a sew sessiona and calles it s
            patient p = ptn.getFULLPatientID(s.getPatID());//creates a patient object and calles it p useing the methood getFULLPatientID
            this.Home.setSelectedIndex(3);//sets the right screen to be displayed
            this.cmbPatient.setSelectedItem(p.getfName() + " " + p.getsName());//sets what item to display on the combo box
        }else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the user to select a row from the table
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        int row = tblSessions.getSelectedRow();// row becomes a row selected in the tblstudents
        if (row != -1) {//malkes sure a row was selected
            int id = Integer.parseInt(tblSessions.getValueAt(row, 0).toString());//gets the id of the patient and stores it in the integer variable id
            currentSes = id;//makes the static variable currentSes = the ID
            currentID = ssn.getPatient(id);//makes the static variable currentID = session id useing methood getPatient
            new viewPatient().setVisible(true); //sets the screen viewPatient to be visiable
        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the user to select a row from the table
        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnSearchPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPatActionPerformed
        int row = tblPatients.getSelectedRow();// row becomes a row selected in the tblstudents
        if (row != -1) {//make sure a row was chosen
            int id = Integer.parseInt(tblPatients.getValueAt(row, 0).toString());//gets the id of the patient and stores it in the integer variable id
            currentID = id;//makes the static variable currentSes = the ID
            new viewPatient().setVisible(true);//sets the screen viewPatient to be visiable
        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the user to select a row from the table
        }
    }//GEN-LAST:event_btnSearchPatActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int row = tblSessions.getSelectedRow();// row becomes a row selected in the tblstudents
        if (row != -1) {//make sure a row was chosen
            int id = Integer.parseInt(tblSessions.getValueAt(row, 0).toString());//gets the id of the patient and stores it in the integer variable id
            currentID = id;//makes the static variable currentSes = the ID
            update = true;//sets the static variable update to be true
            new NewSession().setVisible(true);//sets the screen viewPatient to be visiable
            this.hide();//sets this screen to not be visiable
        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the user to select a row from the table
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        add++;//increases the variable add by one
        this.lblMonth.setText(pop.setMonth(add));//sets the tetxt in lblMonth to be what the methood setMonth sets it
        this.tblCalendar.setModel(pop.populateCalender(Integer.parseInt(cmbYear.getSelectedItem().toString()), DATE.revMonth(lblMonth.getText())));//sets the model of tbl calender 
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        add--;//increases the variable add by one
        this.lblMonth.setText(pop.setMonth(add));//sets the tetxt in lblMonth to be what the methood setMonth sets it
        this.tblCalendar.setModel(pop.populateCalender(Integer.parseInt(cmbYear.getSelectedItem().toString()), DATE.revMonth(lblMonth.getText())));//sets the model of tbl calender 
    }//GEN-LAST:event_btnSubActionPerformed

    private void cmbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearActionPerformed
        this.tblCalendar.setModel(pop.populateCalender(Integer.parseInt(cmbYear.getSelectedItem().toString()), DATE.revMonth(lblMonth.getText())));//sets the model of tbl calender 
    }//GEN-LAST:event_cmbYearActionPerformed

    private void btnViewSesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSesActionPerformed
        String selPatient = this.cmbPatient.getSelectedItem() + "";//creates a string variable that stores the seleced item from the combo box
        if(this.list.getSelectedIndex() != -1){//insures that an item was selected
        int val = selPatient.indexOf(' ');//get pos of space
        String PatientFname = selPatient.substring(0, val);//gets first name
        String PateintSname = selPatient.substring((val + 1), selPatient.length());//gets sur name 
        s = ssn.getSession(PatientFname, PateintSname, this.list.getSelectedValue() + "");//creayes a new session object 
        new viewSessionDetails().setVisible(true);//sets the screen viewPatient to be visiable
        }else{
            JOptionPane.showMessageDialog(null, "Please select a session to view");//alerts the user to select a row from the table
        }
    }//GEN-LAST:event_btnViewSesActionPerformed

    private void txtUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnameActionPerformed

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        lblMonth.setText(pop.TodayMonth());//sets the text of lblMonth
        cmbYear.setSelectedIndex(0);//sets the selected item from cmbYear
    }//GEN-LAST:event_btnDateActionPerformed

    private void btnViewSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSesionActionPerformed
        int x = tblCalendar.getSelectedRow();///gets the selected row from tblCalendar
        int y = tblCalendar.getSelectedColumn();//gets the selected row from tblCalendar
        if(x != -1 && y != -1){//makes sure that a row and columb was selected 
        Object i = tblCalendar.getModel().getValueAt(x, y);//creates a new object with the seected cell
        String [] days = {i.toString()};//creates a new String array
        tSess = ssn.getManySessions(days, DATE.revMonth(lblMonth.getText())+ "", cmbYear.getSelectedItem() + "");//useses the methood getManySessions to populate the array Tsess
        if(!tSess.isEmpty()){//checks if the array tsess is empty
        new viewSessionDetails().setVisible(true);//sets the screen viewPatient to be visiable
        }else
          JOptionPane.showMessageDialog(null, "No sessions for this day");//alaerts the user that there arw no sessions for slected day
        }else 
            JOptionPane.showMessageDialog(null, "Please Select a day");//alterts the user to select a cell
    }//GEN-LAST:event_btnViewSesionActionPerformed

    private void btnUpdatePatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePatActionPerformed
        int row = tblPatients.getSelectedRow();// row becomes a row selected in the tblstudents
        if (row != -1) {//makes sure a cell was selected
            int id = Integer.parseInt(tblPatients.getValueAt(row, 0).toString());//gets the id of the patient and stores it in the integer variable id
            currentID = id;//makes the static variable currentSes = the ID
            update = true;//makes the static variable currentID = session id useing methood getPatient
            new LoginDetail().setVisible(true);//sets the screen viewPatient to be visiable
        this.hide();//sets this screen to not be visiable
        } else {
            JOptionPane.showMessageDialog(null, "Please Select A Row From The Table");//alerts the user to select a row from the table
        }
        this.hide();//sets this screen to not be visiable
    }//GEN-LAST:event_btnUpdatePatActionPerformed

    private void btnViewSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewSesion1ActionPerformed
       
    }//GEN-LAST:event_btnViewSesion1ActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
        String [] days = pop.sesionsInMonth(cmbYear.getSelectedItem() + "", DATE.revMonth(lblMonth.getText()) + "");//creates a string array that is populated by the methood sesionsInMonth
        tSess = ssn.getManySessions(days, DATE.revMonth(lblMonth.getText()) + "", cmbYear.getSelectedItem() + "");//the array list tSess is populated wit the methood getManySessions
        if(tSess.size() != 0){//checks that there are values stored in the array list tSess
        new viewSessionDetails().setVisible(true);//sets the screen viewPatient to be visiable
        }else
          JOptionPane.showMessageDialog(null, "No sessions for this Month");//alerts the user that there are no seeions in this month
    }//GEN-LAST:event_btnViewAllActionPerformed

    
    
   
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
            java.util.logging.Logger.getLogger(viewSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewSession.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewSession().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Home;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeletePat;
    private javax.swing.JButton btnDisplayAll;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnNewPat;
    private javax.swing.JButton btnNewSession;
    private javax.swing.JButton btnNewU;
    private javax.swing.JButton btnPaid;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRest;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchPat;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSub;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdatePat;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JButton btnViewSes;
    private javax.swing.JButton btnViewSesion;
    private javax.swing.JButton btnViewSesion1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbFields;
    private javax.swing.JComboBox<String> cmbMedAid;
    private javax.swing.JComboBox<String> cmbPatient;
    private javax.swing.JComboBox<String> cmbPatients;
    private javax.swing.JComboBox<String> cmbSessions;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDate2;
    private javax.swing.JLabel lblDisplay;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblMonth1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JList<String> list;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JTable tblCalendar;
    private javax.swing.JTable tblCredit;
    private javax.swing.JTable tblPatients;
    private javax.swing.JTable tblSession;
    private javax.swing.JTable tblSessions;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPword;
    private javax.swing.JPanel txtSearch;
    private javax.swing.JTextField txtSerach;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUname;
    // End of variables declaration//GEN-END:variables
}
