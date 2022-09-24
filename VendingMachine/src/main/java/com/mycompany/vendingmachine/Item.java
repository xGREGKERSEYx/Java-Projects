package com.mycompany.vendingmachine;


public class Item {
    private String name;
    private double price;
    private int quantity;
    
    public Item(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    Item(Item item){
        name = item.name;
        price = item.price;
        quantity = item.quantity;
    }//copy constructor
    
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    
    @Override
    public String toString(){
        return this.name + ": " + this.price  + " (" + this.quantity + ") ";
    }
}
