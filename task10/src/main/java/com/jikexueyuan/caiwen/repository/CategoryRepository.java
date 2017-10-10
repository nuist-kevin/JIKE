package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Category;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  Category findCategoryByCategoryNameLike(String categoryName);

  @Query("select cate from Category cate where cate.categoryName = :categoryName")
  @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
  Category findCachedCategoryByName(@Param("categoryName") String categoryName);
}
