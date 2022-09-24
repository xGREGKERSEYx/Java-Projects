package com.mycompany.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
//        Scanner scan = new Scanner (System.in);
//        
//        double principleAmount = 10000, rate = 3.5, timeSpan = 5;//variables for Interest 
//        double costPrice = 400000, salesPrice = 650000;//Variables for profit
//        double temp;
//        int current, preffered;
//        
//        Interest house = new Interest(principleAmount, rate, timeSpan);
//        System.out.println(house);
//        
//        Profit rental = new Profit(costPrice, salesPrice);
//        System.out.println(rental.calculateProfit(costPrice, salesPrice));
//        
//        System.out.println("What temperature are we using? 0 for Celsius, a 1 for  Fahrenheit, and a 2 for Kelvin");
//        current = scan.nextInt();//Asks for which temperature they are using   
//        
//        System.out.println("Please enter the temperature for conversion: ");
//        temp = scan.nextDouble();
//        
//        System.out.println("And what do we want to use? 0 for Celsius, a 1 for  Fahrenheit, and a 2 for Kelvin");
//        preffered = scan.nextInt();       
//        
//        TempConverter newConversion = new TempConverter(current, preffered, temp);
//        System.out.print(newConversion);
        
        java.awt.EventQueue.invokeLater(() -> {
            new calculator_gui().setVisible(true);
        });
    }
}
