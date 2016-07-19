package com.jikexueyuan.caiwen.dao.impl;

import com.jikexueyuan.caiwen.dao.PoetryDao;
import com.jikexueyuan.caiwen.domain.Poetry;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by caiwen on 2016/7/18.
 */
@Repository
public class PoetryDaoImpl extends BaseDaoImpl implements PoetryDao {

    public List<Poetry> getPoetriesByPoetName(String name) {
        List<Poetry> poetryContents;
        poetryContents = sessionFactory.getCurrentSession().createQuery("select p from Poetry p inner join p.poet where p.poet.name = :name ").setString("name", name).list();
        return poetryContents;
    }

    public List<Poetry> getPoetriesBytitle(String title) {
        List<Poetry> poetryContents;
        poetryContents = sessionFactory.getCurrentSession().createQuery("select p from Poetry p where p.title like :title ").setString("title", "%" + title + "%").list();
        return poetryContents;
    }

    public List<Poetry> getPoetriesByContent(String content) {
        List<Poetry> poetryContents;
        poetryContents = sessionFactory.getCurrentSession().createQuery("select p from Poetry p where p.content like :content ").setString("content", "%" + content + "%").list();
        return poetryContents;
    }

}
