package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Role;
import com.jikexueyuan.caiwen.entity.RoleName;
import java.util.List;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  @Query("select r from Role r")
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
  List<Role> findAllCached();

  @Query("select r from Role r where r.roleName like :roleName ")
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
  Role findFromCacheByRoleName(@Param(value = "roleName") RoleName roleName);
}
