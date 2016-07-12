package com.jikexueyuan.caiwen.dao;

import com.jikexueyuan.caiwen.domain.User;

public interface UserDao extends BaseDao<User> {
	public User getUserByUsername(String username);

}
