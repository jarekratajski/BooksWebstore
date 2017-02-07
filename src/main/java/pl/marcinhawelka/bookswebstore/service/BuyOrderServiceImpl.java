/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;
import pl.marcinhawelka.bookswebstore.service.interfaces.UserService;
import pl.marcinhawelka.bookswebstore.service.interfaces.BuyOrderService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.BuyOrder;
import pl.marcinhawelka.bookswebstore.entity.User;
import pl.marcinhawelka.bookswebstore.model.BuyModel;
import pl.marcinhawelka.bookswebstore.model.BuyProduct;
import pl.marcinhawelka.bookswebstore.repository.BuyOrderDAO;

/**
 *
 * @author Matuidi
 */
@Service("BuyOrderService")
@Transactional
public class BuyOrderServiceImpl implements BuyOrderService {

    @Autowired
    private BuyOrderDAO buyOrderDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;
    
    @Override
    public void addBuyOrder(BuyOrder buyOrder) {
        buyOrderDAO.save(buyOrder);
    }

    @Override
    public void updateBuyOrder(BuyOrder buyOrder) {
        BuyOrder b = buyOrderDAO.findOne(buyOrder.getId());

        b.setBuyTotalCost(buyOrder.getBuyTotalCost());
        b.setDateCreated(buyOrder.getDateCreated());
        b.setId(buyOrder.getId());
        b.setUser(buyOrder.getUser());

        buyOrderDAO.save(b);
    }

    @Override
    public void deleteBuyOrder(Long id) {
        buyOrderDAO.delete(id);
    }

    @Override
    public BuyOrder findById(Long id) {
        return buyOrderDAO.findOne(id);
    }

    @Override
    public List<BuyOrder> findAll() {
        return (List<BuyOrder>) buyOrderDAO.findAll();
    }

    @Override
    public List getUserOrders(User user) {
        return buyOrderDAO.findAllUserOrders(user.getId());
    }

    @Override
    public void addBookToOrder(Book book, BuyModel buyModel) {
        BuyProduct buyProduct = new BuyProduct();
        buyProduct.setBook(book);
        buyProduct.setQuantity(1);
        Book booksQuantity = bookService.findOne(buyProduct.getBook().getId());
        buyModel.addProductToModel(buyProduct, booksQuantity.getQuantity());
    }

    @Override
    public void removeBookFromOrder(Book book, BuyModel buyModel) {
        buyModel.deleteProductFromModel(book);
    }

    @Override
    public void updateAmountInOrder(List<Integer> amount, BuyModel buyModel) {
         Book book;
         int i = 0;
        for (BuyProduct product : buyModel.getProducts()) {
            book = bookService.findOne(product.getBook().getId());
            
            if(book.getQuantity() - amount.get(i)<0){
                product.setQuantity(book.getQuantity());
                buyModel.updateTotalCost();
                throw new IllegalArgumentException(String.format("Maksymalna liczba ksiazki %s wynosi: %d",product.getBook().getTitle(),product.getBook().getQuantity()));
            }
            i++;
        }
        buyModel.updateQuantity(amount);
    }

    @Override
    public void saveOrder(User user, BuyModel buyModel) {
        user.setOrdersAmount(user.getOrdersAmount() + 1);
        userService.updateUser(user);
        for(BuyProduct product : buyModel.getProducts()){
            Book book = bookService.findOne(product.getBook().getId());
            book.setQuantity(book.getQuantity()-product.getQuantity());
            bookService.updateQuantity(book);
        }
        BuyOrder buyOrder = new BuyOrder();

        buyOrder.setBuyTotalCost(buyModel.getBuyTotalCost());
        buyOrder.setUser(user);
        buyOrder.setDateCreated(new Date());

        buyOrderDAO.save(buyOrder);
    }

}
