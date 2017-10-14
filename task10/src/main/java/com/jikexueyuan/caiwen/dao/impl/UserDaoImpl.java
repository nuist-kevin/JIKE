package com.jikexueyuan.caiwen.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

    @Override
    public User findByUserName(String userName) {
        return (User) getSession().createCriteria(User.class).add(Restrictions.eq("userName", userName)).uniqueResult();
    }
}
