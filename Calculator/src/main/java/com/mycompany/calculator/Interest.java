package com.mycompany.calculator;

public class Interest {
    private double principleAmount, rate, timeSpan;   
    
    public Interest(double principleAmount, double rate, double timeSpan){
        this.principleAmount = principleAmount;
        this.rate = rate; 
        this.timeSpan = timeSpan;
    }//Sets the constructor for the object
    public Interest(Interest sourceInterest){
        this.principleAmount = sourceInterest.principleAmount;
        this.rate = sourceInterest.rate;
        this.timeSpan = sourceInterest.timeSpan;
    }//copies the object
    
    public double getPrincipleAmount(){
        return this.principleAmount;
    }//Gets the principleAmount
    public double getRate(){
        return this.rate;
    }//Gets the rate
    public double getTimeSpan(){
        return this.timeSpan;
    }//Gets the timeSpan
    
    public void setPrincipleAmount(double newPrincipleAmount){
        this.principleAmount = newPrincipleAmount;
    }//Sets the principleAmount
    public void setRate(double newRate){
        this.rate = newRate;
    }//Sets the rate
    public void setTimeSpan(double newTimeSpan){
        this.timeSpan = newTimeSpan;
    }//Sets the timeSpan
    
    public double simpleInterest(double principleAmount, double rate, double timeSpan){
       double simpleInterest;
       
       simpleInterest = (principleAmount * rate * timeSpan) / 100;//Performs the equation to get the simple interest
       
       return simpleInterest;
        
        
    }//Performs the equation to get the simple interest
    public double compundInterest(double principleAmount, double rate, double timeSpan){
        double compoundInterest;
        
        compoundInterest = principleAmount * (Math.pow((1 + rate / 100), timeSpan));
        
        return compoundInterest;
        
    }
    
    @Override
    public String toString(){
        return "The calculated interest is: "
                + "\nSimple Interest: " + simpleInterest(this.principleAmount, this.rate, this.timeSpan)
                + "\nCompound Interest: " + compundInterest(this.principleAmount, this.rate, this.timeSpan);
    }
    
}
