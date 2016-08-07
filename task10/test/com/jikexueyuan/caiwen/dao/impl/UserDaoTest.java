package com.jikexueyuan.caiwen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.entity.User;

/**
 * Created by caiwen on 2016/8/3.
 */

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	UserDao userDao;

	@Test
	// @Sql("test.sql")
	public void TestfindOneUser() {
		String username = userDao.findOne(1).getUserName();
		Assert.assertEquals(username, "caiwen");
	}

	@Test
	// @Sql("test.sql")
	public void TestfindOneOrder() {
		String username = userDao.findOne(1).getOrders().get(0).getOrderDetails().get(0).getGoodsName();
		Assert.assertEquals(username, "iPhone7");
	}

	@Test
	public void saveTest() {
		User user1 = new User();
		user1.setUserName("caiwen");
		user1.setRealName("蔡文");
		user1.setPassword("6886377");
		user1.setPwdQuestion("老婆的名字");
		user1.setPwdQuestion("宋晓娇");
		user1.setEmail("nuist_kevin@163.com");
		user1.setAddress("南京将军大道");
		user1.setPhoneNo("18094200522");

		Integer id = userDao.save(user1);
		Assert.assertEquals(userDao.findOne(id).getUserName(), "caiwen");
	}
	
	@Test
	public void TestFindAll() {
		List<User> userList = new ArrayList<>();
		User user1 = new User();
		user1.setUserName("caiwen");
		user1.setRealName("蔡文");
		user1.setPassword("6886377");
		user1.setPwdQuestion("老婆的名字");
		user1.setPwdQuestionAnswer("宋晓娇");
		user1.setEmail("nuist_kevin@163.com");
		user1.setAddress("南京浦口");
		user1.setPhoneNo("18094200522");
		user1.setId(1);
		userList.add(user1);
		List<User> actualList = userDao.findAll();
		Assert.assertTrue(userList.size() == actualList.size());
		for(int i = 0; i < actualList.size(); i++) {
			User u1 = userList.get(i);
			User u2 = actualList.get(i);
			Assert.assertTrue(u1.equals(u2));
		}
	}

	@Test
	public void TestTotalCount() {
		Assert.assertTrue(userDao.totalCount() == 1);
	}
	
}
