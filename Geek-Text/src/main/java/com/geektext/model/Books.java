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
    private Double price; 
    
    @Column
    private String genre;
    
    @Column
    private int units_sold;
    
    @Column
    private Double rating;
    
    @Column
    private String publisher;
    
    
    @Column(nullable = false)
    private Double discount;

    public Books(Long book_id, String book_title, String author, Double price, String genre, int units_sold, Double rating, String publisher, Double discount) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.units_sold = units_sold;
        this.rating = rating;
        this.publisher = publisher;
        this.discount = discount;
    }

    public Books() {
        
    }

    public Long getBook_id() {
        return book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Books{");
        sb.append("book_id=").append(book_id);
        sb.append(", book_title=").append(book_title);
        sb.append(", author=").append(author);
        sb.append(", price=").append(price);
        sb.append(", genre=").append(genre);
        sb.append(", units_sold=").append(units_sold);
        sb.append(", rating=").append(rating);
        sb.append(", publisher=").append(publisher);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}