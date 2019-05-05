/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Jacob Sacks
 */
public class Date {

    public String getDate() {// creates a methood that gets todays date
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//creats a new Simple Date Format that stores the year month and day
        String dateString = format.format(new java.util.Date());//  turns the Simple Date Format into a string
        return dateString;//returns the date in string format

    }

    public String formatDate(String date) {//creates a methood that changes the format of the date
        String finalDate = "";//creates a string varable called final date
        //gets substrings of ivne full date
        String day = date.substring(8, 10);//Breaks the passed in date into day mounth and year
        String month = date.substring(4, 7);//Breaks the passed in date into day mounth and year
        String year = date.substring(24);//Breaks the passed in date into day mounth and year

        //checks and formats month
        int finalMonth = 0;//creates an interger varable called finalInt 
        switch (month) {//creaes a switch statement, that will switch the month varable
            case "Jan"://if this case is waht is the case varable then it stets the final month
                finalMonth = 1;//sets the final month
                break;//breaks the statement
            case "Feb"://if this case is waht is the case varable then it stets the final month
                finalMonth = 2;//sets the final month
                break;//breaks the statement
            case "Mar"://if this case is waht is the case varable then it stets the final month
                finalMonth = 3;//sets the final month
                break;//breaks the statement
            case "Apr"://if this case is waht is the case varable then it stets the final month
                finalMonth = 4;//sets the final month
                break;//breaks the statement
            case "May"://if this case is waht is the case varable then it stets the final month
                finalMonth = 5;//sets the final month
                break;//breaks the statement
            case "Jun"://if this case is waht is the case varable then it stets the final month
                finalMonth = 6;//sets the final month
                break;//breaks the statement
            case "Jul"://if this case is waht is the case varable then it stets the final month
                finalMonth = 7;//sets the final month
                break;//breaks the statement
            case "Aug"://if this case is waht is the case varable then it stets the final month
                finalMonth = 8;//sets the final month
                break;//breaks the statement
            case "Sep"://if this case is waht is the case varable then it stets the final month
                finalMonth = 9;//sets the final month
                break;//breaks the statement
            case "Oct"://if this case is waht is the case varable then it stets the final month
                finalMonth = 10;//sets the final month
                break;//breaks the statement
            case "Nov"://if this case is waht is the case varable then it stets the final month
                finalMonth = 11;//sets the final month
                break;//breaks the statement
            case "Dec"://if this case is waht is the case varable then it stets the final month
                finalMonth = 12;//sets the final month
                break;//breaks the statement
        }

        if (finalMonth < 10) {//checks if date is doubble diget
            finalDate = "0" + finalMonth + "/" + day + "/" + year;//if it is then formats the date
        } else {
            finalDate = finalMonth + "/" + day + "/" + year;//stes the date to the new formated date
        }
        return finalDate;//returs the formated date 
    }

    public String formatDay(String day) {//creates a methood to format a date
        String finalDay = "";//creates a String varable called finalDay

        //gets substring of day from given full date
        String subbedDay = day.substring(0, 3);//breaks the date into just its date
        switch (subbedDay) {//creaes a switch statement, that will switch the subbedDay varable
            case "Sun"://if subbedDay is eqaul to the case then:
                finalDay = "sunday";//sets the final equal to a set day
                break;//breaks the statement
            case "Mon"://if subbedDay is eqaul to the case then:
                finalDay = "monday";//sets the final equal to a set day
                break;//breaks the statement
            case "Tue"://if subbedDay is eqaul to the case then:
                finalDay = "tuesday";//sets the final equal to a set day
                break;//breaks the statement
            case "Wed"://if subbedDay is eqaul to the case then:
                finalDay = "wednesday";//sets the final equal to a set day
                break;//breaks the statement
            case "Thu"://if subbedDay is eqaul to the case then:
                finalDay = "thursday";//sets the final equal to a set day
                break;//breaks the statement
            case "Fri"://if subbedDay is eqaul to the case then:
                finalDay = "friday";//sets the final equal to a set day
                break;//breaks the statement
            case "Sat"://if subbedDay is eqaul to the case then:
                finalDay = "saturday";//sets the final equal to a set day
                break;//breaks the statement
        }
        return finalDay;
    }
    
    public int revMonth(String month) {//creates a methood to reverse the formated date
        int finalMonth = 0;//creates an integer varable called final month
        switch (month) {//creaes a switch statement, that will switch the month varable
            case "January"://if month is eqaul to the case then:
                finalMonth = 1;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "Febuary"://if month is eqaul to the case then:
                finalMonth = 2;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "March"://if month is eqaul to the case then:
                finalMonth = 3;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "April"://if month is eqaul to the case then:
                finalMonth = 4;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "May"://if month is eqaul to the case then:
                finalMonth = 5;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "June"://if month is eqaul to the case then:
                finalMonth = 6;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "July"://if month is eqaul to the case then:
                finalMonth = 7;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "August"://if month is eqaul to the case then:
                finalMonth = 8;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "September"://if month is eqaul to the case then:
                finalMonth = 9;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "October"://if month is eqaul to the case then:
                finalMonth = 10;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "Noverber"://if month is eqaul to the case then:
                finalMonth = 11;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case "December"://if month is eqaul to the case then:
                finalMonth = 12;//sets the finalMonth equal to a cased month
                break;//breaks the switch case
        }

        return finalMonth;//returns the varable final month
    }
    
    public String getFinalMonth(int month){//creates a methood to get the the month in a string format
        String finalMonth = "";//creates a string varable called final date
        if (month < 0) {//month cant be smaller than 0
            month = 12 + month;//month restets to decmber
        }
        if (month > 11) {//month cant be greateer than 11
            month = month - 12;//month then resets to January
        }
        switch (month) {//creaes a switch statement, that will switch the month varable
            case 0://if month is eqaul to the case then:
                finalMonth = "January";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 1://if month is eqaul to the case then:
                finalMonth = "Febuary";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 2://if month is eqaul to the case then:
                finalMonth = "March";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 3://if month is eqaul to the case then:
                finalMonth = "April";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 4://if month is eqaul to the case then:
                finalMonth = "May";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 5://if month is eqaul to the case then:
                finalMonth = "June";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 6://if month is eqaul to the case then:
                finalMonth = "July";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 7://if month is eqaul to the case then:
                finalMonth = "August";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 8://if month is eqaul to the case then:
                finalMonth = "September";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 9://if month is eqaul to the case then:
                finalMonth = "October";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 10://if month is eqaul to the case then:
                finalMonth = "Noverber";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
            case 11://if month is eqaul to the case then:
                finalMonth = "December";//sets the finalMonth equal to a cased month
                break;//breaks the switch case
        }
        return finalMonth;//returns the finalMonth varable
    }

}
