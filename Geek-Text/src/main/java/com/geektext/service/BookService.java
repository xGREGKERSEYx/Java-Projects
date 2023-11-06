package com.geektext.service;

import com.geektext.model.Books;
import com.geektext.model.ShoppingCart;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BookService {
    
    public List<Books> getBookGenre(String genre);
    
    public List<Books> getTopSellers(int limit);
    
    public List<Books> getBookFromRating(Double rating, int limit);
        
    public Double discountForPublisher(Double discount, Long book_id);
    
}
