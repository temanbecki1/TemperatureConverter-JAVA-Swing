/*
*   Filename: Conversion.java
*   Author : Teman Beck
*   Date : November 16th, 2021
*   This class handles all logic to convert from fahrenheit to celsius
*/

public class Conversion {
    double exp;                                                                                 //declares variable to store passed in value via constructor
    double celsius;
    double fahrenheit;
    double fahrenheitRatio = 1.8 ;                                                              //declare and initial conversion factor per formula (9/5)
    double celsiusRatio = 0.556 ;                                                               //declare and initial conversion factor per formula (5/9)
    

    public Conversion(){                                                                        //default constructor

    }

    public Conversion(String expression){                                                       //constructor taking in one string parameter
        this.exp = Double.parseDouble(expression);                                              //converts or typecast String input to double 
    }


    public String getFahrenheit() {
        fahrenheit = (exp * fahrenheitRatio)+32 ;                                               //calculates fahrenheit
        return String.format("%.1f", fahrenheit);                                               //returns fahrenheit formatted with 1 decimal in String form
    }

    public String getCelsius(){
        celsius =  (exp-32) *celsiusRatio;                                                      //calculates celsius
        return String.format("%.1f", celsius);                                                  //returns celsius formatted with 1 decimal in String form
    }
}
