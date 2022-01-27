//********************************************************************************
// PANTHERID:  [6296562]
// CLASS: COP 2210 – [2021]
// ASSIGNMENT # [3]
// DATE: [2021-10-31]
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//********************************************************************************
package hauntedhouseproject;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class HauntedHouseProject {

    
    public static void main(String[] args) {
         ImageIcon hauntedhouse = new ImageIcon("hauntedhouse.jpg");//Creates the icon for the Haunted House
         ImageIcon frontdoor = new ImageIcon("frontdoor.jpg");//Creates the icon for the Front door
               
         String userName = JOptionPane.showInputDialog("What is your name?");
//Asks the user for their name, and stores it as a variable
         JOptionPane.showMessageDialog(null, "Hello " + userName + "\nWelcome to this year's Haunted House!", "Haunted House", 0, hauntedhouse);
//Welcomes the player to the Haunted House
         JOptionPane.showMessageDialog(null, userName + " a few rules before we begin:"
           + "\n     1. No Harming the Staff"
           + "\n     2. No Harming each other"
           + "\n     3. Once you explore an item inside a room it "
           + "\n         must be put into your bookbag and the game is over"
           + "\n     4. Have fun", "Rules", 0, hauntedhouse);
//Explains the rules of the game to the player
       
        JOptionPane.showMessageDialog(null, userName + ", you are currently at the front door", "Front Door", 0, frontdoor);
//States the starting Position for the Player
        
        
        
        Rooms room = new Rooms();
        room.frontDoor();

















    }
    
}
