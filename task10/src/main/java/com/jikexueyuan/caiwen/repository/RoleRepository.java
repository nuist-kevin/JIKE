package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Role;
import com.jikexueyuan.caiwen.entity.RoleName;
import java.util.List;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

/**
 * @author caiwen
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

  /**
   * 二级缓存查找所有的用户角色
   *
   * @return 用户列表
   */
  @Query("select r from Role r")
  @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
  List<Role> findAllCached();

  /**
   * 二级缓存根据角色名精确查找用户角色
   *
   * @param roleName 角色名
   * @return 符合条件的角色
   */
  @Query("select r from Role r where r.roleName = :roleName ")
  @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
  Role findFromCacheByRoleName(@Param(value = "roleName") RoleName roleName);
}
