/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.service.BookService;

/**
 *
 * @author Matuidi
 */
public class BuyModel {

    @Autowired
    private BookService bookService;

    private List<BuyProduct> products;

    private BigDecimal buyTotalCost;

    public BuyModel() {
        products = new LinkedList<>();
        buyTotalCost = new BigDecimal(0);
    }

    public List<BuyProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BuyProduct> products) {
        this.products = products;
    }

    public BigDecimal getBuyTotalCost() {
        return buyTotalCost;
    }

    public void setBuyTotalCost(BigDecimal buyTotalCost) {
        this.buyTotalCost = buyTotalCost;
    }

    public void addProductToModel(BuyProduct product, Integer booksQuantity) {
        boolean isContains = false;
        for (BuyProduct bp : products) {
            if (bp.getBook().getTitle().equals(product.getBook().getTitle())) {
                if (product.getBook().getQuantity() >= bp.getQuantity() + 1) {
                    bp.setQuantity(bp.getQuantity() + 1);
                }
                isContains = true;
            }
        }
        if (!isContains) {
            if (booksQuantity < product.getQuantity()) {
                product.setQuantity(0);
            }
            products.add(product);
        }
        updateTotalCost();
    }

    public void deleteProductFromModel(Book book) {
        for (BuyProduct product : products) {
            if (product.getBook().getTitle().equals(book.getTitle())) {
                products.remove(product);
            }
        }
        updateTotalCost();
    }

    public void updateTotalCost() {
        buyTotalCost = new BigDecimal(0);
        for (BuyProduct product : products) {
            buyTotalCost = buyTotalCost.add(product.getBookTotalCost());
        }
    }

    public void updateQuantity(String[] amount) {
        int i = 0;
        for (BuyProduct product : products) {
            product.setQuantity(Integer.parseInt(amount[i++]));
            if (product.getQuantity() == 0) {
                products.remove(product);
            }
        }
        updateTotalCost();
    }

    @Override
    public String toString() {
        return "BuyModel{" + "products=" + products + ", buyTotalCost=" + buyTotalCost + '}';
    }

}
