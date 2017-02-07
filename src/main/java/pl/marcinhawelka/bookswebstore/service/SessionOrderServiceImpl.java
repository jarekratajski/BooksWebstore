/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import pl.marcinhawelka.bookswebstore.service.interfaces.SessionOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.marcinhawelka.bookswebstore.model.BuyModel;

/**
 *
 * @author Matuidi
 */
@Service("SessionOrderService")
public class SessionOrderServiceImpl implements SessionOrderService {

    @Autowired
    private BuyModel buyModel;
    
    @Override
    public BuyModel getBuyModelInSession() {
        return buyModel;
    }

    @Override
    public void removeBuyModelInSession() {   
        buyModel.clearProductsList();
    }

}
