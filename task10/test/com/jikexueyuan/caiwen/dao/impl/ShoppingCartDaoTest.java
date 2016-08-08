package com.jikexueyuan.caiwen.dao.impl;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.CoreMatchers.*;
import com.jikexueyuan.caiwen.dao.ShoppingCartDao;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
public class ShoppingCartDaoTest extends AbstractTransactionalTestNGSpringContextTests{

	@Resource
	ShoppingCartDao shoppingCartDao;

	@Sql("sql/ShoppingCartDaoTest/testFindOne.sql")
	@Test
	public void testFindOne() {

	}

}
