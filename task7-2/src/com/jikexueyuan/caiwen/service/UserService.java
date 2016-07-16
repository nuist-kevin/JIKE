package com.jikexueyuan.caiwen.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.dao.impl.UserDaoImpl;
import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.util.HibernateUtil;

public class UserService {

	private UserDao userDao = new UserDaoImpl();
	
	public Integer create(User user) {
		Integer userId = null;
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			userId = userDao.save(user);
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}
		return userId;
	}
	
	public void edit(User user) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
            userDao.update(user);
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}

	}
	
	public void delete(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			userDao.delete(id);
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}

	}
	
	public User get(Integer id) {
        User user = new User();
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            user = userDao.get(id);
            transaction.commit();
        } catch (Exception exception){
            exception.printStackTrace();
            transaction.rollback();
        }
        return user;
	}
	
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			users = userDao.findAll();
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}

		return users;
	}

	public List<User> findBypage(int page) {
		List<User> users = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			users = userDao.findByPage(10, (page-1) * 10);
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}

		return users;
	}

	public Long getTotalCount() {
		Long totalCount = 0L;
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			totalCount = userDao.totalCount();
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}

		return totalCount;
	}

	public User getUserByUsername(String username) {
		User user = new User();
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			user = userDao.getUserByUsername(username);
            transaction.commit();
        } catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}

		return user;
	}
}
