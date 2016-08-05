package com.jikexueyuan.caiwen.dao.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jikexueyuan.caiwen.dao.ShoppingCartDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
public class ShoppingCartDaoTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Resource
	ShoppingCartDao shoppingCartDao;
	
	@Test
	@Sql
	public void testFindOne() {
		
	}
	
//	@Test
	public void testAdd() {
		
//		shoppingCartDao.save(model);
	}

}
