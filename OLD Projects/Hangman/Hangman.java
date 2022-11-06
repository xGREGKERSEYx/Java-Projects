
/**
 *
 * @author Gregory Kersey
 * 02/06/2022
 * This is the classic game of hangman. Each round the user will have 
 * 8 incorrect guesses they can make. Once they get to 8 incorrect guesses
 * they are given the option to play again. But they will not get the same word
 * unless they close the system. 
 */
public class Hangman {
    
    
    public static void main(String[] args) {
        
        
      HangmanWords hanged = new HangmanWords();
      hanged.gameRules();//Start the game
        
    }
}
