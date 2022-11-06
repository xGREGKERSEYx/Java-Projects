
package com.mycompany.dealership;


public class Dealership {
    private Car [] cars;
    
    public Dealership(Car [] cars){
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);            
        }
    }
    
    public void setCar(Car car, int index){
        this.cars[index] = new Car(car);
    }//Sets the variable to a copy of the referenced object

    public Car getCar(int index){
        return new Car(this.cars[index]);
    }//Returns a copy of the object instead of refrencing the same object

    public void sell(int index){
        this.cars[index] = null;
        System.out.print("Thank you for your purchase");
    }
    public String searchCars(String make, int budget){
          for (int i = 0; i < cars.length; i++) {
            if (this.cars[i] == null) {
                continue;                
            }
            else if (this.cars[i].getMake().equals(make) && this.cars[i].getPrice() <= budget) {
                return "\nWe do have a car fitting that description, in spot " + i + "\n" + this.cars[i].toString();                             
            }
        }
          return "No cars matching that description";
    }
    @Override
    public String toString(){
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking spot: " + i + "\n";
            
            if (this.cars[i] == null) {
                temp += "Empty\n";              
            }else{
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }
        
     
        
    }

