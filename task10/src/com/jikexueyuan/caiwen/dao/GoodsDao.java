package com.jikexueyuan.caiwen.dao;

import com.jikexueyuan.caiwen.entity.Goods;

import java.math.BigDecimal;
import java.util.List;

public interface GoodsDao extends BaseDao<Goods, Integer> {

    List<Goods> findByPage(String name, Integer categoryId, BigDecimal fromPrice, BigDecimal toPrice, Integer
            page);

}
