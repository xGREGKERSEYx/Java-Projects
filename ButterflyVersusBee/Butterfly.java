
import java.util.Random;


/**
 *
 * @author grego
 */
public class Butterfly {
  private String butterflyColonyName;
  private String butterflyPrimaryColor;
  private String butterflyAccentColor;
  private String butterflySize;
  private int btrflyColonySize;
  private int butterflyCarryCapacity; 
  private double butterflyGrowth;
  private double butterflyShrink;
  private String butterflyFinal;
  
  
  
  Random capacity = new Random();//creates a new random
  
  
public void setName(String butterflyColonyName) {//To set the name of butterflies
        this.butterflyColonyName = butterflyColonyName; 
    }
public String getName() {//To get the name of butterflies
        return butterflyColonyName; 
    }
public void setColor(String butterflyPrimaryColor) {//To set the color of butterflies
        this.butterflyPrimaryColor = butterflyPrimaryColor;  
    }
public String getColor() {//To get the color of butterflies
        return butterflyPrimaryColor; 
    }
public void setColor2(String butterflyAccentColor) {//To set the color of butterflies
        this.butterflyAccentColor = butterflyAccentColor;  
    }
public String getColor2() {//To get the color of butterflies
        return butterflyAccentColor; 
    }
public void setSize(String butterflySize) {//To set the size of butterflies
        this.butterflySize = butterflySize;  
    }
public String getSize() {//To get the size of butterflies
        return butterflySize; 
    }
public void setCapacity(int butterflyCarryCapacity) {//To set the carry capacity of butterflies
        this.butterflyCarryCapacity = 1 + capacity.nextInt(9);  
    }
public int getCapacity() {//To get the carry capacity of butterflies
        return butterflyCarryCapacity; 
    }
public void setGrowth(){//Sets to final colony size if the butterflies won
        this.butterflyGrowth = Integer.parseInt(butterflySize) * 3;
    }
public double getGrowth(){//Gets to final colony size if the butterflies won
    return butterflyGrowth;
    }    
public void setShrink(){//Sets the final colony size if the butterflies lost
   int butterflyShrunk;
    butterflyShrunk = Integer.parseInt(butterflySize);
  this.butterflyShrink = butterflyShrunk - (butterflyShrunk * (1/10));
    }
public double getShrink(){//Gets the final colony size if the butterflies lost
    return butterflyShrink;
    }
public void setFinal(){//Sets the colors and name of the butterfly colony
    this.butterflyFinal =  butterflyPrimaryColor + butterflyAccentColor + butterflyColonyName;
    }
public String getFinal(){//Gets the colors and name of the butterfly colony
    return butterflyFinal;    
    }
  
  
} 
  
  

