package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Goods;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Map;

/**
 * 商品的DAO实现类，除了基础的操作方法继承自BaseDaoImpl之外，还包括支持页面高级查询功能的组合选项查询方法<br>
 *
 * @author caiwen
 * @version 1.0
 * @see BaseDaoImpl
 */
@Repository
public class GoodsDaoImpl extends BaseDaoImpl<Goods, Integer> implements GoodsDao {

    public List<Goods> conditionQuery(Map<String,String> parameterMap, Integer page) {
        Criteria criteria = getSession().createCriteria(Goods.class);
        if (parameterMap != null) {
            if (parameterMap.get("goodsName") != null) {
                criteria.add(Restrictions.like("goodsName", "%" + parameterMap.get("goodsName") + "%"));
            }
            if (StringUtils.isNotEmpty(parameterMap.get("categoryId"))) {
                criteria.add(Restrictions.eq("category.id", Integer.valueOf(parameterMap.get
                        ("categoryId").toString())));
            }
            if (StringUtils.isNotEmpty(parameterMap.get("fromPrice") ) && StringUtils.isNotEmpty(parameterMap.get
                    ("toPrice"))) {
                criteria.add(Restrictions.between("price", parameterMap.get("fromPrice"), parameterMap.get("toPrice")));
            }
            if (StringUtils.isNotEmpty(parameterMap.get("fromPrice")) && StringUtils.isEmpty(parameterMap.get
                    ("toPrice"))) {
                criteria.add(Restrictions.ge("price", parameterMap.get("fromPrice")));
            }
            if (StringUtils.isEmpty(parameterMap.get("fromPrice")) && StringUtils.isNotEmpty(parameterMap.get
                    ("toPrice"))) {
                criteria.add(Restrictions.le("price", parameterMap.get("toPrice")));
            }
        }
        criteria.setFirstResult(RECORD_PER_PAGE * (page - 1));
        criteria.setMaxResults(RECORD_PER_PAGE);
        return criteria.list();
    }

}
