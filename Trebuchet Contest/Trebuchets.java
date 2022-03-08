/* Gregory Kersey
*  02/18/2022
*  This is an Object-Orineted based project that uses for loops
*  2D, 1D arrays, and Objects to perform a trajectory calculation
*  And returns the best values i.e the values that lie between the
*  min and max
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class Trebuchets {
    
    public static void main (String [] args) throws FileNotFoundException, IOException{
        
        //BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));//Creates an output text file
        File input = new File("input.txt");//Source file used for inputs
        Scanner scnr = new Scanner(input);//Creates a scanner object to read input
        
        int numOfSets = scnr.nextInt();//Reads the input to determine the number of sets
        
        for(int o = 0; o < numOfSets; ++o){
            System.out.println("\n        -----------------------------    Projectile Table    ------------------------------");
            System.out.print("Speeds: \n");
            
        int numOfSpeeds = scnr.nextInt();//Assigns the input to a numOfSpeeds
        double [] speeds = new double[numOfSpeeds];//Creates a 1D array of speeds
        for(int i = 0; i < numOfSpeeds ; i++){
            if(speeds[i] == ' '){}
            speeds[i] = scnr.nextDouble();
        }//Creates the array that contains all the speeds
        
       int numOfAngles = scnr.nextInt();//Creates a variable for the number of angles there are    
       double [] angles = new double [numOfAngles];//Creates an array to store the angles
       for(int i = 0; i < numOfAngles ; i++){
            if(angles[i] == ' '){}
            angles[i] = scnr.nextDouble();
        }//Creates the array that contains all the angles 
       
        double [] minMax = new double [2];//Creates an array for min and max
        for(int x = 0; x < 2; ++x){
            minMax[x] = scnr.nextInt();
        }//Assigns the min and max values to an array
        
        ArrayList<Double> greatShot = new ArrayList<>();
       
        double [][] trajDistance = new double[speeds.length][angles.length];
        ProjectileTable trebuchet = new ProjectileTable(minMax, speeds, angles, trajDistance, greatShot);
                
        System.out.print("\t");
        for(int i = 0; i < angles.length; i++){
            System.out.print("           " + angles[i]);
        }//For loop to print out the angles
        
        trebuchet.projCalc();
             
        }//Ends the sets for loop
        
        
    
    }
      
         
    
}
