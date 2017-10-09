package com.jikexueyuan.caiwen.repository;

import com.jikexueyuan.caiwen.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  Category findCategoryByCategoryNameLike(String categoryName);
}
