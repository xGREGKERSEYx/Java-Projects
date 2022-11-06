import java.util.Random; 
import java.util.Scanner;


/**
 *
 * @author Gregory Kersey
 * 02/06/2022
 * This is the classic game of hangman. Each round the user will have 
 * 8 incorrect guesses they can make. Once they get to 8 incorrect guesses
 * they are given the option to play again. But they will not get the same word
 * unless they close the system. 
 */
public class HangmanWords{
    private Random r = new Random();
    private Scanner scnr = new Scanner(System.in);
    private int incorrect = 8;
    private int guesses;
    int correctGuess;
    private char actualGuess;
    private String playerGuess;
    private String guessed;
    private String gameWord;
    private boolean playedBefore;
    private boolean containsGuess;
    private char[] wordArray;
    private char[] knownChar;
    
    private String [] words = {"deductible", "strongman", "repository", "oriented", "galvanize", "vaporize", "iatrogenic",
        "numbskull", "voyeurism", "razzmatazz", "espionage", "caliph", "wristwatch", "juicy"};
//Initializes the String array containing the words to be used for Hangman
     

public HangmanWords() {
        this.wordArray = new char[14];
        this.knownChar = new char[14];
        this.correctGuess = 0;
        this.guesses = 0;
        this.actualGuess = '*';
        this.playerGuess = "";
        this.guessed = "";
        this.gameWord ="";
        this.playedBefore = false;
        this.containsGuess = false;
        
        
    }//default constructor
public void gameRules(){
    
    System.out.println("""
                       Here are the rules: You only have 8 incorrect guesses.
                       if the letter does not exist within the word
                       or you have guessed that letter before
                       you lose a guess.""");

    int randomNum = r.nextInt(13);//Creates a random number between  0-13, allows us to pick a word
    
    for(int i = randomNum; i <= 15; i++){
       gameWord = words[i];
       
      
       break;
    }//Creates a for loop that randomly chooses ONE word
   
    
    int wordLength  = gameWord.length();
    wordArray = new char[wordLength];
    
    System.out.print("Hangman:");
    for(int i = 0; i < gameWord.length(); i++) {
        knownChar[i] = '*';
    }
    System.out.print(wordArray);
    
    System.out.println("");
    

pleaseGuess();
}//chooses the current word in play 
public void pleaseGuess(){
    
    System.out.println("\nPlease take a guess!");
    guesses++;
    
    playerGuess = scnr.next();//Takes the players guess and saves it to playerGuess
    actualGuess = playerGuess.toLowerCase().charAt(0);//Changes the guess to a lower Case letter and only takes the first character
        
    playedBefore = (guessed.indexOf(actualGuess)) != -1;//Checks to see if this charcter has been played before
    guessed += actualGuess;//adds the charcater to the String containing all the guesses
    
    if(playedBefore == true){
        System.out.println("OOO! Someone has short-term memory loss");
        message();
        incorrectGuess();
        pleaseGuess();
    }else{
        checkGuess();
    }
    
}//asks the player for their guess and shows them what they input
public void checkGuess(){
    
    containsGuess = gameWord.indexOf(actualGuess) != -1;//Checks to see if the guessed character is in the word
    
    if(containsGuess == true){
        correctGuess();
    }else{
       incorrectGuess();
    }
      
    
}//checks the players guess against the characters inside the word to determine if it was incorrect or correct
public void message(){
    System.out.println
        ("\nYour guess was: " + actualGuess
        + "\nNumber of Guesses: " + guesses
        + "\nNumber of Incorrect Guesses: " + incorrect + "\n");
}
public void correctGuess(){
    for(int i = 0; i < gameWord.length() - 1; i++) {
        knownChar[i] = actualGuess == gameWord.charAt(i) ? actualGuess : knownChar[i];
        System.out.print(knownChar[i]);
        correctGuess = correctGuess + 1;
    }
    
    message();
    pleaseGuess();
    
}//If the player's guess is correct it reveals those characters on the board
public void incorrectGuess(){
    
    while(incorrect > 0){
        incorrect = incorrect - 1;
        pleaseGuess();
    } 
    
    System.out.println("You are incorrect");
    message();
    
    if(this.incorrect == 0) {
            System.out.println("Would you like to play again? 1 for Yes || 2 for No");
            int playAgain = scnr.nextInt();
            
            if(playAgain == 1){
                gameRules();
            }else{
                System.exit(0);
            }
    }else{
        pleaseGuess();
    }
    
    
}//If the guess is incorrect, tells them it is wrong and why. Also increase the count for incorrect guesses by one each time

}//Ends the public class