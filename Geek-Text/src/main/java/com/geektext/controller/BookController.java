package com.geektext.controller;

import com.geektext.model.Books;
import com.geektext.service.BookService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController //Spring Annotation
@RequestMapping(path="/")//Spring Annotation, URI's (endpoints) start with shoppingcart
public class BookController {
    
    @Autowired //Spring annotation, Service calls Service which implements interface
    private BookService bookService;
    
    private Books book;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }//constructor
   
    @GetMapping("/books/sort/genre")
    public ResponseEntity<List<Books>> getBookGenre(@RequestBody Map<String, Object> request) {//RequestBody allows us to use Postman
        String genre = String.valueOf(request.get("genre").toString());
        return ResponseEntity.ok().body(bookService.getBookGenre(genre));
    }//Response Entity allows us to view the reponse via web page
    
    @GetMapping("/books/sort/units_sold")
    public ResponseEntity<List<Books>> getTopSellers(@RequestBody Map<String, Object> request){
        int limit = Integer.valueOf(request.get("limit").toString());
        return ResponseEntity.ok().body(bookService.getTopSellers(limit));
    }
    
    @GetMapping("/books/sort/rating")
    public ResponseEntity<List<Books>> getBookFromRating(@RequestBody Map<String, Object> request){
        Double rating = Double.valueOf(request.get("rating").toString());
        int limit = Integer.valueOf(request.get("limit").toString());
        return ResponseEntity.ok().body(bookService.getBookFromRating(rating, limit));
    }//    public void discountForPublisher(Long book_id, Long user_id);
    
    @PostMapping("/books/publisher_discount")
    public ResponseEntity<Double> discountForPublisher(@RequestBody Map<String, Object> request){
        Long book_id = Long.valueOf(request.get("book_id").toString());
        Double discount = Double.valueOf(request.get("discount").toString());
        Double price = bookService.discountForPublisher(discount, book_id) ;
        return ResponseEntity.ok().body(price);
    }
        
}
