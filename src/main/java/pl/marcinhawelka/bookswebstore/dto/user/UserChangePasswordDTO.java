/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.dto.user;

import org.hibernate.validator.constraints.NotBlank;
import pl.marcinhawelka.bookswebstore.annotation.PasswordMatchesChangePassord;

/**
 *
 * @author Matuidi
 */

@PasswordMatchesChangePassord
public class UserChangePasswordDTO {

    @NotBlank
    private String password;

    @NotBlank
    private String passwordRepeat;


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

    @Override
    public String toString() {
        return "UserChangePasswordDTO{" + "password=" + password + ", passwordRepeat=" + passwordRepeat + '}';
    }

   

   

}
