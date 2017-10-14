package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.entity.Role;
import com.jikexueyuan.caiwen.entity.RoleName;
import com.jikexueyuan.caiwen.entity.User;
import com.jikexueyuan.caiwen.repository.RoleRepository;
import com.jikexueyuan.caiwen.repository.UserRepository;
import com.jikexueyuan.caiwen.service.ShoppingCartService;
import com.jikexueyuan.caiwen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private ShoppingCartService shoppingCartService;

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  @Transactional
  public User addUser(User user) throws Exception {
    //判断用户名是否已存在
    if (getUserByUsername(user.getUsername()) != null) {
      throw new Exception("该用户已存在");
    }
    User result = user;
    Role nomalRole =
        roleRepository.findFromCacheByRoleName(RoleName.USER);
    result.setRole(nomalRole);
    userRepository.save(result);
    //为新用户生成购物车信息
    shoppingCartService.generateShoppingCartForUser(result);
    return result;
  }

  public Page<User> pageQuery(Integer page, Integer recordPerPage) {
    return userRepository.findAll(new PageRequest(page, recordPerPage));
  }

  @Override
  public void deleteUser(Integer id) {
    userRepository.delete(id);
  }

  @Override
  public void updateUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User getUserById(Integer id) {
    return userRepository.findOne(id);
  }

  @Override
  public User getUserByUsername(String userName) {
    return userRepository.findByUsername(userName);
  }

  /**
   * 校验用户名密码
   */
  public Boolean validateUser(String username, String password) {
    User user = getUserByUsername(username);
    if (user != null && password.equals(user.getPassword())) {
      return true;
    } else {
      return false;
    }
  }


}
