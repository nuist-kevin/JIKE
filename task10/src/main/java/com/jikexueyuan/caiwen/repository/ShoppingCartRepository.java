package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author caiwen
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
