
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

@RestController //Spring Annotation
@RequestMapping(path="/card")//Spring Annotation, URI's (endpoints) start with shoppingcart
public class CardController {
    
    private CreditCardService creditCardService;
    
    private CreditCard creditCard;

    public CardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }
    
    @PostMapping("/add_card")
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
