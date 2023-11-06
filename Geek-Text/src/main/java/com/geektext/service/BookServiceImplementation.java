/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

@Service //Spring annotation, implements service
public class BookServiceImplementation implements BookService{
    
    public List<Books> bookList; 
    
    @Autowired
    private DataSource dataSource; // Connection instance is called

    public BookServiceImplementation(DataSource dataSource) {
        this.dataSource = dataSource;
    }//Creates the data source instance used to get connection
     //was getting Consider defining a bean of type 'java.sql.Connection' 
     //in your configuration had to use data source
    
    public BookServiceImplementation() {
        bookList = new ArrayList<>();
    }
    
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
                book.setPrice(rs.getDouble("price"));
                book.setGenre(rs.getString("genre"));
                book.setUnits_sold(rs.getInt("units_sold"));
                book.setRating(rs.getDouble("rating"));
                book.setPublisher(rs.getString("publisher"));
                book.setDiscount(rs.getDouble("discount"));
    
                returnBooks.add(book);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(BookServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnBooks;
    }//Uses PreparedStatement and ResultSet to retrieve books by genre
    
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
                book.setPrice(rs.getDouble("price"));
                book.setGenre(rs.getString("genre"));
                book.setUnits_sold(rs.getInt("units_sold"));
                book.setRating(rs.getDouble("rating"));
                book.setPublisher(rs.getString("publisher"));
                book.setDiscount(rs.getDouble("discount"));
                returnBooks.add(book);
           } 
       } catch (SQLException ex) {
            Logger.getLogger(BookServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return returnBooks;
    }//Uses PreparedStatement and ResultSet to retrieve books by units sold

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
                book.setPrice(rs.getDouble("price"));
                book.setGenre(rs.getString("genre"));
                book.setUnits_sold(rs.getInt("units_sold"));
                book.setRating(rs.getDouble("rating"));
                book.setPublisher(rs.getString("publisher"));
                book.setDiscount(rs.getDouble("discount"));
                returnBooks.add(book);
           } 
       } catch (SQLException ex) {
            Logger.getLogger(BookServiceImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return returnBooks;
    }//Uses PreparedStatement and ResultSet to retrieve books by rating
    

    @Override
    public Double discountForPublisher(Double discount, Long book_id) {
        Double price = null;
        try (Connection connection = dataSource.getConnection()){
           PreparedStatement stmt = connection.prepareStatement("""
                                                                UPDATE books
                                                                SET discount = ?, price = price - (price * discount)
                                                                WHERE book_id = ?;""");
           stmt.setDouble(1, discount);// '?' allows us to insert a variable into an sql statement
           stmt.setLong(2, book_id);
           stmt.executeUpdate();//Adds the statement to our db
           
           ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CartServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
    
}


