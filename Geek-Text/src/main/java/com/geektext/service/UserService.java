//This interface defines methods for user-related operations.
package com.geektext.service;

import com.geektext.model.User;
import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service//Spring annotation,to indicate that it's a Spring Data Service.
public interface UserService {
    
    //Method to add a new user to the database
    public void addUser(String username, String password, String email, String mailing_address);
    
    //Method to retrieve user data based on the provided username
    public List<User> retrieveUserData(String username);
    
     //Method to update user data in the database
    public void updateUserData(Long user_id, String username, String password, String email, String mailing_address);
    
    //Method to add credit card information for a user to the database
    public void addCreditCard(Long user_id, String card_number, Date card_expiration, String card_cvv, String billing_address);
       
}
