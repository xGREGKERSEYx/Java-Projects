
/**
 *
 * @author grego
 */

import java.util.Random; 

public class MonsterAttributes {
    private String myMonsterType = "";
    private String myMonsterClothing = "";
    private String myMonsterEyeColor = "";
    private String myMonsterHeight = "";
    private String myMonsterWeapon = "";
    private int myMonsterSpeed = 0;
    private int myMonsterStrength = 0;
    
     Random r = new Random();
    
public MonsterAttributes(String monsterType, String monsterClothing, String monsterEyeColor, String monsterHeight, String monsterWeapon, int monsterSpeed, int monsterStrength){
    myMonsterType = monsterType;
    myMonsterClothing = monsterClothing;
    myMonsterEyeColor = monsterEyeColor;
    myMonsterHeight = monsterHeight;
    myMonsterWeapon = monsterWeapon;
    myMonsterSpeed = monsterSpeed;
    myMonsterStrength = monsterStrength;  
}//Constructor is declared and initialized 


//Getter (accessor) methods for the Monster object
public String getMonsterType(){
        return myMonsterType;
}
public String getMonsterClothing(){
        return myMonsterClothing;
}
public String getMonsterEyeColor(){
        return myMonsterEyeColor;
}
public String getMonsterHeight(){
        return myMonsterHeight;
}
public String getMonsterWeapon(){
        return myMonsterWeapon;
}
public int getMonsterSpeed(){
        return myMonsterSpeed;
}
public int getMonsterStrength(){
        return myMonsterStrength;
}

//Setter (mutator) methods for the Monster object
public String setMonsterType(String newMonsterType){
    return myMonsterType = newMonsterType;
}
public String setMonsterClothing(String newMonsterClothing){
    return myMonsterClothing = newMonsterClothing;
}
public String setMonsterEyeColor(String newMonsterEyeColor){
    return myMonsterEyeColor = newMonsterEyeColor;
}
public String setMonsterHeight(String newMonsterHeight){
    return myMonsterHeight = newMonsterHeight;
}
public String setMonsterWeapon(String newMonsterWeapon){
   return myMonsterWeapon = newMonsterWeapon;
}
public int setMonsterSpeed(int newMonsterSpeed){
    return myMonsterSpeed = newMonsterSpeed;
}
public int setMonsterStrength(int newMonsterStrength){
   return myMonsterStrength = newMonsterStrength;
}
public int changeSpeed(){
    if(myMonsterSpeed < 50){
       myMonsterSpeed = myMonsterSpeed + r.nextInt(5);
    }else{
        myMonsterSpeed = 50;//MAX speed is going to be 50
    }
    return myMonsterSpeed;
}
public int changeStrength(){
      
    if(myMonsterStrength < 50){
       myMonsterStrength += myMonsterStrength + r.nextInt(5);
    }else{
        myMonsterStrength = 50;//MAX strength is going to be 50
    }
    return myMonsterStrength;
}

}//Ends the public class


