package com.jikexueyuan.caiwen.dao;

import com.jikexueyuan.caiwen.entity.Goods;

import java.util.Map;

public interface GoodsDao extends BaseDao<Goods, Integer> {

    Map<String, Object> conditionQuery(Map<String, String> parameterMap, Integer page, Integer recordPerPage);
}
