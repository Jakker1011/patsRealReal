/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

/**
 *
 * @author Jacob Sacks
 */
public class User {
    private String Username, Password, admin, email;//creates string varables
    

    public User(String Username, String Password, String admin, String email) {//craetes a constructer methood for this class
        this.Username = Username;//initiates the variable
        this.Password = Password;//initiates the variable
        this.admin = admin;//initiates the variable
        this.email = email;//initiates the variable
        
    }

    public String getUsername() {//creates a getter methood
        return Username;//returns variable 
    }

    public void setUsername(String Username) {//creates a setter methood
        this.Username = Username;//sets the variable
    }

    public String getPassword() {//creates a getter methood
        return Password;//returns variable 
    }

    public void setPWord(String Password) {//creates a setter methood
        this.Password = Password;//sets the variable
    }

    public String getAdmin() {//creates a getter methood
        return admin;//returns variable 
    }

    public void setAdmin(String admin) {//creates a setter methood
        this.admin = admin;//sets the variable
    }

    public String getEmail() {//creates a getter methood
        return email;//returns variable 
    }

    public void setEmail(String email) {//creates a setter methood
        this.email = email;//sets the variable
    }

 
    
    
}
