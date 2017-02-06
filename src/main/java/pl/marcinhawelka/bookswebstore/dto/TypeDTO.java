/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.dto;

import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Matuidi
 */
public class TypeDTO {

    private Long id;

    @NotBlank
    private String type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "TypeDTO{" + "id=" + id + ", type=" + type + ", book=" + '}';
    }
    
    
}
