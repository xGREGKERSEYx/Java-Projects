package com.mycompany.shoppingcart;

public class Item {
    private String name;
    private double  price;
    
    public Item(String name, double price){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (price < 0 ){
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        
        this.name = name;
        this.price = price;
    }
    public Item(Item item){
        name = item.name;
        price = item.price;
    }//copy constructor in case we need to create copies of an object
    
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public void setName(String newName){
        if (newName == null || newName.isBlank()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
         
        this.name = newName;
    }
    public void setPrice(int newPrice){
        if (newPrice < 0 ){
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
        this.price = newPrice;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;            
        }
        if (!(obj instanceof Item)) {
            return false;            
        }
        
        Item item = (Item)obj;
        return this.name.equals(item.name) && this.price == item.price;
        
       
       
    }//end of equals method

    
    @Override
    public String toString(){
        return name + ": $" + price + " ";
    }
}
