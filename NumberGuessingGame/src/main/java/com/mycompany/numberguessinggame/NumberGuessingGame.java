package com.mycompany.numberguessinggame;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random ();
        
        int randomNumber = rand.nextInt(50);
        int guesses = 0;
        int userGuess = 0; 
        
        System.out.println("The random number is: " + randomNumber);
       
        while(true){
            System.out.println("Please take a guess (0-50): ");
            userGuess = scnr.nextInt();
            
            
            if(userGuess == randomNumber){
                System.out.println("You win");
                break;
            }else if(randomNumber > userGuess){
                System.out.println("Go higher!");
            }else{
                System.out.println("Go lower!");
            }
        }
        
      
        
    }
    
    
    



}
