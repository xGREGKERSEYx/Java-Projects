
package com.geektext.service;

import com.geektext.model.CreditCard;
import com.geektext.model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImplementation implements CreditCardService{
    public List<CreditCard> creditCard;
    
    @Autowired
    private DataSource dataSource;

    public CreditCardServiceImplementation(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public CreditCardServiceImplementation() {
        creditCard = new ArrayList<>();
    }
    
    @Override
    public void addCreditCard(Long user_id, String card_number, Date card_expiration, String card_cvv, String billing_address) {
         try (Connection connection = dataSource.getConnection()){
                PreparedStatement stmt = connection.prepareStatement("""
                                                                INSERT INTO credit_card (user_id, card_number, card_expiration, card_cvv, billing_address)
                                                                VALUES(null, ?, ?, ?, ?, ?);""");
                stmt.setLong(1, user_id);
                stmt.setString(2, card_number);
                stmt.setDate(3, card_expiration);
                stmt.setString(4, card_cvv);
                stmt.setString(5, billing_address);     

                stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
