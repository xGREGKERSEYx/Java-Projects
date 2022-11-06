package hauntedhouseproject;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Rooms {
     String playerRoom;
     int userSelection;
     
     
   
   public void frontDoor(){
       ImageIcon frontdoor = new ImageIcon("frontdoor.jpg");//Creates the icon for the Front door
       
       String [] frontDoorOptions = {"Living Room", "Dining Room", "Stairs"};//Creates options for Front Door
       
      userSelection =  JOptionPane.showOptionDialog(null, ", you are currently at the front door, \nwhere would you like to go next?", 
              "Front Door", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, frontdoor, frontDoorOptions, frontDoorOptions);
//States the starting Position for the Player
       
       if(userSelection == 0){
          livingRoom();
       }else if (userSelection == 1){
           diningRoom();       
       }else if(userSelection == 2){
           stairs();
       }
   
   
   
   }
public void livingRoom(){
       ImageIcon livingroom = new ImageIcon("livingroom.jpg");//Creates the icon for the Living Room
       ImageIcon chest = new ImageIcon("chest.jpg");//Creates the icon for the chest
       ImageIcon ghost = new ImageIcon("ghost.jpg");//Creates the icon for the ghost
       
       String objectsInRoom = "chest";
       
       String [] livingRoomOptions = {"Living Room", "Bathroom"};//Creates options for Living Room
       
       int userSelection = JOptionPane.showOptionDialog(null, ", "
               + "\nyou have moved into the living room and find a " + objectsInRoom
               + "\nWould you like to check the living room or move into the bathroom?", 
               "Living Room", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, livingroom, livingRoomOptions, livingRoomOptions);
       if (userSelection == 0){
           JOptionPane.showMessageDialog(null, ", "
                   + "\na ghost suddenly appears before you "
                   + "\nand you take 3d12 of phsyic damage, "
                   + "\nleading to an agonizing death. "
                   + "\nGame Over", "Chest", userSelection, chest);
           
           JOptionPane.showMessageDialog(null, ", "
                   + "\nsadly, with the weight of the chest in your bag "
                   + "\nand the sudden presence of the ghost,"
                   + "\nyou have passed on to another realm.", "Ghost", userSelection, ghost);
       
       }else{
      bathroomOne();
       }
      }//Ends living room class
   
public void bathroomOne(){
       ImageIcon bathroom = new ImageIcon("bathroom.jpg");//Creates the icon for the bathroom
       ImageIcon mirror = new ImageIcon("mirror.jpg");//Creates the icon for the mirror
       ImageIcon bloodymirror = new ImageIcon("bloodymary.jpg");//Creates the icon for the bloody mirror
       ImageIcon shower = new ImageIcon("shower.jpg");//Creates the icon for the shower
       ImageIcon steamyshower = new ImageIcon("steamyshower.jpg");//Creates the icon for the steamy shower
       
       String objectsInRoom = "\nan intricate mirror,\nand a dripping shower ";
   
       String [] bathRoomOptions = {"Mirror", "Shower"};//Creates options for downstairs Bathroom
       
       int userSelection = JOptionPane.showOptionDialog(null, ", you have arrived in the bathroom and find " + objectsInRoom, 
               "Downstairs Bathroom", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bathroom, bathRoomOptions, bathRoomOptions);
       
       if(userSelection == 0){
           JOptionPane.showMessageDialog(null, 
                   "\n, as you approach the mirror "
                 + "\nyou see a bloody face in the mirror,"
                 + "\nthat reminds you of a nightmare you once had."
                 + "\nYou decided this house was too scary and "
                 + "\npeed your pants as you ran out the door", "Bathroom Mirror", userSelection, mirror);
           JOptionPane.showMessageDialog(null, 
                   ", sadly, after seeing the bloody face"
                 + "\nthe only thing left behind was"
                 + "\na trail of pee, and an empty book bag",
                   "Boo", userSelection, bloodymirror);
       
       }else{
           JOptionPane.showMessageDialog(null, 
                   ", the room suddenly steams up and you"
                 + "\nfeel fingers touching the nap of your neck,"
                 + "\nand before you realize you too are part of the steam. ", "Bathroom Shower", userSelection, shower);
           JOptionPane.showMessageDialog(null, 
                   ", your mom walks into the bathroom and"
                 + "\nall she finds is an empty book "
                 + "\nbag on the floor. "
                 + "\nGame Over Sport.", "Boo", userSelection, steamyshower);
        }
    }//Ends bathroom class
public void diningRoom(){
         ImageIcon diningroom = new ImageIcon("diningroom.jpg");//Creates the icon for the Dining Room
         ImageIcon ancientcandelabra = new ImageIcon("ancientcandelabra.jpg");//Creates the icon for the ancient candelabra
         ImageIcon shadowofdeath = new ImageIcon("shadowofdeath.jpg");//Creates the icon for the shadow of death
         
         String [] diningRoomOptions = {"Dining Room", "Kicthen"};//Creates options for dining room options

          String objectsInRoom = "an ancient candelabra";
          
          userSelection = JOptionPane.showOptionDialog(null, 
                  ", \nyou have moved to the dining room and found " + objectsInRoom
                  + "\nwould you like to collect the ancient candelabra"
                  + "\nor move into the kicthen?", "Dininr Room", 
                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, diningroom, diningRoomOptions, diningRoomOptions);
          if (userSelection == 0){
          JOptionPane.showMessageDialog(null, 
                  ", as you light up the ancient candelabra"
                + "\nyou see the shadow of death itself"
                + "\nand when you go to shriek"
                + "\nit covers your mouth and drags "
                + "\nyou to the pits of hell","Dining Room", userSelection, ancientcandelabra);
          JOptionPane.showMessageDialog(null, 
                  ", \nsadly, death mistook you for a"
                + "\ntheif after his very own ancient"
                + "\ncandelabra, and dragged you with him."
                + "\nDo not fret though for he left your book bag"
                + "\nwith the ancient candelabra in it."
                + "\nGAME OVER SON", "Dining Room", userSelection, shadowofdeath);
          }else{
          kitchen();
          }
    }
public void kitchen(){
    ImageIcon kitchen = new ImageIcon("kitchen.jpg");//Creates the icon for the kitchen
    ImageIcon refrigerator = new ImageIcon("refrigerator.jpg");//Creates the icon for the refrigerator
    ImageIcon soulfood = new ImageIcon("soulfood.jpg");//Creates the icon for the soul food
    ImageIcon cabinet = new ImageIcon("cabinet.jpg");//Creates the icon for the cabinet
    ImageIcon flyingdishes = new ImageIcon("dishes.jpg");//Creates the icon for the flying dishes
    
    String objectsInRoom = " a Refrigerator, and a cabinet";
    
    String [] kitchenOptions = {"Refrigerator", "Cabinet", "Pantry"};//Creates options for kitchen options
    
    userSelection = JOptionPane.showOptionDialog(null, ", "
            + "\nyou have moved to the kitchen."
            + "\nIn the kitchen you have found"
            + "\n" + objectsInRoom
            + "Would you like to check one of the objects"
            + "\n or move into the Pantry?", "Kitchen", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, kitchen, kitchenOptions, kitchenOptions);
    if(userSelection == 0){
        JOptionPane.showMessageDialog(null, ", "
                + "\nyou have found some delicious soul food "
                + "\ncooked by Sylvia Woods herself", "Refrigerator", userSelection, refrigerator);
        JOptionPane.showMessageDialog(null, 
                ",\nthe soul food was so delicious you had to "
              + "\npack into your book bag and leave the "
              + "\nhaunted house to give some to your mom"
              + "\nGAME OVER PAL!", "Soul Food", userSelection, soulfood);
    }else if(userSelection == 1){
        JOptionPane.showMessageDialog(null, ", "
                + "\nas you open the cabinet you hear rattling"
                + "\nand as it comes open all the way "
                + "\ndishes and glasses start flying at you."
                + "\nA glass handcrafted by leonardo da vinci smacks"
                + "\nyou in the head, you feel faint"
                + "\nand as you fall you feel yourself moving towards the light", "Cabinet", userSelection, cabinet);
        JOptionPane.showMessageDialog(null, ", "
                + "\nsadly, one of the dishes cut the"
                + "\nstring on your book bag and all"
                + "\nyour stuff went flying everywhere."
                + "\nGAME OVER GIRLIE!", "flying dishes", userSelection, flyingdishes);
    
    }else if(userSelection == 2){
        pantry();
    }
        
    }//Ended the kitchen options    
public void pantry(){
    ImageIcon pantry = new ImageIcon("pantry.jpg");//Creates the icon for the pantry
    ImageIcon dustyrecipebox = new ImageIcon("dustyrecipebox.jpg");//Creates the icon for the dusty recipe box
    ImageIcon broom = new ImageIcon("nimbus2000.jpg");//Creates the icon for the broom
    
    String objectsInRoom = "a Dusty Recipe box, and a Broom";
    
    String [] optionsPantry = {"Dusty recipe box", "Broom"};//Creates options for pantry
    
    userSelection = JOptionPane.showOptionDialog(null, ","
            + "\nyou have moved into the pantry and found " + objectsInRoom 
            + "\nwhich object which you like to take?", "Pantry", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, pantry, optionsPantry, userSelection);
    if(userSelection == 0){
        JOptionPane.showMessageDialog(null, ", "
                + "\nyou have found a recipe for chocolate devil's food cake, "
                + "\na rare recipe made by Marco Pierre White", "Dusty Recipe box", userSelection, dustyrecipebox);
        JOptionPane.showMessageDialog(null, ", "
                + "\nyou were so ecsatic about finding the recipe "
                + "\nthat because you knew it was your mom's"
                + "\nfavourite that you ran out, after "
                + "\nstuffing it into your book bag"
                + "\nGame Over", "Dusty Recipe box", userSelection, dustyrecipebox);
    }else if(userSelection == 1){
        JOptionPane.showMessageDialog(null, ", "
                + "\na nimbus 2000 lies before you /n"
                + "\nas you go to grab it, it flies "
                + "\ninto the air and out the roof", "Broom", userSelection, broom);
        JOptionPane.showMessageDialog(null, ","
                + "\nwhen the broom flew off you forgot to "
                + "\ncheck the rest of the pantry and "
                + "\nran off after it instead, leaving "
                + "\nyou with nothing in your book bag"
                + "\nGame Over", "Broom", userSelection, broom);
    }
}//ends pantry options
public void stairs(){
     ImageIcon stairs = new ImageIcon("stairs.jpg");//Creates the icon for the Stairs
     
     String [] stairOptions = {"Dorothy's Bedroom", "Johnny's Bedroom", "Master Bedroom"};//Creates options for Stairs
     
     userSelection = JOptionPane.showOptionDialog(null, 
               "\nyou have moved up the stairs "
             + "\nand find three bedrooms. "
             + "\nWhich one would you like to visit?", "Stairs", 
             JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, stairs, stairOptions, userSelection);
     if(userSelection == 0){
         bedroomOne();
     
     }else if(userSelection == 1){
         bedroomTwo();
     
     }else if(userSelection == 2){
         masterBedroom();
     
     }


}//ends the stair options
public void bedroomOne(){
    String objectsInRoom = "a rocking chair, and a window";
    
    String [] bedroomOneOptions ={"Rocking Chair", "Window", "Bathroom", "Master bedroom"};//Creates options for bedroom one options
    
    ImageIcon bedroomone = new ImageIcon("bedroomone.jpg");//Creates the icon for  the bedroom one
    ImageIcon rockingchair = new ImageIcon("rockingchair.jpg");//Creates the icon for the rocking chair
    ImageIcon window = new ImageIcon("window.jpg");//Creates the icon for the window
    ImageIcon swingingchild = new ImageIcon("swingingchild.jpg");//Creates the icon for the swinging child
    
    userSelection = JOptionPane.showOptionDialog(null, 
               "\nyou have moved into Dorothy's bedroom"
             + "\nand find " + objectsInRoom 
             + "\nWould you like to explore the rocking chair, the window"
             + "\nor move into the bathroom?", "Stairs", 
             JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bedroomone, bedroomOneOptions, userSelection);
    if(userSelection == 0){
        JOptionPane.showMessageDialog(null,
                 ", as you get closer to the chair "
                + "\nit starts rocking back and forth", "Broom", userSelection, rockingchair);
        JOptionPane.showMessageDialog(null, 
                  ", you sit down in the chair"
                + "and before you know it, "
                + "\nyou have been rocking for eternity."
                + "\nGame Over.", "Broom", userSelection, rockingchair);   
    }else if(userSelection == 1){
        JOptionPane.showMessageDialog(null,
                  ", as you look out the window you"
                + "\nnotice a swing with a lonesome child"
                + "\non it. But as you blink the child suddenly dissapears", "Broom", userSelection, window);
        JOptionPane.showMessageDialog(null, 
                  ", you ran out of the Haunted House "
                + "\ntoo look for thie missing child,"
                + "\nbut you failed to realize the uncanny"
                + "\nresemblance the child had to your ownself"
                + "\nGame Over", "Broom", userSelection, swingingchild);
    }else if(userSelection == 2){
        upperBathroom();
    }else if(userSelection == 3){
        masterBedroom();
    }

}

public void bedroomTwo(){
    String objectsInRoom = "a doll house, and a dresser.";
    
    String [] bedroomTwoOptions = {"Doll House", "Dresser", "Bathroom", "Master Bedroom"};//Creates options for bedroom two options
    
    ImageIcon bedroomtwo = new ImageIcon("bedroomtwo.jpg");//Creates the icon for the bedroom two
    ImageIcon dollhouse = new ImageIcon("dollhouse.jpg");//Creates the icon for the doll house
    ImageIcon dresser = new ImageIcon("dresser.jpg");//Creates the icon for the dresser
    ImageIcon ghostbedroom = new ImageIcon("moaningmyrtle.jpg");//Creates the icon for the moaning myrtle
    
    userSelection = JOptionPane.showOptionDialog(null, 
            ", /nyou have moved into Johnny's bedroom."
            + "\nin the bedroom you have found "
            + objectsInRoom 
            + "\nWould you like to explore one of the "
            + "\nobjects or move into the bathroom", "Bedroom Two", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bedroomtwo, bedroomTwoOptions, bedroomTwoOptions);
    if(userSelection == 0){
        JOptionPane.showMessageDialog(null, 
                ", as you get closer the dolls within start dancing "
              + "\nto the tune of Rick Astly's Never Gonna Give You Up", "Doll House", userSelection, dollhouse);
        JOptionPane.showMessageDialog(null, 
                ", you start dancing with the dolls,"
              + "\nand before you know it, you"
              + "\ndanced your feet away."
              + "\nGame Over.", "Doll House", userSelection, dollhouse);
    
    }else if(userSelection == 1){
        JOptionPane.showMessageDialog(null, 
                ", you notice the top drawer is slightly"
                + "\n open, so you pull it further and "
                + "\n the ghost of moaning Myrtle flies out"
                + "\n and goes right through your body", playerRoom, userSelection, dresser);
        JOptionPane.showMessageDialog(null, 
                ", you have experienced an otherwordly "
              + "\nexperience and your mind cannot handle it"
              + "\nyou crumble into a piles of sobs and snivvles"
              + "\nGame Over Cry Baby", playerRoom, userSelection, ghostbedroom);
    
    }else if(userSelection == 2){
        upperBathroom();
        
    }else if(userSelection == 3){
        masterBedroom();    
    }


}

public void upperBathroom(){
    String objectsInRoom = "a mirror and a Shower";
    
    String [] upperBathroomOptions = {"Mirror", "Shower", "Dorothy's", "Johnny's"};//Creates options for the upstairs bathroom
    
    ImageIcon bathroom = new ImageIcon("bathroom.jpg");//Creates the icon for the bathroom
    ImageIcon mirror = new ImageIcon("mirror.jpg");//Creates the icon for the mirror
    ImageIcon bloodymirror = new ImageIcon("bloodymary.jpg");//Creates the icon for the bloody mirror
    ImageIcon shower = new ImageIcon("shower.jpg");//Creates the icon for the shower
    ImageIcon steamyshower = new ImageIcon("steamyshower.jpg");//Creates the icon for the steamy shower
  
    userSelection = JOptionPane.showOptionDialog(null, 
            ", you have moved into the Upstairs Bathroom"
            + "\nIn there is " + objectsInRoom
            + "\nWould you like to explore one of these"
            + "\nitems or move into Dorothy's or Johnny's Bedroom", playerRoom, 
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bathroom, upperBathroomOptions, upperBathroomOptions);
    if(userSelection == 0){
        JOptionPane.showMessageDialog(null, 
                ", as you peer into the intircately decorated "
                + "\n mirror on the wall, you start to see a "
                + "\n reflection peer back at you. A reflection"
                + "\n of lives long past", "Mirror", userSelection, mirror);
        JOptionPane.showMessageDialog(null, 
                ", you failed to recognize the reflection as yourself"
              + "\n, making the same mistakes as yur past self"
              + "\n you are now trapped forever"
              + "\nGame Over.", "Mirror", userSelection, bloodymirror);
        
    }else if(userSelection == 1){
        JOptionPane.showMessageDialog(null, 
                ", the walls began to dew, the air "
                + "\n suddenly becomes heavy and"
                + "\n before you know it, the room is "
                + "\n filled with steam. As you try "
                + "\n to make your wait out, you feels fingers "
                + "\n trwirling around the peach fuzz on the"
                + "\n back of your neck, ", "Shower", userSelection, shower);
        JOptionPane.showMessageDialog(null, 
                ", the creepy feeling on your back,"
              + "\nthe heavy feeling in the air,"
              + "\nit is all too much. You run out screaming."
              + "\nGame Over Cry Baby", "Shower", userSelection, steamyshower);
        
    }else if(userSelection == 2){
        bedroomOne();
    
    }else if(userSelection == 3){
        bedroomTwo();

}


}

public void masterBedroom(){
    String objectsInRoom = "a jewerly box";
    
    String [] masterBedroomOptions = {"Jewerly Box", "Master Bathroom", "Johnny's", "Dorothy's"};
    //Creates options for the master bedroom options
            
    
    ImageIcon masterbedroom = new ImageIcon("masterbedroom.jpg");//Creates the icon for the master bedroom
    ImageIcon jewerlybox = new ImageIcon("jewerlybox.jpg");//Creates the icon for the jewerly box
    ImageIcon hopediamond = new ImageIcon("hopediamond.jpg");//Creates the icon for the hopediamond
    
    userSelection = JOptionPane.showOptionDialog(null, 
            ", you have moved into the master bedroom"
            + "\nIn the master bedroom is " 
            + objectsInRoom 
            + "\nwould you like to explore this object"
            + "\nor move into the master bathroom.", "Master Bedroom", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, masterbedroom, masterBedroomOptions, masterBedroomOptions);
    if(userSelection == 0){
        JOptionPane.showMessageDialog(null, 
                ", as you open the jewerly box "
              + "\n you are astounded by what you see:"
              + "\n the Hope Diamond.", "Jewerly Box", userSelection, jewerlybox);
        JOptionPane.showMessageDialog(null, 
                ", the cursed Hope Diamond claims another soul. "
              + "\nYou are now cursed and as you go to leave the room"
              + "\nyou fall down the stairs and break"
              + "\nyour neck."
              + "\nGame Over.", "Hope Diamond", userSelection, hopediamond);
    
    }else if(userSelection == 1){
        masterBathroom();    
    }

}
public void masterBathroom(){
    String objectsInRoom = "An intricate oil lamp, and a Shower";
    
    String [] masterBathroomOptions = {"Intricate Oil Lamp", "Shower"};//Creates options for the master bathroom options    
    
    ImageIcon masterbathroom = new ImageIcon("masterbathroom.jpg");//Creates the icon for the master bathroom
    ImageIcon oillamp = new ImageIcon("oillamp.jpg");//Creates the icon for the oil lamp
    ImageIcon mastershower = new ImageIcon("mastershower.jpg");//Creates the icon for the master shower
    ImageIcon alladin = new ImageIcon("alladin.jpg");//Creates the icon for the alladin
    
    userSelection = JOptionPane.showOptionDialog(null, 
            ", you have moved into the master bathroom"
            + "\nIn the bathroom you find "
            + objectsInRoom
            + "\nWould you like to explore one of the objects", "Master Bathroom", 
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, masterbathroom, masterBathroomOptions, masterBathroomOptions);
    if(userSelection == 0){
        JOptionPane.showMessageDialog(null, 
                ", upon the counter you find an Intricate Oil Lamp"
                + "\nand memories of the movie Alladin flashes "
                + "\nin your mind. You rub the lamp and a"
                + "\nbig green whisp fills the room. It asks you "
                + "\nfor your three wishes.", "Oil Lamp", userSelection, oillamp);
         JOptionPane.showMessageDialog(null, 
                 ", after your three wishes, you leave the "
               + "\nHaunted House because this place is no"
               + "\nlonger scary."
               + "\nGame Over.", "Genie", userSelection, alladin);
    
    }else if(userSelection == 1){
         JOptionPane.showMessageDialog(null, 
                 ", as you look toward the shower you"
                + "\nyou hear the songs of the Gods"
                + "\nbut there is no one there.", "Shower", userSelection, mastershower);
          JOptionPane.showMessageDialog(null, 
                  ", the songs of the sirens have sung to you"
                + "\nand called you forth. You answer those calls "
                + "\nand are never seen again"
                + "\nGame Over Cry Baby", "Shower", userSelection, mastershower);
    
    }

}

}
          
          
          
          
          
      
    
    













   
    
    
    
    
    
    
    
    
    

