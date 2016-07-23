package com.jikexueyuan.caiwen.repositry;

import com.jikexueyuan.caiwen.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by caiwen on 2016/7/21.
 * 通过实现Srping Data Jpa提供的JpaRepository接口，无需再编写基础数据操作方法，也无需编写实现类
 * 由于User实体类主键是username, String类型，因此，这里继承的泛型中也为String
 */
public interface UserRepository extends JpaRepository<User,String> {
}
