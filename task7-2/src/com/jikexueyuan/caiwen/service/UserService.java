package com.jikexueyuan.caiwen.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.dao.impl.UserDaoImpl;
import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.util.HibernateUtil;

public class UserService {

	private UserDao userDao = new UserDaoImpl();
	
	public void create(User user) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			userDao.save(user);
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}
//		finally {
//			session.close();
//		}
	}
	
	public void edit(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
            userDao.update(userDao.get(id));
			transaction.commit();
		} catch (Exception exception){
			exception.printStackTrace();
			transaction.rollback();
		}
//		finally {
//			session.close();
//		}
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
//		finally {
//			session.close();
//		}
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
		return userDao.findAll();
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
//		finally {
//			session.close();
//		}
		return user;
	}
}
