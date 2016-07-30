package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.command.UserCommand;
import com.jikexueyuan.caiwen.domain.User;

import java.util.List;

/**
 * Created by caiwen on 2016/7/31.
 */
public interface UserService {
    User save(User user);

    User getByUsername(String username);

    List<User> findAll();

    void delete(String username);

    boolean validateUser(UserCommand userCommand);

    boolean isAuthorised(User user);

    boolean isAdmin(User user);
}
