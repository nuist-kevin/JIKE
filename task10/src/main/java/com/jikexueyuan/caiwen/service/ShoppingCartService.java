package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.Goods;
import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.entity.User;

/**
 * Created by caiwen on 2016/8/13.
 */
public interface ShoppingCartService {

  ShoppingCart generateShoppingCartForUser(User user);

  ShoppingCart update(ShoppingCart shoppingCart);
}
