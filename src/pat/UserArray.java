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
                String line = scFile.nextLine();//Creates a String varable to sore the next scanned line of the text file 
                Scanner scLine = new Scanner(line).useDelimiter("#");// goes through the line, the usernme and password are seperated by delimeters                
                String UserName = scLine.next(); // first part of line is the Username
                String Passwords = scLine.next();// second part of line is the password
                String admin = scLine.next();//Third part is the weather it is an admin or a user
                String email = scLine.next();//fourth part is the email adress
                String Password = "";//creates a string varable to store thr password
                   
            String decrypin = Passwords;//creates a string varable to store the cyper text
            String decryptk;//creates a string variable to store the key for the cyper 
            decryptk = "thisisasecurekey";//sets the key for the cyper
            SecretKeySpec key = new SecretKeySpec(decryptk.getBytes(), "AES");// Creates a new SecretKeySpec called key inorder to encrypt the message 
            Cipher decryptCipher = null;//Cretaes a Cipher object to store the array
            
                decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//calls the methood getInstance from the Cipher class
         
            decryptCipher.init(Cipher.DECRYPT_MODE, key);//calls the init methood to initiate the decryptCipher
            String decryptpass = new String(decryptCipher.doFinal(Base64.decodeBase64(decrypin)));//creates a string called decryptpass that decrypts the password
            decryptpass = EncryptDecrypt.decrypt(decryptpass);//Parsing the String to the method decrypt
            Password = decryptpass;//sets the password to the decrypted password
            
      
    

                 User s = new User(UserName, Password, admin, email); // adds the username, password, Admin, email to array
                 userArray.add(s);//adds the User object to the userArray object
            }
            scFile.close();//closes the file

        } catch (FileNotFoundException ex) { //if this wss not attained an error message will appear
            JOptionPane.showMessageDialog(new JFrame(), "File Not Found", "Error",// This is the error message displayed
                    JOptionPane.ERROR_MESSAGE);

        } catch (NoSuchAlgorithmException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//Displays the error mesage 
        } catch (NoSuchPaddingException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//Displays the error mesage 
        } catch (InvalidKeyException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//Displays the error mesage 
        } catch (IllegalBlockSizeException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//Displays the error mesage 
        } catch (BadPaddingException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//Displays the error mesage 
        }

    }

    public ArrayList<User> getUserArray() {//creates a getter methood for the ArrayList
        return userArray;//returns the userArray
    }

    public void setUserArray(ArrayList<User> userArray) {//creates a getter methood for the ArrayList
        this.userArray = userArray;//sets the userArray to the parsed in variable
    }
    
    

    public boolean verify(String user, String pass) { //Method that verifies the students username and password.
        patArray allPatients = new patArray();//creates a patArray object called allPatients
        boolean found = false; // found starts by being false 
        for (int i = 0; i < userArray.size(); i++) { //loops through the usernames and passwords 
            if (userArray.get(i).getUsername().equals(user) && userArray.get(i).getPassword().equals(pass)) {// if the username from the array and the password from the array equal the username and password put in then found will equal true.
                found = true;// then found equals true 
                currentPatient = allPatients.getCurrentPatient(userArray.get(i).getEmail());//sets the static varable current patient to the the patients at i email
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

        return adm;//returns the boolean varable

    }
    
    public boolean CheckExist(String user){//creates a methood that cheches if a user exits in the userArray
          boolean found = false; // found starts by being false 
        for (int i = 0; i < userArray.size(); i++) { //loops through the usernames and passwords 
            if (userArray.get(i).getUsername().equals(user)) {// if the username from the array and the password from the array equal the username and password put in then found will equal true.
                found = true;// then found equals true 
    }
        }
        return found;//returns found
    }

    public void addNewUser(String user, String password, String admin, String email){//Method that adds a new username and password to the textfile.
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("Passwords.txt", true));//uses a print writer to inserts into text File
            
            EncryptDecrypt encDec = new EncryptDecrypt();//creates a EncryptDecrypt object called encDec
            String Password = "";//creates a string variale called Password
        
            String passimp = password;// sets the the variable that will be encryped 
            passimp = EncryptDecrypt.encrypt(passimp);//settting variable passimp with my encryption method returned String.

            String encryptk = "thisisasecurekey";//sets the encryption key
            SecretKeySpec key = new SecretKeySpec(encryptk.getBytes(), "AES");// Creates a new SecretKeySpec called key inorder to encrypt the message
            Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//calls the methood getInstance from the Cipher class
            encryptCipher.init(Cipher.ENCRYPT_MODE, key);//calls the init methood to initiate the decryptCipher

            //encryption statement
            String encryptpas = Base64.encodeBase64String(encryptCipher.doFinal(passimp.getBytes()));//creates a string called decryptpass that decrypts the password
            Password = encryptpas;//sets the password to the decrypted password
      
        
            pw.println(user+ "#" + Password + "#" + admin + "#" + email); // enters the username and encrypted password to textfile 
            pw.close();//cloeses the fule
        } catch (IOException ex) { //if this wss not attained an error message will appear
            JOptionPane.showMessageDialog(new JFrame(), "Could Not Create new User", "Error", // This is the error message displayed
                    JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchAlgorithmException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//catches the encryption of the password
        } catch (NoSuchPaddingException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//catches the encryption of the password
        } catch (InvalidKeyException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//catches the encryption of the password
        } catch (IllegalBlockSizeException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//catches the encryption of the password
        } catch (BadPaddingException ex) {//catches the encryption of the password
            Logger.getLogger(UserArray.class.getName()).log(Level.SEVERE, null, ex);//catches the encryption of the password
        }
    }
    
    public void CreateNewUser(String UName, String PWord){//creates a methood that will CreateNewUser
        if ((val.isName(UName, true) == true) && ((val.isLoginPass(PWord) == false))) {//checks if the password and user name is valid using metoods from the valiadte class
            if (!CheckExist(UName) == true) {//checks if the user name exists 
                int NewUser = JOptionPane.showConfirmDialog(null, "Are you sure you want to make a new use with\n"//asks the user to confirm the details of the enew user
                        + "User name: " + UName + "\nPassword: " + PWord);//asks the user to confirm the details of the enew user
                if (NewUser == 0) {//if confirm is yes
                    String temp = JOptionPane.showInputDialog("Please enter your email adress");//asks the user for thier email adress
                    if(val.isemail(temp) == true){//checks if the email name is valid using metoods from the valiadte class
                    addNewUser(UName, PWord, "U", temp);//adds a new user using the addNewUser methood
                    nUser = true;//sets the static varable nuser to ture
                    currentEmail = temp;//sets the static varable currentEmail to the patients email
                    }else{
                        temp = JOptionPane.showInputDialog("Please enter a valid email adress with an '@'");//if not valid then asks the user to correct the email
                         addNewUser(UName, PWord, "U", temp);//then  adds the user
                         nUser = true;//sets the static varable nuser to ture
                    currentEmail = temp;//sets the static varable currentEmail to the patients email
                    }
                }
                JOptionPane.showMessageDialog(null, "New User Created\nPress Login to continue");//tells the user to continue thier login
            } else {
                JOptionPane.showMessageDialog(null, "User Name already exists please choose a new one");//alerts the user that user name exists
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a suitable user name and passowrd\nPassword Must have:\nA Capital letter\nA Diget");//alerts the user how to correct thier password
        }
    }                         
    
    public void CreateNewAdmin(String UName, String PWord, String Email){//Method that adds a new username and password to the textfile.
        if ((val.isName(UName, true) == true) && (val.isLoginPass(PWord) == false)  && val.isemail(Email)) {//checks if the password and user name is valid using metoods from the valiadte class
            if (!CheckExist(UName) == true) {//checks if the user name exists 
                addNewUser(UName, PWord, "A", Email);//adds a new Adin using the addNewUser methood
                JOptionPane.showMessageDialog(null, "New Admin Created");//alerts the user that a new admin is created 
            } else {
                JOptionPane.showMessageDialog(null, "User Name already exists please choose a new one");//alerts the user that user name exists
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a suitable user name and passowrd\nPassword Must have:\nA Capital letter\nA Diget");//alerts the user how to correct thier password
        }
    }                                         
   
}
