package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.entity.User;

/**
 * @author caiwen
 */
public interface ShoppingCartService {

  /**
   * Description: 新添加用户时，为该用户生成初始的空购物车。 *
   *
   * @param user 需要生成购物车信息的用户
   * @return 返回生成好的该用户对应的初始空购物车
   */
  ShoppingCart generateShoppingCartForUser(User user);

  /**
   * Description: 购物车信息变更时使用。
   *
   * @param shoppingCart 原始的购物车
   * @return 更新购物车
   */
  ShoppingCart update(ShoppingCart shoppingCart);
}
