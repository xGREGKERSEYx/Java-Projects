package com.mycompany.tempconverter;

import java.util.Scanner;

public class TempConverter {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int option = 0;
        
        System.out.println("What temperature are we using? 0 for Celsius, a 1 for  Fahrenheit, and a 2 for Kelvin");
        option = scan.nextInt();//Asks for which temperature they are using   
        
        System.out.println("Please enter the temperature for conversion: ");
        double tempConvert = scan.nextDouble();
        
        System.out.println("And what do we want to use? 0 for Celsius, a 1 for  Fahrenheit, and a 2 for Kelvin");
        int convertOption = scan.nextInt();       
        
        switch(convertOption){
            case 0 -> System.out.println("Your new temperature is: " + toCelsius(tempConvert, option) + " DEGREES");
            case 1 -> System.out.println("Your new temperature is: " + toFahren(tempConvert, option) + " degrees");
            case 2 -> System.out.println("Your new temperature is: " + toKelvin(tempConvert, option) + " Kelvin");
        }//switch
        
        
        
    }//main
    
    public static double toCelsius(double tempConvert, int option){
        double tempC = 0;
        
        switch (option) {
            case 1 -> {
                System.out.print(tempConvert);
                tempC = (5.0/9.0) * (tempConvert - 32);
                return tempC;
            }
            case 2 -> {
                System.out.print(tempConvert);
                tempC = tempConvert - 273;
                return tempC;
            }
            default -> {
                return tempC;
            }
            
        }
        
        
    }//Converts from F or K into C
    public static double toFahren(double tempConvert, int option){
        double tempF = 0;
        
        switch (option) {
            case 0 -> {
                System.out.print(tempConvert);
                tempF = ((9.0/5.0) * tempConvert) + 32;
                return tempF;
            }
            case 2 -> {
                System.out.print(tempConvert);
                tempF = ((9.0/5.0)* (tempConvert - 273) + 32);
                return tempF;
            }
            default -> {
                return tempF;
            }
        }
        
    }//Converts from C or K into F
    public static double toKelvin(double tempConvert, int option){
        double tempK = 0;
        
        switch (option) {
            case 0 -> {
                System.out.print(tempConvert);
                tempK = tempConvert + 273;
                return tempK;
            }
            case 1 -> {
                System.out.print(tempConvert);
                tempK = (((5.0/9.0) * (tempConvert - 32)) + 273);
                return tempK;
            }
            default -> {
                return tempK;
            }
        }
        
    }//Converts C and F into K
}
