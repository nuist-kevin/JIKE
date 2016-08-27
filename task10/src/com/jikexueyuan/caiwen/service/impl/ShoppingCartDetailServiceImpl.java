package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.ShoppingCartDetailDao;
import com.jikexueyuan.caiwen.entity.ShoppingCartDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by caiwen on 2016/8/13.
 */
@Service
@Transactional
public class ShoppingCartDetailServiceImpl {

    @Resource
    ShoppingCartDetailDao shoppingCartDetailDao;

    /**
     * 向购物车中新增一条记录
     * @param shoppingCartDetail
     * @return
     */
    public Integer add(ShoppingCartDetail shoppingCartDetail) {
        return shoppingCartDetailDao.save(shoppingCartDetail);
    }
}
