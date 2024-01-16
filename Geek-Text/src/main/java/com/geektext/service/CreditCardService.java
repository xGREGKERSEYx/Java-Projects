
package com.geektext.service;

import com.geektext.model.CreditCard;
import com.geektext.model.User;
import java.sql.Date;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardService {
    public void addCreditCard(Long user_id, String card_number, Date card_expiration, String card_cvv, String billing_address);
}
