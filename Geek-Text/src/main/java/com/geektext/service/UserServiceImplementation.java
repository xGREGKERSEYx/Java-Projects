
package com.geektext.service;

import com.geektext.model.Books;
import com.geektext.model.ShoppingCart;
import com.geektext.model.User;
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

@Service
public class UserServiceImplementation implements UserService{
    public List<User> users; 
    CreditCardServiceImplementation cc = new CreditCardServiceImplementation();

    @Autowired
    private DataSource dataSource; // Connection instance is injected

    public UserServiceImplementation(DataSource dataSource) {
         this.dataSource = dataSource;
    } // Creates the data source instance used to get a connection

    
    public UserServiceImplementation() {
         users = new ArrayList<>();
    }//Creates the shoppingCart, no arguement


    @Override
    public void addUser(String username, String password, String email, String mailing_address) {
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("""
                                                                 INSERT INTO users (username, password, email, mailing_address)
                                                                 VALUES(?, ?, ?, ?);""");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, mailing_address);
            
            
            stmt.executeUpdate();//Adds the statement to our db

         } catch (SQLException ex) {
             ex.printStackTrace();
             Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public List<User> retrieveUserData(String username) {
        List<User> returnUsers = new ArrayList<>();
        
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("""
                                                            SELECT *
                                                            FROM users
                                                            WHERE username = ?;""");
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();//Adds the statement to our db
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getLong("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setMailingAddress(rs.getString("mailing_address"));
                
                returnUsers.add(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return returnUsers;
    }

    @Override
    public void updateUserData(Long user_id, String username, String password, String email, String mailing_address) {
        try (Connection connection = dataSource.getConnection()){
                PreparedStatement stmt = connection.prepareStatement("""
                                                                UPDATE users
                                                                SET username = ?, password = ?, email = ?, mailing_address = ?
                                                                WHERE user_id = ?;""");
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.setString(3, email);
                stmt.setString(4, mailing_address);
                stmt.setLong(5, user_id);     

                stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }
    

    @Override
    public void addCreditCard(Long user_id, String card_number, Date card_expiration, String card_cvv, String billing_address) {
        try (Connection connection = dataSource.getConnection()){
                    PreparedStatement stmt = connection.prepareStatement("""
                                                                         INSERT INTO credit_card (user_id, card_number, card_expiration, card_cvv, billing_address)
                                                                         VALUES(?, ?, ?, ?, ?);""", Statement.RETURN_GENERATED_KEYS);
                    stmt.setLong(1, user_id);
                    stmt.setString(2, card_number);
                    stmt.setDate(3, card_expiration);
                    stmt.setString(4, card_cvv);
                    stmt.setString(5, billing_address);
                    
                    User user = new User();
                    user.setCard_id(stmt.getGeneratedKeys());

                    stmt.executeUpdate();//Adds the statement to our db

                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
                 }    
    }
    
}
