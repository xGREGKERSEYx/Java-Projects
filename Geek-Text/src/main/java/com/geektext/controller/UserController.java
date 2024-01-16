package com.geektext.controller;

import com.geektext.model.User;
import com.geektext.service.UserService;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Spring Annotation
@RequestMapping(path="/user")
public class UserController {
    
    private UserService userService;
    
    private User user;

    public UserController(UserService userService) {
        this.userService = userService;
    }
       
    @PostMapping("/add_user")
    public ResponseEntity addUser(@RequestBody Map<String, Object> request){
        String username = String.valueOf(request.get("username").toString());
        String password = String.valueOf(request.get("password").toString());
        String email = String.valueOf(request.get("email").toString());
        String mailingAddress = String.valueOf(request.get("mailing_address").toString());
        
        userService.addUser(username, password, email, mailingAddress);
        
        return ResponseEntity.ok("Added user");
    }
    
    @GetMapping("/user_info")
     public ResponseEntity retrieveUserData(@RequestBody Map<String, Object> request){
        String username = String.valueOf(request.get("username").toString());
        return ResponseEntity.ok(userService.retrieveUserData(username));
        
    }
    
    @PostMapping("/update_user")
    public ResponseEntity updateUserData(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        String username = String.valueOf(request.get("username").toString());
        String password = String.valueOf(request.get("password").toString());
        String email = String.valueOf(request.get("email").toString());
        String mailingAddress = String.valueOf(request.get("mailing_address").toString());
        
        userService.updateUserData(user_id, username, password, email, mailingAddress);
        
        return ResponseEntity.ok("Updated user");
    }
    
    @PostMapping("/add_card")
    public ResponseEntity addCreditCard(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        String card_number = String.valueOf(request.get("card_number").toString());
        Date card_expiration = Date.valueOf(request.get("card_expiration").toString());
        String card_cvv = String.valueOf(request.get("card_cvv").toString());
        String billing_address = String.valueOf(request.get("billing_address").toString());
        
        userService.addCreditCard(user_id, card_number, card_expiration, card_cvv, billing_address);
        
        return ResponseEntity.ok("Added card for user");
    }
    
}
