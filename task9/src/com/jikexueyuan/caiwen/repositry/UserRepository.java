package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by caiwen on 2016/7/21.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User getByUsername(String username);
    Void deleteByUsername(String username);

}
