package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Category;
import java.util.List;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  @Query("select c from Category c where c.categoryName = :categoryName")
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
  Category findCachedCategoryByName(@Param("categoryName") String categoryName);

  @Query("select c from Category c")
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
  List<Category> findAll();
}
