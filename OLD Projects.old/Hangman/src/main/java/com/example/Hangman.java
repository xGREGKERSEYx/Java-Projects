package com.example;

import java.util.Random;
import java.util.Scanner;
import java.lang.String;
import java.util.Arrays;

public class Hangman {
    public static String[] gallows 
            =  {"+---+\n" +
                "|   |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "=========\n",

                "+---+\n" +
                "|   |\n" +
                "O   |\n" +
                "    |\n" +
                "    |\n" +
                "    |\n" +
                "=========\n",

                "+---+\n" +
                "|   |\n" +
                "O   |\n" +
                "|   |\n" +
                "    |\n" +
                "    |\n" +
                "=========\n",

                " +---+\n" +
                " |   |\n" +
                " O   |\n" +
                "/|   |\n" +
                "     |\n" +
                "     |\n" +
                " =========\n",

                " +---+\n" +
                " |   |\n" +
                " O   |\n" +
                "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
                "     |\n" +
                "     |\n" +
                " =========\n",

                " +---+\n" +
                " |   |\n" +
                " O   |\n" +
                "/|\\  |\n" +
                "/    |\n" +
                "     |\n" +
                " =========\n",

                " +---+\n" +
                " |   |\n" +
                " O   |\n" +
                "/|\\  |\n" + 
                "/ \\  |\n" +
                "     |\n" +
                " =========\n"};
    
	public static void main(String[] args){
            Scanner scnr = new Scanner(System.in);//Creates a Scanner object
            
            String word = randomWord();//Chooses random word and stores it in a new variable
            
            char [] placeArray = new char [word.length()];//creates a char array with the length of the word
            for (int i = 0; i < word.length(); i++) {
                placeArray[i] = '_';               
            }//replaces the " " with an _ 
            
            int guesses = 0;//creates the variable to store the guesses
            
            char [] missedGuesses = new char[7];
            
            System.out.println("\n    WELCOME TO JAVA HANGMAN     \n");
            while(guesses < 6){
                 System.out.print(gallows[guesses]);
                 
                 System.out.print("\nWord: ");
                 System.out.print(placeArray);
                 
                 System.out.print("\nMissed: " );
                 printMissedGuesses(missedGuesses);
                 
                 System.out.print("\nGuess: ");
                 String guess = scnr.next();//scans for the next input
                 char guessed = guess.charAt(0);//takes only the first letter entered
                 
                 System.out.print("\n");//prints new line for formatting purposes
                 
                 if(checkGuess(word, guessed) == true){
                     updatePlaceHolders(placeArray, word, guessed);
                 }else{
                     guesses++;
                     missedGuesses[guesses] = guessed;
                     
                 }//checks if the guesses are equal and decides what to do next
                 
                 if(Arrays.equals(word.toCharArray(), placeArray)){
                     System.out.print("\nCONGRATS YOU WON");
                     break;
                 }  
            }//end of while loop
            
            if(guesses == 6){
                 System.out.print(gallows[6]);
                 System.out.print("\nYou suck"); 
                 System.out.println("\nThe word was: '" + word + "'");
            }
            scnr.close();
		
                
                
                
                
                
	}
        public static String randomWord(){
             String[] words = 
                {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
                "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
                "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
                "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
                "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
                "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
                "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
                "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
                "wombat", "zebra"};
            
            Random rand = new Random();//Creates a random object
            String word = words[rand.nextInt(62) - 1];//Chooses a random string from the array of words
            
            return word;
        }//Chooses a random word from the array of words
        public static void printPlaceholders(char [] placeArray){
            for (int i = 0; i < placeArray.length; i++) {
                System.out.print(placeArray[i]);
            }
            
        }//prints the _ for the game
        public static boolean checkGuess(String word, char guess){
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    return true;
                } 
            }
            return false;
    }
        public static void updatePlaceHolders(char [] placeArray, String word, char guess){
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    placeArray[i] = guess;
                }                               
            }
                        
            
        }//If the character is in the word, it will replace the _ at that position with the correct character
        public static void printMissedGuesses(char [] missedGuesses){
            for (int i = 0; i < missedGuesses.length; i++) {
                System.out.print(missedGuesses[i] + " ");
            }
        }
            

}
