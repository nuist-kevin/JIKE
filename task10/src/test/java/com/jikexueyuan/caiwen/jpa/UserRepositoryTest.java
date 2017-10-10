package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.RoleName;
import com.jikexueyuan.caiwen.entity.User;
import com.jikexueyuan.caiwen.repository.RoleRepository;
import com.jikexueyuan.caiwen.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends BasicJpaTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Test
  public void saveTest() {
    User user = new User();
    user.setUsername("caiwen");
    user.setRole(roleRepository.findFromCacheByRoleName(RoleName.ADMIN));
    user.setRealName("Cai Wen");
    user.setPassword("6886377");
    user.setAddress("托乐嘉");
    user.setPwdQuestion("老婆叫什么");
    user.setPwdQuestionAnswer("宋晓娇");
    user.setEmail("nuist_kevin@163.com");
    user.setPhoneNo("18094200522");
    userRepository.save(user);
    User dbUser = userRepository.findOne(user.getUserId());
    assertThat(dbUser).isNotNull().isEqualToComparingFieldByField(user);

  }
}
