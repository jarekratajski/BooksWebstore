/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.dto.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import pl.marcinhawelka.bookswebstore.annotation.PasswordMatches;

/**
 *
 * @author Matuidi
 */

@PasswordMatches
public class UserNewDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordRepeat;

    @NotBlank
    @Email
    private String email;
    
    private String role;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserNewDTO{" + "username=" + username + ", password=" + password + ", passwordRepeat=" + passwordRepeat + ", email=" + email + ", role=" + role + '}';
    }

    
 

   

}
