package com.mycompany.vendingmachine;

import java.util.Scanner;


public class VendingMachine {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        
        System.out.println("\t*******************************************\n"
                + "        \t WELCOME TO JAVA DRINKS!\n"
                + "\t*******************************************");
        
        Item[][] items = new Item[][]{
            { new Item("Coca Cola", 1.99, 6), new Item("Slim Jims", .50, 6), new Item("Sour Patch Kids", .75, 6)},
            { new Item("M&Ms", 1.10, 6), new Item("Honey Buns", 1.50, 6), new Item("Gum", .75, 6)},
            { new Item("Dorito's", 1.99, 6), new Item("Thai Tea", 1.50, 6), new Item("Lychee", .75, 6)}
            
        };
        
        Machine machine = new Machine(items);
        System.out.println(machine);
        
        while(true){
            System.out.println("Pick a row: ");
            int row = scnr.nextInt();
            System.out.println("Pick a column: ");
            int column = scnr.nextInt();

           boolean dispensed =  machine.dispense(row, column);
            System.out.println("\n" + machine);
            
            if(dispensed == true){
                System.out.print("\nEnjoy your drink! Press 1 to purchase another: ");
            }else{
                System.out.print("\nSorry, we're out of this item. Press 1 to purchase another: ");
            }
            
            if(scnr.nextInt() != 1)
                break;
        }
                
        
        
        
    }//END OF MAIN
    
}//END OF CLASS
