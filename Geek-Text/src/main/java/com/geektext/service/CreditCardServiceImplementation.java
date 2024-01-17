
package com.geektext.service;

import com.geektext.model.CreditCard;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//Spring annotation, indicates it's a service
public class CreditCardServiceImplementation implements CreditCardService{
    public List<CreditCard> creditCard;
    
    @Autowired
    private DataSource dataSource;//Connection instance is called

    public CreditCardServiceImplementation(DataSource dataSource) {
        this.dataSource = dataSource;
    }//Constructor with DataSource dependency injection

    public CreditCardServiceImplementation() {
        creditCard = new ArrayList<>();
    }//Constructor without arguments, initializes the creditCard
    
    @Override
    public void addCreditCard(Long user_id, String card_number, Date card_expiration, String card_cvv, String billing_address) {
         try (Connection connection = dataSource.getConnection()){
                PreparedStatement stmt = connection.prepareStatement("""
                                                                INSERT INTO credit_card (card_number, card_expiration, card_cvv, billing_address)
                                                                VALUES(?, ?, ?, ?);""", Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, card_number);
                stmt.setDate(2, card_expiration);
                stmt.setString(3, card_cvv);
                stmt.setString(4, billing_address);     

                stmt.executeUpdate();
                
                  // Retrieve the generated card_id
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            Long card_id = null;
            if (generatedKeys.next()) {
                card_id = generatedKeys.getLong(1);
            }

            // Update the user table with the card_id
            if (card_id != null) {
                PreparedStatement userStmt = connection.prepareStatement("""
                                                                        UPDATE users
                                                                        SET card_id = ?
                                                                        WHERE user_id = ?;""");
                userStmt.setLong(1, card_id);
                userStmt.setLong(2, user_id);
                userStmt.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//Method to add a credit card by user id (given card information) using PreparedStatement
}