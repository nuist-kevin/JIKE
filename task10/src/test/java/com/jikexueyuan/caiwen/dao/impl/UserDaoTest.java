package com.jikexueyuan.caiwen.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;
import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.entity.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserDaoTest extends BaseDaoTest {

  @Resource
  UserDao userDao;

  @Test
  @Sql("classpath:/sql/UserDaoTest/testFindOne.sql")
  public void testFindOne() {
    User user = userDao.findOne(1);
    assertThat(user.getUsername(), is("caiwen"));
  }

  @Test
  @Sql("classpath:/sql/UserDaoTest/testFindByUsername.sql")
  public void testFindByUsername() throws Exception {
    User user = userDao.findByUserName("caiwen");
    assertThat(user.getUsername(), is("caiwen"));
  }

  @Test
  @Sql("classpath:/sql/UserDaoTest/testSave.sql")
  public void testSave() {

    User user1 = new User();
    user1.setUsername("caiwen");
    user1.setRealName("蔡文");
    user1.setPassword("123456");
    user1.setPwdQuestion("老婆的名字");
    user1.setPwdQuestion("宋晓娇");
    user1.setEmail("nuist_kevin@163.com");
    user1.setAddress("南京托乐嘉");
    user1.setPhoneNo("18094200522");
    Integer id = userDao.save(user1);
    assertThat(userDao.findOne(id), is(user1));
  }

  //	@Test
  public void TestFindAll() {
    List<User> userList = new ArrayList<>();
    User user1 = new User();
    user1.setUsername("caiwen");
    user1.setRealName("蔡文");
    user1.setPassword("6886377");
    user1.setPwdQuestion("老婆的名字");
    user1.setPwdQuestionAnswer("宋晓娇");
    user1.setEmail("nuist_kevin@163.com");
    user1.setAddress("南京浦口");
    user1.setPhoneNo("18094200522");
    user1.setUserId(1);
    userList.add(user1);
    List<User> actualList = userDao.findAll();
    for (int i = 0; i < actualList.size(); i++) {
      User u1 = userList.get(i);
      User u2 = actualList.get(i);
    }
  }


}
