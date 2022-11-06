package com.mycompany.dealership;

import java.util.Arrays;


public class Car {
    private String make;
    private double price;
    private int year;
    private String color;
    private String[] parts;
    
    public Car(String make, double price, int year, String color, String[] parts){
        this.make = make;
        this.price = price; 
        this.year = year;
        this.color = color;
        this.parts = Arrays.copyOf(parts, parts.length);
    
    }
     public Car(Car source){
        this.make = source.make;
        this.price = source.price; 
        this.year = source.year;
        this.color = source.color;
        this.parts = Arrays.copyOf(source.parts, source.parts.length);
    
    }
    
    public String getMake(){
        return make;
    }
    public double getPrice(){
        return price;
    }
    public int getYear(){
        return year;
    }
    public String getColor(){
        return color;
    }
    public String[] getParts(){
        return Arrays.copyOf(parts, parts.length);
    }
    
    public void setMake(String newMake){
        this.make = newMake;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    public void setYear(int newYear){
        this.year = newYear;
    }
    public void setColor(String newColor){
        this.color = newColor;
    }
    public void setParts(String [] newParts){
        this.parts = Arrays.copyOf(newParts, newParts.length);
    }
    
    @Override
    public String toString(){
        return "Make: " + this.make +
               "\nPrice: " + this.price +
               "\nYear: " + this.year + 
               "\nColor: " + this.color +
               "\nParts: " + Arrays.toString(parts)
                +"\n";
    }
}
