/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Matuidi
 */
@Entity
@Table(name = "buy_orders")
public class BuyOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "buy_total_cost")
    private BigDecimal buyTotalCost;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "data_created")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated;

    public BuyOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBuyTotalCost() {
        return buyTotalCost;
    }

    public void setBuyTotalCost(BigDecimal buyTotalCost) {
        this.buyTotalCost = buyTotalCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "BuyOrder{" + "id=" + id + ", buyTotalCost=" + buyTotalCost + ", user=" + user + ", dateCreated=" + dateCreated + '}';
    }

}
