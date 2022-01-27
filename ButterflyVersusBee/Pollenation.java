

/**
 *
 * @author grego
 */
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
public class Pollenation {
 
    
    
    public static void main(String[] args) {
     Scanner scnr = new Scanner(System.in);   
     
     String userName;
     String Butterfly;
     String Bee;
     double userSelection;
     double butterflyNectarRound1;
     double beeNectarRound1;
     double butterflyNectarRound2;
     double beeNectarRound2;
     double butterflyNectarRound3;
     double beeNectarRound3;
     double totalBeeNectar;
     double totalButterflyNectar;
     boolean gameWinner;
  
     
     userName = JOptionPane.showInputDialog("Please enter your name.");
     //Asks the user for their Name
    
          
    Butterfly = "Team Butterfly";//This sets the options below to show as Team Butterfly and Team Bee
    Bee = "Team Bee";
     
     Random capacity = new Random();//creates a new random
     Butterfly butterfly1 = new Butterfly();//Create a new butterfly to store data for
     Butterfly butterfly2 = new Butterfly();//Create a new butterfly to store data for
     Butterfly butterfly3 = new Butterfly();//Create a new butterfly to store data for
     Bee bee1 = new Bee();//Create a new bee to store data for
     Bee bee2 = new Bee();//Create a new bee to store data for
     Bee bee3 = new Bee();//Create a new bee to store data for
     Flower flower1 = new Flower();//Create a new flower to store data for
     Flower flower2 = new Flower();
     Flower flower3 = new Flower();
     
   String [] options = {Butterfly, Bee};
    userSelection = JOptionPane.showOptionDialog(null, userName + ", would you like to be a Butterfly or a Bee?", "Please pick a Team",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
    options, options [0]);
    //This allows the user to select which team they want to be on
    //Using this showOptionDialog prevents spelling errors
    
      if(userSelection == 0){
         
          butterfly1.setName(JOptionPane.showInputDialog(null,"What is the name of your butterfly colony?"));//Sets the name of the butterfly colony
          butterfly1.setColor(JOptionPane.showInputDialog(null,"What is the primary color of your butterflies?"));
          butterfly1.setColor2(JOptionPane.showInputDialog(null,"What is the accent color of your butterflies?"));//Sets the color of the butterfly colony
          butterfly1.setSize(JOptionPane.showInputDialog(null,"What is the size of " + butterfly1.getColor() + " " + 
                  butterfly1.getColor2() + " " + butterfly1.getName() + "?"));//Sets the size of the butterfly colony
          
        
      }else{
          bee1.setName (JOptionPane.showInputDialog(null,"What is the name of your bee colony?"));//Sets the name of the bee colony
                        JOptionPane.showInputDialog(null,"What is the size of " + bee1.getName() + "?");//Sets the size of the bee colony
              
                  
                  
         //This if/else statement outputs specific questions according to what the user selects
            }
     
      if(userSelection == 0){
          bee1.setName (JOptionPane.showInputDialog(null,"What is the name of the opposing bee colony?"));//Sets the name of the bee colony
          bee1.setSize(JOptionPane.showInputDialog(null,"What is the size of " + bee1.getName() + "?"));//Sets the size of the bee colony
                
                  
                  
         //This if/else statement outputs the opposite questions from the ones above
      
      }else{
          butterfly1.setName(JOptionPane.showInputDialog(null,"What is the name of the opposing butterfly colony?"));//Sets the name of the butterfly colony
          butterfly1.setColor(JOptionPane.showInputDialog(null,"What is the primary color of your butterflies?"));
          butterfly1.setColor(JOptionPane.showInputDialog(null,"What is the accent color of your butterflies?"));//Sets the color of the butterfly colony
          butterfly1.setSize(JOptionPane.showInputDialog(null,"What is the size of " + butterfly1.getColor() + " " + 
                  butterfly1.getColor2() + " " + butterfly1.getName() + "?"));//Sets the size of the butterfly colony
          
      }
      
             
      flower1.setType(JOptionPane.showInputDialog("What is your favorite flower?"));
      flower2.setType(JOptionPane.showInputDialog("What is your mom's favorite flower?"));//Sets the three types of flower used for the game
      flower3.setType(JOptionPane.showInputDialog("What is dad's favorite flower?"));
      
      flower1.setColor(JOptionPane.showInputDialog("What color do you want your " + flower1.getType() + " to be?"));
      flower2.setColor(JOptionPane.showInputDialog("What color do you want your " + flower2.getType() + " to be?"));//Sets the color for the three types of roses
      flower3.setColor(JOptionPane.showInputDialog("What color do you want your " + flower3.getType() + " to be?"));
      
      
      
        //Every round I need to randomize the butterfly and bee carry capacity, the flowers distance from the colony
        //1 + capacity.nextInt(7), does 0-7  but adds a 1 to create the final product; for bees the carry capacity is 3-7, 
        //therefore 3 + capacity.nextInt(4) would give us the correct amount because it would use 0-4 and add 3, 
        //the smallest number possible is 3 and the largest is 7
      
      //--------------------------------------------------------------------------------------------------------------------
      
      //Round 1 
      
      butterfly1.setCapacity(1 + capacity.nextInt(9));
      bee1.setCapacity(3 + capacity.nextInt(4));
      flower1.setDistance(1 + capacity.nextInt(4));
      
      JOptionPane.showMessageDialog(null, "Round 1: \n" + "Team " + butterfly1.getColor() + " " + 
                  butterfly1.getColor2() + " " + butterfly1.getName() + " and Team " + bee1.getName() + " will be racing to the " 
              + flower1.getColor() + " " + flower1.getType() + ". \n The distance to the " + flower1.getColor() + " " + flower1.getType() + " is: " + flower1.getDistance()+ " mile(s).");
      //Sets the distance of the flower using a random number, and then outputs it into JOptionPane
      //Identifies the round, as well as identifies the flower used
        
      
     JOptionPane.showMessageDialog(null," Team " + butterfly1.getColor() + " " +  butterfly1.getColor2() 
              + " " + butterfly1.getName() + " will have a carry capacity of: " + butterfly1.getCapacity() + " gram(s).");
      //Sets the capacity of the butterfly using a random number, and then outputs it into JOptionPane
      
      
      JOptionPane.showMessageDialog(null,"Team " + bee1.getName() + " will have a carry capacity of: " + bee1.getCapacity() + " gram(s).");
       //Sets the capacity of the bee using a random number, and then outputs it into JOptionPane
      
      butterflyNectarRound1 = butterfly1.getCapacity() - (butterfly1.getCapacity() * (flower1.getDistance() * .05));
      beeNectarRound1 = bee1.getCapacity() - (bee1.getCapacity() * (flower1.getDistance() * .05));
      
      JOptionPane.showMessageDialog(null, butterflyNectarRound1 + " gram(s) of nectar made it back to the colony for Team " + butterfly1.getColor() 
              + " " +  butterfly1.getColor2() + " " + butterfly1.getName());
      JOptionPane.showMessageDialog(null, beeNectarRound1 +  " gram(s) of nectar made it back to the colony for Team " + bee1.getName());
           
                  
      JOptionPane.showMessageDialog(null, "Total nectar: \n Team " + bee1.getName() + ": " +  beeNectarRound1 + " gram(s)\n"
         + "Team " + butterfly1.getColor() + " " +  butterfly1.getColor2() + " " + butterfly1.getName() + ": " + butterflyNectarRound1 + " gram(s)");
      
      
      //--------------------------------------------------------------------------------------------------------------------
      
      //Round 2
      
      butterfly2.setCapacity(1 + capacity.nextInt(9));
      bee2.setCapacity(3 + capacity.nextInt(4));
      flower2.setDistance(1 + capacity.nextInt(4));
      
      
      JOptionPane.showMessageDialog(null, "Round 2: \n" + butterfly1.getColor() 
               + " " + butterfly1.getColor2() + " " + butterfly1.getName() + " and Team " + bee1.getName() + " will be racing to the " 
               + flower2.getColor() + " " + flower2.getType() + ".\n" + " The distance to the " + flower2.getColor() + " " + flower2.getType()
               + " is: " + flower2.getDistance() + " mile(s).");
         //Sets the distance of the flower using a random number, and then outputs it into JOptionPane
         //Identifies the round, as well as identifies the flower used
     
      JOptionPane.showMessageDialog(null,"Team " + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName() + " will have a carry capacity of: " 
              + butterfly2.getCapacity() + " gram(s)");
      //Sets the capacity of the butterfly using a random number, and then outputs it into JOptionPane
      
      
      JOptionPane.showMessageDialog(null,"Team " + bee1.getName() + " will have a carry capacity of: " + bee2.getCapacity() + " gram(s)");
       //Sets the capacity of the bee using a random number, and then outputs it into JOptionPane
      
      
      butterflyNectarRound2 = butterfly2.getCapacity() - (butterfly2.getCapacity() * (flower2.getDistance() * .05));
      beeNectarRound2 = bee2.getCapacity() - (bee2.getCapacity() * (flower2.getDistance() * .05));
      
      JOptionPane.showMessageDialog(null, butterflyNectarRound2 + " gram(s) of nectar made it back to the colony for Team " + butterfly1.getColor() 
              + " " + butterfly1.getColor2() + " " + butterfly1.getName());
      JOptionPane.showMessageDialog(null, beeNectarRound2 +  " gram(s) of nectar made it back to the colony for Team " + bee1.getName());
      
      JOptionPane.showMessageDialog(null, "Total nectar: \n Team " + bee1.getName() + ": " + (beeNectarRound1 + beeNectarRound2) + " gram(s)" + " \n Team " 
              + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName() + ": "+ (butterflyNectarRound1 + butterflyNectarRound2) + " gram(s)");
     
      
      //--------------------------------------------------------------------------------------------------------------------
      //Round 3
     
      butterfly3.setCapacity(1 + capacity.nextInt(9));
      bee3.setCapacity(3 + capacity.nextInt(4));
      flower3.setDistance(1 + capacity.nextInt(4));
      
      JOptionPane.showMessageDialog(null, "Round 3: \n" + "Team " + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName()
              + " and team " + bee1.getName() + " will be racing to the " 
              + flower3.getColor() + " " + flower3.getType() + ". \n The distance to the " + flower3.getColor() + " " + flower3.getType()
              + " is: " + flower3.getDistance() + " mile(s).");
        //Sets the distance of the flower using a random number, and then outputs it into JOptionPane      
        //Identifies the round, as well as identifies the flower used
        
      JOptionPane.showMessageDialog(null,"Team " + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName() + " carry capacity will be: " + butterfly3.getCapacity() + " gram(s).");
      //Sets the capacity of the butterfly using a random number, and then outputs it into JOptionPane
      
      
      JOptionPane.showMessageDialog(null,"Team " + bee1.getName() + " carry capacity will BEE: " + bee3.getCapacity() + " gram(s).");
       //Sets the capacity of the bee using a random number, and then outputs it into JOptionPane
      
      //Sets the nectar at the end of round 3      
      butterflyNectarRound3 = butterfly3.getCapacity() - (butterfly3.getCapacity() * (flower3.getDistance() * .05));
      beeNectarRound3 = bee3.getCapacity() - (bee3.getCapacity() * (flower3.getDistance() * .05));
      
      JOptionPane.showMessageDialog(null, butterflyNectarRound3 + " gram(s) of nectar made it back to the colony for Team " 
              + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName());
      JOptionPane.showMessageDialog(null, beeNectarRound3 +  " gram(s) of nectar made it back to the colony for Team " + bee1.getName());
      //Outputs the amount of nectar that made it back to the colony at the end of round three
      
      
      JOptionPane.showMessageDialog(null, "Total nectar: \n Team " + bee1.getName() + ": " + (beeNectarRound1 + beeNectarRound2 + beeNectarRound3) + " gram(s)" 
              + " \n Team " + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName() + ": "
              + (butterflyNectarRound1 + butterflyNectarRound2 + butterflyNectarRound3) + " gram(s)");
      //Outputs the total amount of nectar that made in back to the colonies after the three rounds, in grams
      
      //--------------------------------------------------------------------------------------------------------------------
      
       
                         
     JOptionPane.showMessageDialog(null, "The results are in: \n\n" 
             + "Team " + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName() 
             + "'s original colony size was: " + butterfly1.getSize() +  " butterflies\n"  
                  
             + "Team " + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName() 
             + "'s total carry capacity was: " + (butterfly1.getCapacity() 
              + butterfly2.getCapacity() + butterfly3.getCapacity()) +  " gram(s)\n\n"
         
             +  "Team " + bee1.getName() + "'s original colony size was: " + bee1.getSize() +  " bee(s)\n"
        
             +  "Team " + bee1.getName() + "'s total carry capacity was: " + (bee1.getCapacity() + bee2.getCapacity() 
              + bee3.getCapacity()) +  " gram(s)\n\n"
                      
             + "Total distance traveled: " + (flower1.getDistance() 
              + flower2.getDistance() + flower3.getDistance()) +  " miles(s)\n\n"
         
             + "Total amount of nectar collected: \n" + "     Team  " + butterfly1.getColor() + " " + butterfly1.getColor2() 
             + " " + butterfly1.getName() + "'s: " + (butterflyNectarRound1 + butterflyNectarRound2 + butterflyNectarRound3) 
              + " gram(s)\n" + "     Team "+ bee1.getName() + "'s: " 
             + (beeNectarRound1 + beeNectarRound2 + beeNectarRound3) + " gram(s)\n"
         
         );
         
      //gameWinner finds the higher nectar count of the two colonies
      //If Else statement uses the boolean true (if the butterfly is higher than the bee or TRUE) AND the user selection was for butterflies
      //than the user has won, otherwise they have lost     
     
      totalBeeNectar = beeNectarRound1 + beeNectarRound2 + beeNectarRound3;
      totalButterflyNectar = butterflyNectarRound1 + butterflyNectarRound2 + butterflyNectarRound3;
      
      gameWinner = totalBeeNectar < totalButterflyNectar;
      
          if((gameWinner) && (userSelection==0)){
              butterfly1.setGrowth();
              bee1.setShrink();
         JOptionPane.showMessageDialog(null, "CONGRATULATIONS!  " + userName + ", " 
                 + " You won the game!!" + " and your colony has tripled in size!!!\n"
             + "Team " + butterfly1.getColor() + " " + butterfly1.getColor2() + " " + butterfly1.getName() + "'s final size is " + (butterfly1.getGrowth() + " butterflies." 
                     
             + "\nTeam " + bee1.getName() + "'s final size is " + (bee1.getShrink())) + " bee."
                  
         );
         
         
      }else{
              butterfly1.setShrink();
              bee1.setGrowth();
         JOptionPane.showMessageDialog(null, "OH " + userName + " that is to bad, " + " Try Again\n"
           + "Team " + bee1.getName() + "'s final size is " + (bee1.getGrowth()  + " bees."
           + "Team " + butterfly1.getColor() +" " + butterfly1.getColor2() + " " + butterfly1.getName() + "'s final size is " + (butterfly1.getShrink() + " butterflies."
                        
                 )));
         
         }
       }
    
       
      }
      
   
      
      
      
      
        
   
    
    
    
       

