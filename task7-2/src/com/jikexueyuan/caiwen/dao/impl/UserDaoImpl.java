package com.jikexueyuan.caiwen.dao.impl;

import org.hibernate.criterion.Restrictions;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.util.HibernateUtil;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public User getUserByUsername(String username) {
		return (User)HibernateUtil.getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
	}
}
