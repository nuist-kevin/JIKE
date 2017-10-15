package com.jikexueyuan.caiwen.jpa;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public abstract class BasicJpaTest extends AbstractTransactionalJUnit4SpringContextTests {

}
