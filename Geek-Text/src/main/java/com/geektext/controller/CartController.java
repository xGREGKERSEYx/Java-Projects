//Controller receives HTTP requests and returns HTTP responses
//Annotations provided by Spring are used to define RESTful endpoints

package com.geektext.controller;

import com.geektext.model.Books;
import com.geektext.model.ShoppingCart;
import com.geektext.model.User;
import com.geektext.service.CartService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController //Spring Annotation indicating that this class is a REST controller
@RequestMapping(path="/cart")//Spring Annotation, specifying the base URI path for the controller
public class CartController {
    
    @Autowired //Spring annotation, injecting the CartService dependency
    private CartService cartService;    

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }//Constructor with CartService dependency injection
    
    @GetMapping("/cart_data")//Endpoint for retrieving all cart data
    public List<ShoppingCart> getCarts(){
        return cartService.getAllCartData();    
    }    
    
    @GetMapping("/subtotal")//Endpoint for calculating the subtotal of a user's cart
    public ResponseEntity<Double> getSubTotal(@RequestBody Map<String, Object> request) {//RequestBody allows us to use Postman
        Long user_id = Long.valueOf(request.get("user_id").toString());
        //Value is an Int in the DB, so we are parsing it into a Long value (foreign key)
        Double subtotal = cartService.getSubtotal(user_id);
        return ResponseEntity.ok().body(subtotal);//Response Entity allows us to view the reponse via web page
    }//Extracts user_id and returns sub_total of cart via ResponseEntity

    
    @PostMapping("/user/add")//Endpoint for adding a book to a user's cart
    public ResponseEntity addBookToCart(@RequestBody Map<String, Object> request){
         Long user_id = Long.valueOf(request.get("user_id").toString());
         Long book_id = Long.valueOf(request.get("book_id").toString());
         cartService.addBookToCart(user_id, book_id);
        
        return ResponseEntity.ok("ADDED");
    
    }//Adds a book to specified user's cart
    
    
    @GetMapping("/user")//Endpoint for retrieving a specified user's cart data
    public ResponseEntity<List<Books>> getUserCart(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        return ResponseEntity.ok(cartService.getCartData(user_id));
        
    }//retrieves the specified user's cart
    
    @DeleteMapping("/user/remove")// Endpoint for removing a book from a user's cart
    public ResponseEntity removeBookFromCart(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        Long book_id = Long.valueOf(request.get("book_id").toString());
        cartService.removeBookFromCart(book_id, user_id);
        
        return ResponseEntity.ok("REMOVED"); 
    }//extracts user_id and book_id and uses cartService to remove book from cart
    

}