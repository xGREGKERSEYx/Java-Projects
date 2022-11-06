/* 
*  This is an Object-Orineted based project that uses for loops
*  2D, 1D arrays, and Objects to perform a trajectory calculation
*  And returns the best values i.e the values that lie between the
*  min and max
*/
import java.util.ArrayList;



 public class ProjectileTable {
    /*
    *      Speed^2(sin2(angle))
    * R =  ------------------
    *          9.8m/s
    */
     private double distance, gravity;
     private double [] minAndMax,angles, speeds;
     private double distanceArray[][];
     ArrayList<Double> bestShot;
    
     
     

    public ProjectileTable(double [] minAndMax, double [] speeds, double [] angles, double [][] targetArray, ArrayList<Double> bestValue) {
        this.bestShot = bestValue;
        this.distance = 0;
        this.minAndMax = minAndMax;
        this.gravity = 9.8;
        this.angles = angles;
        this.speeds = speeds;
        this.distanceArray = targetArray;
        
        
    }//end the default constructor
    
    
    public void projCalc(){//method to calculate the distance
       
      
        System.out.println(""); 
        
       for(int row = 0; row < speeds.length; row++){
           System.out.print(speeds[row] + " m/s ");
           
          for(int col = 0; col < angles.length; col++){
              distanceArray[row][col] = ((speeds[row] * speeds[row])* Math.sin(Math.toRadians(angles[col]))) / gravity;//Calculates the trajectory of a projectile
                                                                                                        //Converts the angles to radians                                                                          
              distance = distanceArray[row][col];//Assigns the 2d array to the value of rounDistance
              
                            
              System.out.printf("%15.2f", distanceArray[row][col]);//Console output for the valueof the 2d array at row col
              }
          System.out.println("");
          }
      if(distance > minAndMax[0] && distance < minAndMax[1]){
          double roundDistance = Math.round(distance);
            bestShot.add(roundDistance);//Rounds the distance variable 
            System.out.print("Best Values: " + bestShot);
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------");
      
       }else{
          System.out.print("There are no good shots");
      }
    
    }//Ends the projectile calculation method
    }//Ends the Main Class
    

