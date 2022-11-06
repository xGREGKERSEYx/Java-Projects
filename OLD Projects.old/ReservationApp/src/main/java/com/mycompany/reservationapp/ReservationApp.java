package com.mycompany.reservationapp;

public class ReservationApp {

    public static void main(String[] args) {
        
        
        
        System.out.println("""
                           \t*******************************************
                                   \t WELCOME TO JAVA AIRLINES!
                           \t*******************************************""");
        
        Person[] people = new Person[] {                                       
            new Person("Cleopatra", "Egypt", "69 BC", 1),                      
            new Person("Alexander the Great", "Macedon", "356 BC", 2),
            new Person("Julius Caesar", "Rome", "100 BC", 3),
            new Person("Hannibal", "Carthage", "247 BC", 4),                   
            new Person("Confucius", "China", "551 BC", 5),                     
            new Person("Pericles", "Greece", "429 BC", 6),                     
            new Person("Spartacus", "Thrace", "111 BC", 7),                    
            new Person("Marcus Aurelius", "Rome", "121 AD", 8),
            new Person("Leonidas", "Greece", "540 BC", 9),                     
            new Person("Sun Tzu", "China", "544 BC", 10),                      
            new Person("Hammurabi", "Babylon", "1750 BC", 11),
        };
        
        Airline airline = new Airline();         
        people[10].setSeatNumber(10);
        
        for (int i = 0; i < people.length; i++) {
            if(people[i].applyPassport() == true){
                people[i].setPassport();
                airline.createReservation(people[i]);
            }
           
            
        
        } 
        people[10].setSeatNumber(10);
        
        System.out.println(airline.toString());
        
        System.out.println("""
                           \t*******************************************
                                     THANK YOU FOR FLYING WITH JAVA AIRLINES!
                           \t*******************************************""");
        
                
                
    }//end of main
    
}
