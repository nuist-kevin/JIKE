package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.dao.UserDao;
import com.jikexueyuan.caiwen.entity.Role;
import com.jikexueyuan.caiwen.entity.RoleName;
import com.jikexueyuan.caiwen.entity.ShoppingCart;
import com.jikexueyuan.caiwen.entity.User;
import com.jikexueyuan.caiwen.service.ShoppingCartService;
import com.jikexueyuan.caiwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Resource
  UserDao userDao;
  @Autowired
  ShoppingCartService shoppingCartService;

  public User addUser(User user) throws Exception {
    Assert.notNull(user, "用户信息为空，无法添加");
    //判断用户名是否已存在
    if (userDao.findByUserName(user.getUsername()) != null) {
      throw new Exception("该用户已存在");
    }
    User result = user;
    Role nomalRole = new Role();
    nomalRole.setRoleName(RoleName.USER);
    result.setRole(nomalRole);
    Integer userId = userDao.save(result);
    result.setUserId(userId);
    //为新用户生成购物车信息
    ShoppingCart shoppingCart = shoppingCartService.generateShoppingCartForUser(result);
    return result;
  }

  @Override
  public Map pagedQuery(Integer page, Integer recordPerPage) {
    return userDao.pagedQuery(page, recordPerPage);
  }

  @Override
  public void deleteUser(Integer id) {
    userDao.delete(id);
  }

  @Override
  public void updateUser(User user) {
    userDao.saveOrUpdate(user);
  }

  public User getUserById(Integer id) {
    return userDao.findOne(id);
  }

  public User getUserByUserName(String userName) {
    Assert.notNull(userName, "用户名为空，无法获取用户信息");
    return userDao.findByUserName(userName);
  }

  /**
   * 校验用户名密码
   */
  public Boolean validateUser(String username, String password) {
    Assert.notNull(password, "用户名为空，无法校验");
    Assert.notNull(password, "密码为空，无法校验");
    User user = getUserByUserName(username);
    if (password.equals(user.getPassword())) {
      return true;
    } else {
      return false;
    }
  }


}
