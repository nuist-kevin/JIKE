package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author caiwen
 */
public interface UserRepository extends JpaRepository<User, Integer> {

  /**
   * 根据用户名精确查找用户
   *
   * @param username 查找的用户名
   * @return 返回查找到的用户，没有找到则返回null
   */
  User findByUsername(String username);
}
