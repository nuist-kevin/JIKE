package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author caiwen
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
