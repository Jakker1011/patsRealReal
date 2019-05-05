/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import javax.swing.JOptionPane;

/**
 *
 * @author Jacob Sacks
 */
public class Validate {
public static String message;


    public boolean isName(String input, boolean choice) {
        boolean check = true; //instantiates a new boolean check

        if (input.length() > 0) { //checks if the entered string contains any data
            for (int i = 0; i < input.length(); i++) { //runs a loop through the length of the input
                if (!Character.isAlphabetic(input.charAt(i))) { //checks if the char at position 'i' is not alphabetic
                    if (input.charAt(i) != ' ') {  //checks if the char at position 'i' isnt a space
                        check = false;//sets check to equal false
                        break; //exits the loop
                    }
                }
            }
            if (!check && choice) { //checks if the check boolean is false and the choice was true 
                message += "Only Charters are allowed in the name '"+ input+"'\n" ; //notifies the user to the data type that's allowed
            }
        } else {
            check = false; //sets check to equal false
        }

        return check;//returns the boolean
    }

   

    public boolean isNumber(String input, boolean choice) {
        boolean check = true; //instantiates a new boolean check

        if (input.length() > 0) { //checks if the entered string contains any data
            for (int i = 0; i < input.length(); i++) { //runs a loop through the length of the input
                if (!Character.isDigit(input.charAt(i))) { //checks if the char at position 'i' is not a digit
                    if (input.charAt(i) != ' ' && input.charAt(i) != 'R' && input.charAt(i) != '.') { //checks if the char at position 'i' isnt a space or 'R' or cents 
                        check = false; //sets check to equal false
                        break; //exits the loop
                    }
                }
            }
            if (!check && choice) { //checks if the check boolean is false and the choice was true 
                message += "Only posotive digits are allowed in the value '"+input+"'\n" ; //notifies the user to the data type that's allowed
            }
        }

        return check;//returns the boolean
    }

    public boolean wasentered(String input) {
        boolean check = true; //instantiates a new boolean check

        if (input.length() == 0) {
            check = false; //sets check to equal false
        }
        if (!check) { //checks if the check boolean is false
            message += "You may not leave any fields blank\n" ; //notifies the user to the data type that's allowed
        }
        return check; //returns the boolean
    }

    public boolean isemail(String input) {
        boolean check = false; //instantiates a new boolean check

        if (input.length() > 0) { //checks if the entered string contains any data
            for (int i = 0; i < input.length(); i++) { //runs a loop through the length of the input
                if (input.charAt(i) == '@') { //checks if the input contains an @ sign
                    check = true; //sets check to equal true
                    break; //exits the loop
                }

            }
            if (!check) { //checks if the check boolean is false
                message += "Email is invalid, Emails must contain an '@'\n" ; //notifies the user to the data type that's allowed
            }
        }

        return check; //returns the boolean
    }

    public boolean ispositive(String input) {
        boolean check = true; //instantiates a new boolean check

        if (input.length() > 0) { //checks if the entered string contains any data
            for (int i = 0; i < input.length(); i++) { //runs a loop through the length of the input
                if (input.charAt(i) == '-') { //checks if the input contains a -
                    check = false; //sets check to equal true
                    break; //exits the loop
                }

            }
            if (!check) { //checks if the check boolean is false
                JOptionPane.showMessageDialog(null, "No negative numbers allowed: '" + input + "' \nThe cost has been entered as '" + input.substring(1) + "' \nPlease alert the IT department if you wish to change it", null, JOptionPane.ERROR_MESSAGE); //notifies the user that the email isn't valid
            }
        }

        return check; //returns the boolean
    }
    
     public boolean isLoginPass(String input) {
        boolean check = true; //instantiates a new boolean check
        int t = 0; // creates a tempary integer
        String temp = input.toLowerCase(); //changes input to a lower case
        if (!input.contains(" ") && !input.isEmpty() && !temp.equals(input)) {//checks if the conditions are met
            for (int i = 0; i < input.length(); i++) {//loops through the input char by char
                if(Character.isDigit(i)){//checks if char at i is a diget
                    t++;//increases the count varable by one
                }
            }
            if (t == 0){//checks if t is equal to 0
                    check = false;//makes the boolean varable false
            }
        }
        
        if (check == false){//if the boolean varaible is false
            message += "'"+input+"' is not A valid Passowrd\nPasswords Must Have a capital letter\nA lower case leter\nNo spaces\nA diget" ; //notifies the user to the data type that's allowed

        }
        return check;//returns the boolean
    }

}
