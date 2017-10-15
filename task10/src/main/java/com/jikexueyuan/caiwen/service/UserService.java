package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.User;

import org.springframework.data.domain.Page;

/**
 * @author caiwen
 */
public interface UserService {

  User getUserByUsername(String username);

  Boolean validateUser(String username, String password);

  User getUserById(Integer id);

  User addUser(User user) throws Exception;

  Page<User> pageQuery(Integer page, Integer recordPerPage);

  void deleteUser(Integer id);

  void updateUser(User user);
}
