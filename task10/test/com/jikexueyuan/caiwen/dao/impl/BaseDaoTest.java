package com.jikexueyuan.caiwen.dao.impl;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
public class BaseDaoTest extends AbstractTransactionalTestNGSpringContextTests {

}
