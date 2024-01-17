// Controller receives HTTP requests and returns HTTP responses
// Annotations provided by Spring are used to define RESTful endpoints

package com.geektext.controller;

import com.geektext.service.UserService;
import java.sql.Date;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Spring Annotation indicating that this class is a REST controller
@RequestMapping(path="/user") //Spring Annotation, specifying the base URI path for the controller
public class UserController {
    
    private UserService userService;//Service responsible for handling user-related operations
    
    public UserController(UserService userService) {
        this.userService = userService;
    }//Constructor with UserService dependency injection
       
    @PostMapping("/add_user")//Endpoint for adding a new user
    public ResponseEntity addUser(@RequestBody Map<String, Object> request){
        String username = String.valueOf(request.get("username").toString());
        String password = String.valueOf(request.get("password").toString());
        String email = String.valueOf(request.get("email").toString());
        String mailingAddress = String.valueOf(request.get("mailing_address").toString());
        //Extracting user information from the request
        
        userService.addUser(username, password, email, mailingAddress);
        //Calling the UserService to add a new user
        
        return ResponseEntity.ok("Added user");
    }//Extracts user information and returns ResponseEntity on success
    
    @GetMapping("/user_info")//Endpoint for retrieving user information
     public ResponseEntity retrieveUserData(@RequestBody Map<String, Object> request){
        String username = String.valueOf(request.get("username").toString());
        return ResponseEntity.ok(userService.retrieveUserData(username));
        
    }//Extracts username and returns user information using UserService
    
    @PostMapping("/update_user")//Endpoint for updating user data
    public ResponseEntity updateUserData(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        String username = String.valueOf(request.get("username").toString());
        String password = String.valueOf(request.get("password").toString());
        String email = String.valueOf(request.get("email").toString());
        String mailingAddress = String.valueOf(request.get("mailing_address").toString());
        
        userService.updateUserData(user_id, username, password, email, mailingAddress);
        //Calling the UserService to update user data
        
        return ResponseEntity.ok("Updated user");
    }//Extracts user information from request and updates user through UserService
    
//    @PostMapping("/add_card")//Endpoint for adding a credit card to a user's account
//    public ResponseEntity addCreditCard(@RequestBody Map<String, Object> request){
//        Long user_id = Long.valueOf(request.get("user_id").toString());
//        String card_number = String.valueOf(request.get("card_number").toString());
//        Date card_expiration = Date.valueOf(request.get("card_expiration").toString());
//        String card_cvv = String.valueOf(request.get("card_cvv").toString());
//        String billing_address = String.valueOf(request.get("billing_address").toString());
//        //Extracting credit card information from the request
//        
//        userService.addCreditCard(user_id, card_number, card_expiration, card_cvv, billing_address);
//        //Calling the UserService to add a credit card
//        
//        return ResponseEntity.ok("Added card for user");
//    }//Extracts credit card information and uses UserService to add the information
    
}
