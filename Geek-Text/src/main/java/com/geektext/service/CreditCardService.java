//This interface defines methods for credit card-related operations.
package com.geektext.service;

import java.sql.Date;
import org.springframework.stereotype.Service;

@Service//Spring annotation,to indicate that it's a Spring Data Service.
public interface CreditCardService {
    
    //Method to add credit card information for a user to the database
    public void addCreditCard(Long user_id, String card_number, Date card_expiration, String card_cvv, String billing_address);
}
