package com.jikexueyuan.caiwen.dao.impl;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.jikexueyuan.caiwen.dao.ShoppingCartDao;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
public class ShoppingCartDaoTest extends AbstractTransactionalTestNGSpringContextTests{

	@Resource
	ShoppingCartDao shoppingCartDao;

//	@Sql
	@Test
	public void testFindOne() {
		
	}

//	@Test
//	public void testAdd() {
		
//		shoppingCartDao.save(model);
//	}

}