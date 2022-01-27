import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MonsterMash {

    public static void main(String[] args) {
       int userSelection = 1;
        String newType;
        String newClothing;
        String newColor;
        String newHeight;
        String newWeapon;
        int newSpeed;
        int newStrength;
  // variables to track / store user input changes      
  
        String [] monsterOptions ={"View", "Create", "Change", "Exit"};
        String [] options = {"Vampire", "Zombie", "Zebra-Elephant", "Werewolf", "Tiger-Sheep", "Whale-Snake"};
        String [] attributeOptionsTwo ={"Change Speed", "Change Strength"};
//Creates the options for the various inputs

        ArrayList<MonsterAttributes> monsters = new ArrayList<>();
        monsters.add(new MonsterAttributes (" Vampire-Lord", " Overalls", " Scarlet", " 7 feet 4 inches", " Teeth and Scabbard", 6, 8));
        monsters.add(new MonsterAttributes (" Zombie", " Eat more brains shirt", "Green", "5 feet 10 inches", " Fists and bite", 4, 5));
        monsters.add(new MonsterAttributes (" Zebra-Elephant", " Blue jeans", "Grey", "9 feet 10 inches", " Trunk and mounted gun", 5, 8));
        monsters.add(new MonsterAttributes (" Werewolf", " Cute dog shirt ", " White", "8 feet 3 inches", " Claws and kicks", 7, 7));
        monsters.add(new MonsterAttributes (" Tiger-Sheep", " A Scuba Suit", " Red-orange", "4 feet 7 inches", " False-bleating and a fishing spear", 6, 6));
        monsters.add(new MonsterAttributes (" Whale-Snake", " A Turtle neck", " Yellow", "6 feet 8 inches", " Engorging breath and steel tail whip", 3, 10));
//Creates the arraylist for the required monster objects
        
        do {
            int viewSelection = JOptionPane.showOptionDialog(null, "Do you want to view, create, or change a monster?", "Main Menu", 
                 JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, monsterOptions, monsterOptions);//Create the main menu

            
            if (viewSelection == 0) {
                System.out.println("All Users:");

                for (int i =0; i < monsters.size(); ++i) {
                   JOptionPane.showMessageDialog(null, 
                        "Type: " + monsters.get(i).getMonsterType()
                        + "\nClothing: " + monsters.get(i).getMonsterClothing()
                        + "\nEye Color: " + monsters.get(i).getMonsterEyeColor()
                        + "\nHeight: " + monsters.get(i).getMonsterHeight()
                        + "\nWeapon: " + monsters.get(i).getMonsterWeapon()
                        + "\nSpeed: " + monsters.get(i).getMonsterSpeed()
                        + "\nStrength: " + monsters.get(i).getMonsterStrength(), "MONSTERS", JOptionPane.PLAIN_MESSAGE);
                }
            }
//Display All monsters

            
            if (viewSelection == 1) {
                                
                newType = JOptionPane.showInputDialog("Please enter type of monster: ");
               
                newClothing = JOptionPane.showInputDialog("Please enter the clothing it is wearing: ");
                
                newColor = JOptionPane.showInputDialog("Please enter the eye color: ");
                               
                newHeight = JOptionPane.showInputDialog("Please enter the height: ");
               
                newWeapon = JOptionPane.showInputDialog("Please enter the weapon of choice: ");
                
                newSpeed = monsters.get(3).changeSpeed();
                        JOptionPane.showMessageDialog(null, "This is the Speed: " + monsters.get(3).getMonsterSpeed());
               
                newStrength = monsters.get(3).changeStrength();
                        JOptionPane.showMessageDialog(null, "This is the Strength: " + monsters.get(3).getMonsterStrength());
                
//Allows user to create a new character

                monsters.add(new MonsterAttributes(newType, newClothing, newColor, newHeight, newWeapon, newSpeed, newStrength));
            }

            
            if (viewSelection == 2) {
                int playerSelection = JOptionPane.showOptionDialog(null, "Please selct a monster to change:", "Change a monster", 
                        JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
                

                JOptionPane.showMessageDialog(null, "You have selected: " + monsters.get(playerSelection).getMonsterType());
                int attributeSlection = JOptionPane.showOptionDialog(null, "Change Speed or Change Strength?", "Change Attributes", 
                        JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, attributeOptionsTwo, null);
                
                if(attributeSlection == 0){
                    newSpeed = monsters.get(playerSelection).changeSpeed();
                    JOptionPane.showMessageDialog(null, monsters.get(playerSelection).getMonsterType() 
                            + " speed has been updated to: "
                            + monsters.get(playerSelection).getMonsterSpeed());
                }else{
                    newStrength = monsters.get(playerSelection).changeStrength();
                    JOptionPane.showMessageDialog(null, monsters.get(playerSelection).getMonsterType() 
                            + " strength has been updated to: "
                            + monsters.get(playerSelection).getMonsterStrength());
                }

            }if(viewSelection == 3){
                JOptionPane.showMessageDialog(null, "Come again");
                break;
            }//Exits the program
            
        } while (userSelection != 0);
        
    }
}
