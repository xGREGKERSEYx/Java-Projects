//This interface defines methods for book-related operations.

package com.geektext.service;

import com.geektext.model.Books;
import java.util.List;
import org.springframework.stereotype.Service;

@Service//Spring annotation,to indicate that it's a Spring Data Service.
public interface BookService {
    
    //Method to retrieve books based on a specified genre
    public List<Books> getBookGenre(String genre);
    
    //Method to retrieve top-selling books with a specified limit
    public List<Books> getTopSellers(int limit);
    
    //Method to retrieve books based on a specified rating and limit   
    public List<Books> getBookFromRating(Double rating, int limit);
    
    // Method to apply a discount for a publisher on a specified book    
    public Double discountForPublisher(Double discount, Long book_id);
    
}
