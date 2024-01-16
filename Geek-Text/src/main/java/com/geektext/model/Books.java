package com.geektext.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "books")
public class Books {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    
    @Column(name = "book_name")
    private String book_title;

    @Column
    private String author;

    @Column
    private String genre;
    
    @Column
    private int units_sold;
    
    @Column
    private Double rating;
    
    @Column
    private String publisher;
    
    @Column
    private Double discount;
    
    @Column
    private Double original_price; 
    
    @Column
    private Double discount_price; 
    

    public Books(Long book_id, String book_title, String author, String genre, int units_sold, Double rating, String publisher, Double discount, Double original_price, Double discount_price) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.genre = genre;
        this.units_sold = units_sold;
        this.rating = rating;
        this.publisher = publisher;
        this.discount = discount;
        this.original_price = original_price;
        this.discount_price = discount_price;
        
    }

    public Books() {
        
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getUnits_sold() {
        return units_sold;
    }

    public void setUnits_sold(int units_sold) {
        this.units_sold = units_sold;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getOriginalPrice() {
        return original_price;
    }

    public void setOriginalPrice(Double original_price) {
        this.original_price = original_price;
    }

    public Double getDiscountPrice() {
        return discount_price;
    }

    public void setDiscountPrice(Double discount_price) {
        this.discount_price = discount_price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Books{");
        sb.append("book_id=").append(book_id);
        sb.append(", book_title=").append(book_title);
        sb.append(", author=").append(author);
        sb.append(", genre=").append(genre);
        sb.append(", units_sold=").append(units_sold);
        sb.append(", rating=").append(rating);
        sb.append(", publisher=").append(publisher);
        sb.append(", discount=").append(discount);
        sb.append(", originalPrice=").append(original_price);
        sb.append(", discountPrice=").append(discount_price);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}