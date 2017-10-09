package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.repository.CategoryRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CategoryRepositoryTest extends BasicJpaTest{

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  @Transactional
  public void test() {
    Category category = new Category();
    category.setCategoryName("Cloth");
    categoryRepository.save(category);
    assertThat(categoryRepository.findCategoryByCategoryNameLike("Cloth")).isNotNull();
    assertThat(categoryRepository.findCategoryByCategoryNameLike("Cloth").getCategoryId()).isNotNull();
  }

}
