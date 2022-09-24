package com.mycompany.vendingmachine;

import java.util.Arrays;


public class Machine {
    private Item[][] items;
    
    public Machine(Item[][] items){
        this.items = new Item[items.length][items[0].length];
        
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);  
        }
        }
    }
    Machine(Machine vendingMachine){
        items = vendingMachine.items;
    }
    public Item getItems(int row, int column){
        return new Item(this.items[row][column]);
    }
    public void setItems(Item newItem, int row, int column){
        this.items[row][column] = new Item(newItem);
    }
    public boolean dispense(int row, int column){
        if(items[row][column].getQuantity() > 0){
            items[row][column].setQuantity(items[row][column].getQuantity() - 1);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){     
        String temp = "";
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                temp += this.items[i][j].toString();
        }
            temp += "\n\n";
        }
        temp += "\t*******************************************";
        return temp;
    }
}
