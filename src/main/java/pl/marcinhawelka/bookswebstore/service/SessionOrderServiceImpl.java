/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import pl.marcinhawelka.bookswebstore.model.BuyModel;

/**
 *
 * @author Matuidi
 */
@Service("SessionOrderService")
public class SessionOrderServiceImpl implements SessionOrderService {

    @Override
    public BuyModel getBuyModelInSession(HttpServletRequest request) {
        BuyModel buyModel = (BuyModel) request.getSession().getAttribute("buyModel");
        if (buyModel == null) {
            buyModel = new BuyModel();
            request.getSession().setAttribute("buyModel", buyModel);
        }
        return buyModel;
    }

    @Override
    public void removeBuyModelInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("buyModel");
    }

}
