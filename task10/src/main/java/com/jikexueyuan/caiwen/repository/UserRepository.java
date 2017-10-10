package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  List<User> findUsersByUsernameLike(String username);

  User findByUsername(String username);
}
