package com.geektext.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// This annotation indicates that this class is mapped to a database table named "users"
@Entity
@Table(name = "users")
public class User {
     // Column mapping for each feild (e.g. "book_name") in the "books" table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column
    private String username;

    @Column
    private String email;
    
    @Column
    private String password;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user_id")    
    @JoinColumn(name = "card_id")
    private CreditCard card_id;
    
    @Column
    private String mailing_address;
    
    // Constructor with parameters to initialize the object with specific values
    public User(Long user_id, String username, String email, String password, CreditCard card_id, String mailing_address) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.card_id = card_id;
        this.mailing_address = mailing_address;
    }
    // Default constructor required by JPA
    public User() {
    }
    
    // Getter and Setter methods for each field
    public Long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
    public CreditCard getCard_id() {
        return card_id;
    }
    
    public String getMailingAddress() {
        return mailing_address;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setCard_id(CreditCard card_id) {
        this.card_id = card_id;
    }
     
    public void setMailingAddress(String mailing_address) {
        this.mailing_address = mailing_address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();// Build a string representation of the object
        sb.append("Users{");
        sb.append(", user_id=").append(user_id);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", card_id=").append(card_id);
        sb.append("}");
        return sb.toString();

    }// Override toString() method to provide a readable representation of the object
    

}
