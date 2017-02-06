/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import javax.servlet.http.HttpServletRequest;
import pl.marcinhawelka.bookswebstore.model.BuyModel;

/**
 *
 * @author Matuidi
 */
public interface SessionOrderService {
    
     BuyModel getBuyModelInSession(HttpServletRequest request);
     
     void removeBuyModelInSession(HttpServletRequest request);
       
}
