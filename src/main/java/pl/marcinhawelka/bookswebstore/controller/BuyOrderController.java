/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.marcinhawelka.bookswebstore.entity.Book;
import pl.marcinhawelka.bookswebstore.entity.User;
import pl.marcinhawelka.bookswebstore.model.BuyModel;
import pl.marcinhawelka.bookswebstore.service.interfaces.BookService;
import pl.marcinhawelka.bookswebstore.service.interfaces.BuyOrderService;
import pl.marcinhawelka.bookswebstore.service.interfaces.SessionOrderService;
import pl.marcinhawelka.bookswebstore.service.interfaces.UserService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/order/buy")
public class BuyOrderController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private BuyOrderService buyOrderService;

    @Autowired
    private SessionOrderService sessionOrderService;

    @GetMapping("/{username}/list")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DEALER') || principal.username == #username")
    public String listUserBuyOrders(Model model, @PathVariable("username") String username) {

        User user = userService.findByUsername(username);
        model.addAttribute("orders", buyOrderService.getUserOrders(user));
        return "order/buy/list";
    }

    @GetMapping("add")
    public String addBookToBuyModel(Model model, @RequestParam Long id) {

        Book book = bookService.findOne(id);
        BuyModel buyModel = sessionOrderService.getBuyModelInSession();
        buyOrderService.addBookToOrder(book, buyModel);
        model.addAttribute("buyModel", buyModel);
        return "redirect:cart";
    }

    @GetMapping("/delete")
    public String removeBookFromBuyModel(Model model, @RequestParam Long id) {

        Book book = bookService.findOne(id);
        BuyModel buyModel = sessionOrderService.getBuyModelInSession();
        buyOrderService.removeBookFromOrder(book, buyModel);
        model.addAttribute("buyModel", buyModel);
        return "redirect:cart";
    }

    @GetMapping("cart")
    public String getCart(Model model) {

        model.addAttribute("buyModel", sessionOrderService.getBuyModelInSession());
        return "order/buy/cart";
    }

    @PostMapping("cart")
    public String updateBuyModelAmount(Model model, @RequestParam("quantity") String[] stringAmounts) {
        model.addAttribute("buyModel", sessionOrderService.getBuyModelInSession());
        List<Integer> amounts = new ArrayList<>();
        for (String stringAmount : stringAmounts) {
            amounts.add(Integer.parseInt(stringAmount));
        }
        try {
            buyOrderService.updateAmountInOrder(amounts, sessionOrderService.getBuyModelInSession());
        } catch (IllegalArgumentException e) {
            e.printStackTrace(System.out);
            model.addAttribute("message", "Brak wymaganej liczby ksiązek na magazynie");
        }
        return "order/buy/cart";
    }

    @GetMapping("{username}/confirm")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DEALER') || principal.username == #username")
    public String confirmBuyOrder(Model model, @PathVariable String username) {

        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("buyModel", sessionOrderService.getBuyModelInSession());
        return "order/buy/confirm";
    }

    @PostMapping("{username}/confirm")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DEALER') || principal.username == #username")
    public String saveBuyOrder(Model model, @PathVariable String username) {
        User user = userService.findByUsername(username);
        BuyModel buyModel = sessionOrderService.getBuyModelInSession();
        buyOrderService.saveOrder(user, buyModel);
        sessionOrderService.removeBuyModelInSession();
        return "order/buy/thanks";
    }

    @RequestMapping("/cancel")
    public String cancelBuyOrder() {

        sessionOrderService.removeBuyModelInSession();
        return "order/cancel";
    }
}
