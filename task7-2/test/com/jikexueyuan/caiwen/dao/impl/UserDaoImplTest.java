package com.jikexueyuan.caiwen.dao.impl;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.testng.annotations.Test;

import com.jikexueyuan.caiwen.domain.User;
import com.jikexueyuan.caiwen.util.HibernateUtil;

public class UserDaoImplTest {
	private static Logger logger = Logger.getLogger(UserDaoImplTest.class);
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
//	@Test
	public void testTotalCount() {
	 logger.info(userDaoImpl.totalCount());
	}
	
	@Test
	public void testAdd() {
		User user = new User();
//		user.setAddress("njjjj");
//		user.setAge(20);
//		user.setPassword("ttt");
//		user.setPhoneNum("234234");
//		user.setRealName("ttt");
//		user.setUsername("xxxxxX");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		user = userDaoImpl.get(5);
		user.setAddress("eee");
		userDaoImpl.update(user);
//		session.createQuery("update User u set u.address = 'testAdd' where u.username = '蔡文'").executeUpdate();
		
//		Assert.assertEquals(userDaoImpl.getUserByName("xxxxxX").getAddress(), "njjjj");
		session.getTransaction().commit();
		
	}
}
