package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Goods;
import org.springframework.stereotype.Repository;

/**
 * 商品的DAO实现类，除了基础的操作方法继承自BaseDaoImpl之外，还包括支持页面高级查询功能的组合选项查询方法<br>
 *     @see BaseDaoImpl
 *     @author caiwen
 *     @version 1.0
 *
 */
@Repository
public class GoodsDaoImpl extends BaseDaoImpl<Goods, Integer> implements GoodsDao {

}
