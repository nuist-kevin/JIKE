package com.jikexueyuan.caiwen.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.entity.User;

/**
 * Created by caiwen on 2016/8/3.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(transactionManager = "transactionManager")
public class UserDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    UserDao userDao;
    
    @Test
//    @Sql("test.sql")
    public void TestfindOneUser() {
    	String username = userDao.findOne(1).getUserName();
        Assert.assertEquals(username, "caiwen");
    }
    
    @Test
//  @Sql("test.sql")
  public void TestfindOneOrder() {
  	String username = userDao.findOne(1).getOrders().get(0).getUser().getUserName();
      Assert.assertEquals(username, "caiwen");
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

}
