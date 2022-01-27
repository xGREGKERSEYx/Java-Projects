
import java.util.Random;


/**
 *
 * @author grego
 */
public class Bee {
  private String beeColonyName;
  private String beeColonySize;
  private int beeCarryCapacity;  
  private double beeGrowth;
  private double beeShrink;
  Random capacity = new Random();//creates a new random
  
  
    public void setName(String beeColonyName) {//To set the name of bees
        this.beeColonyName = beeColonyName; 
    }
  public String getName() { //To get the name for bees
        return beeColonyName;
    }
    
    public void setSize(String beeColonySize) {//To set the size of bees
        this.beeColonySize = beeColonySize; 
    }
  public String getSize() {//To get the size of the bees
        return beeColonySize; 
    }
    
    public void setCapacity(int beeCarryCapacity) {//To set the carry capcity of bees
        this.beeCarryCapacity = 3 + capacity.nextInt(4); 
    }
  public int getCapacity() {//To get the carry capacity for bees
        return beeCarryCapacity; 
    }
    
  public void setGrowth(){//Sets the growth of bees after they win
        this.beeGrowth = Integer.parseInt(beeColonySize) * 3;
    }
public double getGrowth(){//Gets the growth of bees after they win
    return beeGrowth;
    }    
public void setShrink(){//Sets the shrinkage of bees after they lose
   int beeShrunk;
    beeShrunk = Integer.parseInt(beeColonySize);
  this.beeShrink = beeShrunk - (beeShrunk * (1/10));
                
    }
public double getShrink(){//Gets the shrinkage of bees after they lose
    return beeShrink;    
    }


}
