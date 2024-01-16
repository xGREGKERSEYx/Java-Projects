//Controller receives HTTP requests and returns HTTP responses
//Annotations provided by Spring are used to define RESTful endpoints

package com.geektext.controller;

import com.geektext.model.CreditCard;
import com.geektext.model.User;
import com.geektext.service.CartService;
import com.geektext.service.CreditCardService;
import java.sql.Date;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Spring Annotation indicating that this class is a REST controller
@RequestMapping(path="/card")//Spring Annotation, specifying the base URI path for the controller
public class CardController {
    
    private CreditCardService creditCardService;

    public CardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }//Constructor with CreditCardService dependency injection
    
    @PostMapping("/add_card")//Endpoint for adding a credit card
    public ResponseEntity addCreditCard(@RequestBody Map<String, Object> request){
        Long user_id = Long.valueOf(request.get("user_id").toString());
        String card_number = String.valueOf(request.get("card_number").toString());
        Date card_expiration = Date.valueOf(request.get("card_expiration").toString());
        String card_cvv = String.valueOf(request.get("card_cvv").toString());
        String billing_address = String.valueOf(request.get("billing_address").toString());;
        
        creditCardService.addCreditCard(null, user_id, card_number, card_expiration, card_cvv, billing_address);
                
        return null;
    }
    
}
