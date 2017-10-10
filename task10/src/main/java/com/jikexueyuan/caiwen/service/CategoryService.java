package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.Category;

import java.util.List;
import org.springframework.data.domain.Page;

public interface CategoryService {

  Category add(String categoryName);

  void delete(Integer id);

  void update(Category category);

  List<Category> getAllCategories();

  int getTotalPages(Integer page, Integer recordPerPage);

  Page<Category> pagedQuery(Integer page, Integer recordPerPage);
}
