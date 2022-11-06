package com.mycompany.reservationapp;

import java.util.Arrays;
import java.util.Random;

public class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private int seatNumber;
    private String [] passport;
    Random r = new Random();
    
    public Person(String name, String nationality, String dateOfBirth, int seatNumber){
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.seatNumber = seatNumber;
        this.passport = new String [3];
        
    }
    public Person(Person person){
        name = person.name;
        nationality = person.nationality;
        dateOfBirth = person.dateOfBirth;
        seatNumber = person.seatNumber;
        passport = Arrays.copyOf(person.passport, person.passport.length);
    }//Copy constructors allow us to create new objects and copy every value from the source; this prevents us from creating an object that references the same object
    
    public String getName(){
        return this.name;
    }
    public String getNationality(){
        return this.nationality;
    }
    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
    public int getSeatNumber(){
        return this.seatNumber;
    }
    public String [] getPassport(){
        return Arrays.copyOf(this.passport, this.passport.length);
    }//returns a copy of the passport array with the same length
    
    
    public void setName(String newName){
        this.name = newName;
    }
    public void setNationality(String newNationality){
        this.nationality = newNationality;
    }
    public void setDateOfBirth(String newDateOfBirth){
        this.dateOfBirth = newDateOfBirth;
    }
    public void setSeatNumber(int newSeatNumber){
        this.seatNumber = newSeatNumber;
    }
    public void setPassport(){
        this.passport = new String [] {this.name, this.nationality, this.dateOfBirth};
    }
    
    @Override
    public String toString(){
        return "Name: " + this.name
                + "\nNationality: " + this.nationality 
                + "\nDate of Birth: " + this.dateOfBirth
                + "\nSeat Number: " + this.seatNumber
                + "\nPassport " + Arrays.toString(this.passport) + "\n";
    }
    public boolean applyPassport(){
        return r.nextBoolean();        
    }
      public void chooseSeat() {
        this.seatNumber = (int) (Math.random() * 11 + 1); 
    }
    
    
    
    
    
}
