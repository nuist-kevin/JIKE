package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Category;
import java.util.List;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

/**
 * @author caiwen
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

  /**
   * 二级缓存根据目录名精确查找目录
   *
   * @param categoryName 目录名
   * @return 符合条件的目录
   */
  @Query("select c from Category c where c.categoryName = :categoryName")
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
  Category findCachedCategoryByName(@Param("categoryName") String categoryName);

  /**
   * 二级缓存查找所有的目录
   *
   * @return  目录列表
   */
  @Override
  @Query("select c from Category c")
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
  List<Category> findAll();
}
