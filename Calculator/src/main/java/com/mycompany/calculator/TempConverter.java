package com.mycompany.calculator;

public class TempConverter {
    private double temp;
    private int currentType, desiredType;
    
    public TempConverter(int currentType, int desiredType, double temp){
        this.currentType = currentType;
        this.desiredType = desiredType;
        this.temp = temp;
    }
    public TempConverter(TempConverter sourceTemp){
        this.currentType = sourceTemp.currentType;
        this.desiredType = sourceTemp.desiredType;
        this.temp = sourceTemp.temp;
        
    }
    
    public double getTemp(){
        return this.temp;
    }
    public int getCurrentType(){
        return this.currentType;
    }
    public int getDesiredType(){
        return this.desiredType;
    }
    
    public void setTemp(double newTemp){
        this.temp = newTemp;
    }
    public void setCurrentType(int newCurrentType){
        this.currentType = newCurrentType;
    }
    public void setDesiredType(int newDesiredType){
        this.desiredType = newDesiredType;
    }
    
    public String  conversionChoice(int desiredType){
        return switch (desiredType) {
            case 0 -> "Your new temperature is: " + toCelsius(temp, currentType) + " DEGREES";
            case 1 -> "Your new temperature is: " + toFahren(temp, currentType) + " DEGREES";
            case 2 -> "Your new temperature is: " + toKelvin(temp, currentType) + " KELVIN";
            default -> "invalid selection";
        };
    }
    
    public double toCelsius(double temp, int currentType){
        double tempC = 0;
        
        switch (currentType) {
            case 1 -> {
                tempC = (5.0/9.0) * (temp - 32);
                return tempC;
            }
            case 2 -> {
                tempC = temp - 273;
                return tempC;
            }
            default -> {
                return tempC;
            }
            
        }
        
        
    }//Converts from F or K into C
    public static double toFahren(double temp, int currentType){
        double tempF = 0;
        
        switch (currentType) {
            case 0 -> {
                tempF = ((9.0/5.0) * temp) + 32;
                return tempF;
            }
            case 2 -> {
                tempF = ((9.0/5.0)* (temp - 273) + 32);
                return tempF;
            }
            default -> {
                return tempF;
            }
        }
        
    }//Converts from C or K into F
    public static double toKelvin(double temp, int currentType){
        double tempK = 0;
        
        switch (currentType) {
            case 0 -> {
                tempK = temp + 273;
                return tempK;
            }
            case 1 -> {
                tempK = (((5.0/9.0) * (temp - 32)) + 273);
                return tempK;
            }
            default -> {
                return tempK;
            }
        }
        
    }//Converts C and F into K
    
    @Override
    public String toString(){
        return "Results: " + conversionChoice(desiredType);
    }
}
