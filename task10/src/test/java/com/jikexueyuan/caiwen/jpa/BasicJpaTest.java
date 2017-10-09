package com.jikexueyuan.caiwen.jpa;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(locations = {"classpath:testApplicationContext.xml"})
public class BasicJpaTest extends AbstractTransactionalJUnit4SpringContextTests {

}
