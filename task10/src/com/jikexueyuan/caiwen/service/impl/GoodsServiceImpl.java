package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Goods;
import com.jikexueyuan.caiwen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> getGoodsByConditionMap(Map condition, Integer page) {
        return goodsDao.conditionQuery(condition, page);
    }

    @Override
    public Goods add(Goods goods) {
        Goods result = goods;
        Integer goodsId =  goodsDao.save(goods);
        result.setId(goodsId);
        return result;
    }

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsDao.findOne(id);
    }

    @Override
    public Integer getTotalPages() {
        return goodsDao.totalPages(10);
    }
}
