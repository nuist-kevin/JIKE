package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.PoetDao;
import com.jikexueyuan.caiwen.domain.Poetry;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by caiwen on 2016/7/18.
 */
@Repository
public class PoetDaoImpl  extends BaseDaoImpl implements PoetDao{

    public List<Poetry> getPoetriesByPoetName(String name) {
        return sessionFactory.getCurrentSession().createQuery("select p.poetries from Poet p where p.name = :name").setString("name", name).list();
    }
}
