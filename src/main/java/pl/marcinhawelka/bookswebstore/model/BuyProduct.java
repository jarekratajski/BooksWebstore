/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.model;

import java.math.BigDecimal;
import pl.marcinhawelka.bookswebstore.entity.Book;

/**
 *
 * @author Matuidi
 */
public class BuyProduct {
    
    private Book book;
    
    private Integer quantity;
    
    private BigDecimal bookTotalCost;
    
    public BuyProduct(){
        this.bookTotalCost = new BigDecimal(0);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.updateBookTotalCost();
    }

    public BigDecimal getBookTotalCost() {
        return bookTotalCost;
    }

    public void setBookTotalCost(BigDecimal bookTotalCost) {
        this.bookTotalCost = bookTotalCost;
    }
    
    public void updateBookTotalCost(){
        this.bookTotalCost = this.book.getPrice().multiply(new BigDecimal(this.quantity));
    }
    
}
