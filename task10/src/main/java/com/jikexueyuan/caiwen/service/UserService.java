package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.User;

import java.util.Map;

/**
 * Created by caiwen on 2016/8/12.
 */
public interface UserService {
    User getUserByUserName(String userName);
    Boolean validateUser(String username, String password);
    User getUserById(Integer id);
    User addUser(User user) throws Exception;

    Map pagedQuery(Integer page, Integer recordPerPage);

    void deleteUser(Integer id);
    void updateUser(User user);
}
