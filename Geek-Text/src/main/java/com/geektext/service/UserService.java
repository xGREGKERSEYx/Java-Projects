package com.geektext.service;

import com.geektext.model.User;
import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    
    public void addUser(String username, String password, String email, String mailing_address);
    
    public List<User> retrieveUserData(String username);
    
    public void updateUserData(Long user_id, String username, String password, String email, String mailing_address);
    
    public void addCreditCard(Long user_id, String card_number, Date card_expiration, String card_cvv, String billing_address);
       
}
