
package com.mycompany.dealership;

public class Main {
     public static void main(String[] args) {
     
     Car[] cars = new Car[]{
         new Car("Focus", 12500, 2017, "Red", new String[] {"Jumper Cables", "Tire Jack"}),
         new Car("Fiat", 3000, 2013, "Blue", new String[] {"Filters", "Duck Tape"}),
         new Car("Tesla", 45000, 2022, "White", new String[] {"Jumper Cables", "Charging Cord"}),
         new Car("Fiat", 3000, 2013, "Blue", new String[] {"Filters", "Duck Tape"}),
         new Car("Tesla", 45000, 2022, "White", new String[] {"Jumper Cables", "Charging Cord"}),
     };
     
     Dealership dealership = new Dealership(cars);     
         for (int i = 0; i < cars.length; i++) {
             dealership.setCar(cars[i], i);
         }
   System.out.println(dealership);
         
         
         
         
         
         
         
         
         
         
     
     }//Main end
     
    
      
     
    
}
