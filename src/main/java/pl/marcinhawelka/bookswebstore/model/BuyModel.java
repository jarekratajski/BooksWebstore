/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.marcinhawelka.bookswebstore.entity.Book;

/**
 *
 * @author Matuidi
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BuyModel {

    private List<BuyProduct> products;

    private BigDecimal buyTotalCost;

    public BuyModel() {
        products = new LinkedList<>();
        buyTotalCost = BigDecimal.ZERO;
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
        boolean isProductContainsBuyModelProducts = false;
        for (BuyProduct bp : products) {
            if (bp.getBook().getTitle().equals(product.getBook().getTitle())) {
                if (product.getBook().getQuantity() >= bp.getQuantity() + 1) {
                    bp.setQuantity(bp.getQuantity() + 1);
                }
                isProductContainsBuyModelProducts = true;
            }
        }
        if (!isProductContainsBuyModelProducts) {
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

    public void updateQuantity(List<Integer> amounts) {
        int i = 0;
        for (BuyProduct product : products) {
            product.setQuantity(amounts.get(i));
            i++;
            if (product.getQuantity() == 0) {
                products.remove(product);
            }
        }
        updateTotalCost();
    }
    
    public void clearProductsList(){
        products.clear();
        updateTotalCost();
    }

    @Override
    public String toString() {
        return "BuyModel{" + "products=" + products + ", buyTotalCost=" + buyTotalCost + '}';
    }

}
