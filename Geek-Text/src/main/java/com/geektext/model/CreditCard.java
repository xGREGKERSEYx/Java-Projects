package com.geektext.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "credit_card")
public class CreditCard {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long card_id;
  
  @OneToOne  (fetch = FetchType.LAZY)//specifies how foreign key is mapped
  @JoinColumn(name = "user_id") //specifies name of foreign key and corresponding primary key
  private User user_id;

  private String card_number;
  private Date card_expiration;
  private String card_cvv;
  private String billing_address;

    public CreditCard(Long card_id, User user_id, String card_number, Date card_expiration, String card_cvv, String billing_address) {
        this.card_id = card_id;
        this.user_id = user_id;
        this.card_number = card_number;
        this.card_expiration = card_expiration;
        this.card_cvv = card_cvv;
        this.billing_address = billing_address;
    }

    public CreditCard() {
    }

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public String getCardNumber() {
        return card_number;
    }

    public void setCardNumber(String card_number) {
        this.card_number = card_number;
    }

    public Date getCardExpiration() {
        return card_expiration;
    }

    public void setCardExpiration(Date card_expiration) {
        this.card_expiration = card_expiration;
    }

    public String getCardCVV() {
        return card_cvv;
    }

    public void setCardCVV(String card_cvv) {
        this.card_cvv = card_cvv;
    }

    public String getBillingAddress() {
        return billing_address;
    }

    public void setBillingAddress(String billing_address) {
        this.billing_address = billing_address;
    }
    
  @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Credit Card{");
        sb.append(", card_id=").append(card_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", cardNumber=").append(card_number);
        sb.append(", cardExpiration=").append(card_expiration);
        sb.append(", cardCVV=").append(card_cvv);
        sb.append(", billingAddress=").append(billing_address);
        sb.append("}");
        return sb.toString();
    }
  
  
}
