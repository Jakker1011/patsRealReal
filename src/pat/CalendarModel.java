/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import javax.swing.DefaultListModel;

/**
 *
 * @author Jacob Sacks
 */
public class CalendarModel {

    String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};//creates an array that stores the diffrent days of the week

    int[] numDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//creates an array that stores how many days in every month

    String[][] calendar = new String[7][7];//creaetes a 2D array that will allow dates to be astored in a table format

    public CalendarModel() {//constructer methood for the class calendar model
        int count = 0;//creates an integer varable called count
        for (int i = 1; i < 7; ++i) {//creates a for loop
            for (int j = 0; j < 7; ++j) {//creates a for loop
                count++;//increses the count varable by one
                calendar[i][j] = " ";//places a space in evevy possion of the table
            }
        }
    }

  

    public Object getValueAt(int row, int column) {//cteates a methood that allows to get a value in the table
        return calendar[row][column];//returs a value from the 2D array at the given positions
    }

    public void setValueAt(Object value, int row, int column) {//cteates a methood that allows to set a value in the table
        calendar[row][column] = (String) value;//sets a value from the 2D array at the given positions
    }
    
    
    

    public void setMonth(int year, int month) {//a methood that populates the table that places the dates in the table
        for (int i = 1; i < 7; ++i) {//creates a for loop that runs from 1 to 7
            for (int j = 0; j < 7; ++j) {//creates a for loop 
                calendar[i][j] = " ";//places a space in evevy possion of the table
            }
        }
        java.util.GregorianCalendar cal = new java.util.GregorianCalendar();// crestes a calander model
        cal.set(year, month, 1);//sets the model to the passed in month and the passed in year
        int offset = cal.get(java.util.GregorianCalendar.DAY_OF_WEEK) - 1;//allows for the first day of month to be places in the correct collumb that correponds to a day of the week 
        offset += 7;// add the offset by seven
        int num = daysInMonth(year, month);//calls the method that determains how many days in the ponth
        for (int i = 0; i < num; ++i) {//runs a for loop to the number of days in month 
            calendar[offset / 7][offset % 7] = Integer.toString(i + 1);//inserts the day of the month in the correct place in the 2D array
            ++offset;//increses the offset by one 
        }
    }

    public boolean isLeapYear(int year) {//creates a methood that checks if is a leap year
        if (year % 4 == 0) {//dtermails if the year is divisible by 4
            return true; // if it is then it reterns true
        }
        return false;//else it returs false
    }

    public int daysInMonth(int year, int month) {//determails days in month
         if (month < 0){//month cant be smaller that 0
            month = month + 11;// if it is then makes the month december 
        }
        if (month > 11){// month cant be greater than 11
            month = month - 11;//if it is it makes the month January
        }
        int days = numDays[month];//creates an integer varable to store the number of days in month
        if (month == 1 && isLeapYear(year)) {//checks if it is a leap year
            days++;//if it is a leap increases the amounts of days
        }
        return days;//returns the number of days 
    }
    
    public DefaultListModel dates() {//creates a class that returns a Defalt list Model
        sessionArray ssn = new sessionArray();//creates a object for session array
        DefaultListModel dates = new DefaultListModel();//createsa new Default List Model called dates
        for (int i = 0; i < ssn.getSessionArray().size(); i++) {//createsa loop that runs to the size of the session array
            String dateArray = ssn.getSessionArray().get(i).getDate();//gets the date of session at the possion of the array that the loop is at 
            dates.addElement(dateArray);//adds the got date to array list
        }
        return dates;//returs the Defalt list Model
    }
}

