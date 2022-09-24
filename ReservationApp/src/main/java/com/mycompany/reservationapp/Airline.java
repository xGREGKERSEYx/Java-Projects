package com.mycompany.reservationapp;

public class Airline {
    private Person[] seats;
    
    public Airline(){
        this.seats = new Person[11];        
    }
    public Person getPerson(int seatNumber){
        return new Person(this.seats[seatNumber]);
    }
    public void setPerson(Person person){
        this.seats[person.getSeatNumber() - 1] = new Person(person);
    }
    public void createReservation(Person person){
        while(this.seats[person.getSeatNumber() - 1] != null){
            System.out.println("\n" + person.getName() + ", seat: "
                    + person.getSeatNumber() + " is already taken. Please choose another oner.\n");
            person.chooseSeat();
        }
        
        this.seats[person.getSeatNumber() - 1] = new Person(person);
        
        System.out.println("Thank you, " 
                + person.getName() + " for flying with Java Airlines. "
                + "Your seat number is " + person.getSeatNumber() + ".\n");   
    }
    
    @Override
    public String toString(){
        String temp = "";
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] != null){
                temp += seats[i].toString();
                temp += "\n\n";
            }else{
                 temp += "Seat " + (i+1) + " is empty.";
                 temp += "\n\n";
            }
            
        }
        
        return temp;
    }
    
}
