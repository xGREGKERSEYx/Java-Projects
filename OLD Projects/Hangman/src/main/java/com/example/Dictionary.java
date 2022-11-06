package com.example;

import java.util.Random;


public class Dictionary {
    
    public static void randomWordHash(){
       //https://www.datamuse.com/api/        https://github.com/sjblair/Datamuse4J    http://sjblair.github.io/Datamuse4J/javadoc/
    
    }
    
     public static String randomWord(){
             String[] words = 
                {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
                "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
                "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
                "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
                "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
                "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
                "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
                "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
                "wombat", "zebra"};
            
            Random rand = new Random();//Creates a random object
            String word = words[rand.nextInt(62) - 1];//Chooses a random string from the array of words
            
            return word;
        }//Chooses a random word from the array of words
    
}
