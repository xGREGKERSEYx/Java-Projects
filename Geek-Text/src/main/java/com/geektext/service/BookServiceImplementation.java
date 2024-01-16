package com.geektext.service;

import com.geektext.model.Books;
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

@Service//Spring annotation, indicates it's a service
public class BookServiceImplementation implements BookService{
    
    public List<Books> bookList; 
    
    @Autowired
    private DataSource dataSource; //Connection instance is called

    
    public BookServiceImplementation(DataSource dataSource) {
        this.dataSource = dataSource;
    }//Constructor with DataSource dependency injection
    
    public BookServiceImplementation() {
        bookList = new ArrayList<>();
    }//Constructor without arguments, initializes the bookList
    
    @Override
    public List<Books> getBookGenre(String genre){
        List<Books> returnBooks = new ArrayList<>();
        
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement stmt = connection.prepareStatement("""
                                                                 SELECT *
                                                                 FROM books
                                                                 WHERE genre = ?;""");
            stmt.setString(1, genre);// '?' allows us to insert a variable into an sql statement
            
            
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
                book.setDiscount(rs.getDouble("original_price"));
                book.setDiscount(rs.getDouble("discount_price"));
                //Setting book attributes from the result set
    
                returnBooks.add(book);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(BookServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnBooks;
    }//Method to retrieve books by genre using PreparedStatement and ResultSet
    
    
    @Override
    public List<Books> getTopSellers(int limit) {
       List<Books> returnBooks = new ArrayList<>();
       try(Connection connection = dataSource.getConnection()){
           PreparedStatement stmt = connection.prepareStatement("""
                                                                SELECT *
                                                                FROM books
                                                                ORDER BY units_sold DESC
                                                                LIMIT ?;""");
           stmt.setInt(1, limit);
           
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
                Books book = new Books();
                book.setBook_id(rs.getLong("book_id"));
                book.setBook_title(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setUnits_sold(rs.getInt("units_sold"));
                book.setRating(rs.getDouble("rating"));
                book.setPublisher(rs.getString("publisher"));
                book.setDiscount(rs.getDouble("discount"));
                book.setDiscount(rs.getDouble("original_price"));
                book.setDiscount(rs.getDouble("discount_price"));
                //Setting book attributes from the result set
                returnBooks.add(book);
           } 
       } catch (SQLException ex) {
            Logger.getLogger(BookServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return returnBooks;
    } //Method to retrieve top sellers by units sold using PreparedStatement and ResultSet
    

    @Override
    public List<Books> getBookFromRating(Double rating, int limit) {
        List<Books> returnBooks = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
           PreparedStatement stmt = connection.prepareStatement("""
                                                                SELECT *
                                                                FROM books
                                                                WHERE rating >= ?
                                                                LIMIT ?;""");
           stmt.setDouble(1, rating);
           stmt.setInt(2, limit);
                      
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
                Books book = new Books();
                book.setBook_id(rs.getLong("book_id"));
                book.setBook_title(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setUnits_sold(rs.getInt("units_sold"));
                book.setRating(rs.getDouble("rating"));
                book.setPublisher(rs.getString("publisher"));
                book.setDiscount(rs.getDouble("discount"));
                book.setDiscount(rs.getDouble("original_price"));
                book.setDiscount(rs.getDouble("discount_price"));
                returnBooks.add(book);
           } 
       } catch (SQLException ex) {
            Logger.getLogger(BookServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return returnBooks;
    }//Method to retrieve books by rating and limit using PreparedStatement and ResultSet
   
    

    @Override
    public Double discountForPublisher(Double discount, Long book_id) {
        Double price = null;
        try (Connection connection = dataSource.getConnection()){
            
           //Update the discount and calculate the discounted price
           PreparedStatement stmt = connection.prepareStatement("""
                                                                UPDATE books
                                                                SET discount = ?, discount_price = original_price - (original_price * discount)
                                                                WHERE book_id = ?;""");
           stmt.setDouble(1, discount);// '?' allows us to insert a variable into an sql statement
           stmt.setLong(2, book_id);
           stmt.executeUpdate();//Adds the statement to our db
           
           //Retrieve the calculated price after the discount
           PreparedStatement selectStmt = connection.prepareStatement("""
                                                                        SELECT
                                                                            CASE
                                                                                WHEN book.discount_price IS NOT NULL THEN book.discount_price
                                                                                ELSE book.original_price
                                                                            END AS price
                                                                        FROM books book
                                                                        WHERE book_id = ?;
                                                                       """);
           selectStmt.setLong(1, book_id);   
           selectStmt.executeQuery();
           
           ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }//Method to apply a discount for a publisher and retrieve the discounted price
   
    
}


