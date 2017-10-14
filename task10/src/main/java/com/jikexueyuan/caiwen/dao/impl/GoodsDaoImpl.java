package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.GoodsDao;
import com.jikexueyuan.caiwen.entity.Goods;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品的DAO实现类，除了基础的操作方法继承自BaseDaoImpl之外，还包括支持页面高级查询功能的组合选项查询方法<br>
 *
 * @author caiwen
 * @version 1.0
 * @see BaseDaoImpl
 */
public class GoodsDaoImpl extends BaseDaoImpl<Goods, Integer> implements GoodsDao {

    public Map<String, Object> conditionQuery(Map<String, String> parameterMap, Integer page, Integer recordPerPage) {
        Map<String, Object> resultMap = new HashMap<>();

 /*       Criteria criteria = getSession().createCriteria(Goods.class);
        if (parameterMap != null) {
            if (StringUtils.isNotEmpty(parameterMap.get("goodsName"))) {
                criteria.add(Restrictions.like("goodsName", "%" + parameterMap.get("goodsName") + "%"));
            }
            if (StringUtils.isNotEmpty(parameterMap.get("categoryId"))) {
                criteria.createAlias("category", "ca").add(Restrictions.eq("ca.id", Integer.valueOf(parameterMap
                        .get("categoryId"))));
            }
            if (StringUtils.isNotEmpty(parameterMap.get("fromPrice")) && StringUtils.isNotEmpty(parameterMap.get
                    ("toPrice"))) {
                criteria.add(Restrictions.between("price", BigDecimal.valueOf(Double.valueOf(parameterMap.get
                                ("fromPrice"))),
                        BigDecimal.valueOf(Double.valueOf(parameterMap.get("toPrice")))));
            }
            if (StringUtils.isNotEmpty(parameterMap.get("fromPrice")) && StringUtils.isEmpty(parameterMap.get
                    ("toPrice"))) {
                criteria.add(Restrictions.ge("price", BigDecimal.valueOf(Double.valueOf(parameterMap.get("fromPrice")
                ))));
            }
            if (StringUtils.isEmpty(parameterMap.get("fromPrice")) && StringUtils.isNotEmpty(parameterMap.get
                    ("toPrice"))) {
                criteria.add(Restrictions.le("price", BigDecimal.valueOf(Double.valueOf(parameterMap.get("toPrice")))));
            }
            criteria.setFirstResult(recordPerPage * (page - 1));
            criteria.setMaxResults(recordPerPage);
            List<Goods> goodsList = criteria.list();
            Integer resultCount = goodsList.size();
            Integer resultPage = ((resultCount % recordPerPage) == 0) ? (resultCount / recordPerPage) :
                    (resultCount / recordPerPage + 1);
            resultMap.put("goodsList", goodsList);
            resultMap.put("resultCount", resultCount);
            resultMap.put("totalPages", resultPage);
        } else {
            Map pagedQuery = pagedQuery(page, recordPerPage);
            resultMap.put("goodsList", pagedQuery.get("pageData"));
            resultMap.put("totalPages", pagedQuery.get("totalPages"));
        }*/
        return resultMap;

    }

}
