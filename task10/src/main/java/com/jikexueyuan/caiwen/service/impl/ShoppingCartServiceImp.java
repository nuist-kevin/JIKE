package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.ShoppingCartDao;
import com.jikexueyuan.caiwen.dao.ShoppingCartDetailDao;
import com.jikexueyuan.caiwen.entity.Goods;
import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.entity.ShoppingCartDetail;
import com.jikexueyuan.caiwen.entity.User;
import com.jikexueyuan.caiwen.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by caiwen on 2016/8/12.
 */
@Service
@Transactional
public class ShoppingCartServiceImp implements ShoppingCartService {
    @Resource
    ShoppingCartDao shoppingCartDao;

    @Resource
    ShoppingCartDetailDao shoppingCartDetailDao;

    /**
     * 用于用户注册时为用户生成一个空的购物车
     * @param user
     */
    public ShoppingCart generateShoppingCartForUser(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        Integer shoppingCartId =  shoppingCartDao.save(shoppingCart);
        shoppingCart.setId(shoppingCartId);
        return shoppingCart;
    }

    /**
     * 用于购物车基本信息修改
     * @param shoppingCart
     * @return
     */

    public void update(ShoppingCart shoppingCart) {
        shoppingCartDao.saveOrUpdate(shoppingCart);
    }


}
