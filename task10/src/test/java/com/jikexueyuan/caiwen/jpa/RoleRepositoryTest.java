package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.Role;
import com.jikexueyuan.caiwen.entity.RoleName;
import com.jikexueyuan.caiwen.repository.RoleRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

public class RoleRepositoryTest extends BasicJpaTest {

  @Autowired
  private RoleRepository roleRepository;

  @Test
  @Sql(statements = "delete from role")
  public void saveTest() {
    Role role = new Role();
    role.setRoleName(RoleName.ADMIN);
    roleRepository.save(role);

    assertThat(role.getRoleId()).isNotNull();
    Role dbRole = roleRepository.findOne(role.getRoleId());
    assertThat(dbRole.getRoleName()).isEqualTo(RoleName.ADMIN);
  }

  @Test
  public void cacheFind() {

    Role dbRole = roleRepository.findOne(1);
    assertThat(dbRole.getRoleName()).isEqualTo(RoleName.ADMIN);

    Role dbRole2 = roleRepository.findOne(1);
    Role dbRole3 = roleRepository.findFromCacheByRoleName(RoleName.ADMIN);
    Role dbRole4 = roleRepository.findFromCacheByRoleName(RoleName.ADMIN);
    Role dbRole5 = roleRepository.findFromCacheByRoleName(RoleName.ADMIN);


    List<Role> roleList = roleRepository.findAllCached();
    assertThat(roleList).hasSize(3);

    List<Role> roleList2 = roleRepository.findAllCached();

  }
}
