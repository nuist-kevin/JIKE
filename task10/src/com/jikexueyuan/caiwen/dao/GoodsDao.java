package com.jikexueyuan.caiwen.dao;

import com.jikexueyuan.caiwen.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsDao extends BaseDao<Goods, Integer> {

    List<Goods> conditionQuery(Map parameterMap, Integer page);
}
