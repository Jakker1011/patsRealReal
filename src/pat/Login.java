package pat;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    UserArray usr = new UserArray();//creates an object for the class: UserArray
    Validate val = new Validate();//creates an object for the class: Validate
    patArray ptn = new patArray();//creates an object for the class:patArray
    public static boolean nUser = false;//creates a static boolean varable called nUser

    /**
     * Creates new form Login
     */
    public Login() {//constructor methood for login Class
        initComponents();//initiates all the components for the screen

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        PWord = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNewUser = new javax.swing.JButton();
        UName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnDemoAdmin = new javax.swing.JButton();
        btnDemoUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        PWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PWordActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("User Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password");

        btnNewUser.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnNewUser.setText("New User");
        btnNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewUserActionPerformed(evt);
            }
        });

        UName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Psychologist App");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDemoAdmin.setText("Demo: Admin");
        btnDemoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemoAdminActionPerformed(evt);
            }
        });

        btnDemoUser.setText("Demo: User");
        btnDemoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemoUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PWord, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(UName))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(btnNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnDemoUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDemoAdmin)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(PWord, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDemoAdmin)
                    .addComponent(btnDemoUser))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        usr = new UserArray(); // reinitiates the userArray class
        if (UName.getText().isEmpty() == false && PWord.getText().isEmpty() == false) {//checks if any fields are empty
            if (usr.verify(UName.getText(), PWord.getText()) == true) { //determans if username and password are valid
                if (usr.CheckAdmin(UName.getText()) == true) { //determains if admin
                    this.hide(); //makes login frame hidden
                    new viewSession().setVisible(true); // makes the viewsessions frame visible
                    MediaPlayer mp = new MediaPlayer(); // declares a new MediaPlayer object
                    mp.playSound();  //plays the audio 
                } else {
                    if (nUser == true) { //checks if its first time logging on
                        this.hide();// makes login frame hidden
                        new LoginDetail().setVisible(true);//if havent loged in will open login frame

                    } else {
                        this.hide(); //makes login frame hidden
                        new viewClient().setVisible(true);//opens viewClient frame

                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect User Name or Password");//if user name or password is incorrect it notifiys the user
                UName.setText("");//restes the unsername text field to nothing
                PWord.setText("");//restes the Password text field to nothing
            }
        } else {
            JOptionPane.showMessageDialog(null, "You can not teave any fields blank");//if user left fields blank, they are notified
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewUserActionPerformed
        if (UName.getText().isEmpty() == false && PWord.getText().isEmpty() == false) {//checks if any fields have been left blank
            usr.CreateNewUser(UName.getText(), PWord.getText());//if not it creates new user whith the enterd details(validation done later)
        } else {
            JOptionPane.showMessageDialog(null, "You can not teave any fields blank");//if user left fields blank, they are notified
        }
    }//GEN-LAST:event_btnNewUserActionPerformed


    private void UNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UNameActionPerformed

    }//GEN-LAST:event_UNameActionPerformed

    private void btnDemoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemoUserActionPerformed
        UName.setText("Daniel");//if the user presses a demo button it logs them in
        PWord.setText("Dan123");//if the user presses a demo button it logs them in
    }//GEN-LAST:event_btnDemoUserActionPerformed

    private void btnDemoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemoAdminActionPerformed
        UName.setText("Jacob");//if the user presses a demo button it logs them in as an admin
        PWord.setText("Jacob2001");//if the user presses a demo button it logs them in as an admin
    }//GEN-LAST:event_btnDemoAdminActionPerformed

    private void PWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PWordActionPerformed
        btnLoginActionPerformed(evt);// the 'enter' button can be used instead of using the mouses's click acction performed
    }//GEN-LAST:event_PWordActionPerformed

    public static void main(String args[]) {//the main of the class

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PWord;
    private javax.swing.JTextField UName;
    private javax.swing.JButton btnDemoAdmin;
    private javax.swing.JButton btnDemoUser;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnNewUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
