package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.repository.CategoryRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

public class CategoryRepositoryTest extends BasicJpaTest{

  @Autowired
  private CategoryRepository categoryRepository;

  @Test
  public void test() {
    Category category = new Category();
    category.setCategoryName("Cloth");
    categoryRepository.save(category);
    assertThat(categoryRepository.findOne(category.getCategoryId())).isNotNull();
  }

  @Sql(statements = {"insert into category values(1, 'Cloth')"})
  @Test
  public void testCacheFind() {
    Category category =
    categoryRepository.findCachedCategoryByName("Cloth");
    Category category2 =
        categoryRepository.findCachedCategoryByName("Cloth");

    assertThat(category).isEqualToComparingFieldByField(category2);
  }

}
