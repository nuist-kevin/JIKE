package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Goods;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 商品的DAO实现类，除了基础的操作方法继承自BaseDaoImpl之外，还包括支持页面高级查询功能的组合选项查询方法<br>
 *     @see BaseDaoImpl
 *     @author caiwen
 *     @version 1.0
 *
 */
@Repository
public class GoodsDaoImpl extends BaseDaoImpl<Goods, Integer> implements GoodsDao {

    public List<Goods> conditionQuery(Map parameterMap, Integer page) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        if (parameterMap.get("goodsname") != null) {
            criteria.add(Restrictions.like("goodsname", parameterMap.get("goodsname")));
        }
        if (parameterMap.get("categoryId") != null) {
            criteria.createCriteria("category").add(Restrictions.eq("id", parameterMap.get("categoryId")));
        }
        if (parameterMap.get("fromPrice")  != null && parameterMap.get("toPrice")  != null) {
            criteria.add(Restrictions.between("price", parameterMap.get("fromPrice"), parameterMap.get("toPrice")));
        }
        if (parameterMap.get("fromPrice") != null && parameterMap.get("toPrice") == null) {
            criteria.add(Restrictions.ge("price", parameterMap.get("fromPrice")));
        }
        if (parameterMap.get("fromPrice") == null && parameterMap.get("toPrice") != null) {
            criteria.add(Restrictions.le("price", parameterMap.get("toPrice")));
        }
        criteria.setFirstResult((totalPages() - 1) * page);
        criteria.setMaxResults(RECORD_PER_PAGE);
        return criteria.list();
    }

    public List<Goods> findByPage(String name, Integer categoryId, BigDecimal fromPrice, BigDecimal toPrice, Integer
            page) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        if (name != null) {
            criteria.add(Restrictions.like("goodsname", name));
        }
        if (categoryId != null) {
            criteria.createCriteria("category").add(Restrictions.eq("id", categoryId));
        }
        if (fromPrice != null && toPrice != null) {
            criteria.add(Restrictions.between("price", fromPrice, toPrice));
        }
        if (fromPrice != null && toPrice == null) {
            criteria.add(Restrictions.ge("price", fromPrice));
        }
        if (fromPrice == null && toPrice != null) {
            criteria.add(Restrictions.le("price", toPrice));
        }
        criteria.setMaxResults(RECORD_PER_PAGE);
        criteria.setFirstResult((totalPages() - 1) * page);
        return criteria.list();
    }
}
