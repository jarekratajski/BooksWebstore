/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Matuidi
 */
@Controller
public class SecurityController {

    @GetMapping("/loginSuccess")
    public String loginSuccess(Model model) {
        model.addAttribute("message", "Zostales zalogowany pomyslnie");
        return "security/loginSuccess";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {

        if (error != null) {
            model.addAttribute("error", true);
        }
        return "/security/login";
    }

    @GetMapping("/denied")
    public String denied(Model model) {
        model.addAttribute("message", "Nie masz uprawnien do przegladania tej strony");
        return "security/denied";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            request.getSession().invalidate();
        }
        return "redirect:/";
    }
}
