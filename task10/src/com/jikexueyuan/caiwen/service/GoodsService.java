package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by caiwen on 2016/8/20.
 */
public interface GoodsService {
    List<Goods> getGoodsByConditionMap(Map condition, Integer page);
    Goods add(Goods goods);
    Goods getGoodsById(Integer id);
    Integer getTotalPages();
}
