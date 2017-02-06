/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinhawelka.bookswebstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.marcinhawelka.bookswebstore.entity.BuyOrder;

/**
 *
 * @author Matuidi
 */
@Repository
public interface BuyOrderDAO extends CrudRepository<BuyOrder, Long>{
    
    @Query("select b from BuyOrder b where user_id=?1")
    public List findAllUserOrders(Long userId);
    
}
