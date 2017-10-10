package com.jikexueyuan.caiwen.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.repository.CategoryRepository;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

public class CategoryRepositoryTest extends BasicJpaTest {

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

  @Sql(statements = {
      "insert into category values(1, 'Cloth')",
      "insert into category values(2, 'Cloth2')",
      "insert into category values(3, 'Cloth2')",
      "insert into category values(4, 'Cloth2')",
      "insert into category values(5, 'Cloth2')",
      "insert into category values(6, 'Cloth2')",
      "insert into category values(7, 'Cloth2')",
      "insert into category values(8, 'Cloth2')",
      "insert into category values(9, 'Cloth2')",
      "insert into category values(10, 'Cloth2')",
      "insert into category values(11, 'Cloth2')",

  })
  @Test
  public void testPageFind() {
    Page<Category> page =
        categoryRepository.findAll(
            new PageRequest(1, 5, new Sort(Direction.ASC, "categoryId")));
    int startCategoryId = 6;
    for (Category category : page.getContent()) {
      assertThat(category.getCategoryId()).isEqualTo(startCategoryId);
      startCategoryId++ ;
    }
  }


}
