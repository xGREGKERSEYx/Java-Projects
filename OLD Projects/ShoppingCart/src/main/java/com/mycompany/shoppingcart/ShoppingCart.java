package com.mycompany.shoppingcart;

import java.util.ArrayList;// import the ArrayList class

public class ShoppingCart {
    ArrayList<Item> items = new ArrayList<>();
    
    public ShoppingCart(){
        this.items = new ArrayList<>();         
    }//Constructor, set thes feild equal to a new object of the ArrayList class
    
    public Item getItem(int index){
        return new Item(this.items.get(index));
    }//returns
    
    public void setItem(int index, Item item){
        this.items.set(index, new Item(item));        
    }
    
    
    
    public boolean add(Item item){
        if (this.items.contains(item)) {
            return false;            
        }//checks to see if this object is already in the cart
        this.items.add(new Item(item));
        return true;
    }
    
    
    
    public void remove(String name){
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot remove items from an empty cart");
        }
        
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals(name)){
                this.items.remove(i);
            }
            
        }
        
    }//removes an item matching the name passed in

    public String checkout(){
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot check out an empty cart");
        }
        
        double [] reciept = new double [3];
        
        for (int i = 0; i < this.items.size(); i++) {
            reciept[0] += this.items.get(i).getPrice();
        }//totals the cost of the items in the cart
        
        reciept[1] = reciept[0] * 0.13;
        reciept[2] = reciept[1] + reciept[0];
        
        return """
               \tRECEIPT
               
               \tSubtotal: $""" + reciept[0] + "\n" + "\tTax: $" + reciept[1] + "\n" + "\tTotal: $" + reciept[2] + "\n";
    
    }
    
    @Override
    public String toString(){
        String temp = "";
        
        for (int i = 0; i < this.items.size(); i++) {
            temp += this.items.get(i).toString();
            temp += "\n";
        }
        
        return temp;
    }
    
    
}//end Cart class
