package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.PoetryDao;
import com.jikexueyuan.caiwen.domain.Poetry;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by caiwen on 2016/7/18.
 */
@Repository
public class PoetryDaoImpl extends BaseDaoImpl implements PoetryDao {

    public List<Poetry> getPoetriesBytitle(String title) {
        List<Poetry> poetryContents;
//        poetryContents = (List<Poetry>) sessionFactory.getCurrentSession().createCriteria(Poetry.class).add(Restrictions.like("title", "%" + title + "%")).list();
        poetryContents = sessionFactory.getCurrentSession().createQuery("select p from Poetry p where p.title like :title ").setString("title", "%" + title + "%").list();
        return poetryContents;
    }



}
