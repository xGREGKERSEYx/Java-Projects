//This interface defines methods for shopping cart-related operations.

package com.geektext.service;

import com.geektext.model.Books;
import com.geektext.model.ShoppingCart;
import java.util.List;
import org.springframework.stereotype.Service;

@Service//Spring annotation,to indicate that it's a Spring Data Service.
public interface CartService{
    
    //Method to retrieve the specified user's cart data
    public List<Books> getCartData(Long user_id);
    
    //Method to retrieve the specified user's cart data
    public List<ShoppingCart> getAllCartData();
    
    //Method to calculate the subtotal for the specified user's cart
    public Double getSubtotal(Long user_id);
    
    // ethod to add a book to the specified user's cart
    public void addBookToCart(Long book_id, Long user_id);
    
    //Method to remove a book from the specified user's cart
    public void removeBookFromCart(Long book_id, Long user_id);
}
