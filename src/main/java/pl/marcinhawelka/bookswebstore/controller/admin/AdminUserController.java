/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.controller.admin;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marcinhawelka.bookswebstore.dto.user.UserEditDTO;
import pl.marcinhawelka.bookswebstore.service.interfaces.UserService;

/**
 *
 * @author Matuidi
 */
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }
    
    @GetMapping("edit/{username}")
    public String getEditPage(Model model, @PathVariable String username){
        model.addAttribute("user", userService.findByUsername(username));
        return "user/edit";
    }
    
    @PostMapping("edit/{username}")
    public String handleEditPage(@Valid @ModelAttribute("user") UserEditDTO userEditDTO, BindingResult result, @PathVariable("username") String username){
        if(result.hasErrors()){
            return "user/edit";
        }
        
       userService.updateUserDTO(userEditDTO, userService.findByUsername(username).getId());
       return "redirect:/user/" + username;
    }

}
