/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

import javax.servlet.http.HttpServletRequest;
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
import pl.marcinhawelka.bookswebstore.service.BookService;
import pl.marcinhawelka.bookswebstore.service.BuyOrderService;
import pl.marcinhawelka.bookswebstore.service.SessionOrderService;
import pl.marcinhawelka.bookswebstore.service.UserService;

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
    public String addBookToBuyModel(Model model, HttpServletRequest request, @RequestParam Long id) {
       
        Book book = bookService.findOne(id);
        BuyModel buyModel = sessionOrderService.getBuyModelInSession(request);
        buyOrderService.addBookToOrder(book, buyModel);
        model.addAttribute("buyModel", buyModel);
        return "redirect:cart";
    }

    @GetMapping("/delete")
    public String removeBookFromBuyModel(Model model, HttpServletRequest reuest, @RequestParam Long id) {

        Book book = bookService.findOne(id);
        BuyModel buyModel = sessionOrderService.getBuyModelInSession(reuest);
        buyOrderService.removeBookFromOrder(book, buyModel);
        model.addAttribute("buyModel", buyModel);
        return "redirect:cart";
    }

    @GetMapping("cart")
    public String getCart(Model model, HttpServletRequest request) {

        model.addAttribute("buyModel", sessionOrderService.getBuyModelInSession(request));
        return "order/buy/cart";
    }

    @PostMapping("cart")
    public String updateBuyModelAmount(Model model, HttpServletRequest request, @RequestParam("quantity") String[] amount) {  
            model.addAttribute("buyModel", sessionOrderService.getBuyModelInSession(request));
            String message = buyOrderService.updateAmountInOrder(amount, sessionOrderService.getBuyModelInSession(request));
            model.addAttribute("message",message);
            return "order/buy/cart";
    }
    
    @GetMapping("{username}/confirm")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DEALER') || principal.username == #username")
    public String confirmBuyOrder(Model model, HttpServletRequest request, @PathVariable String username) {

        model.addAttribute("user", userService.findByUsername(username));
        model.addAttribute("buyModel", sessionOrderService.getBuyModelInSession(request));
        return "order/buy/confirm";
    }

    @PostMapping("{username}/confirm")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_DEALER') || principal.username == #username")
    public String saveBuyOrder(Model model, HttpServletRequest request, @PathVariable String username) {
        User user = userService.findByUsername(username);
        BuyModel buyModel = sessionOrderService.getBuyModelInSession(request);
        buyOrderService.saveOrder(user, buyModel); 
        sessionOrderService.removeBuyModelInSession(request);
        return "order/buy/thanks";
    }

    @RequestMapping("/cancel")
    public String cancelBuyOrder(HttpServletRequest request) {

        sessionOrderService.removeBuyModelInSession(request);
        return "order/cancel";
    }
}
