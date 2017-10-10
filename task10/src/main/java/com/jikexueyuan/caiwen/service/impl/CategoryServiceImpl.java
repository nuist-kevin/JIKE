package com.jikexueyuan.caiwen.service.impl;

import com.jikexueyuan.caiwen.entity.Category;
import com.jikexueyuan.caiwen.repository.CategoryRepository;
import com.jikexueyuan.caiwen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  @Transactional
  public Category add(String categoryName) {
    Category category = new Category();
    category.setCategoryName(categoryName);
    return categoryRepository.save(category);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    categoryRepository.delete(id);
  }

  @Override
  @Transactional
  public void update(Category category) {
    categoryRepository.save(category);
  }

  @Override
  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public int getTotalPages(Integer page, Integer recordPerPage) {
    Pageable pageable = new PageRequest(page, recordPerPage);
    return categoryRepository.findAll(pageable).getTotalPages();
  }

  @Override
  public Page<Category> pagedQuery(Integer page, Integer recordPerPage) {
    Pageable pageable = new PageRequest(page, recordPerPage);
    return categoryRepository.findAll(pageable);
  }


}
