package com.jikexueyuan.caiwen.service;

import com.jikexueyuan.caiwen.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    Category add(String categoryName);
    void delete(Integer id);
    void update(Category category);
    List<Category> getAllCategories();
    Integer getTotalPages();
    Map pagedQuery(Integer page, Integer recordPerPage);
}
