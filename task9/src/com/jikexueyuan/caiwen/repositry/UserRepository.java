package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caiwen on 2016/7/21.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User getByUsername(String username);

    @Modifying
    @Transactional
//    @Query("delete from User u where u.username = :username")
    void removeByUsername(@Param("username") String username);

}
