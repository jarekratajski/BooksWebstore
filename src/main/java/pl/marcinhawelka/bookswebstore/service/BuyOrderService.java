/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import java.util.List;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.BuyOrder;
import pl.marcinhawelka.bookswebstore.entity.User;
import pl.marcinhawelka.bookswebstore.model.BuyModel;

/**
 *
 * @author Matuidi
 */
public interface BuyOrderService {

    void addBuyOrder(BuyOrder buyOrder);

    void updateBuyOrder(BuyOrder buyOrder);

    void deleteBuyOrder(Long id);

    BuyOrder findById(Long id);

    List<BuyOrder> findAll();

    List getUserOrders(User user);

    void addBookToOrder(Book book, BuyModel buyModel);

    void removeBookFromOrder(Book book, BuyModel buyModel);

    String updateAmountInOrder(String[] amount, BuyModel buyModel);

    void saveOrder(User user, BuyModel buyModel);

}
