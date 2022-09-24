package com.mycompany.shoppingcart;

public class Items {
    private String name;
    private int price;
    
    public Items(String name, int price){
        this.name = name;
        this.price = price;
    }
    public Items(Items item){
        name = item.name;
        price = item.price;
    }
    
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setPrice(int newPrice){
        this.price = newPrice;
    }

    
    @Override
    public String toString(){
        return name + ": $" + price + " ";
    }
}
