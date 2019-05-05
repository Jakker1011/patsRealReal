/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import static pat.Login.nUser;

/**
 *
 * @author Jacob Sacks
 */
public class UserArray { // main method 

    public static patient currentPatient = null;
    public static String currentEmail = "";
    Validate val = new Validate();
     private ArrayList<User> userArray = new ArrayList<>(); // array to store 100 usernames and passwords 


    public UserArray(){//Default Constructor. It will populate the UsernamePasswordArray with data from the Passwords textfile.
        try {
            Scanner scFile = new Scanner(new File("Passwords.txt")); // scanning the Passwords text file in
            while (scFile.hasNext()) { //loop through while there is another line in the text file 
                String line = scFile.nextLine();
                Scanner scLine = new Scanner(line).useDelimiter("#");// goes through the line, the usernme and password are seperated by delimeters                
                String UserName = scLine.next(); // first part of line is the Username
                String Passwords = scLine.next();// second part of line is the password
                String admin = scLine.next();//Third part is the weather it is an admin or a user
                String email = scLine.next();//fourth part is the email adress
                String Password = "";
                   
            String decrypin = Passwords;
            String decryptk;
            decryptk = "thisisasecurekey";
            SecretKeySpec key = new SecretKeySpec(decryptk.getBytes(), "AES");
            Cipher decryptCipher = null;
            
                decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
         
            decryptCipher.init(Cipher.DECRYPT_MODE, key);
            String decryptpass = new String(decryptCipher.doFinal(Base64.decodeBase64(decrypin)));
            decryptpass = EncryptDecrypt.decrypt(decryptpass);//putting the String variable in brackets sends it to the method
            Password = decryptpass;
            
      
    

                 User s = new User(UserName, Password, admin, email); // adds the username, password, Admin, email to array
                 userArray.add(s);
            }
            scFile.close();

        } catch (FileNotFoundException ex) { //if this wss not attained an error message will appear
            JOptionPane.showMessageDialog(new JFrame(), "File Not Found", "Error",// This is the error message displayed
                    JOptionPane.ERROR_MESSAGE);

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<User> getUserArray() {
        return userArray;
    }

    public void setUserArray(ArrayList<User> userArray) {
        this.userArray = userArray;
    }
    
    

    public boolean verify(String user, String pass) { //Method that verifies the students username and password.
        patArray allPatients = new patArray();
        boolean found = false; // found starts by being false 
        for (int i = 0; i < userArray.size(); i++) { //loops through the usernames and passwords 
            if (userArray.get(i).getUsername().equals(user) && userArray.get(i).getPassword().equals(pass)) {// if the username from the array and the password from the array equal the username and password put in then found will equal true.
                found = true;// then found equals true 
                currentPatient = allPatients.getCurrentPatient(userArray.get(i).getEmail());
            }
        }
        return found;// returns found
    }

    public boolean CheckAdmin(String AD) { //methood checks if user is an admin
        boolean adm = false; //admin starts by being false
        for (int i = 0; i < userArray.size(); i++) { //loops through the usernames and passwords 
            if (userArray.get(i).getUsername().equals(AD) && userArray.get(i).getAdmin().equals("A")) { //checks if user is an admin
                adm = true;// adm updates to true
                
            }
        }

        return adm;

    }
    
    public boolean CheckExist(String user){
          boolean found = false; // found starts by being false 
        for (int i = 0; i < userArray.size(); i++) { //loops through the usernames and passwords 
            if (userArray.get(i).getUsername().equals(user)) {// if the username from the array and the password from the array equal the username and password put in then found will equal true.
                found = true;// then found equals true 
    }
        }
        return found;
    }

    public void addNewUser(String user, String password, String admin, String email){//Method that adds a new username and password to the textfile.
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Passwords.txt", true));//uses a print writer to inserts into text File
            
            EncryptDecrypt encDec = new EncryptDecrypt();
            String Password = "";
        
            String passimp = password;
            passimp = EncryptDecrypt.encrypt(passimp);//settting variable passimp with my encryption method returned String.

            String encryptk = "thisisasecurekey";
            SecretKeySpec key = new SecretKeySpec(encryptk.getBytes(), "AES");
            Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);

            //encryption statement
            String encryptpas = Base64.encodeBase64String(encryptCipher.doFinal(passimp.getBytes()));
            Password = encryptpas;
      
        
            pw.println(user+ "#" + Password + "#" + admin + "#" + email); // enters the username and encrypted password to textfile 
            pw.close();
        } catch (IOException ex) { //if this wss not attained an error message will appear
            JOptionPane.showMessageDialog(new JFrame(), "Could Not Create new User", "Error", // This is the error message displayed
                    JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CreateNewUser(String UName, String PWord){
        if ((val.isName(UName, true) == true) && ((val.isLoginPass(PWord) == false))) {
            if (!CheckExist(UName) == true) {
                int NewUser = JOptionPane.showConfirmDialog(null, "Are you sure you want to make a new use with\n"
                        + "User name: " + UName + "\nPassword: " + PWord);
                if (NewUser == 0) {
                    String temp = JOptionPane.showInputDialog("Please enter your email adress");
                    if(val.isemail(temp) == true){
                    addNewUser(UName, PWord, "U", temp);
                    nUser = true;
                    currentEmail = temp;
                    }else{
                        temp = JOptionPane.showInputDialog("Please enter a valid email adress with an '@'");
                         addNewUser(UName, PWord, "U", temp);
                    nUser = true;
                    currentEmail = temp;
                    }
                }
                JOptionPane.showMessageDialog(null, "New User Created\nPress Login to continue");
            } else {
                JOptionPane.showMessageDialog(null, "User Name already exists please choose a new one");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a suitable user name and passowrd\nPassword Must have:\nA Capital letter\nA Diget");
        }
    }                         
    
    public void CreateNewAdmin(String UName, String PWord, String Email){
        if ((val.isName(UName, true) == true) && (val.isLoginPass(PWord) == false)  && val.isemail(Email)) {
            if (!CheckExist(UName) == true) {
                addNewUser(UName, PWord, "A", Email);
                JOptionPane.showMessageDialog(null, "New Admin Created");
            } else {
                JOptionPane.showMessageDialog(null, "User Name already exists please choose a new one");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a suitable user name and passowrd\nPassword Must have:\nA Capital letter\nA Diget");
        }
    }                                         
   
}
