package com.geektext.service;

import com.geektext.model.Books;
import com.geektext.model.ShoppingCart;
import com.geektext.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Spring annotation, implements service
public class CartServiceImplementation implements CartService {
    

    public List<ShoppingCart> shoppingCart; 

    @Autowired
    private DataSource dataSource; // Connection instance is injected

    public CartServiceImplementation(DataSource dataSource) {
         this.dataSource = dataSource;
    } // Creates the data source instance used to get a connection

    
    public CartServiceImplementation() {
         shoppingCart = new ArrayList<>();
    }//Creates the shoppingCart, no arguement

    
    @Override
    public List<ShoppingCart> getAllCartData() {
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cart_items");
            //Data comes in the form of tables
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ShoppingCart cart = new ShoppingCart();
                cart.setCart_item_id(rs.getLong("cart_item_id"));

                //In order to use properties of object we need to instantiate those objects
                User user = new User();
                user.setUser_id(rs.getLong("user_id"));
                cart.setUser_id(user);

                Books book = new Books();
                book.setBook_id(rs.getLong("book_id"));
                cart.setBook_id(book);


                cart.setQuantity(rs.getInt("quantity"));
                
                shoppingCart.add(cart);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shoppingCart;
    }//Retrieves all carts and associated data
    
    @Override
    public List<Books> getCartData(Long user_id) {
        List<Books> userBooks = new ArrayList<>();
        
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("""
                                                                 SELECT books.*
                                                                 
                                                                 FROM cart_items
                                                                 
                                                                 JOIN books ON cart_items.book_id = books.book_id
                                                                 
                                                                 WHERE cart_items.user_id = ?;""");
            
            
            stmt.setLong(1, user_id);// '?' allows us to insert a variable into an sql statement
            
            //Data comes in the form of tables
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Books book = new Books();
                book.setBook_id(rs.getLong("book_id"));
                book.setBook_title(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setUnits_sold(rs.getInt("units_sold"));
                book.setRating(rs.getDouble("rating"));
                book.setPublisher(rs.getString("publisher"));
                book.setDiscount(rs.getDouble("discount"));
                book.setOriginalPrice(rs.getDouble("original_price"));
                book.setOriginalPrice(rs.getDouble("discount_price"));
                

                userBooks.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userBooks;
    }//Retrieves specified user's data
    
    @Override
    public Double getSubtotal(Long user_id){
       Double sub_total = null;
       
       try (Connection connection = dataSource.getConnection()){
           PreparedStatement stmt = connection.prepareStatement(
                "SELECT SUM(\n" +
                "    CASE\n" +
                "        WHEN book.discount_price IS NOT NULL THEN book.discount_price * cart.quantity\n" +
                "        ELSE book.original_price * cart.quantity\n" +
                "    END\n" +
                ") AS sub_total\n" +
                "FROM cart_items cart\n" +
                "INNER JOIN books book ON cart.book_id = book.book_id\n" +
                "WHERE cart.user_id = ?;"
                        );
           stmt.setLong(1, user_id);// '?' allows us to insert a variable into an sql statement

  
            //Data comes in the form of tables
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sub_total = rs.getDouble("sub_total");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sub_total;
    }//Uses a PreparedStatement to run an sql query that returns sub_total
    
    @Override
    public void addBookToCart(Long book_id, Long user_id){
        try (Connection connection = dataSource.getConnection()){
           PreparedStatement stmt = connection.prepareStatement("""
                                                                INSERT INTO cart_items (user_id, book_id, quantity)
                                                                VALUES(?, ?, 1);""");
           stmt.setLong(1, user_id);
           stmt.setLong(2, book_id);
           stmt.executeUpdate();//Adds the statement to our db
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//Adds a book to the user's cart
    
    @Override
    public void removeBookFromCart(Long book_id, Long user_id){
        try (Connection connection = dataSource.getConnection()){
           PreparedStatement stmt = connection.prepareStatement("""
                                                                DELETE FROM cart_items WHERE book_id=? AND user_id=?""");
           stmt.setLong(1, user_id);// '?' allows us to insert a variable into an sql statement
           stmt.setLong(2, book_id);
           stmt.executeUpdate();//Adds the statement to our db
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//Removes a book to the user's cart
        
    }
    

