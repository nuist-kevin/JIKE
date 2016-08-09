package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Goods;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 商品的DAO实现类，除了基础的操作方法继承自BaseDaoImpl之外，还包括支持页面高级查询功能的组合选项查询方法<br>
 *     @see BaseDaoImpl
 *     @author caiwen
 *     @version 1.0
 */
@Repository
public class GoodsDaoImpl extends BaseDaoImpl<Goods, Integer> implements GoodsDao {

    public List<Goods> conditionQuery(Map parameterMap, Integer page) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        if (parameterMap.get("goodsname") != null) {
            criteria.add(Restrictions.like("goodsname", "%" +parameterMap.get("goodsname") + "%"));
        }
        if (parameterMap.get("categoryId") != null) {
            criteria.add(Restrictions.eq("category.id", parameterMap.get
                    ("categoryId")));
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
        criteria.setFirstResult(RECORD_PER_PAGE * (page - 1));
        criteria.setMaxResults(RECORD_PER_PAGE);
        return criteria.list();
    }

}
