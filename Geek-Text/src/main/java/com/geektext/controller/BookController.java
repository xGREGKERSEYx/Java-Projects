// Controller receives HTTP requests and returns HTTP responses
// Annotations provided by Spring are used to define RESTful endpoints

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

@RestController //Spring Annotation indicating that this class is a REST controller
@RequestMapping(path="/")//Spring Annotation, specifying the base URI path for the controller
public class BookController {
    
    @Autowired //Spring annotation, injecting the BookService dependency
    private BookService bookService;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }//Constructor with BookService dependency injection
   
    @GetMapping("/books/sort/genre")//Endpoint for getting books sorted by genre
    public ResponseEntity<List<Books>> getBookGenre(@RequestBody Map<String, Object> request) {//RequestBody allows us to use Postman
        String genre = String.valueOf(request.get("genre").toString());//Extracting genre from the request
        return ResponseEntity.ok().body(bookService.getBookGenre(genre)); //Returning a ResponseEntity with the result from the BookService
    }//Response Entity allows us to view the reponse via web page
    
    // Endpoint for getting top sellers based on units sold
    @GetMapping("/books/sort/units_sold")
    public ResponseEntity<List<Books>> getTopSellers(@RequestBody Map<String, Object> request){
        int limit = Integer.valueOf(request.get("limit").toString());
        return ResponseEntity.ok().body(bookService.getTopSellers(limit));
    }//Extracts limit from request and returns ResponseEntity with topSellers via a list of books
    
    //Endpoint for getting books based on rating with a specified limit
    @GetMapping("/books/sort/rating")
    public ResponseEntity<List<Books>> getBookFromRating(@RequestBody Map<String, Object> request){
        Double rating = Double.valueOf(request.get("rating").toString());
        int limit = Integer.valueOf(request.get("limit").toString());
        return ResponseEntity.ok().body(bookService.getBookFromRating(rating, limit));
    }//Extracts rating and limit from request; then returns ResponseEntity with list of books
    
     // Endpoint for applying a discount for a publisher
    @PostMapping("/books/publisher_discount")
    public ResponseEntity<Double> discountForPublisher(@RequestBody Map<String, Object> request){
        Long book_id = Long.valueOf(request.get("book_id").toString());
        Double discount = Double.valueOf(request.get("discount").toString());
        Double price = bookService.discountForPublisher(discount, book_id) ;
        return ResponseEntity.ok().body(price);
    }//Extracts book_id and discount from request; then apply the discount through the BookService and return the updated price
        
}
