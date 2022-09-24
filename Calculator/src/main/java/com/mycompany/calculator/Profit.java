package com.mycompany.calculator;

public class Profit {
    private double costPrice, sellPrice;
    
    public Profit(double costPrice, double sellPrice){
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
    }
    public Profit(Profit sourceProfit){
        this.costPrice = sourceProfit.costPrice;
        this.sellPrice = sourceProfit.sellPrice;
    }
    
    public double getCostPrice(){
        return this.costPrice;
    }
    public double getSellPrice(){
        return this.sellPrice;
    }
    
    public void setCostPrice(double newCostPrice){
        this.costPrice = newCostPrice;
    }
    public void setSellPrice(double newSellPrice){
        this.sellPrice = newSellPrice;
    }
    
    public String calculateProfit(double costPrice, double sellPrice){
        double profit, profitPercentage = 0;
        
        profit = sellPrice - costPrice;
        profitPercentage = (profit/costPrice) * 100;
        
        return "Profit: " + profit + "\nProfit Percentage: " + profitPercentage;
        
    }//Calculates and returns profit
    public String calculateLoss(double costPrice, double sellPrice){
        double loss, lossPercentage = 0;
        
        loss = costPrice - sellPrice;
        lossPercentage = (loss / costPrice) * 100;
        
        return "Loss: " + loss + "\nLoss Percentage " + lossPercentage;
        
        
        
    }//Calculates and returns Loss
    
    
}
