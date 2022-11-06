package towerofterror;


import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Floors {
     int playerSelection;
     String bookBag = "";
     private int leave = 0;
     String dice = " 3d12 dice,";
     String playerName;
   
   public void startGame(){
       ImageIcon hauntedhouse = new ImageIcon("hauntedhouse.jpg");//Creates the icon for the Haunted House
        ImageIcon towerofterror = new ImageIcon("towerofterror.jpg");//Creates the icon for the Tower of Terror
        ImageIcon frontdoor = new ImageIcon("frontdoor.jpg");//Creates the icon for the Front door
               
          playerName = JOptionPane.showInputDialog("What is your name?");
//Asks the user for their name, and stores it as a variable
         JOptionPane.showMessageDialog(null, "Hello " + playerName + "," + "\nWelcome to this year's Haunted.....!", "Haunted House?", 0, hauntedhouse);
         JOptionPane.showMessageDialog(null, "TOWER OF TERROR", "Tower of Terror", 0, towerofterror);
//Welcomes the player to the Haunted House
         JOptionPane.showMessageDialog(null, playerName + "," + " a few rules before we begin:"
           + "\n     1. No Harming the Staff"
           + "\n     2. No Harming each other"
           + "\n     3. You need to collect two keys "
                 + "\n          in order to exit this tower"
           + "\n     4. Have fun and Good Luck", "Rules", 0, towerofterror);
//Explains the rules of the game to the player
       
        JOptionPane.showMessageDialog(null, playerName + ", you are currently at the front door", "Front Door", 0, frontdoor);
//States the starting Position for the Player
       frontDoor();
   
   }
   public void basement(){
        ImageIcon basement = new ImageIcon("basement.jpg");//Creates the icon for the basement
        
        String [] basementSelection = {"Boiler Room", "Storage Room", "Elevator"};
        
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", you have arrived in"
               + "\nthe basement. Would you like to check"
               + "\nthe boiler room or the storage room, first?", "Basement", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, basement, basementSelection, basementSelection);
        switch(playerSelection){
            case 0:
                boilerRoom();        
            case 1:
                storageRoom();
            case 2:
                elevator();        
        }
   
   }//Ends the method for Basement
   
   public void boilerRoom(){
       String map = " Map,";
       ImageIcon boilerroom = new ImageIcon("boilerroom.jpg");//Creates the icon for the boiler room
       
       String [] boilerRoomOptions = {"Broken pipe", "Storage Room", "Back to Basement Hall"};
       
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", Welcome to the Boiler Room!"
               + "\nWould you like to explore"
               + "\nthe Broken pipe, storage room or move back"
               + "\ninto the elevator?", "Boiler Room", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, boilerroom, boilerRoomOptions, boilerRoomOptions);
      switch(playerSelection){
          case 0:
              JOptionPane.showMessageDialog(null, playerName + ", inside the broken pipe"
                   + "\nyou find a treasure map with an X"
                   + "\nbeside V3", "Broken Pipe", playerSelection, boilerroom);
              
             bookBag = bookBag.concat(map);//Adds Map to the book bag
              
              basement();
          case 1:
              storageRoom();
          case 2:
              basement();
      }
   }//Ends Boiler Room Method
   
   public void storageRoom(){
       String key = " Normal Key,";
       
       ImageIcon creepystorageroom = new ImageIcon("creepystorageroom.jpg");//Creates the Image Icon for the storage room
       ImageIcon chest = new ImageIcon("chest.jpg");//Creates the icon for the chest
       
       String [] storageRoomOptions = {"Explore this Chest", "Boiler Room", "Back to Basement Hall"};
       
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", welcome to the storage room"
               + "\nWhat do you want to do next", "Storage Room", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, creepystorageroom, storageRoomOptions, storageRoomOptions);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", you have found the key for the attic!"
                       + "\nPlease put it somewhere safe.", "Storage Room Chest", playerSelection, chest);
               
               bookBag = bookBag.concat(key);//Adds the key to the book bag
                             
               storageRoom();
           case 1:
               boilerRoom();
           case 2:
               basement();
       }
   }//Ends storage room method
   
   public void frontDoor(){
       ImageIcon frontdoor = new ImageIcon("frontdoor.jpg");//Creates the icon for the Front door
       int count = 0;
       do{ 
           if (leave == 0){
            

            String [] frontDoorOptions = {"Elevator"};

            JOptionPane.showOptionDialog(null, playerName + ", Please move onto the elevator", "Front Door", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, frontdoor, frontDoorOptions, frontDoorOptions);
            leave = 1;
            elevator();
           }
           
           if (leave == 1){
               JOptionPane.showMessageDialog(null, playerName + ", you cannot leave the Tower of Terror. THE DOOR IS LOCKED!"
                       + "\nYou Must find the Master Key to Unlock the front door and escape!"
                       + "\nHint: The Master Key is somewhere higher then floor 6!", "Front Door", playerSelection, frontdoor);
               elevator();
           }
           
           if (leave == 2){
               count++;
           }
           
           if (count == 2){
               JOptionPane.showMessageDialog(null, playerName + ", congratulations, You unlocked the Front Door with the Master Key!"
                       + "\nYou Have Escaped From the Tower of Terror!"
                       + "\nRun Away While You Still Can!!!"
                       + "\n\nItems in Backpack: " + bookBag);
               System.exit(0);
           }
       } while(leave == 2);
   
   }//ends the front door method
   
   public void elevator(){
       ImageIcon creepyelevator = new ImageIcon("creepyelevator.jpg");//Creates the icon for the creepy elevator
       
       String [] elevatorOptions = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
       
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", you are now in the elevator. "
               + "\nWhere would you like to go?"
               + "\n\n0-Basement  \n1-Front Door  \n2-Living Room  \n3-Dining Room  \n4-Kitchen  \n5-Dorothy's Bedroom  \n6-Upper Bathroom"
               + "\n7-Johnny's Bedroom  \n8-Master Bedroom  \n9-Attic\n\n", "Elevator", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, creepyelevator, elevatorOptions, elevatorOptions);
       
       switch(playerSelection){
           case 0:
               basement();
           case 1:
               frontDoor();
           case 2:
               livingRoom();
           case 3:
               diningRoom();
           case 4:
               kitchen();
           case 5:
               dorothyBedroom();
           case 6:
               upperBathroom();
           case 7:
               johnnyBedroom();
           case 8:
               masterBedroom();
           case 9:
               attic();
           }
   }//ends the elevator method
   
   public void livingRoom(){
       
       
       ImageIcon livingroom = new ImageIcon("livingroom.jpg");//Creates the icon for the Living Room
       ImageIcon chest = new ImageIcon("chest.jpg");//Creates the icon for the chest
       ImageIcon ghost = new ImageIcon("ghost.jpg");//Creates the icon for the ghost
       ImageIcon creepycouch = new ImageIcon("creepycouch.jpg");//Creates the icon for the creepy couch
       
       String [] livingRoomOptions = {"Check the Couch", "Check the Chest", "Move into the Bathroom", "Back into the Elevator"};//Creates options for Living Room
       
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", you have moved into the living room"
               + "\nwhat would you like to do next?", "Living Room", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, livingroom, livingRoomOptions, livingRoomOptions);
       switch(playerSelection){
            case 0:
               JOptionPane.showMessageDialog(null, playerName + ", as you take a seat on the coach"
                       + "\n you fall asleep and have the most peaceful"
                       + "\ndreams of your childhood. "
                       + "\nYou wake up and a kidney is missing", "Living Room", playerSelection, creepycouch);
               livingRoom();
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", you walk towards the"
                       + "\nnormal looking chest in the corner of the room.", "Living Room", playerSelection, chest);
               JOptionPane.showMessageDialog(null, playerName + ", as you open"
                       + "\nthe chest a ghost suddenly appears before you "
                       + "\nand you take 3d12 of phsyic damage."
                       + "The ghost also happens to drop 3d12 dice.", "Living Room", playerSelection, ghost);
               bookBag = bookBag.concat(dice);//Adds dice to the book bag
               livingRoom();
           case 2:
               bathRoom();
           case 3:
               elevator();
       }
   }//ends the living room method
   
   public void bathRoom(){
       String glass = " Glass,";
       String fingerNail = " Finger Nail,";
       
       ImageIcon bathroom = new ImageIcon("bathroom.jpg");//Creates the icon for the bathroom
       ImageIcon mirror = new ImageIcon("mirror.jpg");//Creates the icon for the mirror
       ImageIcon bloodymirror = new ImageIcon("bloodymary.jpg");//Creates the icon for the bloody mirror
       ImageIcon shower = new ImageIcon("shower.jpg");//Creates the icon for the shower
       ImageIcon steamyshower = new ImageIcon("steamyshower.jpg");//Creates the icon for the steamy shower
       
       String [] bathRoomOptions = {"Look into the Mirror", "Step into the Shower", "Back into the Living Room"};//Creates options for downstairs Bathroom
       
       int playerSelecrtion = JOptionPane.showOptionDialog(null, playerName + ", what do you want to peruse "
               + "\nin this spooky scary bathroom?", "Bathroom", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bathroom, bathRoomOptions, bathRoomOptions);
       switch(playerSelecrtion){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", as you peer into the mirror"
                       + "\nsomething starts to peer back.", "Bathroom", playerSelection, mirror);
               JOptionPane.showMessageDialog(null, playerName + ", a piece of glass falls off the mirror"
                       + "\nand you place it in your bookbag.", "Bathroom", playerSelection, bloodymirror);
               bookBag = bookBag.concat(glass);//Adds glass to the book bag
               bathRoom();
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", you place one foot in"
                       + "\nand then another and before you know it"
                       + "\nthe room has filled with steam. ", "Bathroom", playerSelection, shower);
               JOptionPane.showMessageDialog(null, playerName + ", as the room steams up"
                       + "\nyou feel something on the back of your neck"
                       + "\but when you turn around there is"
                       + "\nnothing there except an old finger nail."
                       + "\nPlease place it in your bookbag.", "Bathroom", playerSelection, steamyshower);
               bookBag = bookBag.concat(fingerNail);//Adds a finger nail to the book bag
               bathRoom();
           case 2:
               livingRoom();
       }
   }//ends the bathroom method
   
   public void diningRoom(){
       String candelabra = " Candelabra,";
       
        ImageIcon diningroom = new ImageIcon("diningroom.jpg");//Creates the icon for the Dining Room
        ImageIcon ancientcandelabra = new ImageIcon("ancientcandelabra.jpg");//Creates the icon for the ancient candelabra
        ImageIcon shadowofdeath = new ImageIcon("shadowofdeath.jpg");//Creates the icon for the shadow of death
         
        String [] diningRoomOptions = {"Steal the ornate Candelabra", "Move into the Kicthen", "Back into the Elevator"};//Creates options for dining room options
        
         playerSelection = JOptionPane.showOptionDialog(null, playerName + ", you have moved into the dining room"
                + "\nas such you can do (see options below): ", "Dining Room", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, diningroom, diningRoomOptions, diningRoomOptions);
        switch(playerSelection){
            case 0:
                JOptionPane.showMessageDialog(null, playerName + ", you spot the ornate candelabra"
                        + "\njust sitting there ripe for the taking."
                        + "\nBut as you place it in your bag...", "Dining Room", playerSelection, ancientcandelabra);
                JOptionPane.showMessageDialog(null, "The shadow of death appears behind you."
                        + "\nYou must tread carefully for Death is"
                        + "\nalways watching you.", "Dining Room", playerSelection, shadowofdeath);
                bookBag = bookBag.concat(candelabra);//Adds a candelabra to the book bag
                diningRoom();
            case 1:
                kitchen();
            case 2:
                elevator();}
   }//ends the dining room method
   
   public void kitchen(){
       String soulFood = " Soul food,";
       String brokenDish = " A broken dish";
       
       ImageIcon kitchen = new ImageIcon("kitchen.jpg");//Creates the icon for the kitchen
       ImageIcon refrigerator = new ImageIcon("refrigerator.jpg");//Creates the icon for the refrigerator
       ImageIcon soulfood = new ImageIcon("soulfood.jpg");//Creates the icon for the soul food
       ImageIcon cabinet = new ImageIcon("cabinet.jpg");//Creates the icon for the cabinet
       ImageIcon flyingdishes = new ImageIcon("dishes.jpg");//Creates the icon for the flying dishes
       
       String [] kitchenOptions = {"Peer into the Refrigerator", "Look in the Cabinet", "Move into the Pantry", "Back into the Elevator"};//Creates options for kitchen options
       
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", you have moved into the kitchen."
               + "\nPick an option below. "
               + "\nIf you dare.", "Kitchen", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, kitchen, kitchenOptions, kitchenOptions);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", as you open the refrigerator"
                       + "\na delicious smell wafts out.", "Kitchen", playerSelection, refrigerator);
               JOptionPane.showMessageDialog(null, "Inside the refrigerator you find"
                       + "\nSoul food, cooked by Sylvia Woods herself.", "Kitchen", playerSelection, soulfood);
               bookBag = bookBag.concat(soulFood);//Adds soul food to the book bag
               kitchen();
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", you approach the raggity"
                       + "\ncabinet and hear the sound of clanking.", "Kitchen", playerSelection, cabinet);
               JOptionPane.showMessageDialog(null, "As you pull the door open"
                       + "\ndishes start flying out. "
                       + "\nOne particularly ornate plate hits"
                       + "\nyou in the head and breaks. "
                       + "\nIn a daze you pick up a broken piece.", "Kitchen", playerSelection, flyingdishes);
               bookBag = bookBag.concat(brokenDish);//Adds the broken dish to the book bag
               kitchen();
           case 2:
               pantry();
           case 3:
               elevator();
       }
   
   }//ends the kitchen method
   public void pantry(){
       String Nimbus = " broom,";
       String recipe = " recipe,";
       
       ImageIcon pantry = new ImageIcon("pantry.jpg");//Creates the icon for the pantry
       ImageIcon dustyrecipebox = new ImageIcon("dustyrecipebox.jpg");//Creates the icon for the dusty recipe box
       ImageIcon broom = new ImageIcon("nimbus2000.jpg");//Creates the icon for the broom
       
       String [] optionsPantry = {"Look in the dusty recipe box", "Grab the broom", "Head back into the Kitchen"};//Creates options for pantry
       
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", you have moved into the pantry."
               + "\nWhat would you like to do?", "Pantry", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, pantry, optionsPantry, optionsPantry);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", inside the dusty recipe box"
                       + "\nyou find a recipe for chocolate devil's food cake, "
                       + "\na rare recipe made by Marco Pierre White", "Pantry", playerSelection, dustyrecipebox);
               bookBag = bookBag.concat(recipe);//Adds the recipe to the book bag
               pantry();
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", a nimbus 2000 lies before you"
                + "\nas you go to grab it, it flies "
                + "\ninto the air and straight into your bookbag", "Pantry", playerSelection, broom);
               bookBag = bookBag.concat(Nimbus);//Adds the broom to the book bag
               pantry();
           case 2:
               kitchen();
       }
   }//Ends the method for pantry
   
   public void dorothyBedroom(){
       Random r = new Random();
       String doll = " creepy doll,";
       int i;
       
       ImageIcon bedroomone = new ImageIcon("bedroomone.jpg");//Creates the icon for  the bedroom one
       ImageIcon rockingchair = new ImageIcon("rockingchair.jpg");//Creates the icon for the rocking chair
       ImageIcon creepydoll = new ImageIcon("creppydoll.jpg");//Creates the icon for the creepy doll
       ImageIcon DICE = new ImageIcon("3d12.jpg");//Creates an icon for the dice
              
       String [] bedroomOneOptions ={"Sit in the rocking chair", "Steal the creepy Doll", "Back into the elevator"};//Creates options for bedroom one options
        
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", Welcome to my little girl's room"
               + "\nPlease make sure to put all Toys back, and choose below.", "Dorothy's Bedroom", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bedroomone, bedroomOneOptions, bedroomOneOptions);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", as you sit in the rocking chair"
                       + "\nit slowly starts rocking back and forth"
                       + "\nas you start to doze off, you snap"
                       + "\nawake, remembering death is around the corner"
                       + "\nand as you come to, you realize you are now in"
                       + "\nthe children's bathroom.", "Dorothy's Bedroom", playerSelection, rockingchair);
               upperBathroom();
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", in the middle of the room"
                       + "\nyou find a creepy doll, so creepy it"
                       + "\nbrings you chills. But oddly enough"
                       + "\nyou want that doll.", "Dorothy's Bedroom", playerSelection, creepydoll);
               //A mini game using if statements and a for loop
               int GhostRoll = (1+ r.nextInt (12) + 1+ r.nextInt (12) + 1+ r.nextInt (12));
               int playerRoll = (1+ r.nextInt (12) + 1+ r.nextInt (12) + 1+ r.nextInt (12));
               
               if(bookBag.contains(dice)){
                   JOptionPane.showMessageDialog(null, playerName + ", as you reach for the doll a hand appears and says..", "Dorothy's Bedroom", playerSelection, creepydoll);
                   JOptionPane.showMessageDialog(null, playerName + ", bring out your die and lets begin", "Dorothy's Bedroom", playerSelection, DICE);
                   for(i = playerRoll; i > GhostRoll; ++i){
                       JOptionPane.showMessageDialog(null, playerName + ", a game of intense die insues, where each of you "
                               + "\nrolls your die and the higher number wins", dice, playerSelection, DICE);
                       JOptionPane.showMessageDialog(null, playerName + ", CONGRATS YOU HAVE BEATEN THE GHOST AND MAY KEEP THE DOLL"
                               + "\nThe Ghost Rolled: " + GhostRoll + "\nPLAYERNAME, rolled: " + playerRoll, "Dorothy's Bedroom", playerSelection, creepydoll);
                       bookBag = bookBag.concat(doll);
                       break;
                } 
                   for(i = playerRoll; i < GhostRoll; ++i){
                       JOptionPane.showMessageDialog(null, playerName + ", a game of intense die insues, where each of you "
                               + "\nrolls your die and the higher number wins", dice, playerSelection, DICE);
                       JOptionPane.showMessageDialog(null, playerName + ", CONGRATS YOU LOST AND THE GHOST TOOK THE DOLL"
                               + "\nThe Ghost Rolled: " + GhostRoll + "\n" + playerName + ", rolled: " + playerRoll, "Dorothy's Bedroom", playerSelection, DICE);
                       break;
                }    
                }else{
                   JOptionPane.showMessageDialog(null, playerName + ", as you reach for the doll a hand appears and says..", "Dorothy's Bedroom", playerSelection, creepydoll);
                   JOptionPane.showMessageDialog(null, playerName + ", you cannot play without dice", "Dorothy's Bedroom", playerSelection, creepydoll);
               
               }
               dorothyBedroom();
           case 2:
               elevator();
       }
   }//ends the method for Dorothy's bedroom
   
   public void upperBathroom(){
       String glass = " Glass,";
       String fingerNail = " Finger Nail,";
       
       ImageIcon bathroom = new ImageIcon("bathroom.jpg");//Creates the icon for the bathroom
       ImageIcon mirror = new ImageIcon("mirror.jpg");//Creates the icon for the mirror
       ImageIcon bloodymirror = new ImageIcon("bloodymary.jpg");//Creates the icon for the bloody mirror
       ImageIcon shower = new ImageIcon("shower.jpg");//Creates the icon for the shower
       ImageIcon steamyshower = new ImageIcon("steamyshower.jpg");//Creates the icon for the steamy shower
       ImageIcon creepysink = new ImageIcon("creepysink.jpg");//Creates the icon for the creepy sink
       
       String [] upperBathroomOptions = {"Peer into the mirror", "Step into the shower", "Turn on the Hot Water", "Turn on the Cold Water", "Back Into Elevator"};
//Creates options for the upstairs bathroom
       
       playerSelection = JOptionPane.showOptionDialog(null, playerName + ", you have moved into the"
               + "\nchildren's bathroom. Please refrain from touching"
               + "\ntheir toothbrushes.", "Upper Bathroom", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bathroom, upperBathroomOptions, upperBathroomOptions);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", as you peer into the mirror", "Upper Bathroom", playerSelection, mirror);
               JOptionPane.showMessageDialog(null, "The face of your past or future peers back."
                       + "\nbefore long you peer so hard,"
                       + "\na piece of the mirror falls off."
                       + "\n\nPlace it in your bag.", "Upper Bathroom", playerSelection, bloodymirror);
           bookBag = bookBag.concat(glass);//Adds the broken mirror to the book bag    
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", as you step into the shower", "Upper Bathroom", playerSelection, shower);
               JOptionPane.showMessageDialog(null, 
                       "the walls began to dew, the air "
                     + "\nsuddenly becomes heavy and"
                     + "\nbefore you know it, the room is "
                     + "\nfilled with steam. As you try "
                     + "\nto make your way out, you feel fingers "
                     + "\ntrwirling around the peach fuzz on the"
                     + "\nback of your neck and feel a slight prick."
                     + "\nAs you reach to the back of your neck,"
                     + "\nyou find an entire finger nail digging into your skin."
                     + "Place it in your bookbag.", "Upper Bathroom", playerSelection, steamyshower); 
               bookBag = bookBag.concat(fingerNail);//Adds the finger nail to the book bag
               upperBathroom();
           case 2:
               JOptionPane.showMessageDialog(null, playerName + ", after all these scares"
                       + "\nyou need some water. As you turn on the"
                       + "\nhot water the room vanishes and you"
                       + "\nreappear in Dorothy's Bedroom!", "Upper Bathroom", playerSelection, creepysink);
               dorothyBedroom();
           case 3:
               JOptionPane.showMessageDialog(null, playerName + ", after all these scares"
                       + "\nyou need some water. As you turn on the"
                       + "\ncold water the room vanishes and you"
                       + "\nreappear in Johnny's Bedroom!", "Upper Bathroom", playerSelection, creepysink);
               johnnyBedroom();     
           
           case 4:
               elevator();
       }
   }//ends the upper bathroom method
   
   public void johnnyBedroom(){
       String droppings = " Ghost Droppings,";
       
       ImageIcon bedroomtwo = new ImageIcon("bedroomtwo.jpg");//Creates the icon for the bedroom two
       ImageIcon dollhouse = new ImageIcon("dollhouse.jpg");//Creates the icon for the doll house
       ImageIcon dresser = new ImageIcon("dresser.jpg");//Creates the icon for the dresser
       ImageIcon ghostbedroom = new ImageIcon("moaningmyrtle.jpg");//Creates the icon for the moaning myrtle
       
       String [] bedroomTwoOptions = {"Look into the doll house", "Open the dresser", "Back into the elevator"};//Creates options for bedroom two options
       
        playerSelection = JOptionPane.showOptionDialog(null, playerName + ", welcome to my son's, Johnny, bedroom"
                + "\nPlease keep your undergarments on, the entire time.", "Johnny's Bedroom", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, bedroomtwo, bedroomTwoOptions, bedroomTwoOptions);
        switch(playerSelection){
            case 0:
                JOptionPane.showMessageDialog(null, playerName + ", as you move closer to"
                        + "\ninspect the doll house. The dolls start dancing."
                        + "\nThey dance so well that before you know it"
                        + "\n...lights out."
                        + "\n\nYou were hit on the head and wake up in the children's bathroom.", "Johnny's Bedroom", playerSelection, dollhouse);
                upperBathroom();
            case 1:
                JOptionPane.showMessageDialog(null, playerName + ", you creep closer to the dresser."
                        + "\nAnd with one powerful motion you "
                        + "\nwrench open the top draw to reveal...", "Johnny's Bedroom", playerSelection, dresser);
                JOptionPane.showMessageDialog(null, "A GH...GH...GHOST"
                        + "\nThe ghost leaves behind some..droppings."
                        + "\nPlease keep these in a safe place.", "Johnny's Bedroom", playerSelection, ghostbedroom);
                bookBag = bookBag.concat(droppings);//Adds the droppings to the book bag
                johnnyBedroom();
            case 2:
                elevator();
        }
   }//ends the method for johnny's bedroom
   
   public void masterBedroom(){
       Random r = new Random();
       String hopeDiamond = " Hope Diamond (theif),";
       
       ImageIcon masterbedroom = new ImageIcon("masterbedroom.jpg");//Creates the icon for the master bedroom
       ImageIcon jewerlybox = new ImageIcon("jewerlybox.jpg");//Creates the icon for the jewerly box
       ImageIcon hopediamond = new ImageIcon("hopediamond.jpg");//Creates the icon for the hope diamond
       ImageIcon creepypainting = new ImageIcon("creepypainting");//Cretaes an icon for the creepy painting on the wall
       ImageIcon safe = new ImageIcon("safe.jpg");//Creates the icon for the safe
       ImageIcon moneysafe = new ImageIcon("moneysafe.jpg");//Creates the icon for the money inside the safe
       
       int ghostFirstRoll = (1+ r.nextInt (30));
       int ghostSecondRoll = (1+ r.nextInt (30));
       int ghostThirdRoll = (1+ r.nextInt (30));
       
       int playerFirstRoll = (1+ r.nextInt (30));
       int playerSecondRoll = 1+ r.nextInt (30);
       int playerThirdRoll = 1+ r.nextInt (30);
                       
       
       String [] masterBedroomOptions = {"Look in the jewerly box", "Look behind painting on wall",
           "Move into the master bathroom","Back into the Elevator"};//Creates options for the master bedroom options
              
       playerSelection = JOptionPane.showOptionDialog(null, playerName + ", welcome to my bedroom."
               + "\nPlease stay as long as you like...please", "Master Bedroom", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, masterbedroom, masterBedroomOptions, masterBedroomOptions);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", you move closer to MY"
                       + "\njewerly box, which is very expensive and handcrafted.", "Master Bedroom", playerSelection, jewerlybox);
               JOptionPane.showMessageDialog(null, "As you open MY jewerly box,"
                       + "\nyou find the Cursed Hope Diamond and"
                       + "\nas you place it in your bookbag, a wave of"
                       + "\nbad feelings rush over you.", "Master Bedroom", playerSelection, hopediamond);
               bookBag = bookBag.concat(hopeDiamond);//Adds the hope diamond to the book bag
               masterBedroom();
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", as you reach for the painting, "
                       + "\nyou notice a red x, in the bottom right corner."
                       + "\nand you rip that painting off with glee", "Master Bedroom", leave, creepypainting);
               JOptionPane.showMessageDialog(null, "and you find none other than a safe."
                       + "\nIn the middle of the safe is giant hole."
                       + "\nI wonder what goes there.", "Master Bedroom", leave, safe);
               while(!bookBag.contains(" broom,")){
                   JOptionPane.showMessageDialog(null, playerName + ", you need to find something long and round", "Master Bedroom", leave, safe);
                   masterBedroom();
               }
               JOptionPane.showMessageDialog(null, playerName + ", try putting the nimbus 2000 in there.", "Master Bedroom", leave, safe);
               JOptionPane.showMessageDialog(null, playerName + ", THAT FIT, now you have to guess the numbers"
                       + "\nin order to open the safe.", "Master Bedroom", leave, safe);
               JOptionPane.showMessageDialog(null, playerName + ", you get three tries, and so does the safe"
                       + "\nIf all three are higher, the safe opens OTHERWISE "
                       + "\nYOU LOSE.", "Master Bedroom", leave, safe);
               JOptionPane.showMessageDialog(null, playerName + ", your roles are:"
                       + "\n" + playerFirstRoll 
                       + "\n" + playerSecondRoll  
                       + "\n" + playerThirdRoll, "Master Bedroom", leave, safe);
               JOptionPane.showMessageDialog(null, "The safe rolled:"
                       + "\n" + ghostFirstRoll 
                       + "\n" + ghostSecondRoll  
                       + "\n" + ghostThirdRoll, "Master Bedroom", leave, safe);
               if((playerFirstRoll > ghostFirstRoll)&& (playerSecondRoll > ghostSecondRoll) && (playerThirdRoll > ghostThirdRoll)){
                   int amountMoney = 1+ r.nextInt (1000);
                   
                   JOptionPane.showMessageDialog(null, "THE SAFE OPENS AND INSIDE IS "
                           + "\n$" + amountMoney, "Master Bedroom", leave, moneysafe);
                   JOptionPane.showMessageDialog(null, "Now spend this money wisely, "
                           + "\nespecially since you just stole it form me.", "Master Bedroom", leave, masterbedroom);
               masterBedroom();
               }else{
                   JOptionPane.showMessageDialog(null, playerName + ", HAHA you lost and a good thing"
                           + "\ntoo. I spent a fortune on that safe.", "Master Bedroom", leave, masterbedroom);
                    masterBedroom();
               
               }
           case 2:
               masterBathroom();
           case 3:
               elevator();
       }
   }//ends the method for the master bedroom
   
   public void masterBathroom(){
       String alladinGenie = " Alladin,";
       String hand = " an entire hand,";
       
       ImageIcon masterbathroom = new ImageIcon("masterbathroom.jpg");//Creates the icon for the master bathroom
       ImageIcon oillamp = new ImageIcon("oillamp.jpg");//Creates the icon for the oil lamp
       ImageIcon alladin = new ImageIcon("alladin.jpg");//Creates the icon for the alladin
       ImageIcon mastershower = new ImageIcon("mastershower.jpg");//Creates the icon for the master shower
       ImageIcon steamyshower = new ImageIcon("steamyshower.jpg");//Creates the icon for the steamy shower
           
       String [] masterBathroomOptions = {"Rub the intricate oil lamp", "Step into the shower", "Move back into the master bedroom"};//Creates options for the master bathroom options    
       
       playerSelection = JOptionPane.showOptionDialog(null, playerName + ", welcome to the Master Bathroom"
               + "\nor as I like to call it. My wife's paradise."
               + "\nchoose an activity.", "Master Bathroom", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, masterbathroom, masterBathroomOptions, masterBathroomOptions);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", as you rub the oil lamp"
                       + "\nwhisps of smoke start to pour out.", "Master Bathroom", playerSelection, oillamp);
               JOptionPane.showMessageDialog(null, "Before you lies, the great alladin."
                       + "\nHe asks you to place him in your bookbag,"
                       + "\nSo he can escape this Tower of Terror.", "Master Bathroom", playerSelection, alladin);
               bookBag = bookBag.concat(alladinGenie);//Adds the genie to the book bag
               masterBathroom();
           case 1:
               JOptionPane.showMessageDialog(null, playerName + ", as you step into the shower", "Master Bathroom", playerSelection, mastershower);
               JOptionPane.showMessageDialog(null, 
                       "the walls began to dew, the air "
                     + "\nsuddenly becomes heavy and"
                     + "\nbefore you know it, the room is "
                     + "\nfilled with steam. As you try "
                     + "\nto make your way out, you feel fingers "
                     + "\ntrwirling around the peach fuzz on the"
                     + "\nback of your neck and feel a slight prick."
                     + "\nAs you reach to the back of your neck,"
                     + "\nyou find an entire hand digging into your skin."
                     + "Place it in your bookbag.", "Upper Bathroom", playerSelection, steamyshower); 
               bookBag = bookBag.concat(hand);//Adds the hand to the book bag
               masterBathroom();
           case 2:
               masterBedroom();
       }
   }//ends the method for the master bathroom
   
   public void attic(){
       String masterKey = " Master Key,";
       
       ImageIcon creepyattic = new ImageIcon("creepyattic.jpg");
       ImageIcon atticchest = new ImageIcon ("atticchest.jpg");
       ImageIcon lockeddoor = new ImageIcon("lockeddoor.jpg");
       
       String [] atticOptions = {"Look into the chest", "Move back into the elevator"};
       
       while (!bookBag.contains(" Normal Key,")){
           JOptionPane.showMessageDialog(null, "You cannot enter the attic! It is Locked!"
                   + "\nYou must find the normal key to unlock this door!"
                   + "\nHint: It is in the basement", "Attic", leave, lockeddoor);
           
           elevator();
       }
       
       
       playerSelection = JOptionPane.showOptionDialog(null, playerName + ", YOU HAVE UNLOCKED THE DOOR WITH THE NORMAL KEY!"
               + "\nWELCOME TO THE ATTIC!!!"
               + "\nOR AS MY WIFE LIKES TO CALL IT"
               + "\nTHE DO-NOTHING ALL DAY ROOM.", "Attic", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, creepyattic, atticOptions, atticOptions);
       switch(playerSelection){
           case 0:
               JOptionPane.showMessageDialog(null, playerName + ", inside the chest"
                       + "\nyou find the master key to the front door."
                       + "\nyou can escape, or you can continue to explore.", "Attic", playerSelection, atticchest);
               bookBag = bookBag.concat(masterKey);//Adds the Master Key to the book bag
               this.leave = 2;
               attic();
           case 1:
               elevator();
       }
   
   }//ends the method for the attic

}//ends the class Floors
    