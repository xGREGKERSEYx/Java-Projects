
package trial;

import javax.swing.JOptionPane;

/**
 *
 * @author grego
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author grego
 */

import javax.swing.JOptionPane;
import java.util.Random;
public class Main {
    
    public static void main(String [] args){   
        Random r = new Random();
        JOptionPane.showMessageDialog(null, "Hey Mom, Here are you winning numbers:\n" 
                + "          Fantasy Five Numbers: " + ( 1+ r.nextInt (36) + " ") + ( 1+ r.nextInt (36) + " ") + ( 1+ r.nextInt (36) + " ") + ( 1+ r.nextInt (36) + " ")+ ( 1+ r.nextInt (36) + " ")
                + "\n" + "          Regular Loto: " + ( 1+ r.nextInt (53) + " ") + ( 1+ r.nextInt (53) + " ") + ( 1+ r.nextInt (53) + " ") + ( 1+ r.nextInt (53) + " ")+ ( 1+ r.nextInt (53) + " ") + ( 1+ r.nextInt (53) + " "), 
                "Lottery Numbers"
                , JOptionPane.PLAIN_MESSAGE);
        
        
  
    }     

    }



    
    

