package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.entity.User;
import com.jikexueyuan.caiwen.repository.ShoppingCartRepository;
import com.jikexueyuan.caiwen.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService {

  @Resource
  private ShoppingCartRepository shoppingCartRepository;

  /**
   * 用于用户注册时为用户生成一个空的购物车
   */
  @Transactional
  public ShoppingCart generateShoppingCartForUser(User user) {
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setUser(user);
    return shoppingCartRepository.save(shoppingCart);
  }

  @Transactional
  public ShoppingCart update(ShoppingCart shoppingCart) {
    return shoppingCartRepository.save(shoppingCart);
  }

}
